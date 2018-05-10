package itesm.mx.proyectofinal.perfil;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import itesm.mx.proyectofinal.R;

public class ListaVista {

    private Context contexto;
    private Button btnMano;
    private Button btnP2P;

    public ListaVista(Context contexto, View.OnClickListener listener){
        this.contexto = contexto;

        Activity act = (Activity) contexto;
        btnMano = act.findViewById(R.id.usrscn_scores_menu_btnMano);
        btnP2P = act.findViewById(R.id.usrscn_scores_menu_btnP2P);

        btnMano.setOnClickListener(listener);
        btnP2P.setOnClickListener(listener);
    }
}
