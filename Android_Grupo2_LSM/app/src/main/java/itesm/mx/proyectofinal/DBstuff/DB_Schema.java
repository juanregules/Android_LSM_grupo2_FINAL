package itesm.mx.proyectofinal.DBstuff;

import android.provider.BaseColumns;

/**
 * Created by Martin RB on 26/03/2018.
 */

public final class DB_Schema {
    private DB_Schema() {

    }

    public static final class UsuarioTable implements BaseColumns {
        public static final String TABLE = "Usuario";
        public static final String C_NOMBRE = "nombre_usuario";
        public static final String C_IMAGEN = "imagen";
    }

    public static final class P2PTable implements BaseColumns {
        public static final String TABLE = "Juego_P2P";
        public static final String C_NOMBRE_CONTRINCANTE = "nombre_contrincante";
        public static final String C_PUNTAJE_CONTRINCANTE = "puntaje_contrincante";
        public static final String C_NOMBRE_MIO = "nombre_mio";
        public static final String C_PUNTAJE_MIO = "puntaje_mio";
        public static final String C_FECHA_HORA = "fecha_hora";
    }

    public static final class ManoTable implements BaseColumns {
        public static final String TABLE = "Juego_Mano";
        public static final String C_PUNTAJE = "puntaje";
        public static final String C_FECHA_HORA = "fecha_hora";
    }
}
