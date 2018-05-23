package itesm.mx.proyectofinal.expand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import itesm.mx.proyectofinal.Glosario.Content;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.Glosario.Word;
import mx.itesm.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import mx.itesm.expandablerecyclerview.models.ExpandableGroup;



/*
*
* LSM - descripción_proyecto
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
* */

public class WordAdapter extends ExpandableRecyclerViewAdapter<WordViewHolder, ContentViewHolder> {

    public WordAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public WordViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_word, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public ContentViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_content, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ContentViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final Content artist = ((Word) group).getItems().get(childIndex);
        if(!artist.isFavorite())
        holder.setContentName(artist.getName());
        else
        holder.setContentName(artist.getName(), artist.getDrawable());
    }

    @Override
    public void onBindGroupViewHolder(WordViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {

        holder.setWordTitle(group);
    }
}
