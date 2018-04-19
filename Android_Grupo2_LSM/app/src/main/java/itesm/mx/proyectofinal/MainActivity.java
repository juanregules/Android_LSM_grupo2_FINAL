package itesm.mx.proyectofinal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements PantallaUsuario.IMyUserScreen {
    public static String PACKAGE_NAME;
    ImageView fondo;
    Button gamemano, gamep2p;

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
                    cargarDummy();
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
        fondo = (ImageView) findViewById(R.id.imageView);
        PACKAGE_NAME = getApplicationContext().getPackageName();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        gamemano = findViewById(R.id.botonmano);
        gamep2p = findViewById(R.id.botonp2p);
        //gamemano.setOnClickListener(this);
        //gamep2p.setOnClickListener(this);
    }
/*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.c:
                cargarUsuario();
                fondo.setVisibility(View.INVISIBLE);
                break;
            case R.id.b:
                cargarDummy();
                fondo.setVisibility(View.INVISIBLE);
                break;
            case R.id.a:
                cargarGlosario();
                fondo.setVisibility(View.INVISIBLE);
                break;
            case R.id.botonmano:
                cargarmano();
                break;
            case R.id.botonp2p:
                cargarp2p();
                break;
        }
    }
*/
    private void cargarUsuario() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaUsuario()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaUsuario()).commit();
        }

    }

    private void cargarDummy() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaDummy()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaDummy()).commit();
        }
    }

    private void cargarGlosario() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaGlosario()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaGlosario()).commit();
        }

    }

    private void cargarmano() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaMano()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaMano()).commit();
        }

    }

    private void cargarp2p() {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, new PantallaP2p()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, new PantallaP2p()).commit();
        }
    }

    @Override
    public void endMyLife() {

    }


}
