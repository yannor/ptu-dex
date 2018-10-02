package ys.ptu.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ys.ptu.R;
import ys.ptu.domain.PokemonDex;

/**
 * Created by Yannick on 14/08/2017.
 */

public class PokedexAdapter extends ArrayAdapter<PokemonDex> implements Filterable{

    private Context context;
    private List<PokemonDex> listAllPokemon;
    private List<PokemonDex>searchedPokemon;
    private ItemFilter mFilter = new ItemFilter();

    public PokedexAdapter(Context context, List<PokemonDex> listAllPokemon) {
        super(context, R.layout.row_pokemon_pokedex, listAllPokemon);

        this.context = context;
        this.listAllPokemon = listAllPokemon;
        searchedPokemon = listAllPokemon;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater.from(getContext()));
        View row = inflater.inflate(R.layout.row_pokemon_pokedex, parent, false);


        TextView txvId = (TextView) row.findViewById(R.id.txvId);
        TextView txvNaam = (TextView) row.findViewById(R.id.txvNaam);
        TextView txvType1 = (TextView) row.findViewById(R.id.txvType1);
        TextView txvType2 = (TextView) row.findViewById(R.id.txvType2);

        ImageView spriteView = (ImageView) row.findViewById(R.id.imgSprite) ;
       


        PokemonDex poke = searchedPokemon.get(position);
        txvNaam.setText(poke.getNaam());
        txvId.setText(poke.getId());
        if(poke.getType1() != null) {
            txvType1.setText(poke.getType1());
        }
        if(poke.getType2() != null) {
            txvType2.setText(poke.getType2());
        }

        spriteView.setImageResource(poke.getSprite());
        return row;
    }

    public int getCount() {
        return searchedPokemon.size();
    }


    public Filter getFilter() {
        return mFilter;
    }


        private class ItemFilter extends Filter {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                searchedPokemon = (List<PokemonDex>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                int count = listAllPokemon.size();
                List<PokemonDex> FilteredArrayNames = new ArrayList<>();

                // perform your search here using the searchConstraint String.

                for (int i = 0; i < count; i++) {
                    String namePokemon = listAllPokemon.get(i).getNaam();
                    if (namePokemon.toUpperCase().contains(constraint.toString().toUpperCase()))  {
                        FilteredArrayNames.add(listAllPokemon.get(i));
                    }

                    // other ways of searching
                }

                results.count = FilteredArrayNames.size();
                results.values = FilteredArrayNames;

                return results;
            }
        };



}





