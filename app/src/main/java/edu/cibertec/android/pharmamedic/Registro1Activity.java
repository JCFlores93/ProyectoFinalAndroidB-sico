package edu.cibertec.android.pharmamedic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class Registro1Activity extends AppCompatActivity {
    String sNombre,sApelllido,sDNI,sMovil,sEmail,sContrasena,Opcion,sNumTarjeta;
    EditText NumTarjeta,opcion;
    RadioButton rbtnEfectivo;
    Button btnCrearCuenta;
    private Handler puente;
    ProgressDialog progressDialog;
    ImageButton imgVisa;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        puente=new Handler(){
            @Override
            public void handleMessage(Message msg){
                if((Integer)msg.obj==10001){
                    Intent ventana2=new Intent(getBaseContext(),RegistroFActivity.class);
                    ventana2.putExtra("Nombre",sNombre);
                    ventana2.putExtra("Apellido",sApelllido);
                    ventana2.putExtra("DNI",sDNI);
                    ventana2.putExtra("Movil",sMovil);
                    ventana2.putExtra("Email",sEmail);
                    ventana2.putExtra("Contrasena",sContrasena);
                    sNumTarjeta=NumTarjeta.getText().toString();
                    ventana2.putExtra("NumeroDeTarjeta",sNumTarjeta);
                    if(rbtnEfectivo.isChecked()){
                        Opcion = "EFECTIVO";
                    }

                    ventana2.putExtra("Efectivo",Opcion);

                    startActivity(ventana2);
                    finish();
                }else{progressDialog.setProgress((Integer)msg.obj);}

            }
        };

        Bundle extras=this.getIntent().getExtras();

        sNombre=extras.getString("Nombre");
        sApelllido=extras.getString("Apellido");
        sDNI=extras.getString("DNI");
        sMovil=extras.getString("Movil");
        sEmail=extras.getString("Email");
        sContrasena=extras.getString("Contrasena");
        rbtnEfectivo = (RadioButton) findViewById(R.id.rbtnEfectivo);
        NumTarjeta=(EditText)findViewById(R.id.txtNumeroDeTarjeta);
        imgVisa=(ImageButton)findViewById(R.id.imgbtnVisa);
        tv=(TextView)findViewById(R.id.textView);

        //imgVisa.setFocusable(true);
        /*imgVisa.setFocusableInTouchMode(true);*/
        //imgVisa.requestFocus();
        tv.setFocusable(true);
        tv.setFocusableInTouchMode(true);



        NumTarjeta.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    NumTarjeta.setText("");
                }else{
                    if (!hasFocus && NumTarjeta.getText().toString().equals("")){
                        NumTarjeta.setText("Nombres");
                    }
                }
            }
        });


        btnCrearCuenta=(Button)findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                progressDialog= new ProgressDialog(Registro1Activity.this);
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
            }

        });


    }


}
