package com.example.tareaconlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tareaconlistview.Adaptadores.AdaptadorCountryCovid;
import com.example.tareaconlistview.Modelos.CountryCovid;
import com.example.tareaconlistview.WebServices.Asynchtask;
import com.example.tareaconlistview.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    private ListView lstPaisesCovid;
    private TextView lbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPaisesCovid = (ListView)findViewById(R.id.lstPaises);

        View header = getLayoutInflater().inflate(R.layout.ly_countrycovid, null);
        lstPaisesCovid.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.covid19api.com/summary", datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        try {
            ArrayList<CountryCovid> countries = new ArrayList<CountryCovid>();
            JSONObject lista = new JSONObject(result.toString());
            JSONArray JSONlistaPaises = lista.getJSONArray("Countries");

            for (int i = 0; i < JSONlistaPaises.length(); i++) {
                JSONObject pais =JSONlistaPaises.getJSONObject(i);
                CountryCovid p = new CountryCovid(pais.getString("Country").toString(),
                        Integer.parseInt(pais.getString("TotalConfirmed").toString()),
                        Integer.parseInt(pais.getString("TotalDeaths").toString()),
                        Integer.parseInt(pais.getString("TotalRecovered").toString()),
                        pais.getString("Date").toString());
                countries.add(p);
            }

            AdaptadorCountryCovid adapatorPaises = new AdaptadorCountryCovid(this, countries);
            lstPaisesCovid.setAdapter(adapatorPaises);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }

    }
}