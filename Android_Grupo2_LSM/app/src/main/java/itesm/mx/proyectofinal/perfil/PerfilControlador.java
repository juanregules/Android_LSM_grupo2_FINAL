package itesm.mx.proyectofinal.perfil;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Operations;
import itesm.mx.proyectofinal.extras.ImageMastah;
import itesm.mx.proyectofinal.extras.ScreenManager;
import itesm.mx.proyectofinal.principal.MainActivity;

public class PerfilControlador extends Fragment implements View.OnClickListener {

    private DB_Operations dbOps;
    private ScreenManager screenManager;
    private PerfilVista vista;

    private byte[] fotoAntigua;
    private boolean enEdicion;

    private final int CAMERA_REQUEST = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.usr_scn, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        // Inicializacion de variables
        Context contexto = getActivity();
        screenManager = (MainActivity) contexto;
        vista = new PerfilVista(contexto, this);
        dbOps = new DB_Operations(contexto);
        fotoAntigua = null;
        enEdicion = false;
        String textoAnterior;

        screenManager.setBack(null);
        if(savedInstanceState != null){
            enEdicion = savedInstanceState.getBoolean("enEdicion");
        }

        if(enEdicion){
            byte[] fotoNueva = savedInstanceState.getByteArray("fotoNueva");
            fotoAntigua = savedInstanceState.getByteArray("fotoAntigua");
            textoAnterior = savedInstanceState.getString("textoAnterior");

            vista.setEdicion();
            vista.setNombreEditable(textoAnterior);
            vista.setImagen(
                    ImageMastah.fromByteArrayToBitmap(fotoNueva)
            );
        }
        else{
            vista.setImagen(
                    ImageMastah.fromByteArrayToBitmap(dbOps.obtenerFoto())
            );

            String nombre = dbOps.obtenerNombre();
            if(nombre.equals("")){
                vista.setNombre("No name");
            }
            else{
                vista.setNombre(nombre);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putBoolean("enEdicion", enEdicion);
        savedInstanceState.putByteArray("fotoNueva", vista.getImagen());
        savedInstanceState.putByteArray("fotoAntigua", fotoAntigua);
        savedInstanceState.putString("textoAnterior", vista.getNombreEditable());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case CAMERA_REQUEST:
                if(resultCode == -1){
                    vista.setImagen((Bitmap)data.getExtras().get("data"));
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // Empieza a modificar
            case R.id.usrscn_btnEdith:
                iniEditar();
                //fatherActivity.establecerPantallaAnterior(new PerfilControlador());
                break;
            // Deja de modificar
            case R.id.usrscn_btnFinishEdith:
                finEditar(true);
                //fatherActivity.establecerPantallaAnterior(null);
                break;
            // Cancela la modificacion
            case R.id.usrscn_btnCancelEdith:
                finEditar(false);
               // fatherActivity.establecerPantallaAnterior(null);
                break;
            // Ir a los puntajes
            case R.id.usrscn_btnScores:
                abrirPantallaPuntajes();
                break;
            // Modificar la imagen
            case R.id.usrscn_btnPhotoEdith:
                tomarFoto();
                break;
        }
    }

    @Deprecated
    public boolean estaEnEdicion(){
        return enEdicion;
    }

    private void tomarFoto(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, CAMERA_REQUEST);
    }

    private void abrirPantallaPuntajes(){
        screenManager.changeScreen(new ListaControlador());
    }

    private void iniEditar(){
        screenManager.setBack(new PerfilControlador());
        vista.setEdicion();
        vista.setNombreEditable(vista.getNombre());
        fotoAntigua = vista.getImagen();
        enEdicion = true;
    }

    private void finEditar(boolean seGuardar){
        if(seGuardar){
            vista.unSetEdicion();

            vista.setNombre(vista.getNombreEditable());
            dbOps.cambiarNombre(vista.getNombreEditable());
            dbOps.cambiarFoto(vista.getImagen());
            enEdicion = false;
        }
        else{
            vista.unSetEdicion();
            enEdicion = false;
            vista.setImagen(
                    ImageMastah.fromByteArrayToBitmap(fotoAntigua)
            );
        }
    }
}
