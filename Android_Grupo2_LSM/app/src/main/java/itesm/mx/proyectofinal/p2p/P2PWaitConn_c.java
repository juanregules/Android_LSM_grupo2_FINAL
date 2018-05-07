package itesm.mx.proyectofinal.p2p;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Operations;
import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.extras.Tuple;
import itesm.mx.proyectofinal.transports.P2PIngameData;

public class P2PWaitConn_c extends Fragment implements AdapterView.OnItemClickListener {

    private Context contexto;
    private P2P_v vista;
    private boolean esCliente;
    //private ArrayList<String> listConns;
    private String yo;

    private CommSystem commSystem;
    private DB_Operations dbOperations;
    private ArrayList<Tuple<String, String>> connections;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle b = getArguments();
        esCliente = b.getBoolean("esCliente");

        return inflater.inflate(R.layout.p2p_waitconn, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getActivity();
        vista = new P2P_v(contexto, this);
        vista.initWaitConn(esCliente);

        dbOperations = new DB_Operations(contexto);
        dbOperations.open();
        yo = dbOperations.obtenerNombre();
        dbOperations.close();


        commSystem = CommSystem.createCommSystem(
                contexto,
                this,
                yo);


        // Inicio
        if(esCliente){
            commSystem.startDiscovery();
            connections = new ArrayList<>();
            vista.waitConn_setConnectionsList(new ArrayList<String>());
        }
        else{
            commSystem.startAnnounce();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //iniciarConexion(connections.get(i));
        Tuple <String, String> temp = connections.get(i);
        commSystem.conectar(temp.getFirst(), temp.getSecond());
    }


    // Cliente
    public void agregarConexion(String endpoint, String username){
        connections.add(new Tuple<String, String>(endpoint, username));
        ArrayList<String> s = new ArrayList<>();
        for (Tuple<String, String> con : connections) {
            s.add(con.getSecond());
        }
        vista.waitConn_setConnectionsList(s);
    }

    public void eliminarConexion(String endpoint){
        ArrayList<String> s = new ArrayList<>();
        for (Tuple<String, String> con : connections) {
            if(con.getFirst().equals(endpoint)){
                connections.remove(con);
            }
            else{
                s.add(con.getSecond());
            }
        }
        vista.waitConn_setConnectionsList(s);
    }

    public void iniciarConexion(String elOtroEndpointName){
        P2PGame_c game = new P2PGame_c();
        Bundle b = new Bundle();
        b.putBoolean("esAsker", false);
        b.putInt("puntajeMio", 0);
        b.putInt("puntajeVs", 0);
        b.putString("nombreMio", yo);
        b.putString("nombreVs", elOtroEndpointName);
        game.setArguments(b);

        getFragmentManager().beginTransaction()
                .replace(R.id.pantalla, game)
                .commit();
    }


    // Servidor
    public void conexionEntrante(String yo, String vs){
        P2PGame_c game = new P2PGame_c();
        Bundle b = new Bundle();
        b.putBoolean("esAsker", true);
        b.putInt("puntajeMio", 0);
        b.putInt("puntajeVs", 0);
        b.putString("nombreMio", yo);
        b.putString("nombreVs", vs);
        game.setArguments(b);

        getFragmentManager().beginTransaction()
                .replace(R.id.pantalla, game)
                .commit();
    }
}
