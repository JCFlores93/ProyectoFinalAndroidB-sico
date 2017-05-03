package edu.cibertec.android.pharmamedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ProductosActivity extends AppCompatActivity {
    EditText txtProducto1,txtProducto2,txtProducto3;
    Button btnSiguiente2;
    String nProducto1,nProducto2,nProducto3;
    int cProducto1,cProducto2,cProducto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        txtProducto1=(EditText)findViewById(R.id.txtProducto1);
        txtProducto2=(EditText)findViewById(R.id.txtProducto2);
        txtProducto3=(EditText)findViewById(R.id.txtProducto3);

        txtProducto1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtProducto1.setText("");
                }else{
                    if (!hasFocus && txtProducto1.getText().toString().equals("")){
                        txtProducto1.setText("Ingrese la cantidad");
                    }
                }
            }
        });

        txtProducto2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtProducto2.setText("");
                }else{
                    if (!hasFocus && txtProducto2.getText().toString().equals("")){
                        txtProducto2.setText("Ingrese la cantidad");
                    }
                }
            }
        });

        txtProducto3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtProducto3.setText("");
                }else{
                    if (!hasFocus && txtProducto1.getText().toString().equals("")){
                        txtProducto3.setText("Ingrese la cantidad");
                    }
                }
            }
        });

        btnSiguiente2=(Button)findViewById(R.id.btnSiguiente2);
        btnSiguiente2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view){

                        if(Integer.parseInt(txtProducto1.getText().toString())>0){
                                 nProducto1="Producto1";
                                 cProducto1=Integer.parseInt(txtProducto1.getText().toString());
                        }

                        if(Integer.parseInt(txtProducto2.getText().toString())>0){
                             nProducto2="Producto2";
                             cProducto2=Integer.parseInt(txtProducto2.getText().toString());
                        }

                        if(Integer.parseInt(txtProducto3.getText().toString())>0){
                             nProducto3="Producto3";
                             cProducto3=Integer.parseInt(txtProducto3.getText().toString());
                        }

                        Intent ventananueva= new Intent(getBaseContext(),Productos2Activity.class);
                        if((cProducto1>0)&&(cProducto2>0) && (cProducto3>0)){
                            ventananueva.putExtra("sProducto1",nProducto1);
                            ventananueva.putExtra("cProducto1",cProducto1);
                            ventananueva.putExtra("sProducto2",nProducto2);
                            ventananueva.putExtra("cProducto2",cProducto2);
                            ventananueva.putExtra("sProducto3",nProducto3);
                            ventananueva.putExtra("cProducto3",cProducto3);
                            startActivity(ventananueva);
                            finish();

                        }else{
                            if((cProducto1>0)&&(cProducto2>0 ) &&(cProducto3<=0 )){
                                ventananueva.putExtra("sProducto1",nProducto1);
                                ventananueva.putExtra("cProducto1",cProducto1);
                                ventananueva.putExtra("sProducto2",nProducto2);
                                ventananueva.putExtra("cProducto2",cProducto2);
                                startActivity(ventananueva);
                                finish();
                            }else {
                                if((cProducto1>0 )&&(cProducto3>0 ) &&(cProducto2<=0)){
                                    ventananueva.putExtra("sProducto1",nProducto1);
                                    ventananueva.putExtra("cProducto1",cProducto1);
                                    ventananueva.putExtra("sProducto3",nProducto3);
                                    ventananueva.putExtra("cProducto3",cProducto3);
                                    startActivity(ventananueva);
                                    finish();
                                }else {
                                    if((cProducto1<=0)&&(cProducto2>0 )&&(cProducto3>0)){
                                        ventananueva.putExtra("sProducto2",nProducto2);
                                        ventananueva.putExtra("cProducto2",cProducto2);
                                        ventananueva.putExtra("sProducto3",nProducto3);
                                        ventananueva.putExtra("cProducto3",cProducto3);
                                        startActivity(ventananueva);
                                        finish();
                                    }else {
                                        if((cProducto1>0 )&&(cProducto2<=0 ) && (cProducto3<=0 )){
                                            ventananueva.putExtra("sProducto1",nProducto1);
                                            ventananueva.putExtra("cProducto1",cProducto1);
                                            startActivity(ventananueva);
                                            finish();

                                        }else
                                        {
                                            if((cProducto1<=0 )&&(cProducto2>0 ) && (cProducto3<=0 )){
                                                ventananueva.putExtra("sProducto2",nProducto2);
                                                ventananueva.putExtra("cProducto2",cProducto2);
                                                startActivity(ventananueva);
                                                finish();
                                            }else{
                                                if((cProducto1<=0 )&&(cProducto2<=0 ) && (cProducto3>0)){
                                                    ventananueva.putExtra("sProducto3",nProducto3);
                                                    ventananueva.putExtra("cProducto3",cProducto3);
                                                    startActivity(ventananueva);
                                                    finish();
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }



                 }


                });


    }

}

