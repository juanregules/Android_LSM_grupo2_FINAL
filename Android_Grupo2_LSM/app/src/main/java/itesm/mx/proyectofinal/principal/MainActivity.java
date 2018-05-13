package itesm.mx.proyectofinal.principal;

import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import itesm.mx.proyectofinal.Glosario.PantallaGlosario;
import itesm.mx.proyectofinal.R;
import itesm.mx.proyectofinal.extras.ScreenManager;
import itesm.mx.proyectofinal.perfil.PerfilControlador;

public class MainActivity extends AppCompatActivity implements ScreenManager, BottomNavigationView.OnNavigationItemSelectedListener{
    Fragment fragmentoAnterior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Lenguaje de Señas Mexicano");
        }
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this);
        cargarGlosario();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                    cargarGlosario();
                return true;
            case R.id.navigation_dashboard:
                    cargarLista();
                return true;
            case R.id.navigation_notifications:
                    cargarUsuario();
                return true;
        }
        return false;
    }

    private void cargarUsuario() {
        changeScreen(new PerfilControlador());

    }
    private void cargarLista() {
        changeScreen(new MenuDeActividades());
    }
    private void cargarGlosario() {
        changeScreen(new PantallaGlosario());
    }

    @Override
    public void changeScreen(Fragment nextFrag) {
        if (getFragmentManager().findFragmentById(R.id.pantalla) != null) {
            getFragmentManager().beginTransaction().replace(R.id.pantalla, nextFrag).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.pantalla, nextFrag).commit();
        }
    }

    @Override
    public void setBack(Fragment backFrag) {
        fragmentoAnterior = backFrag;
    }

    @Override
    public void onBackPressed() {
        if(fragmentoAnterior != null) {
            changeScreen(fragmentoAnterior);
        }else {
            super.onBackPressed();
        }
    }


}
