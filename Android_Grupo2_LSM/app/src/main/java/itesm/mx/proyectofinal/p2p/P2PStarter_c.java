package itesm.mx.proyectofinal.p2p;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.ScreenManager;
import itesm.mx.proyectofinal.principal.MainActivity;
import itesm.mx.proyectofinal.principal.MenuDeActividades;
import itesm.mx.proyectofinal.transports.ManoGameData;

public class P2PStarter_c extends Fragment implements View.OnClickListener {

    private ScreenManager screenManager;
    private Context contexto;
    private P2P_v vista;

    private final int PERM_COARSE = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.p2p_inicio, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getActivity();
        pedirPermisos();
        init();
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

        screenManager.changeScreen(waitConn);
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

    private void pedirPermisos(){
        if (ContextCompat.checkSelfPermission(contexto, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    (Activity) contexto,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERM_COARSE);
        }
    }
    private void init(){
        screenManager = (MainActivity)contexto;
        vista = new P2P_v(contexto, this);

        screenManager.setBack(new MenuDeActividades());
        vista.initInicio();
    }
    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String permissions[],
            int[] grantResults) {

        switch (requestCode) {
            case PERM_COARSE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    init();
                }
                else {
                    Toast.makeText(contexto, "Debes permitir el acceso a Wifi", Toast.LENGTH_SHORT)
                            .show();
                    ((MainActivity)contexto).onBackPressed();
                }
            }
        }
    }
}
