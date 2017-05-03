package edu.cibertec.android.pharmamedic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.R.*;

public class RegistroFActivity extends AppCompatActivity {
    String sNombre,sApelllido,sDNI,sMovil,sEmail,sContrasena,sEfectivo,sNumTarjeta;
    EditText tNombre,txtApellido,txtDNI,txtMovil,txtEmail,txtContrasena,txtNumeroDeTarjeta,txtModoEfectivo;
    RadioButton rbtnEfectivo;
    Button btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_f);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        tNombre=(EditText)findViewById(R.id.txtNombre);
        txtApellido=(EditText)findViewById(R.id.txtApellido);
        txtDNI=(EditText)findViewById(R.id.txtDNI);
        txtMovil=(EditText)findViewById(R.id.txtMovil);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtContrasena=(EditText)findViewById(R.id.txtContraseña);
        txtNumeroDeTarjeta=(EditText)findViewById(R.id.txtNumeroDeTarjeta);
        txtModoEfectivo=(EditText)findViewById(R.id.txtModoEfectivo);

        Bundle extras=this.getIntent().getExtras();
        sNombre=extras.getString("Nombre");
        sApelllido=extras.getString("Apellido");
        sDNI=extras.getString("DNI");
        sMovil=extras.getString("Movil");
        sEmail=extras.getString("Email");
        sContrasena=extras.getString("Contrasena");
        sNumTarjeta=extras.getString("NumeroDeTarjeta");
        sEfectivo=extras.getString("Efectivo");

        tNombre.setText(sNombre);
        txtApellido.setText(sApelllido);
        txtDNI.setText(sDNI);
        txtMovil.setText(sMovil);
        txtEmail.setText(sEmail);
        txtContrasena.setText(sContrasena);
        txtNumeroDeTarjeta.setText(sNumTarjeta);
        txtModoEfectivo.setText(sEfectivo);


        /*rbtnEfectivo = (RadioButton) findViewById(R.id.rbtnEfectivo);
        NumTarjeta=(EditText)findViewById(R.id.txtNumeroDeTarjeta);*/
    }

}
