package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText etRemitente;
    EditText etAsunto;
    EditText etMensaje;

    AppDataBase miDB;
    CorreoDAO correoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etRemitente = findViewById(R.id.etRemitente);
        etAsunto = findViewById(R.id.etAsunto);
        etMensaje = findViewById(R.id.etMensaje);

        miDB = AppDataBase.getInstance(this);
        correoDAO = miDB.correoDAO();
    }

    public void guardar(View view){
        String remitente = etRemitente.getText().toString();
        String asunto = etAsunto.getText().toString();
        String mensaje = etMensaje.getText().toString();

        Correo correo = new Correo(remitente, asunto, mensaje);
        correoDAO.insertar(correo);
        Toast.makeText(MainActivity2.this, "Correo Guardado", Toast.LENGTH_SHORT).show();
    }
}