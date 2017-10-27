package edu.dlsu.mobapde.handsonweatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by courtneyngo on 06/10/2017.
 */

public class WeatherAdapterSkeleton extends RecyclerView.Adapter<WeatherAdapterSkeleton.WeatherViewHolder> {

    ArrayList<Weather> weather;

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
        notifyDataSetChanged();
    }

    public WeatherAdapterSkeleton(ArrayList<Weather> weather){
        this.weather = weather;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO inflate view
        // TODO return a WeatherViewHolder
        return null;
    }


    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        weather.get(position).setListPosition(position);
        Weather currentWeather = weather.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* TODO call onItemClickListener's onItemClick to trigger the
                  call back method you created in MainActivity */

                // notifyItemChanged(clickedPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{
        // TODO declare views

        public WeatherViewHolder(View itemView) {
            super(itemView);
            // TODO initialize views
        }

    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        public void onItemClick(Weather w);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
