package itesm.mx.proyectofinal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import itesm.mx.proyectofinal.DBstuff.DB_Operations;

/**
 * Created by Martin RB on 26/03/2018.
 */

public class PantallaUsuario extends Fragment implements View.OnClickListener {

    Activity a;
    IMyUserScreen userScreen;

    EditText
            etNombreUsuario;
    TextView
            tvNombreUsuario;
    Button
            btnPuntuaciones,
            btnEditar,
            btnFinEditar,
            btnEditarFoto,
            btnCancelarEditar;
    ImageView ivFoto;
    DB_Operations ops;
    byte[] antiguaFoto;

    @Override
    public void onAttach(Context con) {
        super.onAttach(con);
        a = (Activity) con;
        try {
            userScreen = (IMyUserScreen) a;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Crecaion del View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.usrscn, container, false);
    }

    /* Inicialización: Se inicia aqui y no en el onStart() para evitar problemas con los intents de
    * la camara*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ops = new DB_Operations(getActivity());

        tvNombreUsuario = a.findViewById(R.id.usrscn_tvUsrName);
        etNombreUsuario = a.findViewById(R.id.usrscn_etUsrName);
        btnPuntuaciones = a.findViewById(R.id.usrscn_btnScores);
        btnEditar = a.findViewById(R.id.usrscn_btnEdith);
        btnFinEditar = a.findViewById(R.id.usrscn_btnFinishEdith);
        btnEditarFoto = a.findViewById(R.id.usrscn_btnPhotoEdith);
        btnCancelarEditar = a.findViewById(R.id.usrscn_btnCancelEdith);
        ivFoto = a.findViewById(R.id.usrscn_ivPhoto);

        btnEditarFoto.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
        btnFinEditar.setOnClickListener(this);
        btnPuntuaciones.setOnClickListener(this);
        btnCancelarEditar.setOnClickListener(this);

        btnFinEditar.setVisibility(View.INVISIBLE);
        btnCancelarEditar.setVisibility(View.INVISIBLE);
        cargarDatos();
    }

    @Override
    public void onStart() {
        super.onStart();

//        ops = new DB_Operations(getActivity());
//        tvNombreUsuario = a.findViewById(R.id.usrscn_tvUsrName);
//        etNombreUsuario = a.findViewById(R.id.usrscn_etUsrName);
//        btnPuntuaciones = a.findViewById(R.id.usrscn_btnScores);
//        btnEditar = a.findViewById(R.id.usrscn_btnEdith);
//        btnFinEditar = a.findViewById(R.id.usrscn_btnFinishEdith);
//        btnEditarFoto = a.findViewById(R.id.usrscn_btnPhotoEdith);
//        btnCancelarEditar = a.findViewById(R.id.usrscn_btnCancelEdith);
//        ivFoto = a.findViewById(R.id.usrscn_ivPhoto);
//
//        btnEditarFoto.setOnClickListener(this);
//        btnEditar.setOnClickListener(this);
//        btnFinEditar.setOnClickListener(this);
//        btnPuntuaciones.setOnClickListener(this);
//        btnCancelarEditar.setOnClickListener(this);
//
//        btnFinEditar.setVisibility(View.INVISIBLE);
//        btnCancelarEditar.setVisibility(View.INVISIBLE);

//        cargarDatos();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.usrscn_btnScores:
                mostrarPuntajes();
                break;
            case R.id.usrscn_btnEdith:
                editarDatos();
                break;
            case R.id.usrscn_btnFinishEdith:
                finEditarDatos();
                break;
            case R.id.usrscn_btnPhotoEdith:
                editarFoto();
                break;
            case R.id.usrscn_btnCancelEdith:
                canEditarDatos();
                break;
            default:
                // Try catch vacio. Adrmiralo un momento
                try {
                    throw new Exception("No existe el boton: " + v.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        ops.publicClose();
    }

    @Override
    public void onResume() {
        super.onResume();
        ops.publicOpen();
    }

    private void cargarDatos() {
        String nombre;
        byte[] foto;

        // Cargar nombre
        nombre = ops.obtenerNombre();
        if (nombre != null) {
            tvNombreUsuario.setText(nombre);
        } else {
            tvNombreUsuario.setText("I AM ERROR");
        }

        // Cargar foto
        foto = ops.obtenerFoto();
        if (foto != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(foto, 0, foto.length);
            ivFoto.setImageBitmap(bitmap);
        } else {
            ivFoto.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    private void editarDatos() {
        tvNombreUsuario.setVisibility(View.INVISIBLE);
        etNombreUsuario.setVisibility(View.VISIBLE);
        btnEditarFoto.setVisibility(View.VISIBLE);
        btnEditar.setVisibility(View.INVISIBLE);
        btnPuntuaciones.setVisibility(View.INVISIBLE);
        btnFinEditar.setVisibility(View.VISIBLE);
        btnCancelarEditar.setVisibility(View.VISIBLE);

        etNombreUsuario.setText(tvNombreUsuario.getText().toString());

        // Guardar foto actual por si se cancela la operacion
        Bitmap b = getBitmapFromImageView(ivFoto);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, s);
        antiguaFoto = s.toByteArray();
    }

    private void finEditarDatos() {
        String nuevoNombre;
        byte[] nuevaFoto;

        nuevoNombre = etNombreUsuario.getText().toString();
        Bitmap b = getBitmapFromImageView(ivFoto);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, s);
        nuevaFoto = s.toByteArray();

        if (!nuevoNombre.equals("")) {
            ops.cambiarFoto(nuevaFoto);
            ops.cambiarNombre(nuevoNombre);
        } else {
            Toast.makeText(a, "Escribe un nombre valido", Toast.LENGTH_SHORT).show();
        }

        etNombreUsuario.setVisibility(View.INVISIBLE);
        tvNombreUsuario.setText(nuevoNombre);
        tvNombreUsuario.setVisibility(View.VISIBLE);
        btnEditarFoto.setVisibility(View.INVISIBLE);
        btnFinEditar.setVisibility(View.INVISIBLE);
        btnCancelarEditar.setVisibility(View.INVISIBLE);
        btnPuntuaciones.setVisibility(View.VISIBLE);
        btnEditar.setVisibility(View.VISIBLE);
    }

    private void canEditarDatos() {
        Bitmap b = BitmapFactory.decodeByteArray(antiguaFoto, 0, antiguaFoto.length);
        ivFoto.setImageBitmap(b);

        etNombreUsuario.setVisibility(View.INVISIBLE);
        tvNombreUsuario.setVisibility(View.VISIBLE);
        btnEditarFoto.setVisibility(View.INVISIBLE);
        btnFinEditar.setVisibility(View.INVISIBLE);
        btnCancelarEditar.setVisibility(View.INVISIBLE);
        btnPuntuaciones.setVisibility(View.VISIBLE);
        btnEditar.setVisibility(View.VISIBLE);
    }

    private void mostrarPuntajes() {

    }

    private void editarFoto() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (i.resolveActivity(a.getPackageManager()) != null) {
            startActivityForResult(i, 0);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Foto toamda
            case 0:
                Bundle dat = data.getExtras();
                ivFoto.setImageBitmap((Bitmap) dat.get("data"));
                break;
        }
    }

    private Bitmap getBitmapFromImageView(ImageView iv) {
        Bitmap b;
        Drawable d;

        d = iv.getDrawable();
        b = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b);
        d.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        d.draw(canvas);
        return b;
    }

    public interface IMyUserScreen {
        void endMyLife();
    }
}
