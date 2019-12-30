package com.example.iptracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.iptracker.model.Geolocation;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        ArrayList<Geolocation> list = (ArrayList<Geolocation>) intent.getSerializableExtra("list");
        TableLayout table = findViewById(R.id.table);

        for (Geolocation location : list) {
            TableRow tr = new TableRow(this);
            TextView c1 = new TextView(this);
            c1.setText(location.getIp());
            TextView c2 = new TextView(this);
            c2.setText(location.getCity());
            TextView c3 = new TextView(this);
            c3.setText(location.getCountry());
            TextView c4 = new TextView(this);
            c4.setText(location.getContinent());

            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            tr.addView(c4);
            table.addView(tr);
        }
    }
}
