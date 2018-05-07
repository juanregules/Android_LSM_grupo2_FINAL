package itesm.mx.proyectofinal.p2p;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Operations;
import itesm.mx.proyectofinal.transports.P2PGameData;
import itesm.mx.proyectofinal.transports.P2PIngameData;

public class P2PResult_c extends Fragment implements View.OnClickListener {

    private Context contexto;
    private P2P_v vista;
    private Bundle b;
    CommSystem commSystem;

    boolean cambioDePantalla = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.p2p_resultado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getActivity();
        vista = new P2P_v(contexto, this);

        b = getArguments();
        vista.initResultado(b.getBoolean("esAcierto"), b.getBoolean("esAsker"));
        commSystem = CommSystem.createCommSystem(contexto, this, b.getString("nombreMio"));
    }

    @Override
    public void onClick(View view) {
        cambioDePantalla = true;
        switch (view.getId()){
            case R.id.resultado_btnContinuar:
                P2PIngameData ingameData = new P2PIngameData(P2PIngameData.RESULTS_SIGUIENTEPREGUNTA);
                commSystem.enviarDatos(ingameData);
                siguientePregunta();
                break;
        }
    }

    public void siguientePregunta(){
        Bundle bOut = new Bundle();
        cambioDePantalla = true;

        bOut.putBoolean("esAsker", !b.getBoolean("esAsker"));
        bOut.putInt("puntajeMio", b.getInt("puntajeMio"));
        bOut.putInt("puntajeVs", b.getInt("puntajeVs"));
        bOut.putString("nombreMio", b.getString("nombreMio"));
        bOut.putString("nombreVs", b.getString("nombreVs"));

        P2PGame_c gameC = new P2PGame_c();
        gameC.setArguments(bOut);

        getFragmentManager().beginTransaction()
                .replace(R.id.pantalla, gameC)
                .commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(!cambioDePantalla){
            DB_Operations operations = new DB_Operations(contexto);
            P2PGameData gameData = new P2PGameData(
                    b.getString("nombreMio"),
                    b.getInt("puntajeMio"),
                    b.getString("nombreVs"),
                    b.getInt("puntajeVs"),
                    new Date());

            operations.open();
            operations.agregarPuntuacion(gameData);
            operations.close();
            commSystem.desconectar();

            // Salir al menu principal
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new P2PStarter_c()).commit();
        }
    }
}
