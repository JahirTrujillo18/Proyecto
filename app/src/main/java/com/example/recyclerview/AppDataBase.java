package com.example.recyclerview;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {Correo.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DB_NAME = "correos.db";
    private static AppDataBase INSTANCIA =null;

    public static AppDataBase getInstance(Context context){

        if(INSTANCIA == null){
            synchronized (AppDataBase.class){
                INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                        AppDataBase.class,
                        DB_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }

        return INSTANCIA;

    }

    public abstract CorreoDAO correoDAO();
}
