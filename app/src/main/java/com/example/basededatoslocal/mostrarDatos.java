package com.example.basededatoslocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mostrarDatos extends AppCompatActivity {

    EditText texto;
    Button btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        texto = findViewById(R.id.editTextTextMultiLine);
        btn7 = findViewById(R.id.button7);

        sql sql1 = new sql(getApplicationContext());

        //sql1.insert(1,"Pepe", "241 110 3434", getApplicationContext());

        String datos = sql1.select("select * from usuario", getApplicationContext());

        texto.setText(datos);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}