package itesm.mx.proyectofinal.usuario;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Operations;
import itesm.mx.proyectofinal.bdd.DB_Schema;
import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.transports.ManoGameData;
import itesm.mx.proyectofinal.transports.P2PGameData;

public class PuntajesControlador extends ListFragment {

    Context contexto;
    IMyScreen fatherActivity;
    SimpleDateFormat dateFormat;
    DB_Operations dbOp;
    PuntajesVista vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.usrscn_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getActivity();
        vista = new PuntajesVista(contexto, getListView());
        setFatherActivity();
        dateFormat = new SimpleDateFormat("dd/MM/YYYY hh:mm");
        dbOp = new DB_Operations(contexto);

        // Procesos

        Bundle args = getArguments();
        if(args != null){
            dbOp.open();
            switch (args.getString("nombreJuego")){
                case DB_Schema.ManoTable.TABLE:
                    mostrarMano();
                    break;
                case DB_Schema.P2PTable.TABLE:
                    mostrarP2P();
                    break;
            }
            dbOp.close();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void setFatherActivity() {
        try{
            fatherActivity = (IMyScreen) contexto;
        }
        catch (Exception e){

        }
    }

    private void mostrarMano(){
        ManoGameData manoData = dbOp.obtenerScoreMano();
        ArrayList<String> datos = new ArrayList<>();

        if(manoData.getFecha() == null){
            datos.add("No has jugado partidas de la mano.\nJuega ya en la sección de actividades");
        }
        else{
            datos.add(
                    String.format("Maximo puntaje: %s. Fecha: %s",
                            manoData.getPuntaje(),
                            dateFormat.format(manoData.getFecha().toString())
                    )
            );
        }

        vista.mostrarDatos(datos);
    }

    private void mostrarP2P(){
        ArrayList<P2PGameData> p2pData = dbOp.obtenerScoreP2P();
        ArrayList<String> datos = new ArrayList<>();

        if(p2pData.size() == 0){
            datos.add("No has jugado partidas de P2P.\nJuega ya en la sección de actividades");
        }
        else{
            for(P2PGameData dat : p2pData){
                datos.add(
                        String.format("%s: %s <---> %s :%s\nFecha: %s",
                                dat.getNombreMio(),
                                dat.getPuntajeMio(),
                                dat.getPuntajeVs(),
                                dat.getNombreVs(),
                                dateFormat.format(dat.getFecha()))
                );
            }
        }


        vista.mostrarDatos(datos);
    }
}
