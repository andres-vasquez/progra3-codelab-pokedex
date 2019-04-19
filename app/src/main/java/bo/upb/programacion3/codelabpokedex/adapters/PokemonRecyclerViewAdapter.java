package bo.upb.programacion3.codelabpokedex.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bo.upb.programacion3.codelabpokedex.R;
import bo.upb.programacion3.codelabpokedex.model.Pokemon;

public class PokemonRecyclerViewAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private Context context;
    private List<Pokemon> pokemonList;
    private LayoutInflater inflater;

    public PokemonRecyclerViewAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
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
        Pokemon pokemon = this.pokemonList.get(position);
        pokemonViewHolder.imageView.setImageResource(pokemon.getImage());
        pokemonViewHolder.textViewName.setText(pokemon.getName());
        pokemonViewHolder.textViewType.setText(pokemon.getType());
    }

    @Override
    public int getItemCount() {
        return this.pokemonList.size();
    }
}
