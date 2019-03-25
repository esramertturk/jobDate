package com.example.user.istarih;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SonucActivity extends AppCompatActivity {

    String  [] gelenler;
    ListView islerList;
    String gelen_is,gelen_tarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        islerList = findViewById(R.id.islerList);

        Intent gelen = getIntent();
        Bundle bundle = gelen.getExtras();
        gelen_is =bundle.getString("gonder_is");
        gelen_tarih = bundle.getString("gonder_tarih");
        gelenler = new String[] {
                gelen_is+" * " +gelen_tarih
        };

        Toast.makeText(this, "İŞ"+gelen_is, Toast.LENGTH_LONG).show();

     /*   final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(gelen_is + " " + gelen_tarih);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listview_ozel,arrayList);
        islerList.setAdapter(adapter);*/

        final List<String> arrayList = new ArrayList<String>(Arrays.asList(gelenler));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrayList);

        //arrayList.add(gelen_is + " " + gelen_tarih);
        islerList.setAdapter(arrayAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
