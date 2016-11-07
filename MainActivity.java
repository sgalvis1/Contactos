package com.sebastian.contactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    TextInputLayout TILnombre;
    TextInputLayout TILtelefono;
    TextInputLayout TILcorreo;
    TextInputLayout TILdescripcion;
    TextInputEditText TIEnombre;
    TextInputEditText TIEtelefono;
    TextInputEditText TIEcorreo;
    TextInputEditText TIEdescripcion;
    String ETnombre;
    String ETtelefono;
    String ETemail;
    String ETdescripcion;
    private int Year, mes,dia;
    String nombre;
    String telefono;
    String correo;
    String descripcion;
    int V =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();
        TILnombre = (TextInputLayout)findViewById(R.id.TILnombre);
        TILtelefono = (TextInputLayout)findViewById(R.id.TILtelefono);
        TILcorreo = (TextInputLayout)findViewById(R.id.TILemail);
        TILdescripcion = (TextInputLayout)findViewById(R.id.TILdescripcion);

        TIEnombre = (TextInputEditText)findViewById(R.id.TIEnombre);
        TIEtelefono = (TextInputEditText)findViewById(R.id.TIEtelefono);
        TIEcorreo = (TextInputEditText)findViewById(R.id.TIEemail);

        Button BTsiguiente = (Button) findViewById(R.id.BTsiguiente);
        Button BTfecha = (Button) findViewById(R.id.BTfecha);

        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString("Nombre");
        telefono = parametros.getString("Telefono");
        correo = parametros.getString("Correo");
        descripcion = parametros.getString("Descripcion");
        if(V==1) {
            TIEnombre.setText(nombre);
            TIEtelefono.setText(telefono);
            TIEcorreo.setText(correo);
            TIEdescripcion.setText(descripcion);
        }

        BTsiguiente.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Contacto creado",Toast.LENGTH_SHORT).show();
                ETnombre =  TILnombre.getEditText().getText().toString();
                ETtelefono =  TILtelefono.getEditText().getText().toString();
                ETemail =  TILcorreo.getEditText().getText().toString();
                ETdescripcion =  TILdescripcion.getEditText().getText().toString();

               // hideKeyboard();
                Intent i3 = new Intent(MainActivity.this,Main2Activity.class);
                i3.putExtra("Nombre",ETnombre);
                i3.putExtra("Telefono",ETtelefono);
                i3.putExtra("Correo",ETemail);
                i3.putExtra("Descripcion",ETdescripcion);
                startActivity(i3);

            }
        });


/*
        contactos.add(new Contacto("Paulo Galvis","3137004059","paulo97@gmail.com"));
        contactos.add(new Contacto("Gloria Cardona","3127945443","gloria.cardona@hotmail.es"));
        contactos.add(new Contacto("Neslon Galvis","311349866","negapaz1@hotmail.com"));

        ArrayList<String> nombre_contactos = new ArrayList<>();
        for (Contacto contacto: contactos){
            nombre_contactos.add(contacto.getNombre());
        }

        ListView LVcontactos = (ListView) findViewById(R.id.LVContactos);
        LVcontactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombre_contactos));

        LVcontactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i1 = new Intent(MainActivity.this, Main2Activity.class);
                i1.putExtra("Nombre",contactos.get(position).getNombre());
                i1.putExtra("Telefono",contactos.get(position).getTelefono());
                i1.putExtra("Correo",contactos.get(position).getCorreo());
                startActivity(i1);
                finish();
            }
        });
*/
    }
    // Metodo para no volver a mostrar el teclado
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int syear, int smonth, int sday) {
            // Do something with the date chosen by the user
            final Calendar c = Calendar.getInstance();
            int year = syear;
            int month = smonth;
            int day = sday;
            // Create a new instance of DatePickerDialog and return it
            new DatePickerDialog(getActivity(), this, year, month, day);
        }


    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

}
