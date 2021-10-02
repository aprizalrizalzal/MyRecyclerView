package me.aprizal.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import me.aprizal.myrecyclerview.adapter.CardViewHeroAdapter;
import me.aprizal.myrecyclerview.adapter.GridHeroAdapter;
import me.aprizal.myrecyclerview.adapter.ListHeroAdapter;
import me.aprizal.myrecyclerview.model.Hero;
import me.aprizal.myrecyclerview.model.HeroesData;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private final ArrayList<Hero> heroArrayList = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvHeroes=findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        heroArrayList.addAll(HeroesData.getListData());
        showRecyclerViewList();
    }

    private void showRecyclerViewList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(heroArrayList);
        rvHeroes.setAdapter(listHeroAdapter);
    }

    private void showRecyclerViewGrid() {
        rvHeroes.setLayoutManager(new GridLayoutManager(this,2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(heroArrayList);
        rvHeroes.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerViewCardView() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(heroArrayList);
        rvHeroes.setAdapter(cardViewHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_list:
                title = "Mode List";
                showRecyclerViewList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerViewGrid();
                break;
            case R.id.action_card_view:
                title = "Mode Card View";
                showRecyclerViewCardView();
                break;
        }
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}