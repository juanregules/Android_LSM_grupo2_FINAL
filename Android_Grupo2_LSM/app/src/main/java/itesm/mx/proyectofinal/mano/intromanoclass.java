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
 * Created by Juan Regules on 25/04/2018.
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
 *
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
