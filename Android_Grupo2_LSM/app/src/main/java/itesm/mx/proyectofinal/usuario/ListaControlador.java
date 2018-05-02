package itesm.mx.proyectofinal.usuario;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itesm.mx.proyectofinal.MenuDeActividades;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Schema;
import itesm.mx.proyectofinal.extras.IMyScreen;

public class ListaControlador extends Fragment implements View.OnClickListener{

    private Context contexto;
    private IMyScreen fatherActivity;
    private ListaVista vista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.usrscn_scores_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Declaracion
        contexto = getActivity();
        setFatherActivity();
        vista = new ListaVista(contexto, this);

        // Procesos
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usrscn_scores_menu_btnMano:
                consultarPuntuacion(DB_Schema.ManoTable.TABLE);
                break;
            case R.id.usrscn_scores_menu_btnP2P:
                consultarPuntuacion(DB_Schema.P2PTable.TABLE);
                break;
        }
    }

    private void setFatherActivity(){
        try{
            fatherActivity = (IMyScreen) contexto;
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void consultarPuntuacion(String nombreJuego){
        /*
        PuntajesControlador controlador = new PuntajesControlador();
        Bundle b = new Bundle();
        b.putString("nombreJuego", nombreJuego);
        controlador.setArguments(b);
*/
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PuntajesControlador()).addToBackStack(null).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PuntajesControlador()).addToBackStack(null).commit();
        }
    }
}
