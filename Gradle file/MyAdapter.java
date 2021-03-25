// My Version Start
package com.example.latihanaplikasi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mahasiswa_Adapter extends RecyclerView.Adapter<Mahasiswa_Adapter.Mahasiswanakal> {

    private ArrayList<Mahasiswa> listMahasiswa;
    public Mahasiswa_Adapter(ArrayList<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;

    }


    @NonNull
    @Override
    public Mahasiswa_Adapter.Mahasiswanakal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_mahasiswa , parent , false);
        return new Mahasiswanakal(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mahasiswa_Adapter.Mahasiswanakal holder, int position) {
        holder.nrp1.setText(listMahasiswa.get(position).getNrp());
        holder.nama1.setText(listMahasiswa.get(position).getNama());
        holder.email1.setText(listMahasiswa.get(position).getEmail());

    }

    @Override
    public int getItemCount() {

        return (listMahasiswa != null) ? listMahasiswa.size() : 0;
    }

    public class Mahasiswanakal extends RecyclerView.ViewHolder{
        private TextView nama1, nrp1, email1;

        public Mahasiswanakal(View view){
            super(view);
            nama1 = view.findViewById(R.id.nama1);
            nrp1 = view.findViewById(R.id.nrp1);
            email1 = view.findViewById(R.id.email1);
//            git status
        }
    }
}

// My Version end


























package com.Android.sa.Tab;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.kampuskoding.kampuskoding.R;
import com.kampuskoding.kampuskoding.fragment.ChatFragment;
import com.kampuskoding.kampuskoding.fragment.ExploreFragment;
import com.kampuskoding.kampuskoding.fragment.FriendFragment;
import com.kampuskoding.kampuskoding.fragment.HomeFragment;

/**
 * Created by Ujang Wahyu on 18/08/2016.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"A","B","C","D"};
    int[] icon = new int[]{R.drawable.ic_home_white_24dp,R.drawable.ic_explore_white_24dp,R.drawable.ic_chat_white_24dp,R.drawable.ic_person_white_24dp};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new HomeFragment();
        }else if(position == 1){
            frag = new ExploreFragment();
        }else if(position == 2){
            frag = new ChatFragment();
        }else if(position == 3){
            frag = new FriendFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}
