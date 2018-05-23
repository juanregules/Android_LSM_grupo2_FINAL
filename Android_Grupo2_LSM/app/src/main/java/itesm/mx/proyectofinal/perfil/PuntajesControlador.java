package itesm.mx.proyectofinal.perfil;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.bdd.DB_Operations;
import itesm.mx.proyectofinal.bdd.DB_Schema;
import itesm.mx.proyectofinal.extras.ScreenManager;
import itesm.mx.proyectofinal.perfil.ListviewAdapters.ManoAdapter;
import itesm.mx.proyectofinal.principal.MainActivity;
import itesm.mx.proyectofinal.transports.ManoGameData;
import itesm.mx.proyectofinal.transports.P2PGameData;


/*
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
* */
public class PuntajesControlador extends ListFragment {

    private Context contexto;
    ScreenManager screenManager;
    SimpleDateFormat dateFormat;
    DB_Operations dbOp;
    PuntajesVista vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.usrscn_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getActivity();
        vista = new PuntajesVista(contexto, getListView());
        screenManager = (MainActivity)contexto;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        dbOp = new DB_Operations(contexto);

        // Procesos
        screenManager.setBack(new ListaControlador());
        Bundle args = getArguments();
        if(args != null){
            switch (args.getString("nombreJuego")){
                case DB_Schema.ManoTable.TABLE:
                    mostrarMano();
                    break;
                case DB_Schema.P2PTable.TABLE:
                    mostrarP2P();
                    break;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void mostrarMano(){
        ArrayList<ManoGameData> data = new ArrayList<>();
        ManoGameData manoData = dbOp.obtenerScoreMano();

        data.add(manoData);
        vista.mostrarDatos_mano(data);
    }

    private void mostrarP2P(){
        vista.mostrarDatos_p2p(dbOp.obtenerScoreP2P());
    }
}