package com.example.used;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.used.Fragments.AcercaFragment;
import com.example.used.Fragments.CalendarioFragment;
import com.example.used.Fragments.EmailFragment;
import com.example.used.Fragments.InfoFragment;
import com.example.used.Fragments.ListaFragment;
import com.example.used.Fragments.MensajeFragment;
import com.example.used.Fragments.TelefonoFragment;
import com.example.used.Fragments.WebFragment;
import com.example.used.Interfaces.IComunicaFragments;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements IComunicaFragments {
    //no me sale
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setToolbar();
        setFragmentByDefault();

        //Métodos que me permitan controlar las acciones
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentsTransaction = false;
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.menu_acerca:
                        fragment = new AcercaFragment();
                        fragmentsTransaction=true;
                        break;
                    case R.id.menu_mail:
                        fragment = new EmailFragment();
                        fragmentsTransaction=true;
                        break;
                    case R.id.menu_web:
                        fragment = new WebFragment();
                        fragmentsTransaction=true;
                        break;
                    case R.id.menu_mensaje:
                        fragment = new MensajeFragment();
                        fragmentsTransaction=true;
                        break;
                    case R.id.menu_telf:
                        fragment = new TelefonoFragment();
                        fragmentsTransaction = true;
                        break;
                    case R.id.menu_calendario:
                        fragment = new CalendarioFragment();
                        fragmentsTransaction=true;
                        break;
                    case R.id.menu_lista:
                        fragment = new ListaFragment();
                        fragmentsTransaction=true;
                        break;
                    case R.id.menu_info:
                        fragment = new InfoFragment();
                        fragmentsTransaction=true;
                        break;
                }

                //Randarizar los fragments según corresponda en content_fragment
                if (fragmentsTransaction) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
                    //navigationView.setItemIconTintList(null);
                //Marcar el item seleccionado...
                    //seleccionamos de manera visual
                    item.setCheckable(true);

                    //Ingresar el título segun corresponda en el toolbar
                    getSupportActionBar().setTitle(item.getTitle());

                    //al seleccionar, se cerrara nuestro drawer layout
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });
        navigationView.setItemIconTintList(null);
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //para ver el item seleccionado
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //Abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        };
        return super.onOptionsItemSelected(item);
    }

    private void setFragmentByDefault(){
        //Randarizar los fragments según corresponda en content_fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new AcercaFragment()).commit();
        //crear variable item, se va a crear como un menu item
        MenuItem item = navigationView.getMenu().getItem(0);
        //Marcar el item seleccionado...
        //seleccionamos de manera visual
        item.setCheckable(true);

        //Ingresar el título segun corresponda en el toolbar
        getSupportActionBar().setTitle(item.getTitle());
    }

    public AlertDialog dialogJulitza(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(Html.fromHtml("<font color='#81c784'><b>Julitza Vera</b></font>")).setMessage("Estudiante de la carrera de desarrollo de Software | Aula: 4'A'," +
                        " de la materia 'DESARROLLO DE APLICACIONES MÓVILES'.\n\n" + "Proyecto - Desarrollo de una APP >>{+used}\n\n\n" +
                        "Cualquier consulta preguntar a este correo:\n\n" + "judvera@est.istg.edu.ec")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Leida la información de \n\t\tJulitza Vera", Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }

    public AlertDialog dialogEmily(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(Html.fromHtml("<font color='#b39ddb'><b>Emily Ortega</b></font>")).setMessage("Estudiante de la carrera de desarrollo de Software | Aula: 4'A'," +
                        " de la materia 'DESARROLLO DE APLICACIONES MÓVILES'.\n\n" + "Proyecto - Desarrollo de una APP >>{+used}\n\n\n" +
                        "Cualquier consulta preguntar a este correo:\n\n" + "emgortega@est.istg.edu.ec")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Leida la información de \n\t\tEmily Ortega", Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }

    public AlertDialog dialogJairo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(Html.fromHtml("<font color='#90caf9'><b>Jairo Rubira</b></font>")).setMessage("Estudiante de la carrera de desarrollo de Software | Aula: 4'A'," +
                        " de la materia 'DESARROLLO DE APLICACIONES MÓVILES'.\n\n" + "Proyecto - Desarrollo de una APP >>{+used}\n\n\n" +
                        "Cualquier consulta preguntar a este correo:\n\n" + "jadrubira@est.istg.edu.ec")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Leida la información de \n\t\tJairo Rubira", Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }

    public AlertDialog dialogAndrea(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(Html.fromHtml("<font color='#ea80fc'><b>Andrea Mora</b></font>")).setMessage("Estudiante de la carrera de desarrollo de Software | Aula: 4'A'," +
                        " de la materia 'DESARROLLO DE APLICACIONES MÓVILES'.\n\n" + "Proyecto - Desarrollo de una APP >>{+used}\n\n\n" +
                        "Cualquier consulta preguntar a este correo:\n\n" + "ananmora@est.istg.edu.ec")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Leida la información de \n\t\tAndrea Mora", Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }
    @Override
    public void juli() {
        dialogJulitza().show();
    }

    @Override
    public void emily() {
        dialogEmily().show();
        //Toast.makeText(getApplicationContext(), "Emily Ortega", Toast.LENGTH_LONG).show();
    }

    @Override
    public void jairo() {
        dialogJairo().show();
    }

    @Override
    public void andrea() {
        dialogAndrea().show();

    }
}