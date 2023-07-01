package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDataBase miDB;
    CorreoDAO correoDAO;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://appapi2022.000webhostapp.com/api.php";



        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Usuario> usuarios = new ArrayList<>();
                        for (int i=0; i<response.length(); i++){
                            try {
                                JSONObject usuarioObject = response.getJSONObject(i);
                                String username = usuarioObject.getString("username");
                                String nombres = usuarioObject.getString("nombres");
                                String apellidos = usuarioObject.getString("apellidos");
                                String tipo = usuarioObject.getString("tipo");
                                Log.i("DATOS", usuarioObject.getString("tipo"));
                                usuarios.add(new Usuario(username, nombres, apellidos, tipo));


                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        RecyclerView  myRecycler = findViewById(R.id.myRecycler);
                        CorreoAdapter myAdapter = new CorreoAdapter(usuarios);
                        myRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        myRecycler.setAdapter(myAdapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error al cargar al cargar datos", Toast.LENGTH_SHORT).show();

                    }
                });

        queue.add(request);



        /*miDB = AppDatabase.getInstance(this);
        correoDAO = miDB.correoDAO();*/

        // List<Correo> correos = correoDAO.traerTodo();
        /*correos.add(new Correo("Dagmar", "Ut molestias impedi", "Voluptatem similiqu"));
        correos.add(new Correo("Piper", "Necessitatibus veni", "Nihil ut est ipsum"));
        correos.add(new Correo("Khalid", "Sunt voluptatem est", "Consectetur et inci"));
        correos.add(new Correo("Scottie", "Omnis et officiis q", "Ut explicabo possim"));
        correos.add(new Correo("frank", "Doloribus placeat e", "Incidunt delectus r"));
        correos.add(new Correo("yanpohol", "Doloribus placeat e", "Incidunt delectus r"));
        correos.add(new Correo("Yorch", "Doloribus placeat e", "Incidunt delectus r"));
        correos.add(new Correo("Angello", "Doloribus placeat e", "Incidunt delectus r"));
        correos.add(new Correo("Pilar", "Doloribus placeat e", "Incidunt delectus r"));
        correos.add(new Correo("Soleda", "Doloribus placeat e", "Incidunt delectus r"));
        correos.add(new Correo("Pepin", "Doloribus placeat e", "Incidunt delectus r"));*/



    }
}