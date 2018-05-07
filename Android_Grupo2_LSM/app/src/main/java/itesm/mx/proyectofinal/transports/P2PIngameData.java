package itesm.mx.proyectofinal.transports;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import itesm.mx.proyectofinal.extras.Tuple;

@SuppressLint("ParcelCreator")
public class P2PIngameData implements Parcelable {

    public static final byte GAME_PREGUNTA = 0x0;
    public static final byte GAME_RESPUESTA = 0x1;
    public static final byte WAITCON_KIMINONAWA = 0x2;
    public static final byte RESULTS_SIGUIENTEPREGUNTA = 0x3;

    private byte tipo;
    private ArrayList<Object> datos;
    // 0: Pregunta  -   esAcierto
    // 1: imagen    -   null

    public P2PIngameData(Parcel p){
        datos = new ArrayList<>();
        tipo = p.readByte();
        switch (tipo){
            case GAME_PREGUNTA:
                String sTemp = p.readString();
                int iTemp = p.readInt();
                byte[] bTemp = new byte[iTemp];
                p.readByteArray(bTemp);

                datos.add(sTemp);
                datos.add(bTemp);
                break;
            case GAME_RESPUESTA:
                boolean[] boTemp = new boolean[1];
                p.readBooleanArray(boTemp);

                datos.add(boTemp[0]);
                break;
        }
    }

    public P2PIngameData(byte[] bytes){
        datos = new ArrayList<>();
        try{
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream out = new ObjectInputStream (bais);

            tipo = out.readByte();
            int arrSize = out.readInt();
            for(int i = 0; i < arrSize; i++){
                datos.add(out.readObject());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public P2PIngameData(byte tipo){
        datos = new ArrayList<>();
        this.tipo = tipo;
    }


    public void agregarDatos_pregunta(String pregunta, byte[] imagen){
        if(tipo != GAME_PREGUNTA){
            return;
        }
        datos.add(pregunta);
        datos.add(imagen);
    }

    public void agregarDatos_resultados(boolean esAcierto) {
        if(tipo != GAME_RESPUESTA){
            return;
        }
        datos.add(esAcierto);
    }

    public void agregarDatos_nombre(String nombre){
        if(tipo != WAITCON_KIMINONAWA){
            return;
        }
        datos.add(nombre);
    }


    public Tuple<String, byte[]> obtenerDatos_pregunta(){
        if(tipo != GAME_PREGUNTA){
            return null;
        }
        return new Tuple<>(String.valueOf(datos.get(0)), (byte[])datos.get(1));
    }

    public boolean obtenerDatos_resultados(){
        if(tipo != GAME_RESPUESTA){
            return false;
        }
        return (Boolean)(datos.get(0));
    }

    public String obtenerDatos_nombre(){
        return String.valueOf(datos.get(0));
    }


    public byte getTipo() {
        return tipo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(tipo);
        switch (tipo){
            case GAME_PREGUNTA:
                byte[] bArrTemp = (byte[])datos.get(1);
                parcel.writeString((String)datos.get(0));
                parcel.writeInt(bArrTemp.length);
                parcel.writeByteArray(bArrTemp);
                break;
            case GAME_RESPUESTA:
                boolean[] boArrTemp = new boolean[]{ (boolean)datos.get(0) };
                parcel.writeBooleanArray(boArrTemp);
                break;
        }
    }

    private void readFromParcel(){

    }

    public byte[] getBytes(){
        byte[] bytes = new byte[0];

        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream (baos);

            out.writeByte(tipo);
            out.writeInt(datos.size());
            for(Object o: datos){
                out.writeObject(o);
            }
            out.flush();
            bytes = baos.toByteArray();
            out.close();
            baos.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return bytes;
    }
}