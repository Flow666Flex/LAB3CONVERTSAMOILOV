package com.example.lab2convertsamoilov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spFROM;
    Spinner spTO;
    EditText etFROM;
    TextView tvTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFROM = findViewById(R.id.lstFROM);
        spTO = findViewById(R.id.lstTO);
        etFROM = findViewById(R.id.txtFrom);
        tvTO = findViewById(R.id.labTo);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFROM.setAdapter(adp);
        spTO.setAdapter(adp);

    }

    public void on_convert(View V)
    {
        double from = Double.parseDouble (etFROM.getText().toString());

        String sFrom = (String) spFROM.getSelectedItem();
        String sTo = (String) spTO.getSelectedItem();

        double to = 0.0;

        if (sFrom.equals("mm"))
        {
            if (sTo.equals("mm")) to = from * 1.0;
            if (sTo.equals("cm")) to = from * 0.1;
            if (sTo.equals("m")) to = from * 0.001;
            if (sTo.equals("km")) to = from * 0.000001;
        }

        if (sFrom.equals("cm"))
        {
            if (sTo.equals("mm")) to = from * 10;
            if (sTo.equals("cm")) to = from * 1;
            if (sTo.equals("m")) to = from * 0.01;
            if (sTo.equals("km")) to = from * 0.00001;
        }

        if (sFrom.equals("m"))
        {
            if (sTo.equals("mm")) to = from * 1000;
            if (sTo.equals("cm")) to = from * 100;
            if (sTo.equals("m")) to = from * 1;
            if (sTo.equals("km")) to = from * 0.001;
        }

        if (sFrom.equals("km"))
        {
            if (sTo.equals("mm")) to = from * 1000000;
            if (sTo.equals("cm")) to = from * 100000;
            if (sTo.equals("m")) to = from * 1000;
            if (sTo.equals("km")) to = from * 1;
        }

        tvTO.setText(String.valueOf(to));

    }
}