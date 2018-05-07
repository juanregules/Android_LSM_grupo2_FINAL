package itesm.mx.proyectofinal.principal;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import itesm.mx.proyectofinal.MenuDeActividades;
import itesm.mx.proyectofinal.Glosario.PantallaGlosario;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.usuario.PerfilControlador;

public class MainActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;
    //ImageView fondo;
    Fragment fragmentoAnterior;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    cargarGlosario();
                    //fondo.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    cargarLista();
                    //fondo.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    cargarUsuario();
                    //fondo.setVisibility(View.INVISIBLE);
                    return true;
            }
            return false;
        }
    };


    @Override
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant

                return;
            }
        }
        super.onStart();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! do the
                    // calendar task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'switch' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fondo = findViewById(R.id.imageView);
        PACKAGE_NAME = getApplicationContext().getPackageName();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        cargarGlosario();

    }
    private void cargarUsuario() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PerfilControlador()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PerfilControlador()).commit();
        }

    }
    private void cargarLista() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new MenuDeActividades()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new MenuDeActividades()).commit();
        }
    }
    private void cargarGlosario() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaGlosario()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaGlosario()).commit();
        }
    }

}
