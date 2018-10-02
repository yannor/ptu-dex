package ys.ptu.adapters.admin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ys.ptu.R;
import ys.ptu.activities.ActAdminHome;
import ys.ptu.activities.fragments.FragAdminPokedex;

/**
 * Created by Yannick on 9/07/2018.
 */

public class AdminHomeAdapter extends BaseAdapter{

    String [] keuzes;
    Context context;
    private static LayoutInflater inflater=null;

    private final static String TAG = "ActAdminHome";

    public AdminHomeAdapter(ActAdminHome mainActivity, String[] keuzes) {
        this.keuzes=keuzes;
        context = mainActivity;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return keuzes.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView txv_keuze;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_item_home, null);
        holder.txv_keuze =(TextView) rowView.findViewById(R.id.txv_keuze);

        holder.txv_keuze.setText(keuzes[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        ((ActAdminHome) context).openKeuze(new FragAdminPokedex());
                        break;

                    /*case 0:
                        ((MainActivity)context).openOpdracht(Activity_CurrencyConverter.class);
                        break;
                    case 1:
                        ((MainActivity)context).openOpdracht(Activity_HigherLower.class);
                        break;
                    case 2:
                        ((MainActivity)context).openOpdracht(Activity_FadingAnimations.class);
                        break;
                    case 3:
                        ((MainActivity)context).openOpdracht(Activity_GameConnect3.class);
                        break;
                    case 4: ((MainActivity)context).openOpdracht(Activity_Video.class);*/
                }
            }
        });

        return rowView;
    }
}