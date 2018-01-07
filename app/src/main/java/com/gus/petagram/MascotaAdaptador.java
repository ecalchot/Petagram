package com.gus.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gus on 1/1/18.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity  = activity;
    }

    @Override //Inflar el layout y lo pasará al viewholder para que el obtenga los views
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override //Asocia cada elemento de nuestra lista con cada view
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgMascotaFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvMascotaNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvMascotaRating.setText(Integer.toString(mascota.getRating()));

        mascotaViewHolder.imbMascotaLike.setOnClickListener(new View.OnClickListener() { //aumento en 1 cada vez qeu se le da like

            @Override
            public void onClick(View v) {

                int rating;
                rating = Integer.parseInt((String) mascotaViewHolder.tvMascotaRating.getText());
                ++rating;
                mascotaViewHolder.tvMascotaRating.setText(Integer.toString(rating));
            }
        });

    }

    @Override //cantidad de elementos que contiene mi lista
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView   imgMascotaFoto;
        private TextView    tvMascotaNombre;
        private TextView    tvMascotaRating;
        private ImageButton imbMascotaLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascotaFoto  = (ImageView)   itemView.findViewById(R.id.ImageViewMascota);
            tvMascotaNombre = (TextView)    itemView.findViewById(R.id.TextViewMascotaNombre);
            tvMascotaRating = (TextView)    itemView.findViewById(R.id.TextViewRatingCount);
            imbMascotaLike  = (ImageButton) itemView.findViewById(R.id.ImageButtonRatingMascota);
        }
    }
}
