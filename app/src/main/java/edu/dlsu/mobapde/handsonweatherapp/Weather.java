package edu.dlsu.mobapde.handsonweatherapp;

/**
 * Created by courtneyngo on 06/10/2017.
 */

public class Weather {

    private String date;
    private int temp;
    private int wind;
    private int icon;

    private int listPosition;

    public Weather(){}

    public Weather(String date, int temp, int wind, int icon) {
        this.date = date;
        this.temp = temp;
        this.wind = wind;
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getListPosition() {
        return listPosition;
    }

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", temp=" + temp +
                ", wind=" + wind +
                ", icon=" + icon +
                '}';
    }
}
