package itesm.mx.proyectofinal.perfil;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.perfil.ListviewAdapters.ManoAdapter;
import itesm.mx.proyectofinal.perfil.ListviewAdapters.P2PAdapter;
import itesm.mx.proyectofinal.transports.ManoGameData;
import itesm.mx.proyectofinal.transports.P2PGameData;

public class PuntajesVista {

    Context contexto;
    ListView listView;

    public PuntajesVista(Context contexto, ListView ls) {
        this.contexto = contexto;
        listView = ls;
    }

    public void mostrarDatos_mano(ArrayList<ManoGameData> lista){
        listView.setAdapter(
                new ManoAdapter(
                        contexto,
                        lista
                )
        );
    }
    public void mostrarDatos_p2p(ArrayList<P2PGameData> lista){
        listView.setAdapter(
                new P2PAdapter(
                        contexto,
                        lista
                )
        );
    }
}