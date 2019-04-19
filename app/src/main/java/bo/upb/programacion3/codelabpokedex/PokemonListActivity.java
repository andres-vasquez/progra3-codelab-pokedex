package bo.upb.programacion3.codelabpokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.LinkedList;
import java.util.List;

import bo.upb.programacion3.codelabpokedex.adapters.PokemonRecyclerViewAdapter;
import bo.upb.programacion3.codelabpokedex.model.Pokemon;

public class PokemonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMyPokemons);

        List<Pokemon> pokemonList = new LinkedList<>();
        pokemonList.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, "Electric"));
        pokemonList.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, "Electric"));
        pokemonList.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, "Electric"));
        pokemonList.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, "Electric"));
        pokemonList.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, "Electric"));
        pokemonList.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, "Electric"));

        PokemonRecyclerViewAdapter adapter = new PokemonRecyclerViewAdapter(this, pokemonList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }
}
