package itesm.mx.proyectofinal.principal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.ScreenManager;
import itesm.mx.proyectofinal.mano.intromanoclass;
import itesm.mx.proyectofinal.p2p.P2PStarter_c;

/**
 * Created by Martin RB on 27/03/2018.
 */

public class MenuDeActividades extends Fragment implements View.OnClickListener {

    Button botonpantallamano;
    Button botonpantallap2p;
    ScreenManager screenManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.layout_juegos, container, false);
    }
    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        Activity a = getActivity();
        screenManager = (MainActivity)a;


        screenManager.setBack(null);

        botonpantallamano = a.findViewById(R.id.botonmano);
        botonpantallap2p = a.findViewById(R.id.botonp2p);

        botonpantallap2p.setOnClickListener(this);
        botonpantallamano.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonmano:
                screenManager.changeScreen(new intromanoclass());
                break;

            case R.id.botonp2p:
                screenManager.changeScreen(new P2PStarter_c());
                break;
        }
    }
}
