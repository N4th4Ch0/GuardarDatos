package com.example.guardardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.txtNombre);
        etDatos = (EditText) findViewById(R.id.txtDatos);

    }

    public void Guardar(View view){
        String nombre = etNombre.getText().toString();
        String datos = etDatos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences( "agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();

        Toast.makeText(this, "El contacto fue guardado", Toast.LENGTH_LONG).show();

    }


    //funcion del boton
    public void Buscar(View view){

        String nombre = etNombre.getText().toString();

        SharedPreferences preferencias =getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos= preferencias.getString(nombre, "");

        if(datos.length() ==0 ){

            Toast.makeText(this, "No se encontro este registro", Toast.LENGTH_LONG).show();
        }else{
            etDatos.setText(datos);

        }

    }

}