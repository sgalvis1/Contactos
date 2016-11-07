package com.sebastian.contactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    private TextView TVnombre;
    private TextView TVtelefono;
    private TextView TVcorreo;
    private TextView TVdescripcion;

    String nombre;
    String telefono;
    String correo;
    String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button BTmodificar = (Button)findViewById(R.id.BTmodificar);

        Bundle parametros = getIntent().getExtras();

        nombre = parametros.getString("Nombre");
        telefono = parametros.getString("Telefono");
        correo = parametros.getString("Correo");
        descripcion = parametros.getString("Descripcion");

        TVnombre = (TextView) findViewById(R.id.TVnombre);
        TVtelefono = (TextView) findViewById(R.id.TVtelefono);
        TVcorreo = (TextView) findViewById(R.id.TVcorreo);
        TVdescripcion = (TextView) findViewById(R.id.TVdescripcion);

        TVnombre.setText(nombre);
        TVtelefono.setText(telefono);
        TVcorreo.setText(correo);
        TVdescripcion.setText(descripcion);

        BTmodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Main2Activity.this,MainActivity.class);
                int V = 1;
                i4.putExtra("Nombre",nombre);
                i4.putExtra("Telefono",telefono);
                i4.putExtra("Correo",correo);
                i4.putExtra("Descripcion",descripcion);
                i4.putExtra("Bandera",V);
                startActivity(i4);
            }
        });


    }

    public void llamar(View v) {
        String telefono = TVtelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+telefono)));


    }

    public void enviarcorreo(View v){
        String correo =  TVcorreo.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,correo);
        emailIntent.putExtra(Intent.EXTRA_CC,correo);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"correo"));
    }

 /*   public boolean onKeyDown(int KeyCode, KeyEvent event){
        if (KeyCode==KeyEvent.KEYCODE_BACK){
            Intent i2 = new Intent(this,MainActivity.class);
            startActivity(i2);
        }
        return super.onKeyDown(KeyCode,event);
    }
*/

}

