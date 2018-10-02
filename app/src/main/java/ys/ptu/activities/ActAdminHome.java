package ys.ptu.activities;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import ys.ptu.R;
import ys.ptu.activities.fragments.FragAdminPokedex;
import ys.ptu.adapters.admin.AdminHomeAdapter;
import ys.ptu.adapters.PokedexAdapter;
import ys.ptu.domain.PokemonDex;
import ys.ptu.domain.PokemonDexBuilder;

public class ActAdminHome extends AppCompatActivity {

    private TextView txvWelkom;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        txvWelkom = (TextView) findViewById(R.id.txv_welkom);

        setWelkomText();
        setKeuzesPanel();
        //setPokedex();

    }

    private void setWelkomText() {
        txvWelkom.setText("Welkom Yannick (admin)");
    }

    private void setKeuzesPanel() {
        GridView gv = (GridView) findViewById(R.id.gridItems);

        String[] keuzes = new String[]{
                "Pokedex"};

        gv.setAdapter(new AdminHomeAdapter(ActAdminHome.this, keuzes));
    }


    public void openKeuze(Fragment fragment) {
        // open andere activities, wordt aangeroepen door adapter

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new FragAdminPokedex());
        transaction.commit();
    }
}
