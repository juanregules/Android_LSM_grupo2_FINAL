package itesm.mx.proyectofinal.expand;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import itesm.mx.proyectofinal.R;
import mx.itesm.expandablerecyclerview.viewholders.ChildViewHolder;
/*
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
* */
public class ContentViewHolder extends ChildViewHolder {

    private TextView childTextView;
    private VideoView childVideo;
    private ImageView childImage;

    public ContentViewHolder(View itemView) {
        super(itemView);
        childVideo = (VideoView) itemView.findViewById(R.id.childVideo);
        childImage = (ImageView) itemView.findViewById(R.id.childImage);
    }

    public void setContentName(String name) {
            childVideo.setVisibility(View.VISIBLE);
            childImage.setVisibility(View.INVISIBLE);
            childVideo.setVideoURI(Uri.parse(name));
            childVideo.start();

    }

    public void setContentName(String name, Drawable drawable){
        childImage.setVisibility(View.VISIBLE);
        childVideo.setVisibility(View.INVISIBLE);
        childImage.setImageDrawable(drawable);
    }
}
