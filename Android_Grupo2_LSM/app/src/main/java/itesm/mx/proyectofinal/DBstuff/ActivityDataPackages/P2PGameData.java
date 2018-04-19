package itesm.mx.proyectofinal.DBstuff.ActivityDataPackages;

import java.util.Date;

import itesm.mx.proyectofinal.DBstuff.DB_Schema;

/**
 * Created by Martin RB on 26/03/2018.
 */

public class P2PGameData extends GameData {
    private String nombreContrincante;
    private int puntajeContrincante;
    private String nombreMio;
    private int puntajeMio;
    private Date fecha;

    public P2PGameData(String nombreContrincante, int puntajeContrincante, String nombreMio, int puntajeMio, Date fecha) {
        this.nombreContrincante = nombreContrincante;
        this.puntajeContrincante = puntajeContrincante;
        this.nombreMio = nombreMio;
        this.puntajeMio = puntajeMio;
        this.fecha = fecha;
        tipoJuego = DB_Schema.P2PTable.TABLE;
    }

    public String getNombreContrincante() {
        return nombreContrincante;
    }

    public int getPuntajeContrincante() {
        return puntajeContrincante;
    }

    public String getNombreMio() {
        return nombreMio;
    }

    public int getPuntajeMio() {
        return puntajeMio;
    }

    public Date getFecha() {
        return fecha;
    }
}
