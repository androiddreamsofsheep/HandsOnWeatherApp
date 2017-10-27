package edu.dlsu.mobapde.handsonweatherapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by courtneyngo on 06/10/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    ArrayList<Weather> weather;
    private OnItemClickListener onItemClickListener;

    int clickedPosition=0;

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public WeatherAdapter(ArrayList<Weather> weather){
        this.weather = weather;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);

        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, final int position) {
        Weather currentWeather = weather.get(position);
        holder.tvDate.setText(currentWeather.getDate());
        holder.ivIcon.setImageResource(currentWeather.getIcon());
        holder.container.setTag(currentWeather);

        if(position==clickedPosition){
            holder.container.setBackgroundColor(Color.parseColor("#f3f3f3"));
        }else{
            holder.container.setBackgroundColor(Color.parseColor("#eeeeee"));
        }

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick((Weather) view.getTag());
                int temp = clickedPosition;
                clickedPosition = position;
                notifyItemChanged(temp);
                notifyItemChanged(clickedPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{
        TextView tvDate;
        ImageView ivIcon;
        View container;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            container = itemView.findViewById(R.id.container);
        }

    }


    public interface OnItemClickListener{
        public void onItemClick(Weather w);
    }

}
