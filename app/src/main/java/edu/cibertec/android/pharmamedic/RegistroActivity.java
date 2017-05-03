package edu.cibertec.android.pharmamedic;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Message;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegistroActivity extends AppCompatActivity {
    Button btnSgt;
    EditText txtNombre,txtApellido,txtDNI,txtMovil,txtEmail,txtContrasena;
    String sNombre,sApelllido,sDNI,sMovil,sEmail,sContrasena;
    ProgressDialog progressDialog;
    private Handler puente;
    TextView textView;
    ImageButton btnGoogle,btnFaceb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        txtNombre=(EditText)findViewById(R.id.txtnombre);
        txtApellido=(EditText)findViewById(R.id.txtApellido);
        txtDNI=(EditText)findViewById(R.id.txtDNI);
        txtMovil=(EditText)findViewById(R.id.txtMovil);
        txtEmail=(EditText)findViewById(R.id.txtCorreo);
        txtContrasena=(EditText)findViewById(R.id.txtContrasena);
        textView=(TextView)findViewById(R.id.textView2);
        btnGoogle=(ImageButton)findViewById(R.id.imageButton);
        btnFaceb=(ImageButton)findViewById(R.id.imageButton2);
        textView=(TextView)findViewById(R.id.textView2);

        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);


        txtNombre.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtNombre.setText("");
                }else{
                    if (!hasFocus && txtNombre.getText().toString().equals("")){
                        txtNombre.setText("Nombres");
                    }
                }
            }
        });

        txtApellido.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtApellido.setText("");
                }else{
                    if (!hasFocus && txtApellido.getText().toString().equals("")){
                        txtApellido.setText("Apellidos");
                    }
                }
            }
        });

        txtDNI.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtDNI.setText("");
                }else{
                    if (!hasFocus && txtDNI.getText().toString().equals("")){
                        txtDNI.setText("DNI");
                    }
                }
            }
        });

        txtEmail.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtEmail.setText("");
                }else{
                    if (!hasFocus && txtEmail.getText().toString().equals("")){
                        txtEmail.setText("E-mail");
                    }
                }
            }
        });
        txtMovil.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtMovil.setText("");
                }else{
                    if (!hasFocus && txtMovil.getText().toString().equals("")){
                        txtMovil.setText("Móvil");
                    }
                }
            }
        });

        txtContrasena.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtContrasena.setText("");
                }else{
                    if (!hasFocus && txtContrasena.getText().toString().equals("")){
                        txtContrasena.setText("................");
                    }
                }
            }
        });


        puente=new Handler(){
            @Override
            public void handleMessage(Message msg){
                if((Integer)msg.obj==10001){
                    sNombre=txtNombre.getText().toString();
                    sApelllido=txtApellido.getText().toString();
                    sDNI=txtDNI.getText().toString();
                    sMovil=txtMovil.getText().toString();
                    sEmail=txtEmail.getText().toString();
                    sContrasena=txtContrasena.getText().toString();
                    Intent ventana2=new Intent(getBaseContext(),Registro1Activity.class);
                    ventana2.putExtra("Nombre",sNombre);
                    ventana2.putExtra("Apellido",sApelllido);
                    ventana2.putExtra("DNI",sDNI);
                    ventana2.putExtra("Movil",sMovil);
                    ventana2.putExtra("Email",sEmail);
                    ventana2.putExtra("Contrasena",sContrasena);
                    startActivity(ventana2);
                    finish();
                }else{progressDialog.setProgress((Integer)msg.obj);}

            }
        };


        btnSgt=(Button)findViewById(R.id.btnSiguiente1);


        btnSgt.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){
                progressDialog= new ProgressDialog(RegistroActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMessage("Loading...");
                progressDialog.setMax(10000);
                progressDialog.setProgress(0);
                progressDialog.setCancelable(false);
                progressDialog.show();
                Thread th1 = new Thread(){
                    @Override
                    public void run() {

                        for (int a=1;a<=10001;a++)
                        {
                            int contador=a;
                            Message msg=new Message();
                            msg.obj=a;
                            puente.sendMessage(msg);
                        }
                    }
                };
                th1.start();

              /*  DNI=txtDNI.getText().toString();
                Intent ventana2 =new Intent(getBaseContext(),DetallePersonaActivity.class);
                ventana2.putExtra("DNI",DNI);
                startActivity(ventana2);
                finish();*/
            }
        });

    }


}
