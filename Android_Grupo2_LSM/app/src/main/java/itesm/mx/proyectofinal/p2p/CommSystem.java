package itesm.mx.proyectofinal.p2p;

import android.app.Fragment;
import android.content.Context;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.Toast;

import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import itesm.mx.proyectofinal.extras.Tuple;
import itesm.mx.proyectofinal.transports.P2PGameData;
import itesm.mx.proyectofinal.transports.P2PIngameData;
/*
*
*  LSM - descripción_proyecto
  Elaborar una aplicación para Android en la que los usuarios
  puedan aprender mediante un glosario
 y dos juegos interactivos la Lengua de Señas Mexicana,
  de una manera entretenida.

 Copyright (C) 2018 - ITESM

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
*
* */
public class CommSystem {

    private Fragment controller;
    private ConnectionsClient clientConns;
    private String elOtroEndpoint;
    private String elOtroEndpointName;
    private String elOtroEndpointName_Temp;
    private String miEndpoint;
    private Context contexto;
    private static CommSystem disObj;
    private ArrayList<Long> payloadsReceived;

    private InputStream in;

    private CommSystem(Context contexto, Fragment controller, String miEndpoint){
        this.controller = controller;
        this.miEndpoint = miEndpoint;
        this.contexto = contexto;

        clientConns = Nearby.getConnectionsClient(contexto);
        payloadsReceived = new ArrayList<>();
    }
    public static CommSystem createCommSystem(Context contexto, Fragment controller, String miNombre){
        if(disObj == null) {
            disObj = new CommSystem(contexto, controller, miNombre);
        }
        else{
            if(!contexto.equals(CommSystem.disObj.contexto)){
                CommSystem.disObj.contexto = contexto;
            }
            if(!controller.equals(CommSystem.disObj.controller)){
                CommSystem.disObj.controller = controller;
            }
            if(!miNombre.equals(disObj.miEndpoint)){
                CommSystem.disObj.miEndpoint = miNombre;
            }
        }
        return disObj;
    }


