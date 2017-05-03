package edu.cibertec.android.pharmamedic;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.cibertec.android.pharmamedic.data.MySqlOpenHelper;
import edu.cibertec.android.pharmamedic.data.Persona;
import edu.cibertec.android.pharmamedic.data.PersonaDAO;
import edu.cibertec.android.pharmamedic.data.PersonaSQLite;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    MySqlOpenHelper helper = new MySqlOpenHelper(this);
    private Button Bsignupbutton;
    private boolean encontrado =false;
    private PersonaDAO personaDAO;
    Persona persona = new Persona();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bsignupbutton=(Button) findViewById(R.id.Bsignupbutton);
        Bsignupbutton.setOnClickListener(this);
        personaDAO = new PersonaSQLite(getBaseContext());
    }




    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Bsignupbutton){
            EditText name = (EditText)findViewById(R.id.name);
            EditText email = (EditText)findViewById(R.id.email);
            EditText lastname = (EditText)findViewById(R.id.lastname);
            EditText pass1 = (EditText)findViewById(R.id.password);
            EditText pass2 = (EditText)findViewById(R.id.confirm_password);

            String nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String lastnameStr = lastname.getText().toString();
            String passStr = pass1.getText().toString();
            String pass2Str = pass2.getText().toString();

            if(!passStr.equals(pass2Str)){
                // Show some popUp message
                Toast message = Toast.makeText(this, "Your does not Match", Toast.LENGTH_SHORT);
                message.show();
            }else{
                // Insert User Details into the Database
                persona.setName(nameStr);
                persona.setEmail(emailStr);
                persona.setLastname(lastnameStr);
                persona.setPassword(passStr);


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder
                        .setMessage(encontrado ? "Se actualizará Datos de Persona" : "Se guardará los datos de la Persona")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                long rowid = personaDAO.insertarPersona(persona);
                                if (rowid != -1){
                                    persona.setId(rowid);
                           /*Snackbar snack = Snackbar.make(toolbar, encontrado ? "Se actualizó los datos":"Se guardó los datos",
                                    Snackbar.LENGTH_SHORT);
                            snack.show();*/
                                    mostrarNotificacion();
                                }else{
                                    Snackbar.make(getWindow().getDecorView(), "Ocurrió un error", Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                //helper.insertContact(con);
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void mostrarNotificacion() {
        long[] pattern = new long[]{100, 250, 100, 500};
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat
                .Builder(this)
                .setSmallIcon(R.drawable.phama4)
                .setLargeIcon((((BitmapDrawable)getResources().getDrawable(R.drawable.phama4)).getBitmap()))
                .setContentTitle("Bienvenido")
                .setContentText("Accede a tu cuenta ya!");

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent resultIntent = new Intent(this, LoginActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, resultIntent, 0);
        //Se abrirá la vista Login
        mBuilder.setContentIntent(pendingIntent);
        //Se le asigna la vibracion a la notifiacion
        mBuilder.setVibrate(pattern);
        //Se quitara la notificación al hacer tap sobre ella
        mBuilder.setAutoCancel(true);
        mNotificationManager.notify(1, mBuilder.build());
        //Se cierra este activity
      /*  finish();*/
}
}
