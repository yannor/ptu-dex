package ys.ptu.activities.fragments;



import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ys.ptu.R;
import ys.ptu.adapters.PokedexAdapter;
import ys.ptu.domain.PokemonDex;
import ys.ptu.domain.PokemonDexBuilder;
import ys.ptu.domain.TypeEnum;


public class FragAdminPokedex extends Fragment {

    private final static String TAG = "FragAdminPokedex";


    //Pokedex
    private PokedexAdapter pokedexAdapter;
    private ListView lvPokemons;


    public FragAdminPokedex() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_admin_pokedex, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setListViewPokemons();
    }

    private void setListViewPokemons() {
        final ListView pokemonsListView = (ListView) getView().findViewById(R.id.listPokemonPokedex);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child("dexPokemon");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<PokemonDex> allPokemons = new ArrayList<>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    PokemonDex pokemon = postSnapshot.getValue(PokemonDex.class);
                    allPokemons.add(pokemon);
                }
                Collections.sort(allPokemons, new Comparator<PokemonDex>() {
                    @Override
                    public int compare(PokemonDex p1, PokemonDex p2) {
                        return p1.getId().compareTo(p2.getId());
                    }
                });
                pokedexAdapter = new PokedexAdapter(getActivity(), allPokemons);
                pokemonsListView.setAdapter(pokedexAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("The read failed: ", databaseError.getMessage());
            }
        });
    }

   /*  private List<PokemonDex> getAllPokemons() {
       // TODO get data van database
        List<PokemonDex> allPokemons = new ArrayList<>();

        allPokemons.add(new PokemonDexBuilder()
                .id("001")
                .sprite(R.drawable.bulbasaur)
                .name("Bulbasaur")
                .baseHp(5)
                .baseAtt(5)
                .baseDef(5)
                .baseSpAtt(7)
                .baseSpDef(7)
                .baseSpeed(5)
                .type1(TypeEnum.GRASS)
                .type2(TypeEnum.POISON)
                .build());

        allPokemons.add(new PokemonDexBuilder()
                .id("002")
                .sprite(R.drawable.ivysaur)
                .name("Ivysaur")
                .baseHp(5)
                .baseAtt(5)
                .baseDef(5)
                .baseSpAtt(7)
                .baseSpDef(7)
                .baseSpeed(5)
                .type1(TypeEnum.GRASS)
                .type2(TypeEnum.POISON)
                .build());
        return allPokemons;
    }*/

}
