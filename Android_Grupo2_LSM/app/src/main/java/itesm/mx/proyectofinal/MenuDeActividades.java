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
import android.support.v7.app.AppCompatActivity;

import itesm.mx.proyectofinal.extras.IMyScreen;

/**
 * Created by Martin RB on 27/03/2018.
 */

public class MenuDeActividades extends Fragment implements View.OnClickListener {

    Button botonpantallamano;
    Button botonpantallap2p;
    TextView text;
    Activity a;
    IMyScreen userScreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.layout_juegos, container, false);
    }
    @Override
    public void onAttach(Context con) {
        super.onAttach(con);
        a = (Activity) con;
        try {
            userScreen = (IMyScreen) a;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        botonpantallamano=a.findViewById(R.id.botonmano);
        botonpantallap2p=a.findViewById(R.id.botonp2p);
        botonpantallap2p.setOnClickListener(this);
        botonpantallamano.setOnClickListener(this);

        userScreen.establecerPantallaAnterior(null);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.botonmano:
            {
                if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                    getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaMano()).commit();
                    //cargaba PantallaDummy()
                } else {
                    getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaMano()).commit();
                    //cargaba PantallaDummy()
                }

            };


            break;
            case R.id.botonp2p:
            {
                if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                    getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaP2p()).commit();
                    //cargaba PantallaDummy()
                } else {
                    getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaP2p()).commit();
                    //cargaba PantallaDummy()
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
