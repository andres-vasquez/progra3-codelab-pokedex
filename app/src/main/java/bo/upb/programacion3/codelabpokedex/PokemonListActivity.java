package bo.upb.programacion3.codelabpokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import bo.upb.programacion3.codelabpokedex.adapters.PokemonListViewAdapter;
import bo.upb.programacion3.codelabpokedex.model.Pokemon;
import bo.upb.programacion3.codelabpokedex.utils.PokemonUtils;

public class PokemonListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        initViews();
        initToolbar();

        final List<Pokemon> pokemonList = PokemonUtils.getPokemons();
        PokemonListViewAdapter adapter = new PokemonListViewAdapter(this, pokemonList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon pokemon = pokemonList.get(position);
                Intent intent = new Intent(PokemonListActivity.this, PokemonDetailsActivity.class);
                intent.putExtra(Constants.POKEMON_SELECTED, gson.toJson(pokemon));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        listview = findViewById(R.id.listViewMyPokemons);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.pokemon_favorites_activity_title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
