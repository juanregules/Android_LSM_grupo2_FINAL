package itesm.mx.proyectofinal.extras;

import android.app.Fragment;

public interface ScreenManager {
    public void changeScreen(Fragment nextFrag);
    public void setBack(Fragment backFrag);
}
