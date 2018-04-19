package itesm.mx.proyectofinal;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import itesm.mx.proyectofinal.Glosario.GlosarioAnimales;
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
        animalesBtn.setOnClickListener(myClickListener);
    }

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
                getFragmentManager().beginTransaction().replace(R.id.pantalla, new GlosarioAnimales()).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.pantalla, new GlosarioAnimales()).commit();
            }
        }
    };



}
