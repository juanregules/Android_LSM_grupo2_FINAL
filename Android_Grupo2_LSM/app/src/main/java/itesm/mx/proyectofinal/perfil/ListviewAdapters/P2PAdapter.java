package itesm.mx.proyectofinal.perfil.ListviewAdapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.transports.P2PGameData;

public class P2PAdapter extends ArrayAdapter{
    Context contexto;
    ArrayList<P2PGameData> data;

    public P2PAdapter(@NonNull Context context, ArrayList<P2PGameData> data) {
        super(context, 0, data);
        contexto = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            LayoutInflater inflater =
                    (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.usrscn_score_p2p, null);
        }


        P2PGameData gameData = data.get(position);
        if(gameData != null){
            if(gameData.getPuntajeMio() == -1){
                row.findViewById(R.id.usrscn_score_p2p_tvSinPuntaje).setVisibility(View.VISIBLE);
                return row;
            }
            else{
                row.findViewById(R.id.usrscn_score_p2p_llPuntaje).setVisibility(View.VISIBLE);
            }

            int puntajeMio = gameData.getPuntajeMio();
            int puntajeVs = gameData.getPuntajeVs();
            if(puntajeMio < puntajeVs){
                ((ConstraintLayout)row
                        .findViewById(R.id.usrscn_score_p2p_clVs))
                        .setBackground(contexto.getResources().getDrawable(R.color.p2p_res_correct));
                ((ConstraintLayout)row
                        .findViewById(R.id.usrscn_score_p2p_clMio))
                        .setBackground(contexto.getResources().getDrawable(R.color.p2p_res_incorrect));
            }
            else if(puntajeMio > puntajeVs){
                ((ConstraintLayout)row
                        .findViewById(R.id.usrscn_score_p2p_clMio))
                        .setBackground(contexto.getResources().getDrawable(R.color.p2p_res_correct));
                ((ConstraintLayout)row
                        .findViewById(R.id.usrscn_score_p2p_clVs))
                        .setBackground(contexto.getResources().getDrawable(R.color.p2p_res_incorrect));
            }
            else{
                ((ConstraintLayout)row
                        .findViewById(R.id.usrscn_score_p2p_clVs))
                        .setBackground(contexto.getResources().getDrawable(R.color.p2p_res_noRes));
                ((ConstraintLayout)row
                        .findViewById(R.id.usrscn_score_p2p_clMio))
                        .setBackground(contexto.getResources().getDrawable(R.color.p2p_res_noRes));
            }

            ((TextView)row.findViewById(R.id.usrscn_score_p2p_tvFecha))
                    .setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(gameData.getFecha()));
            ((TextView)row.findViewById(R.id.usrscn_score_p2p_tvNombreMio))
                    .setText(gameData.getNombreMio());
            ((TextView)row.findViewById(R.id.usrscn_score_p2p_tvPuntajeMio))
                    .setText(String.valueOf(puntajeMio));
            ((TextView)row.findViewById(R.id.usrscn_score_p2p_tvNombreVs))
                    .setText(gameData.getNombreVs());
            ((TextView)row.findViewById(R.id.usrscn_score_p2p_tvPuntajeVs))
                    .setText(String.valueOf(puntajeVs));
        }
        return row;

    }
}
