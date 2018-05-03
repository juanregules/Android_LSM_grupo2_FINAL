package itesm.mx.proyectofinal.transports;

import java.util.Date;

import itesm.mx.proyectofinal.bdd.DB_Schema;

/**
 * Created by Martin RB on 26/03/2018.
 */

public class P2PGameData extends GameData {
    private String nombreVs;
    private int puntajeVs;
    private String nombreMio;
    private int puntajeMio;
    private Date fecha;

    public P2PGameData(String nombreMio, int puntajeMio, String nombreVs, int puntajeVs, Date fecha) {
        this.nombreVs = nombreVs;
        this.puntajeVs = puntajeVs;
        this.nombreMio = nombreMio;
        this.puntajeMio = puntajeMio;
        this.fecha = fecha;
        tipoJuego = DB_Schema.P2PTable.TABLE;
    }

    public String getNombreVs() {
        return nombreVs;
    }

    public int getPuntajeVs() {
        return puntajeVs;
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
