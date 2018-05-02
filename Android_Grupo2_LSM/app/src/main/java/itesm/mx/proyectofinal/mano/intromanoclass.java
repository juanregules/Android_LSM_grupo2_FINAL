package itesm.mx.proyectofinal.mano;

import android.view.View;
import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.usuario.ListaControlador;

/**
 * Created by 59159 on 25/04/2018.
 */

public class intromanoclass extends android.app.Fragment implements View.OnClickListener {
    IMyScreen fatherActivity;
    Context contexto;
    Activity a;
    ImageButton botonintro;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.intromano, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void setFatherActivity() {
        try{
            fatherActivity = (IMyScreen) contexto;
        }
        catch (Exception e){

        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonintro:
                if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                    getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaMano()).commit();
                    //cargaba PantallaDummy()
                } else {
                    getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaMano()).commit();
                    //cargaba PantallaDummy()
                }

        };


    }


    @Override
    public void onAttach(Context con) {
        super.onAttach(con);
        a = (Activity) con;
        try {
            fatherActivity = (IMyScreen) a;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        botonintro=a.findViewById(R.id.botonintro);
        botonintro.setOnClickListener(this);
        contexto = getActivity();



    }
}
