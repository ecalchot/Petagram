package com.gus.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotasReiteadas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_reiteadas);

        Toolbar actBarMascota = (Toolbar) findViewById(R.id.actBarMascota);
        setSupportActionBar(actBarMascota);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

        listaMascotas = (RecyclerView) findViewById(R.id.RecyclerViewMascotasRaiteadas);

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

        mascotas.add(new Mascota(R.drawable.panter,  "Shadow", 58));
        mascotas.add(new Mascota(R.drawable.chamelon,"Charly", 100));
        mascotas.add(new Mascota(R.drawable.tiger,   "Tora", 33));
        mascotas.add(new Mascota(R.drawable.phyton,  "Venom", 10));
        mascotas.add(new Mascota(R.drawable.parrot,  "Zazu", 22));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opc2, menu);
        return true;
    }

}
