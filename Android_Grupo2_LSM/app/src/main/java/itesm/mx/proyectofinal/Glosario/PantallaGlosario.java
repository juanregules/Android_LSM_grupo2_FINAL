package itesm.mx.proyectofinal.Glosario;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import itesm.mx.proyectofinal.Glosario.GlosarioAbecedario;
import itesm.mx.proyectofinal.Glosario.GlosarioAnimales;
import itesm.mx.proyectofinal.Glosario.GlosarioColores;
import itesm.mx.proyectofinal.Glosario.GlosarioComida;
import itesm.mx.proyectofinal.Glosario.GlosarioDias;
import itesm.mx.proyectofinal.Glosario.GlosarioMeses;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.expand.ExpandActivity;

/**
 * Created by 59159 on 16/04/2018.
 */

public class PantallaGlosario extends Fragment{
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.layout_glosario, container, false);
    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        ImageButton animalesBtn = (ImageButton) getActivity().findViewById(R.id.animalesBtn);
        ImageButton abecedarioBtn = (ImageButton) getActivity().findViewById(R.id.abecedarioBtn);
        ImageButton coloresBtn = (ImageButton) getActivity().findViewById(R.id.coloresBtn);
        ImageButton comidaBtn = (ImageButton) getActivity().findViewById(R.id.comidaBtn);
        ImageButton diasBtn = (ImageButton) getActivity().findViewById(R.id.diasBtn);
        ImageButton mesesBtn = (ImageButton) getActivity().findViewById(R.id.mesesBtn);
        animalesBtn.setOnClickListener(animalesAction);
        abecedarioBtn.setOnClickListener(abecedarioAction);
        coloresBtn.setOnClickListener(coloresAction);
        comidaBtn.setOnClickListener(comidaAction);
        diasBtn.setOnClickListener(diasAction);
        mesesBtn.setOnClickListener(mesesAction);
    }

    private View.OnClickListener animalesAction = new View.OnClickListener() {
        public void onClick(View v) {
            if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                getFragmentManager().beginTransaction().replace(R.id.pantalla, new GlosarioAnimales()).addToBackStack(null).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.pantalla, new GlosarioAnimales()).addToBackStack(null).commit();
            }
        }
    };

    private View.OnClickListener abecedarioAction = new View.OnClickListener() {
        public void onClick(View v) {
            if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                getFragmentManager().beginTransaction().replace(R.id.pantalla, new GlosarioAbecedario()).addToBackStack(null).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.pantalla, new GlosarioAbecedario()).addToBackStack(null).commit();
            }
        }
    };

    private View.OnClickListener coloresAction = new View.OnClickListener() {
        public void onClick(View v) {
            if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                getFragmentManager().beginTransaction().replace(R.id.pantalla, new GlosarioColores()).addToBackStack(null).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.pantalla, new GlosarioColores()).addToBackStack(null).commit();
            }
        }
    };

    private View.OnClickListener comidaAction = new View.OnClickListener() {
        public void onClick(View v) {
            if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                getFragmentManager().beginTransaction().replace(R.id.pantalla, new GlosarioComida()).addToBackStack(null).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.pantalla, new GlosarioComida()).addToBackStack(null).commit();
            }
        }
    };


    private View.OnClickListener diasAction = new View.OnClickListener() {
        public void onClick(View v) {
            if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                getFragmentManager().beginTransaction().replace(R.id.pantalla, new GlosarioDias()).addToBackStack(null).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.pantalla, new GlosarioDias()).addToBackStack(null).commit();
            }
        }
    };


    private View.OnClickListener mesesAction = new View.OnClickListener() {
        public void onClick(View v) {
            if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                getFragmentManager().beginTransaction().replace(R.id.pantalla, new GlosarioMeses()).addToBackStack(null).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.pantalla, new GlosarioMeses()).addToBackStack(null).commit();
            }
        }
    };





}
