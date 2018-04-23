package itesm.mx.proyectofinal.usuario;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.transports.ManoGameData;

public class PuntajesVista {

    Context contexto;
    ListView listView;

    public PuntajesVista(Context contexto, ListView ls) {
        this.contexto = contexto;
        listView = ls;
    }

    public void mostrarDatos(ArrayList<String> lista){
        listView.setAdapter(
                new ArrayAdapter<String>(
                        contexto,
                        R.layout.support_simple_spinner_dropdown_item,
                        lista
                )
        );
    }
}