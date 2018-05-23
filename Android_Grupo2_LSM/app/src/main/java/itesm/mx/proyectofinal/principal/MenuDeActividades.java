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
 */

public class MenuDeActividades extends Fragment implements View.OnClickListener {

    private Button botonpantallamano;
    private Button botonpantallap2p;
    private ScreenManager screenManager;

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
