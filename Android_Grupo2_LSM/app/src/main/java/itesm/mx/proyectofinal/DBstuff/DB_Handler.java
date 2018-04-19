package itesm.mx.proyectofinal.DBstuff;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Martin RB on 26/03/2018.
 */

/* CLASE QUE SE ENCARGA DE OPERACIONES BASICAS DE LA BASE DE DATOS. EN ESTE CASO ESTAN DEFINIDAS
* LAS FUNCIONES DE CREACION Y ACTUALIZACION DE BASE DE DATOS*/
public class DB_Handler extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "IdontknowwhyItdoesntevenmatterhowhardyoutry.db";
    private static int DATABAE_VERSION = 1;

    protected DB_Handler(Context con) {
        super(con, DATABASE_NAME, null, DATABAE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Crear tablas
        String CREAR_USUARIO = "CREATE TABLE " +
                DB_Schema.UsuarioTable.TABLE +
                "(" +
                DB_Schema.UsuarioTable._ID + " integer primary key AUTOINCREMENT," +
                DB_Schema.UsuarioTable.C_NOMBRE + " varchar(15)," +
                DB_Schema.UsuarioTable.C_IMAGEN + " blob" +
                ");";
        String CREAR_P2P_TABLE = "CREATE TABLE " +
                DB_Schema.P2PTable.TABLE +
                "(" +
                DB_Schema.P2PTable._ID + " integer primary key AUTOINCREMENT," +
                DB_Schema.P2PTable.C_PUNTAJE_MIO + " INT NOT NULL, " +
                DB_Schema.P2PTable.C_PUNTAJE_CONTRINCANTE + " INT NOT NULL, " +
                DB_Schema.P2PTable.C_NOMBRE_MIO + " VARCHAR(15) NOT NULL, " +
                DB_Schema.P2PTable.C_NOMBRE_CONTRINCANTE + " VARCHAR(15) NOT NULL, " +
                DB_Schema.P2PTable.C_FECHA_HORA + " DATETIME NOT NULL" +
                ");";
        String CREAR_MANO_TABLE = "CREATE TABLE " +
                DB_Schema.ManoTable.TABLE +
                "(" +
                DB_Schema.ManoTable._ID + " integer primary key AUTOINCREMENT," +
                DB_Schema.ManoTable.C_PUNTAJE + " INT NOT NULL, " +
                DB_Schema.ManoTable.C_FECHA_HORA + " DATETIME " +
                ");";

        Log.i("Query_onCreate", CREAR_USUARIO);
        db.execSQL(CREAR_USUARIO);
        Log.i("Query_onCreate", CREAR_P2P_TABLE);
        db.execSQL(CREAR_P2P_TABLE);
        Log.i("Query_onCreate", CREAR_MANO_TABLE);
        db.execSQL(CREAR_MANO_TABLE);

        // Insertar fila de informacion del Usuario
        String insertar = "INSERT INTO " + DB_Schema.UsuarioTable.TABLE +
                " (" + DB_Schema.UsuarioTable.C_NOMBRE +
                ") VALUES (" + "'NONAME'" + ");";
        Log.i("Query_onCreate", insertar);
        Cursor c = db.rawQuery(insertar, null);
        c.moveToFirst();
        c.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DEL_UsuarioTable = "drop table if exists " +
                DB_Schema.UsuarioTable.TABLE + ";";
        String DEL_P2PTable = "drop table if exists " +
                DB_Schema.P2PTable.TABLE + ";";
        String DEL_ManoTable = "drop table if exists " +
                DB_Schema.ManoTable.TABLE + ";";

        Log.i("Query_onUpgrade", DEL_UsuarioTable);
        db.execSQL(DEL_UsuarioTable);
        Log.i("Query_onUpgrade", DEL_ManoTable);
        db.execSQL(DEL_ManoTable);
        Log.i("Query_onUpgrade", DEL_P2PTable);
        db.execSQL(DEL_P2PTable);
        onCreate(db);
    }
}
