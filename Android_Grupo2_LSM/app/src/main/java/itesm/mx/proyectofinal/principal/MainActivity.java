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


/*
*
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
*
* */

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
