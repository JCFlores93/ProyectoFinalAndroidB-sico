package edu.cibertec.android.pharmamedic.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Android on 26/11/2016.
 */

public class PersonaSQLite implements PersonaDAO {

    MySqlOpenHelper mySqlOpenHelper;
    private Cursor fila;
    public PersonaSQLite(Context context){ mySqlOpenHelper = new MySqlOpenHelper(context);}

    @Override
    public long insertarPersona(Persona persona) {
        SQLiteDatabase db = mySqlOpenHelper.getWritableDatabase();

        ContentValues datos = new ContentValues();
        datos.put(PersonaDBContract.PersonaEntry.COLUMN_NAME, persona.getName());
        datos.put(PersonaDBContract.PersonaEntry.COLUMN_EMAIL, persona.getEmail());
        datos.put(PersonaDBContract.PersonaEntry.COLUMN_PASSWORD, persona.getPassword());
        datos.put(PersonaDBContract.PersonaEntry.COLUMN_LASTNAME, persona.getLastname());

        long rowid = db.insert(PersonaDBContract.PersonaEntry.TABLE_NAME, null,datos);

        return rowid;//BaseColumns al usar esto en la clase el SQLite maneja el id del registro
    }

    public String searchHelper(String email){
        SQLiteDatabase db = mySqlOpenHelper.getReadableDatabase();
        String query = "select email, password from "+ PersonaDBContract.PersonaEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "This was not Found";

        if (cursor.moveToFirst()) {
            do{
                a = cursor.getString(0);


                if(a.equals(email)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }





    @Override
    public List<Persona> listaPersona(Persona persona) {
        return null;
    }
}
