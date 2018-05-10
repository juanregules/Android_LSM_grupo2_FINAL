package itesm.mx.proyectofinal.mano;

import android.view.View;
import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.ScreenManager;
import itesm.mx.proyectofinal.principal.MainActivity;

/**
 * Created by 59159 on 25/04/2018.
 */

public class intromanoclass extends android.app.Fragment implements View.OnClickListener {
    ScreenManager screenManager;
    Activity a;
    ImageButton botonintro;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.intromano, container, false);
    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        a = getActivity();
        screenManager = (MainActivity)a;

        botonintro = a.findViewById(R.id.botonintro);
        botonintro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonintro:
                screenManager.changeScreen(new PantallaMano());
        }
    }
}
