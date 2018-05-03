package itesm.mx.proyectofinal.p2p;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.extras.ImageMastah;
import itesm.mx.proyectofinal.transports.P2PIngameData;

public class P2PStarter_c extends Fragment implements View.OnClickListener {

    //private IMyScreen fatherActivity;
    private Context contexto;
    private P2P_v vista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.p2p_inicio, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getActivity();
        vista = new P2P_v(contexto, this);
        vista.initInicio();
        ImageView i = ((Activity)contexto).findViewById(R.id.DEBUG);
        byte[] b = ImageMastah.fromBitmapToByteArray(ImageMastah.getBitmapFromImageView(i));

        if(P2PIngameData.DEBUG(b)){
            Toast.makeText(contexto, "exito", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        P2PWaitConn_c waitConn = new P2PWaitConn_c();

        switch (view.getId()){
            case R.id.in_btnCreate:
                createMatch(waitConn);
                break;
            case R.id.in_btnJoin:
                joinMatch(waitConn);
                break;
            default:
                return;
        }

        getFragmentManager().beginTransaction()
                .replace(R.id.pantalla, waitConn)
                .commit();
    }

    private void createMatch(P2PWaitConn_c c){
        Bundle b = new Bundle();
        b.putBoolean("esCliente", false);
        c.setArguments(b);
    }
    private void joinMatch(P2PWaitConn_c c){
        Bundle b = new Bundle();
        b.putBoolean("esCliente", true);
        c.setArguments(b);
    }
}
