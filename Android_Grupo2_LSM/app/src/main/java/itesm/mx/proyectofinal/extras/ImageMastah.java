package itesm.mx.proyectofinal.extras;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

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
* */


public class ImageMastah {

    public static Bitmap fromByteArrayToBitmap(byte[] foto){
        if(foto != null)
            return BitmapFactory.decodeByteArray(foto, 0, foto.length);
        else
            return null;
    }
    public static byte[] fromBitmapToByteArray(Bitmap foto){
        if(foto == null)
            return null;
        Bitmap b = foto;
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, s);
        return s.toByteArray();
    }

    public static Bitmap getBitmapFromImageView(ImageView ivFoto){
        Bitmap b;
        Drawable d;

        d = ivFoto.getDrawable();
        if(d.getIntrinsicHeight() < 0 || d.getIntrinsicWidth() < 0)
            return null;
        b = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b);
        d.setBounds(0,0,canvas.getWidth(), canvas.getHeight());
        d.draw(canvas);
        return b;
    }
}
