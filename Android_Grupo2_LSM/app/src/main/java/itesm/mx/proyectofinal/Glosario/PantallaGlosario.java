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
 *
 *
 *  LSM - descripción_proyecto
 Elaborar una aplicación para Android en la que los usuarios
 puedan aprender mediante un glosario
 y dos juegos interactivos la Lengua de Señas Mexicana,
 de una manera entretenida.

 Copyright (C) 2018 - ITESM

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *
 *
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
