package itesm.mx.proyectofinal.usuario;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.ImageMastah;
import itesm.mx.proyectofinal.extras.Tuple;

public class PerfilVista {

    Context contexto;

    private TextView tvNombreUsuario;
    private EditText etNombreUYsuario;
    private ImageView ivImagen;
    private Button btnPuntuaciones;
    private Button btnIniEditar;
    private Button btnAccEditar;
    private Button btnCanEditar;
    private Button btnCambiarFoto;

    public PerfilVista(Context contexto, View.OnClickListener listener){
        this.contexto = contexto;

        Activity act = (Activity) contexto;
        // declaracion
        tvNombreUsuario = act.findViewById(R.id.usrscn_tvUsrName);
        etNombreUYsuario = act.findViewById(R.id.usrscn_etUsrName);
        btnIniEditar = act.findViewById(R.id.usrscn_btnEdith);
        btnCambiarFoto = act.findViewById(R.id.usrscn_btnPhotoEdith);
        btnAccEditar = act.findViewById(R.id.usrscn_btnFinishEdith);
        btnCanEditar = act.findViewById(R.id.usrscn_btnCancelEdith);
        btnPuntuaciones = act.findViewById(R.id.usrscn_btnScores);
        ivImagen = act.findViewById(R.id.usrscn_ivPhoto);

        btnIniEditar.setOnClickListener(listener);
        btnCambiarFoto.setOnClickListener(listener);
        btnAccEditar.setOnClickListener(listener);
        btnCanEditar.setOnClickListener(listener);
        btnPuntuaciones.setOnClickListener(listener);
    }

    public void setNombre(String nombre){
        tvNombreUsuario.setText(nombre);
    }
    public String getNombre(){
        return tvNombreUsuario.getText().toString();
    }

    public void setImagen(Bitmap foto){
        ivImagen.setImageBitmap(foto);
    }
    public byte[] getImagen(){
        // Regresa la imagen actual. Si se cancela, el sistema pondra la foto anterior
        return ImageMastah.fromBitmapToByteArray(
                ImageMastah.getBitmapFromImageView(ivImagen)
        );
    }

    public void setNombreEditable(String nombre){
        etNombreUYsuario.setText(nombre);
    }
    public String getNombreEditable(){
        return etNombreUYsuario.getText().toString();
    }

    public void setEdicion(){
        btnIniEditar.setVisibility(View.INVISIBLE);
        btnPuntuaciones.setVisibility(View.INVISIBLE);
        tvNombreUsuario.setVisibility(View.INVISIBLE);

        btnAccEditar.setVisibility(View.VISIBLE);
        btnCanEditar.setVisibility(View.VISIBLE);
        etNombreUYsuario.setVisibility(View.VISIBLE);
        btnCambiarFoto.setVisibility(View.VISIBLE);
    }
    public void unSetEdicion(){
        btnIniEditar.setVisibility(View.VISIBLE);
        btnPuntuaciones.setVisibility(View.VISIBLE);
        tvNombreUsuario.setVisibility(View.VISIBLE);

        btnAccEditar.setVisibility(View.INVISIBLE);
        btnCanEditar.setVisibility(View.INVISIBLE);
        etNombreUYsuario.setVisibility(View.INVISIBLE);
        btnCambiarFoto.setVisibility(View.INVISIBLE);
    }
}

