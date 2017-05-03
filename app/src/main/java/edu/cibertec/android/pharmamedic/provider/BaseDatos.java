package edu.cibertec.android.pharmamedic.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import edu.cibertec.android.pharmamedic.provider.Contrato.Alquileres;

/**
 * Clase auxiliar para controlar accesos a la base de datos SQLite
 */
public class BaseDatos extends SQLiteOpenHelper {

    static final int VERSION = 1;

    static final String NOMBRE_BD = "alquileres.db";


    interface Tablas {
        String APARTAMENTO = "alquiler";
    }

    public BaseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + Tablas.APARTAMENTO + "("
                        + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + Alquileres.ID_ALQUILER + " TEXT UNIQUE NOT NULL,"
                        + Alquileres.NOMBRE + " TEXT NOT NULL,"
                        + Alquileres.UBICACION + " TEXT NOT NULL,"
                        + Alquileres.DESCRIPCION + " TEXT NOT NULL,"
                        + Alquileres.PRECIO + " REAL NOT NULL,"
                        + Alquileres.URL_IMAGEN + " TEXT NOT NULL)");



        String androidListViewStrings[] = {"Epaplus Colágeno + Ác. Hialurónico + Magnesio sabor limón 332g", "LaJusticia colágeno con magnesio 180comp",
                "Fluocaril pasta dentifrica 125ml+125ml + 20% gratis",
                "LaJusticia colágeno con magnesio 450comp",
                "Xhekpon® crema facial 40ml", "Colnatur® Complex sabor neutro 330g",
                "LaJusticia colágeno con magnesio fresa 20 sticks", "Fluocaril pasta dentifrica 125ml+125ml + 20% gratis",
                "LaJusticia colágeno con magnesio 450com"};

        // Registro ejemplo #1
        ContentValues valores = new ContentValues();
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE,"Xhekpon® crema facial 40ml");
        valores.put(Alquileres.UBICACION, "San Juan de Mirafloes");
        valores.put(Alquileres.DESCRIPCION, "Controlar la ingesta diaria de alimentos, sobre todo cuando existen problemas de salud asociados, no resulta siempre fácil. Por este motivo Sanon ha lanzado el complemento vitamínico Omega 3, 6, 9, que gracias a su alto contenido en protectores cardiovasculares reduce los niveles de colesterol en sangre.");
        valores.put(Alquileres.PRECIO, "200");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/8330/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

        // Registro ejemplo #2
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE, "Armolipid Plus 20comp");
        valores.put(Alquileres.UBICACION, "San Juan de Miraflores");
        valores.put(Alquileres.DESCRIPCION, "Te ayuda a controlar los niveles de colesterol en sangre");
        valores.put(Alquileres.PRECIO, "240");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/18024/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

        // Registro ejemplo #3
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE, "Arkosterol levadura de arroz rojo 60cáps");
        valores.put(Alquileres.UBICACION, "Magdalena");
        valores.put(Alquileres.DESCRIPCION, "El colesterol circula por venas y arterias pudiendo formar depósitos que impidan el tránsito correcto de los fluidos. Si los niveles de colesterol son ligeramente altos es necesario tener un cuidado especial con la alimentación. ");
        valores.put(Alquileres.PRECIO, "300");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/11712/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

        // Registro ejemplo #4
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE, "Oxicol 28cáps");
        valores.put(Alquileres.UBICACION, "San Isidro");
        valores.put(Alquileres.DESCRIPCION, "Oxicol es un complemento alimenticio rico en activos que ayudan a controlar los niveles de colesterol, como la monacolina K, el extracto de olivo y el extracto de uva enriquecido. Estos compuestos actúan de forma sinérgica regulando el metabolismo del colesterol y aportando beneficios cardiovasculares.");
        valores.put(Alquileres.PRECIO, "500");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/27686/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

        // Registro ejemplo #5
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE, "Sanon Omega 3,6,9 110 perlas");
        valores.put(Alquileres.UBICACION, "Surco");
        valores.put(Alquileres.DESCRIPCION, "Controlar la ingesta diaria de alimentos, sobre todo cuando existen problemas de salud asociados, no resulta siempre fácil. Por este motivo Sanon ha lanzado el complemento vitamínico Omega 3, 6, 9, que gracias a su alto contenido en protectores cardiovasculares reduce los niveles de colesterol en sangre.");
        valores.put(Alquileres.PRECIO, "310");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/8441/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

        // Registro ejemplo #6
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE, "Oxicol 28cáps");
        valores.put(Alquileres.UBICACION, "San Isidro");
        valores.put(Alquileres.DESCRIPCION, "Oxicol es un complemento alimenticio rico en activos que ayudan a controlar los niveles de colesterol, como la monacolina K, el extracto de olivo y el extracto de uva enriquecido. Estos compuestos actúan de forma sinérgica regulando el metabolismo del colesterol y aportando beneficios cardiovasculares.");
        valores.put(Alquileres.PRECIO, "500");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/27686/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

        // Registro ejemplo #7
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE, "Sotya Omega 3 1400mg 50 perlas");
        valores.put(Alquileres.UBICACION, "San borja");
        valores.put(Alquileres.DESCRIPCION, "Controlar los niveles de colesterol es fundamental para preservar la salud, ya que este lípido es el responsable del 8% de toda la carga de enfermedades de los países desarrollados, del 60% de las enfermedades de corazón y del 40% de los infartos cerebrales");
        valores.put(Alquileres.PRECIO, "540");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/26576/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

        // Registro ejemplo #8
        valores.put(Alquileres.ID_ALQUILER, Alquileres.generarIdAlquiler());
        valores.put(Alquileres.NOMBRE, "Sanon Omega 3,6,9 110 perlas");
        valores.put(Alquileres.UBICACION, "Surco");
        valores.put(Alquileres.DESCRIPCION, "Controlar la ingesta diaria de alimentos, sobre todo cuando existen problemas de salud asociados, no resulta siempre fácil. Por este motivo Sanon ha lanzado el complemento vitamínico Omega 3, 6, 9, que gracias a su alto contenido en protectores cardiovasculares reduce los niveles de colesterol en sangre.");
        valores.put(Alquileres.PRECIO, "310");
        valores.put(Alquileres.URL_IMAGEN, "http://d2ycanzclfvz8u.cloudfront.net/images/coupon/8441/large/coupon_image_1.jpg");
        db.insertOrThrow(Tablas.APARTAMENTO, null, valores);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + Tablas.APARTAMENTO);
        } catch (SQLiteException e) {
            // Manejo de excepciones
        }
        onCreate(db);
    }
}
