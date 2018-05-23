package itesm.mx.proyectofinal.perfil;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Schema;
import itesm.mx.proyectofinal.extras.ScreenManager;
import itesm.mx.proyectofinal.principal.MainActivity;

/*
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
* */



public class ListaControlador extends Fragment implements View.OnClickListener{

    private Context contexto;
    private ScreenManager screenManager;
    private ListaVista vista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.usrscn_scores_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Declaracion
        contexto = getActivity();
        screenManager = (MainActivity)contexto;
        vista = new ListaVista(contexto, this);

        // Procesos
        screenManager.setBack(new PerfilControlador());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usrscn_scores_menu_btnMano:
                consultarPuntuacion(DB_Schema.ManoTable.TABLE);
                break;
            case R.id.usrscn_scores_menu_btnP2P:
                consultarPuntuacion(DB_Schema.P2PTable.TABLE);
                break;
        }
    }

    private void consultarPuntuacion(String nombreJuego){

        PuntajesControlador controlador = new PuntajesControlador();
        Bundle b = new Bundle();
        b.putString("nombreJuego", nombreJuego);
        controlador.setArguments(b);

        screenManager.changeScreen(controlador);
    }
}
