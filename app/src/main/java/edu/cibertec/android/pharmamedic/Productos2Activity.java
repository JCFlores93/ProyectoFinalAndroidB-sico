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
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Productos2Activity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    String sProd1,sProd2,sProd3,Resultado;
    Double dMonto1,dMonto2,dMonto3,dMontoFinal;
    int cProd1,cProd2,cProd3;
    Button btnConfirmar;
    ProgressDialog progressDialog;
    private Handler puente;
    ImageButton imgRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



           // tv1=(TextView)findViewById(R.id.txtProductos);
            //tv2=(TextView)findViewById(R.id.txtCantidad);
            //tv3=(TextView)findViewById(R.id.txtMonto);
        tv1=(TextView)findViewById(R.id.textView15);
        btnConfirmar=(Button)findViewById(R.id.btnConfirmar);
        imgRegresar=(ImageButton)findViewById(R.id.imgBtnRegresar);
        imgRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });

        Bundle extras=this.getIntent().getExtras();
        cProd1=extras.getInt("cProducto1");
        sProd1=extras.getString("sProducto1");
        cProd2=extras.getInt("cProducto2");
        sProd2=extras.getString("sProducto2");
        cProd3=extras.getInt("cProducto3");
        sProd3=extras.getString("sProducto3");
        puente=new Handler(){
            @Override
            public void handleMessage(Message msg){
                if((Integer)msg.obj==10001){
                    //Enviar al historial o iniciar el login
                    Intent ventana=new Intent(getBaseContext(),RegistroActivity.class);
                    startActivity(ventana);
                    finish();
                }else{progressDialog.setProgress((Integer)msg.obj);}

            }
        };
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargar();
            }
        });

       loadText();
    }

    public void loadText(){
            if(cProd1>0 && cProd2>0 && cProd3>0){
            dMonto1=8.25*cProd1;
            dMonto2=10.00*cProd2;
            dMonto3=12.23*cProd3;
            dMontoFinal=dMonto1+dMonto2+dMonto3;
            Resultado=   sProd1+"                    "+cProd1+"                         "+dMonto1+"\n"+
                         sProd2+"                    "+cProd2+"                         "+dMonto2+"\n"+
                         sProd3+"                    "+cProd3+"                         "+dMonto3+"\n"+
                    "------------------------------------------------------------------\n"+
                    "SubTotal:                                                  "+dMontoFinal+"\n"+
                    "Total   :                                                      "+dMontoFinal;


        }else{
            if(cProd1>0 && cProd2>0 && cProd3<=0){
                dMonto1=8.25*cProd1;
                dMonto2=10.00*cProd2;

                dMontoFinal=dMonto1+dMonto2;
                 Resultado=   sProd1+"                    "+cProd1+"                         "+dMonto1+"\r\n"+
                        sProd2+"                    "+cProd2+"                         "+dMonto2+"\r\n"+

                         "------------------------------------------------------------------\n"+
                         "SubTotal:                                                  "+dMontoFinal+"\n"+
                         "Total   :                                                      "+dMontoFinal;


            }else{
                if(cProd1>0 && cProd2<=0 && cProd3>0){
                    dMonto1=8.25*cProd1;

                    dMonto3=12.23*cProd3;
                    dMontoFinal=dMonto1+dMonto3;
                    Resultado=   sProd1+"                    "+cProd1+"                         "+dMonto1+"\r\n"+

                            sProd3+"                    "+cProd3+"                         "+dMonto3+"\r\n"+
                            "------------------------------------------------------------------\n"+
                            "SubTotal:                                                  "+dMontoFinal+"\n"+
                            "Total   :                                                      "+dMontoFinal;


                }else{
                    if(cProd1<=0 && cProd2>0 && cProd3>0){

                        dMonto2=10.00*cProd2;
                        dMonto3=12.23*cProd3;
                        dMontoFinal=dMonto2+dMonto3;
                        Resultado=
                                sProd2+"                    "+cProd2+"                         "+dMonto2+"\r\n"+
                                        sProd3+"                    "+cProd3+"                         "+dMonto3+"\r\n"+
                                        "------------------------------------------------------------------\n"+
                                        "SubTotal:                                                  "+dMontoFinal+"\n"+
                                        "Total   :                                                      "+dMontoFinal;


                    }else{
                        if(cProd1>0 && cProd2<=0 && cProd3<=0){
                            dMonto1=8.25*cProd1;

                            dMontoFinal=dMonto1;
                             Resultado=   sProd1+"                    "+cProd1+"                         "+dMonto1+"\r\n"+

                                     "------------------------------------------------------------------\n"+
                                     "SubTotal:                                                  "+dMontoFinal+"\n"+
                                     "Total   :                                                      "+dMontoFinal;


                        }else{
                            if(cProd1<=0 && cProd2>0 && cProd3<=0){

                                dMonto2=10.00*cProd2;

                                dMontoFinal=dMonto2;
                               Resultado=
                                        sProd2+"                    "+cProd2+"                         "+dMonto2+"\r\n"+

                                                "------------------------------------------------------------------\n"+
                                                "SubTotal:                                                  "+dMontoFinal+"\n"+
                                                "Total   :                                                      "+dMontoFinal;


                            }else{
                                if(cProd1<=0 && cProd2<=0 && cProd3>0){

                                    dMonto3=12.23*cProd3;
                                    dMontoFinal=dMonto3;
                                     Resultado=
                                            sProd3+"                    "+cProd3+"                         "+dMonto3+"\r\n"+
                                                    "------------------------------------------------------------------\n"+
                                                    "SubTotal:                                                  "+dMontoFinal+"\n"+
                                                    "Total   :                                                      "+dMontoFinal;


                                }
                            }
                        }
                    }
                }
            }

        }
tv1.setMovementMethod(new ScrollingMovementMethod());
        tv1.setText(Resultado);
}
    public void cargar(){


        progressDialog= new ProgressDialog(Productos2Activity.this);
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
    public void regresar(){
        Intent ventana=new Intent(getBaseContext(),ProductosActivity.class);
        startActivity(ventana);
        finish();
    }
}

