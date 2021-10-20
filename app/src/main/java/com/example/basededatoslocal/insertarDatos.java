package com.example.basededatoslocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insertarDatos extends AppCompatActivity {

    Button btn5, btn6;
    EditText id, nom, tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_datos);

        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);

        id = findViewById(R.id.editTextNumber);
        nom = findViewById(R.id.editTextTextPersonName);
        tel = findViewById(R.id.editTextPhone);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql sql1 = new sql(getApplicationContext());
                sql1.insert(Integer.parseInt(id.getText().toString()), nom.getText().toString(),tel.getText().toString(), getApplicationContext());
                //Toast.makeText(this, "Se creó el usuario", Toast.LENGTH_SHORT).show();
                id.setText("");
                nom.setText("");
                tel.setText("");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}