package itesm.mx.proyectofinal.p2p;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.transports.P2PIngameData;

public class P2PResult_c extends Fragment implements View.OnClickListener {

    private Context contexto;
    private P2P_v vista;
    private Bundle b;

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.resultado_btnContinuar:
                CommSystem commSystem = CommSystem.createCommSystem(contexto, this, b.getString("nombreMio"));
                P2PIngameData ingameData = new P2PIngameData(P2PIngameData.RESULTS_SIGUIENTEPREGUNTA);
                commSystem.enviarDatos(ingameData);
                siguientePregunta();
                break;
        }
    }

    public void siguientePregunta(){
        Bundle bOut = new Bundle();

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
}
