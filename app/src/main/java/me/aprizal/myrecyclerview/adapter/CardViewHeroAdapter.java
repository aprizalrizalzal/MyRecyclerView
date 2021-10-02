package me.aprizal.myrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import me.aprizal.myrecyclerview.R;
import me.aprizal.myrecyclerview.model.Hero;

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder> {
    private final ArrayList<Hero> heroArrayList;

    public CardViewHeroAdapter(ArrayList<Hero> heroList) {
        this.heroArrayList = heroList;
    }

    @NonNull
    @Override
    public CardViewHeroAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_hero,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHeroAdapter.CardViewHolder holder, int position) {
        Hero hero = heroArrayList.get(position);
        Glide.with(holder.itemView.getContext()).load(hero.getPhoto()).apply(new RequestOptions().override(355,555)).into(holder.imgPhoto);
        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());

        holder.btnFavorite.setOnClickListener(v -> Toast.makeText(holder.itemView.getContext(),"Favorite " + heroArrayList.get(holder.getAbsoluteAdapterPosition()).getName(),Toast.LENGTH_SHORT).show());

        holder.btnShare.setOnClickListener(v -> Toast.makeText(holder.itemView.getContext(),"Share " + heroArrayList.get(holder.getAbsoluteAdapterPosition()).getName(),Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnFavorite, btnShare;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
