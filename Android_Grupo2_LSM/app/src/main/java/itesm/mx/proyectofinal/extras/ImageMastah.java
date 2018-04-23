package itesm.mx.proyectofinal.extras;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class ImageMastah {

    public static Bitmap fromByteArrayToBitmap(byte[] foto){
        return BitmapFactory.decodeByteArray(foto, 0, foto.length);
    }
    public static byte[] fromBitmapToByteArray(Bitmap foto){
        Bitmap b = foto;
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, s);
        return s.toByteArray();
    }

    public static Bitmap getBitmapFromImageView(ImageView ivFoto){
        Bitmap b;
        Drawable d;

        d = ivFoto.getDrawable();
        b = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b);
        d.setBounds(0,0,canvas.getWidth(), canvas.getHeight());
        d.draw(canvas);
        return b;
    }
}
