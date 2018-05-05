package itesm.mx.proyectofinal.p2p;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;

import id.zelory.compressor.Compressor;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Operations;
import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.transports.P2PGameData;
import itesm.mx.proyectofinal.transports.P2PIngameData;

public class P2PGame_c extends Fragment implements View.OnClickListener {

    private Context contexto;
    private P2P_v vista;
    private int puntajeMio;
    private int puntajeVs;
    private String nombreMio;
    private String nombreVs;
    private boolean esAsker;

    private CommSystem commSystem;
    private String respuesta;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle b = getArguments();
        esAsker = b.getBoolean("esAsker");
        puntajeMio = b.getInt("puntajeMio");
        puntajeVs = b.getInt("puntajeVs");
        nombreMio = b.getString("nombreMio");
        nombreVs = b.getString("nombreVs");

        int lay = -1;
        if(esAsker){
            lay = R.layout.p2p_asker;
        }
        else{
            lay = R.layout.p2p_answerer;
        }
        return inflater.inflate(lay, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getActivity();
        vista = new P2P_v(contexto, this);
        commSystem = CommSystem.createCommSystem(contexto, this, nombreMio);
        if(esAsker){
            vista.initAsker();
        }
        else{
            vista.initAnswerer();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.asker_btnRendirse:
                rendirse();
                break;
            case R.id.asker_btnPreguntar:
                enviarPregunta();
                break;
            case R.id.asker_btnTomarFoto:
                tomarFoto();
                break;

            case R.id.answerer_btnRendirse:
                rendirse();
                break;
            case R.id.answerer_btnResponder:
                enviarRespuesta();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void rendirse(){
        commSystem.desconectar();
        desconeccion();
    }

    public void desconeccion(){
        // Guardar datos

        DB_Operations operations = new DB_Operations(contexto);
        P2PGameData gameData = new P2PGameData(nombreMio, puntajeMio, nombreVs, puntajeVs, new Date());

        operations.open();
        operations.agregarPuntuacion(gameData);
        operations.close();
    }

    private void roleJudger(){

    }


    // Asker
    private void tomarFoto(){

    }

    private void enviarPregunta(){
        vista.asker_setWait();
        String ans = vista.asker_getAnswer();
        byte[] photo = vista.asker_getPhoto();
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0, photo.length);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
        photo = outputStream.toByteArray();
        P2PIngameData ingameData = new P2PIngameData(P2PIngameData.GAME_PREGUNTA);
        ingameData.agregarDatos_pregunta(ans, photo);

        commSystem.enviarDatos(ingameData);
    }

    public void irAResultados(boolean esAcierto){
        if(esAcierto){
            puntajeVs++;
        }
        P2PResult_c resultC = new P2PResult_c();
        Bundle b = new Bundle();
        b.putBoolean("esAcierto", esAcierto);
        b.putBoolean("esAsker", esAsker);
        b.putInt("puntajeMio", puntajeMio);
        b.putInt("puntajeVs", puntajeVs);
        b.putString("nombreMio", nombreMio);
        b.putString("nombreVs", nombreVs);

        resultC.setArguments(b);
        getFragmentManager().beginTransaction()
                .replace(R.id.pantalla, resultC)
                .commit();
    }



    // Answr
    public void endWaitMode(String respuesta, byte[] imagen){
        this.respuesta = respuesta;
        vista.answerer_setPhoto(imagen);
        vista.answerer_unsetWait();
    }

    private void enviarRespuesta(){
        P2PIngameData ingameData = new P2PIngameData(P2PIngameData.GAME_RESPUESTA);
        String miRespuesta = vista.answerer_getAnswer();
        boolean esAcierto = miRespuesta.equalsIgnoreCase(respuesta);
        ingameData.agregarDatos_resultados(esAcierto);

        commSystem.enviarDatos(ingameData);

        if(esAcierto){
            puntajeMio++;
        }
        P2PResult_c resultC = new P2PResult_c();
        Bundle b = new Bundle();
        b.putBoolean("esAcierto", esAcierto);
        b.putBoolean("esAsker", esAsker);
        b.putInt("puntajeMio", puntajeMio);
        b.putInt("puntajeVs", puntajeVs);
        b.putString("nombreMio", nombreMio);
        b.putString("nombreVs", nombreVs);
        resultC.setArguments(b);

        resultC.setArguments(b);
        getFragmentManager().beginTransaction()
                .replace(R.id.pantalla, resultC)
                .commit();
    }

}
