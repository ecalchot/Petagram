package com.gus.petagram;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        Toolbar actBarMascota = (Toolbar) findViewById(R.id.actBarMascota);
        setSupportActionBar(actBarMascota);

        listaMascotas = (RecyclerView) findViewById(R.id.RecyclerViewMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();

    }

    private void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.chamelon,"Charly", 0));
        mascotas.add(new Mascota(R.drawable.phyton,  "Venom", 0));
        mascotas.add(new Mascota(R.drawable.parrot,  "Zazu", 0));
        mascotas.add(new Mascota(R.drawable.tiger,   "Tora", 0));
        mascotas.add(new Mascota(R.drawable.panter,  "Shadow", 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opc1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuOpcFive:

                Intent intent = new Intent(this, MascotasReiteadas.class);
                startActivity(intent);

                break;

            case R.id.menuOpcAbout:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
