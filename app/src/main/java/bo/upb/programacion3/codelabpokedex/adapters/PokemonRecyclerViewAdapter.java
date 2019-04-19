package bo.upb.programacion3.codelabpokedex.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bo.upb.programacion3.codelabpokedex.R;
import bo.upb.programacion3.codelabpokedex.callback.PokemonCallback;
import bo.upb.programacion3.codelabpokedex.model.Pokemon;

public class PokemonRecyclerViewAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private List<Pokemon> pokemonList;
    private LayoutInflater inflater;
    private PokemonCallback pokemonCallback;

    public PokemonRecyclerViewAdapter(Context context, List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = this.inflater.inflate(R.layout.pokemon_list_item, null);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder pokemonViewHolder, int position) {
        final Pokemon pokemon = this.pokemonList.get(position);
        pokemonViewHolder.imageView.setImageResource(pokemon.getImage());
        pokemonViewHolder.textViewName.setText(pokemon.getName());
        pokemonViewHolder.textViewType.setText(pokemon.getType());
        pokemonViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pokemonCallback != null) {
                    pokemonCallback.onPokemonClick(pokemon);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.pokemonList.size();
    }

    public void setPokemonCallback(PokemonCallback pokemonCallback) {
        this.pokemonCallback = pokemonCallback;
    }
}
