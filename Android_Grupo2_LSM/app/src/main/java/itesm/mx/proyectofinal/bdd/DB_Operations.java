package itesm.mx.proyectofinal.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;
import android.util.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import itesm.mx.proyectofinal.transports.GameData;
import itesm.mx.proyectofinal.transports.ManoGameData;
import itesm.mx.proyectofinal.transports.P2PGameData;


/**
 * Created by Martin RB on 26/03/2018.
 */

/*CLASE ENCARGADA DE OPERACIONES COMUNES EN LA BASE DE DATOS. SON FUNCIONES MAS QUE NADA DE
 * CONSULTA Y ACTUALIZACION*/
public class DB_Operations {
    private DB_Handler DBHandler;
    private SQLiteDatabase db;
    private SimpleDateFormat dateFormat;

    public DB_Operations(Context con){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DBHandler = new DB_Handler(con);
        open();
        //DBHandler.onUpgrade(db, 0,0);
    }

    // Open y close diferenciados por si a acaso
    public void open(){
        try{
            if(db == null || !db.isOpen()){
                db = DBHandler.getWritableDatabase();
            }
        } catch ( SQLException e){
            Log.e("SQL_UWU", e.toString());
        }
    }
    public void close(){
        db.close();
    }

    public void cambiarNombre(String nombre){
        open();
        String query = "UPDATE " + DB_Schema.UsuarioTable.TABLE +
                " SET " + DB_Schema.UsuarioTable.C_NOMBRE + " = '" + nombre + "'";

        db.execSQL(query);
    }
    public void cambiarFoto(byte[] foto){
        if(foto == null){
            return;
        }
        ContentValues values = new ContentValues();
        values.put(DB_Schema.UsuarioTable.C_IMAGEN, foto);
        db.update(DB_Schema.UsuarioTable.TABLE, values, DB_Schema.UsuarioTable.C_NOMBRE + " is not null", null);
        /*db.execSQL(query);*/
    }
    public String obtenerNombre(){
        Cursor c;
        String query;

        query = "SELECT *" + /*DB_Schema.UsuarioTable.C_NOMBRE +*/
                " FROM " + DB_Schema.UsuarioTable.TABLE;
        c = db.rawQuery(query, null);
        if(c.moveToFirst()){
            return c.getString(c.getColumnIndex(DB_Schema.UsuarioTable.C_NOMBRE));
        }
        c.close();
        return null;
    }
    public byte[] obtenerFoto(){
        Cursor c;
        String query;

        query = "SELECT " + DB_Schema.UsuarioTable.C_IMAGEN +
                " FROM " + DB_Schema.UsuarioTable.TABLE;
        c = db.rawQuery(query, null);
        if(c.moveToFirst()){
            byte[] b = c.getBlob(c.getColumnIndex(DB_Schema.UsuarioTable.C_IMAGEN));
            return b;
        }
        c.close();
        return null;
    }

    public void agregarPuntuacion(GameData data) {
        switch (data.getTipoJuego()){

            case DB_Schema.ManoTable.TABLE:
                agregarPuntuacionMano(data);
                break;


            case DB_Schema.P2PTable.TABLE:
                agregarPuntuacionP2P(data);
                break;


            default:
                try{throw new Exception(
                        "Tipo de juego " + "'" + data.getTipoJuego() + "'" + " no implementado");
                }
                catch (Exception e){e.printStackTrace();}
                break;
        }
    }
    public ArrayList<P2PGameData> obtenerScoreP2P() {
        ArrayList<P2PGameData> data;
        String query;
        Cursor c;
        Date fecha;

        fecha = null;
        data = new ArrayList<>();
        query = "SELECT * "+
                " FROM " + DB_Schema.P2PTable.TABLE +
                " ORDER BY " + DB_Schema.P2PTable.C_FECHA_HORA;
        c = db.rawQuery(query, null);
        while (c.moveToNext()){
            try {
                fecha = dateFormat.parse(c.getString(c.getColumnIndex(DB_Schema.P2PTable.C_FECHA_HORA)));
            } catch (ParseException e) { e.printStackTrace();}

            data.add(new P2PGameData(
                    c.getString(c.getColumnIndex(DB_Schema.P2PTable.C_NOMBRE_CONTRINCANTE)),
                    c.getInt(c.getColumnIndex(DB_Schema.P2PTable.C_PUNTAJE_CONTRINCANTE)),
                    c.getString(c.getColumnIndex(DB_Schema.P2PTable.C_NOMBRE_MIO)),
                    c.getInt(c.getColumnIndex(DB_Schema.P2PTable.C_PUNTAJE_MIO)),
                    fecha
            ));
        }
        c.close();
        return data;
    }
    public ManoGameData obtenerScoreMano() {
        String query;
        Cursor c;
        Date fecha;

        fecha = null;
        query = "SELECT * " +
                " FROM " + DB_Schema.ManoTable.TABLE;
        c = db.rawQuery(query, null);
        if(c.moveToNext() && c.getCount() > 0){
            try {
                fecha = dateFormat.parse(c.getString(c.getColumnIndex(DB_Schema.ManoTable.C_FECHA_HORA)));
            } catch (ParseException e) { e.printStackTrace(); }

            return new ManoGameData(
                    c.getInt(c.getColumnIndex(DB_Schema.ManoTable.C_PUNTAJE)),
                    fecha
            );
        }
        c.close();
        return new ManoGameData(
                0,
                null
        );
    }


