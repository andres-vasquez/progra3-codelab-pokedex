package bo.upb.programacion3.codelabpokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import java.util.List;

import bo.upb.programacion3.codelabpokedex.adapters.PokemonRecyclerViewAdapter;
import bo.upb.programacion3.codelabpokedex.callback.PokemonCallback;
import bo.upb.programacion3.codelabpokedex.model.Pokemon;
import bo.upb.programacion3.codelabpokedex.utils.PokemonUtils;

public class PokemonRecyclerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_recycler);
        initViews();
        initToolbar();

        List<Pokemon> pokemonList = PokemonUtils.getPokemons();
        PokemonRecyclerViewAdapter adapter = new PokemonRecyclerViewAdapter(this, pokemonList);
        adapter.setPokemonCallback(new PokemonCallback() {
            @Override
            public void onPokemonClick(Pokemon pokemon) {
                Intent intent = new Intent(PokemonRecyclerActivity.this, PokemonDetailsActivity.class);
                intent.putExtra(Constants.POKEMON_SELECTED, gson.toJson(pokemon));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerViewMyPokemons);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.pokemon_list_activity_title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
