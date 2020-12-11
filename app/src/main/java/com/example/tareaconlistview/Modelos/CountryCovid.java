package com.example.tareaconlistview.Modelos;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountryCovid {
    private String CountryName;
    private Integer TotalConfirmed;
    private Integer TotalDeaths;
    private Integer TotalRecovered;
    private String Date;

    public CountryCovid(String countryName, Integer totalConfirmed, Integer totalDeaths, Integer totalRecovered, String date) {
        CountryName = countryName;
        TotalConfirmed = totalConfirmed;
        TotalDeaths = totalDeaths;
        TotalRecovered = totalRecovered;
        Date = date;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public int getTotalDeaths() { return TotalDeaths; }

    public void setTotalDeaths(int totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getDate() { return Date; }

    public void setDate(String date) { Date = date; }
}
