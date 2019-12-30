package com.example.iptracker;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.iptracker.model.Geolocation;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String baseUrl = "http://free.ipwhois.io/json/";
    ArrayList<Geolocation> list = new ArrayList();

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("list", list);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        list = (ArrayList<Geolocation>) savedInstanceState.getSerializable("list");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();

        makeApiCall(baseUrl + message);
    }

    public void makeApiCall(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        final Gson gson = new Gson();
        final Intent intent = new Intent(this, ListActivity.class);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Geolocation geolocation = gson.fromJson(response, Geolocation.class);
                if (geolocation.success && geolocation.city != null) {
                    list.add(geolocation);

                } else {
                    // prikazi error neki
                }

                intent.putExtra("list", list);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });

        queue.add(request);
    }


}
