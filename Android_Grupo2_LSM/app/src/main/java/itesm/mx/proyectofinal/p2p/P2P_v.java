package itesm.mx.proyectofinal.p2p;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.extras.ImageMastah;

public class P2P_v {

    // inicio
    private Button in_btnCreate;
    private Button in_btnJoin;

    // waitConn
    private TextView waitConn_tvMensaje;
    private ListView waitConn_lvConns;

    // answerer
    private ImageView ans_ivFoto;
    private Button ans_btnRendirse;
    private Button ans_btnResponder;
    private TextView ans_tvEsperando;
    private EditText ans_etRespuesta;

    // asker
    private Button ask_btnRendirse;
    private Button ask_btnTomarFoto;
    private Button ask_btnPreguntar;
    private TextView ask_tvEsperando;
    private ImageView ask_ivFoto;
    private EditText ask_etRespuesta;

    // waitRes
    private TextView waitRes_tvMensaje;

    // result
    private ImageView res_ivBackground;
    private TextView res_tvResultado;
    private Button res_btnContinuar;

    private Context contexto;
    private View.OnClickListener clickListener;
    private AdapterView.OnItemClickListener itemClickListener;
    private IMyScreen screen;
    private Activity a;

    public P2P_v(Context contexto, View.OnClickListener clickListener){
        this.clickListener = clickListener;
        this.contexto = contexto;
        a = (Activity) contexto;
    }

    public P2P_v(Context contexto, AdapterView.OnItemClickListener itemClickListener){
        this.contexto = contexto;
        this.itemClickListener = itemClickListener;
        a = (Activity) contexto;
    }

    // Inicializadores
    public void initInicio(){
        in_btnCreate = a.findViewById(R.id.in_btnCreate);
        in_btnJoin = a.findViewById(R.id.in_btnJoin);

        in_btnCreate.setOnClickListener(clickListener);
        in_btnJoin.setOnClickListener(clickListener);
    }

    public void initWaitConn(boolean esCliente){
        waitConn_tvMensaje = a.findViewById(R.id.waitConn_tvMensaje);
        waitConn_lvConns = a.findViewById(R.id.waitConn_lvConns);

        if(esCliente){
            waitConn_tvMensaje.setText("Buscando partidas");
            waitConn_lvConns.setOnItemClickListener(itemClickListener);
        }
        else{
            waitConn_lvConns.setVisibility(View.INVISIBLE);
            waitConn_tvMensaje.setText("Esperando jugador");
        }
    }

    public void initAsker(){
        ask_btnPreguntar = a.findViewById(R.id.asker_btnPreguntar);
        ask_btnRendirse = a.findViewById(R.id.asker_btnRendirse);
        ask_btnTomarFoto = a.findViewById(R.id.asker_btnTomarFoto);
        ask_tvEsperando = a.findViewById(R.id.asker_tvEsperando);
        ask_etRespuesta = a.findViewById(R.id.asker_etRespuesta);
        ask_ivFoto = a.findViewById(R.id.asker_ivFoto);
        ask_tvEsperando.setVisibility(View.INVISIBLE);

        ask_btnPreguntar.setOnClickListener(clickListener);
        ask_btnRendirse.setOnClickListener(clickListener);
        ask_btnTomarFoto.setOnClickListener(clickListener);
    }

    public void initAnswerer(){
        ans_btnRendirse = a.findViewById(R.id.answerer_btnRendirse);
        ans_btnResponder = a.findViewById(R.id.answerer_btnResponder);
        ans_etRespuesta = a.findViewById(R.id.answerer_etRespuesta);
        ans_tvEsperando = a.findViewById(R.id.answerer_tvEsperando);
        ans_ivFoto = a.findViewById(R.id.answerer_ivFoto);

        ans_btnResponder.setOnClickListener(clickListener);
        ans_btnRendirse.setOnClickListener(clickListener);
        ans_btnResponder.setClickable(false);
    }

    public void initResultado(boolean esResultadoCorrecto, boolean esAsker){
        res_btnContinuar = a.findViewById(R.id.resultado_btnContinuar);
        res_ivBackground = a.findViewById(R.id.resultado_ivBackground);
        res_tvResultado = a.findViewById(R.id.resultado_tvResultado);

        res_btnContinuar.setOnClickListener(clickListener);
        if(esResultadoCorrecto){
            res_ivBackground.setBackgroundColor(a.getResources().getColor(R.color.p2p_res_correct));
            if(esAsker){
                res_tvResultado.setText("Le atino!");
            }
            else{
                res_tvResultado.setText("Correcto!");
            }
        }
        else{
            res_ivBackground.setBackgroundColor(a.getResources().getColor(R.color.p2p_res_incorrect));
            if(esAsker){
                res_tvResultado.setText("No le atino!!");
            }
            else{
                res_tvResultado.setText("Incorrecto!");
            }
        }
    }


    // Datos aparte
    public void asker_setWait(){
        ask_tvEsperando.setVisibility(View.VISIBLE);
        ask_btnTomarFoto.setClickable(false);
        ask_btnPreguntar.setClickable(false);
    }

    public void asker_setPhoto(byte[] foto){
        ask_ivFoto.setImageBitmap(
                ImageMastah.fromByteArrayToBitmap(foto)
        );
    }

    public byte[] asker_getPhoto(){
        return ImageMastah.fromBitmapToByteArray(
                ImageMastah.getBitmapFromImageView(ask_ivFoto)
        );
    }

    public String asker_getAnswer(){
        return ask_etRespuesta.getText().toString();
    }

    public void answerer_unsetWait(){
        ans_tvEsperando.setVisibility(View.INVISIBLE);
        ans_btnResponder.setClickable(true);
    }

    public void answerer_setPhoto(byte[] foto){
        ans_ivFoto.setImageBitmap(
                ImageMastah.fromByteArrayToBitmap(foto)
        );
    }

    public String answerer_getAnswer(){
        return ans_etRespuesta.getText().toString();
    }

    public void waitConn_setConnectionsList(ArrayList<String> lista){
        try{
            if(waitConn_lvConns == null)
                throw new IllegalStateException("Pantalla 'waitConn' no inicializada");
            waitConn_lvConns.setAdapter(new ArrayAdapter<String>(
                    contexto,
                    R.layout.support_simple_spinner_dropdown_item,
                    lista)
            );
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(contexto, "ERROR: Checar log", Toast.LENGTH_SHORT).show();
        }
    }
}