    // Funciones auxiliares
    private void agregarPuntuacionMano(GameData data){
        String query;
        Cursor c;
        ManoGameData m;

        m = (ManoGameData)data;
        query = "SELECT " + DB_Schema.ManoTable._ID + ", " + DB_Schema.ManoTable.C_PUNTAJE +
                " FROM " + DB_Schema.ManoTable.TABLE;
        c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            if(c.getInt(1) <= m.getPuntaje()){
                // PUNTUACION MAXIMA
                query = "UPDATE " + DB_Schema.ManoTable.TABLE +
                        " SET " + DB_Schema.ManoTable.C_PUNTAJE + "=" + m.getPuntaje() +
                        " WHERE " + DB_Schema.ManoTable._ID + "=" + c.getInt(0);
                c = db.rawQuery(query, null);
                c.moveToFirst();
                c.close();
            }
            else{
                //NO ES PUNTUACION MAXIMA
            }
        }
        else{
            // NO HAY PUNTUACIONES REGISTRADAS
            query = "INSERT INTO " + DB_Schema.ManoTable.TABLE +
                    " (" + DB_Schema.ManoTable.C_PUNTAJE + ", " + DB_Schema.ManoTable.C_FECHA_HORA +
                    ") VALUES ('" + m.getPuntaje() + "', '" + dateFormat.format(m.getFecha()) + "') ";
            c = db.rawQuery(query, null);
            c.moveToFirst();
            c.close();
        }
    }
    private void agregarPuntuacionP2P(GameData data) {
        P2PGameData p;
        String query;
        Cursor c;
        String fecha;

        p = (P2PGameData)data;
        query = "SELECT " + DB_Schema.P2PTable._ID + ", " + DB_Schema.P2PTable.C_FECHA_HORA +
                " FROM " + DB_Schema.P2PTable.TABLE +
                " ORDER BY " + DB_Schema.P2PTable.C_FECHA_HORA;
        c = db.rawQuery(query, null);

        if(c.getCount() == 20){
            //La tabla tiene 20 registros\
            /* Emcontrar el registro de tiempo mas antiguo
             * TODO: Tambien buscar puntaje mas alto y guardarlo
             */
            Pair<Date, Integer> fechaMenor = new Pair<>(new Date(), -1);
            while(c.moveToNext()){
                Date fechaRegistro = null;
                try {
                    fechaRegistro = dateFormat.parse(c.getString(1));
                } catch (ParseException e) {
                    fechaRegistro = new Date();
                    ;                }
                int diferencia = fechaMenor.first.compareTo(fechaRegistro);

                if(diferencia >= 0){
                    fechaMenor = new Pair<>(fechaRegistro, c.getInt(0));
                }
            }
            // * Reemplazar el registro menor por el registro mas nuevo
            fecha = dateFormat.format(p.getFecha());
            query = "UPDATE " + DB_Schema.P2PTable.TABLE +
                    " SET " +
                    DB_Schema.P2PTable.C_NOMBRE_CONTRINCANTE+"='"+p.getNombreVs()+"',"+
                    DB_Schema.P2PTable.C_PUNTAJE_CONTRINCANTE+"="+p.getPuntajeVs()+","+
                    DB_Schema.P2PTable.C_NOMBRE_MIO+"='"+p.getNombreMio()+"',"+
                    DB_Schema.P2PTable.C_PUNTAJE_MIO+"="+p.getPuntajeMio()+","+
                    DB_Schema.P2PTable.C_FECHA_HORA+"='"+fecha+
                    "' WHERE " + DB_Schema.P2PTable._ID + " = " + fechaMenor.second;
            c = db.rawQuery(query, null);
            c.moveToFirst();
            c.close();
        }
        else{
            // La tabla tiene menos de 20 registros. Se pueden agregar registros
            fecha = dateFormat.format(p.getFecha());
            query = "INSERT INTO " + DB_Schema.P2PTable.TABLE +
                    "(" +
                    DB_Schema.P2PTable.C_NOMBRE_CONTRINCANTE + "," +
                    DB_Schema.P2PTable.C_PUNTAJE_CONTRINCANTE + "," +
                    DB_Schema.P2PTable.C_NOMBRE_MIO + "," +
                    DB_Schema.P2PTable.C_PUNTAJE_MIO + "," +
                    DB_Schema.P2PTable.C_FECHA_HORA +
                    ")" +
                    " VALUES (" +
                    "'" + p.getNombreVs() + "'," +
                    p.getPuntajeVs() + "," +
                    "'" + p.getNombreMio() + "'," +
                    p.getPuntajeMio() + "," +
                    "'" + fecha + "'" +
                    ")";
            c = db.rawQuery(query, null);
            c.moveToFirst();
            c.close();
        }
    }
}
