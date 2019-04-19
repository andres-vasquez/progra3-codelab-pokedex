package bo.upb.programacion3.codelabpokedex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PokemonDetailsActivity extends AppCompatActivity {

    private ImageView pokemonImage;
    private TextView nameTextView;
    private TextView idTextView;
    private TextView typeTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        initViews();
        fillPokemonData();
    }

    // Esto ya saben!
    private void initViews() {
        this.pokemonImage = findViewById(R.id.pokemonImage);
        this.nameTextView = findViewById(R.id.nameTextView);
        this.idTextView = findViewById(R.id.idTextView);
        this.typeTextView = findViewById(R.id.typeTextView);
    }

    private void fillPokemonData() {

    }
}
