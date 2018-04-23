package itesm.mx.proyectofinal.extras;

import android.app.Fragment;

public interface IMyScreen {
    public void cambiarPantalla(Fragment siguientePantalla);
    public void establecerPantallaAnterior(Fragment pantallaAnterior);
}
