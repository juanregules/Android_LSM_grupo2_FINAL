package itesm.mx.proyectofinal.principal;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import itesm.mx.proyectofinal.MenuDeActividades;
import itesm.mx.proyectofinal.PantallaGlosario;
import itesm.mx.proyectofinal.PantallaMano;
import itesm.mx.proyectofinal.PantallaP2p;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.IMyScreen;
import itesm.mx.proyectofinal.usuario.PerfilControlador;

public class MainActivity extends AppCompatActivity implements IMyScreen {
    public static String PACKAGE_NAME;
    ImageView fondo;
    Fragment fragmentoAnterior;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    cargarGlosario();
                    fondo.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    cargarLista();
                    fondo.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    cargarUsuario();
                    fondo.setVisibility(View.INVISIBLE);
                    return true;
            }
            return false;
        }
    };


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fondo = findViewById(R.id.imageView);
        PACKAGE_NAME = getApplicationContext().getPackageName();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

    @Override
    public void onBackPressed(){
        if(fragmentoAnterior != null){
            getFragmentManager().beginTransaction().replace(R.id.pantalla, fragmentoAnterior).commit();
        }
    }
    @Override
    public void cambiarPantalla(Fragment siguientePantalla) {
        getFragmentManager().beginTransaction().replace(R.id.pantalla, siguientePantalla).commit();
    }
    @Override
    public void establecerPantallaAnterior(Fragment pantallaAnterior) {
        fragmentoAnterior = pantallaAnterior;
    }
}
