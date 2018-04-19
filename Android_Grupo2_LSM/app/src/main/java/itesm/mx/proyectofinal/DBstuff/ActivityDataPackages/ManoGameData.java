package itesm.mx.proyectofinal.DBstuff.ActivityDataPackages;

import java.util.Date;

import itesm.mx.proyectofinal.DBstuff.DB_Schema;

/**
 * Created by Martin RB on 26/03/2018.
 */

public class ManoGameData extends GameData {
    private int puntaje;
    private Date fecha;

    public ManoGameData(int puntaje, Date fecha) {
        this.puntaje = puntaje;
        this.fecha = fecha;
        tipoJuego = DB_Schema.ManoTable.TABLE;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public Date getFecha() {
        return fecha;
    }
}