    public void startAnnounce(){

        clientConns.startAdvertising(miEndpoint, contexto.getPackageName(), announce_clC, new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_STAR).build())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Notificar buen funcionamiento
                        Toast.makeText(contexto, "Buscando...", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Notificar el error
                        Toast.makeText(contexto, "Error al buscar...", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                });
    }
    private final ConnectionLifecycleCallback announce_clC = new ConnectionLifecycleCallback() {
        @Override
        public void onConnectionInitiated(@NonNull String endPointID, @NonNull ConnectionInfo connectionInfo) {
            clientConns.acceptConnection(endPointID, announce_pC);
        }

        @Override
        public void onConnectionResult(@NonNull String endPointID, @NonNull ConnectionResolution connectionResolution) {
            // Si la conexion es correcta. Saltar al asker
            elOtroEndpoint = endPointID;
            switch (connectionResolution.getStatus().getStatusCode()){
                case ConnectionsStatusCodes.STATUS_OK:
                    clientConns.stopAdvertising();
                    break;
                case ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED:
                    Toast.makeText(contexto, "Conexion negada", Toast.LENGTH_SHORT).show();
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR:
                    Toast.makeText(contexto, "Error en la conexion", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void onDisconnected(@NonNull String endPointID) {
            // Guardar datos y salir al menu principal
            try{
                if(controller instanceof P2PGame_c) {
                    ((P2PGame_c) controller).desconeccion();
                }
                else if(controller instanceof P2PResult_c){
                    ((P2PResult_c) controller).desconeccion();
                }
            }
            catch (Exception e){
                Toast.makeText(contexto, "Debes presionar el boton de rendicion. No se guardaran los datos", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    };
    private final PayloadCallback announce_pC = new PayloadCallback() {
        @Override
        public void onPayloadReceived(@NonNull String endPointID, @NonNull Payload payload) {
            // Realizar acciones dependiendo del tipo de dato
            payloadsReceived.add(payload.getId());
            try{
                //Toast.makeText(contexto, "processing", Toast.LENGTH_SHORT).show();
                in = payload.asStream().asInputStream();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onPayloadTransferUpdate(@NonNull String endPointID, @NonNull PayloadTransferUpdate payloadTransferUpdate) {
            // No c xd
            // No c xd

            //String datos = "";
            //datos += String.valueOf(payloadTransferUpdate.getStatus() == PayloadTransferUpdate.Status.IN_PROGRESS);
            //datos += String.valueOf(payloadTransferUpdate.getBytesTransferred()) + " : ";
            //datos += String.valueOf(payloadTransferUpdate.getPayloadId()) + " : ";
            //datos += String.valueOf(payloadTransferUpdate.getTotalBytes()) + " : ";

            if(payloadTransferUpdate.getStatus() == PayloadTransferUpdate.Status.SUCCESS){
                //Toast t = Toast.makeText(contexto, datos + " - Correcto", Toast.LENGTH_LONG);
                //t.setGravity(Gravity.CENTER, 0, 50);
                //t.show();

                Long packageID = payloadTransferUpdate.getPayloadId();
                if(payloadsReceived.contains(packageID)){
                    dataJudger(new P2PIngameData(fromPayloadToByteArr(Payload.fromStream(in))));
                    payloadsReceived.remove(packageID);
                }
            }
        }
    };



    public void startDiscovery(){
        clientConns.startDiscovery(contexto.getPackageName(), discov_edC, new DiscoveryOptions.Builder().setStrategy(Strategy.P2P_STAR).build())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(contexto, "Buscando...", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(contexto, "Error al buscar!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                });
    }
    private final EndpointDiscoveryCallback discov_edC = new EndpointDiscoveryCallback() {
        @Override
        public void onEndpointFound(@NonNull String endpointID, @NonNull DiscoveredEndpointInfo discoveredEndpointInfo) {
            // Enviar nuevo endpoint
            ((P2PWaitConn_c)controller).enlistarConexion(endpointID, discoveredEndpointInfo.getEndpointName());
        }

        @Override
        public void onEndpointLost(@NonNull String endPointID) {
            // Remover endpoint
            ((P2PWaitConn_c)controller).deslistarConexion(endPointID);
        }
    };

    public void conectar(final String endpoint, String name){
        elOtroEndpointName_Temp = name;
        clientConns.requestConnection(contexto.getPackageName(), endpoint, discov_clC).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(contexto, "Oponente desconectado", Toast.LENGTH_SHORT).show();
                ((P2PWaitConn_c)controller).deslistarConexion(endpoint);
                ((P2PWaitConn_c)controller).limpiarConexiones();
                desconectar();
                startDiscovery();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                clientConns.stopDiscovery();
                elOtroEndpointName = elOtroEndpointName_Temp;
            }
        });

    }
    private final ConnectionLifecycleCallback discov_clC = new ConnectionLifecycleCallback() {
        @Override
        public void onConnectionInitiated(@NonNull String endpointID, @NonNull ConnectionInfo connectionInfo) {
            clientConns.acceptConnection(endpointID, discov_pC);
            // Notificar que se esta conectando
        }

        @Override
        public void onConnectionResult(@NonNull String endpointID, @NonNull ConnectionResolution connectionResolution) {
            // Si ya se conecto, notificar y pasar al answerer
            // Guardar el dato en la clase actual
            elOtroEndpoint = endpointID;
            switch (connectionResolution.getStatus().getStatusCode()){
                case ConnectionsStatusCodes.STATUS_OK:
                    Toast.makeText(contexto, "Conectado con " + elOtroEndpointName, Toast.LENGTH_SHORT).show();

                    // Decirle al host cual es tu nombre
                    P2PIngameData data = new P2PIngameData(P2PIngameData.WAITCON_KIMINONAWA);
                    data.agregarDatos_nombre(miEndpoint);
                    enviarDatos(data);

                    ((P2PWaitConn_c)controller).iniciarConexion(elOtroEndpointName);

                    break;
                case ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED:
                    Toast.makeText(contexto, "Conexion negada", Toast.LENGTH_SHORT).show();
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR:
                    Toast.makeText(contexto, "Error en la conexion", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void onDisconnected(@NonNull String s) {
            // Salir al menu principal
            try{
                if(controller instanceof P2PGame_c) {
                    ((P2PGame_c) controller).desconeccion();
                }
                else if(controller instanceof P2PResult_c){
                    ((P2PResult_c) controller).desconeccion();
                }
            }
            catch (Exception e){
                Toast.makeText(contexto, "Debes presionar el boton de rendicion. No se guardaran los datos", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    };
    private final PayloadCallback discov_pC = new PayloadCallback() {
        @Override
        public void onPayloadReceived(@NonNull String endpointID, @NonNull Payload payload) {
            payloadsReceived.add(payload.getId());
            try{
                //Toast.makeText(contexto, "processing", Toast.LENGTH_SHORT).show();
                in = payload.asStream().asInputStream();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onPayloadTransferUpdate(@NonNull String s, @NonNull PayloadTransferUpdate payloadTransferUpdate) {
            // No c xd

            //String datos = "";
            //datos += String.valueOf(payloadTransferUpdate.getStatus() == PayloadTransferUpdate.Status.IN_PROGRESS);
            //datos += String.valueOf(payloadTransferUpdate.getBytesTransferred()) + " : ";
            //datos += String.valueOf(payloadTransferUpdate.getPayloadId()) + " : ";
            //datos += String.valueOf(payloadTransferUpdate.getTotalBytes()) + " : ";

            if(payloadTransferUpdate.getStatus() == PayloadTransferUpdate.Status.SUCCESS){
                //Toast t = Toast.makeText(contexto, datos + " - Correcto", Toast.LENGTH_LONG);
                //t.setGravity(Gravity.CENTER, 0, 50);
                //t.show();

                Long packageID = payloadTransferUpdate.getPayloadId();
                if(payloadsReceived.contains(packageID)){
                    dataJudger(new P2PIngameData(fromPayloadToByteArr(Payload.fromStream(in))));
                    payloadsReceived.remove(payloadsReceived.indexOf(packageID));
                }
            }
            if(payloadTransferUpdate.getStatus() == PayloadTransferUpdate.Status.IN_PROGRESS) {
                //Toast t = Toast.makeText(contexto, datos + " - in progress", Toast.LENGTH_LONG);
                //t.setGravity(Gravity.CENTER, 0, 50);
                //t.show();
            }
            if(payloadTransferUpdate.getStatus() == PayloadTransferUpdate.Status.FAILURE) {
                //Toast t = Toast.makeText(contexto, datos + " - fail", Toast.LENGTH_LONG);
                //t.setGravity(Gravity.CENTER, 0, 50);
                //t.show();
            }
            if(payloadTransferUpdate.getStatus() == PayloadTransferUpdate.Status.CANCELED){
                //Toast t = Toast.makeText(contexto, datos + " - Cancel", Toast.LENGTH_LONG);
                //t.setGravity(Gravity.CENTER, 0, 50);
                //t.show();
            }
        }
    };



    public void DEBUG_DETERMINARPAQUETE(PayloadTransferUpdate payloadTransferUpdate){

    }
    public void dataJudger(P2PIngameData data){
        switch (data.getTipo()){
            case P2PIngameData.GAME_PREGUNTA:
                Tuple<String, byte[]> tempP = data.obtenerDatos_pregunta();
                ((P2PGame_c)controller).endWaitMode(tempP.getFirst(), tempP.getSecond());
                break;
            case P2PIngameData.GAME_RESPUESTA:
                boolean tempR = data.obtenerDatos_resultados();
                ((P2PGame_c)controller).irAResultados(data.obtenerDatos_resultados());
                break;
            case P2PIngameData.RESULTS_SIGUIENTEPREGUNTA:
                if(controller instanceof P2PResult_c){
                    ((P2PResult_c)controller).siguientePregunta();
                }
                break;
            case P2PIngameData.WAITCON_KIMINONAWA:
                elOtroEndpointName = data.obtenerDatos_nombre();
                Toast.makeText(contexto, "Conectado con " + elOtroEndpointName, Toast.LENGTH_SHORT).show();
                ((P2PWaitConn_c)controller).conexionEntrante(miEndpoint, elOtroEndpointName);
                break;
        }
    }
    public void enviarDatos(P2PIngameData datos){
        // POSIBLE ERROR EN EL TAMAÑO DE STREAM!!!!!!!!!!!
        byte[] bytes = datos.getBytes();
        int a = bytes.length;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        byteArrayInputStream.available();
        clientConns.sendPayload(
                elOtroEndpoint,
                Payload.fromStream(
                        byteArrayInputStream
                )
        );
    }
    public void desconectar(){
        if(elOtroEndpoint != null)
            clientConns.disconnectFromEndpoint(elOtroEndpoint);
        clientConns.stopDiscovery();
        clientConns.stopAllEndpoints();
    }
    private byte[] fromPayloadToByteArr(Payload p){
        byte[] bytes = null;
        try{
            InputStream stream = p.asStream().asInputStream();
            bytes = new byte[stream.available()];
            stream.read(bytes);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bytes;
    }
}
