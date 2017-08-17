package com.example.dd.footballGamesOnline.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dd.footballGamesOnline.R;
import com.example.dd.footballGamesOnline.model.User;

import java.util.List;

/**
 * Created by dd on 03.05.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<User> item;
    Context context ;

    public RecyclerViewAdapter(Context context, List<User> item ) {
        Log.d("123", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("123", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.activity2_recyclerview, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("123", "onBindViewHolder");
        //Strings
        holder.caption.setText(item.get(position).getCaption());
        holder.league.setText(item.get(position).getLeague());
        holder.lastUpdated.setText(item.get(position).getLastUpdated());
        holder.year.setText(item.get(position).getYear());

        //Integers
        holder.currentMatchday.setText(item.get(position).getCurrentMatchday().toString());
        holder.numberOfGames.setText(item.get(position).getNumberOfGames().toString());
        holder.numberOfMatchdays.setText(item.get(position).getNumberOfMatchdays().toString());
        holder.numberOfTeams.setText(item.get(position).getNumberOfTeams().toString());

    }

    @Override
    public int getItemCount() {
        Log.d("123", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView caption,league,currentMatchday, numberOfGames,
                numberOfMatchdays, numberOfTeams, lastUpdated, year;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.d("123", "ViewHolder");

            caption = (TextView) itemView.findViewById(R.id.tvCaption);
            league = (TextView) itemView.findViewById(R.id.tvLeague);
            currentMatchday = (TextView) itemView.findViewById(R.id.tvCurrentMatchday);
            numberOfGames = (TextView) itemView.findViewById(R.id.tvNumberOfGames);
            numberOfMatchdays = (TextView) itemView.findViewById(R.id.tvNumberOfMatchdays);
            numberOfTeams = (TextView) itemView.findViewById(R.id.tvNumberOfTeams);
            lastUpdated = (TextView) itemView.findViewById(R.id.tvLastUpdated);
            year = (TextView) itemView.findViewById(R.id.tvYear);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }


    }
}
