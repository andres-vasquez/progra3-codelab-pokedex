package bo.upb.programacion3.codelabpokedex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bo.upb.programacion3.codelabpokedex.R;
import bo.upb.programacion3.codelabpokedex.model.Pokemon;

public class PokemonListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Pokemon> pokemonList;

    public PokemonListViewAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }


    @Override
    public int getCount() {
        return this.pokemonList.size();
    }

    @Override
    public Pokemon getItem(int position) {
        return this.pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.pokemonList.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.pokemon_list_item_horizontal, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewPokemon);
            viewHolder.textViewName = vista.findViewById(R.id.textViewName);
            viewHolder.textViewType = vista.findViewById(R.id.textViewType);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Pokemon pokemon = this.pokemonList.get(position);
        viewHolder.imageView.setImageResource(pokemon.getImage());
        viewHolder.textViewName.setText(pokemon.getName());
        viewHolder.textViewType.setText(pokemon.getType());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewType;
    }
}
