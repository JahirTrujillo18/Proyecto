package com.example.recyclerview;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CorreoDAO {
    @Query("SELECT * FROM correo")
    List<Correo> TraerTodo();

    @Insert
    void insertar(Correo... correos);

}