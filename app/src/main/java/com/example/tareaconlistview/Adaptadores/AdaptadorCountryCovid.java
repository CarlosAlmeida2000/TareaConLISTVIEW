package com.example.tareaconlistview.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tareaconlistview.Modelos.CountryCovid;
import com.example.tareaconlistview.R;

import java.util.ArrayList;

public class AdaptadorCountryCovid extends ArrayAdapter<CountryCovid> {

    public AdaptadorCountryCovid(Context context, ArrayList<CountryCovid> datos) {
        super(context, R.layout.ly_countrycovid, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_countrycovid, null);

        TextView countryName = (TextView)item.findViewById(R.id.lblCountryName);
        countryName.setText(getItem(position).getCountryName());

        TextView totalConfirmed = (TextView)item.findViewById(R.id.lblTotalConfirmed);
        totalConfirmed.setText("TotalConfirmed: " +getItem(position).getTotalConfirmed());

        TextView totalDeaths = (TextView)item.findViewById(R.id.lblTotalDeaths);
        totalDeaths.setText("TotalDeaths: "+getItem(position).getTotalDeaths());

        TextView totalRecovered = (TextView)item.findViewById(R.id.lblTotalRecovered);
        totalRecovered.setText("TotalRecovered: "+getItem(position).getTotalRecovered());

        TextView fecha = (TextView)item.findViewById(R.id.lblFecha);
        fecha.setText("Fecha: "+getItem(position).getDate());

        return(item);
    }
}
