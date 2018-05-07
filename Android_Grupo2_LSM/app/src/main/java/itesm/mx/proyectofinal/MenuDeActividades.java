package itesm.mx.proyectofinal;

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

import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.mano.intromanoclass;
import itesm.mx.proyectofinal.p2p.P2PStarter_c;

/**
 * Created by Martin RB on 27/03/2018.
 */

public class MenuDeActividades extends Fragment implements View.OnClickListener {

    Button botonpantallamano;
    Button botonpantallap2p;
    TextView text;
    Activity a;
    //IMyScreen userScreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.layout_juegos, container, false);
    }
    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        Activity a = getActivity();
        botonpantallamano=a.findViewById(R.id.botonmano);
        botonpantallap2p=a.findViewById(R.id.botonp2p);
        botonpantallap2p.setOnClickListener(this);
        botonpantallamano.setOnClickListener(this);

        //userScreen.establecerPantallaAnterior(null);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.botonmano:
            {
                if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                    getFragmentManager().beginTransaction().replace(R.id.pantalla, new intromanoclass()).commit();//PantallaMano
                    //cargaba PantallaDummy()
                } else {
                    getFragmentManager().beginTransaction().add(R.id.pantalla, new intromanoclass()).commit();  //PantallaMano
                    //cargaba PantallaDummy()
                }

            };


            break;
            case R.id.botonp2p:
            {
                if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                    getFragmentManager().beginTransaction().replace(R.id.pantalla, new P2PStarter_c()).addToBackStack(null).commit();
                } else {
                    getFragmentManager().beginTransaction().add(R.id.pantalla, new P2PStarter_c()).addToBackStack(null).commit();
                }
            };


            break;

            default:
                // Try catch vacio. Adrmiralo un momento
                try {
                    throw new Exception("No existe el boton: " + v.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }


}
