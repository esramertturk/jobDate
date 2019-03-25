package com.example.user.istarih;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText isler, tarihET;
    String is, tarih;
    Button gonder;
    String isListesi [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isler = findViewById(R.id.isET);
        tarihET = findViewById(R.id.tarihET);
        gonder = findViewById(R.id.gonderBtn);

       // tarih = tarihET.getText().toString();
        tarih = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        tarihET.setText(tarih);

        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is = isler.getText().toString();
                tarih = tarihET.getText().toString();

                Intent gonder = new Intent(getApplicationContext(),SonucActivity.class);
                gonder.putExtra("gonder_is",is);
                gonder.putExtra("gonder_tarih",tarih);

                startActivity(gonder);
            }
        });



    }
}
