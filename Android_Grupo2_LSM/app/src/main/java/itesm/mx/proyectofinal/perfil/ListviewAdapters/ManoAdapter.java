package itesm.mx.proyectofinal.perfil.ListviewAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.transports.ManoGameData;
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
*
*
* */
public class ManoAdapter extends ArrayAdapter {
    Context contexto;
    ArrayList<ManoGameData> data;

    public ManoAdapter(Context contexto, ArrayList<ManoGameData> data){
        super(contexto, 0, data);
        this.contexto = contexto;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(convertView == null){
            LayoutInflater inflater =
                    (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.usrscn_score_mano, null);
        }

        ManoGameData gameData = data.get(position);
        if(gameData != null){
            Date d = gameData.getFecha();
            if(d != null){
                row.findViewById(R.id.usrscn_score_mano_clPuntaje).setVisibility(View.VISIBLE);

                TextView tvPuntaje = row.findViewById(R.id.usrscn_score_mano_tvPuntaje);
                TextView tvFecha = row.findViewById(R.id.usrscn_score_mano_tvFecha);

                tvPuntaje.setText(String.valueOf(gameData.getPuntaje()));
                tvFecha.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(gameData.getFecha()));
            }
            else{
                row.findViewById(R.id.usrscn_score_mano_tvSinPuntaje).setVisibility(View.VISIBLE);
            }
        }
        return row;
    }
}
