package cl.miempresa.miempresa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cl.miempresa.miempresa.Clases.DBHelper;
import cl.miempresa.miempresa.Clases.Empleado;

public class ListaEmpleadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        ListView listView = (ListView) findViewById(R.id.list_view_empleados);

        DBHelper db = new DBHelper(this);
        List<Empleado> listaEmpleados = db.getEmpleados();

        List<String> nombresEmpleados = new ArrayList<String>();

        for(Empleado empleado : listaEmpleados){
            nombresEmpleados.add(empleado.getNombre());
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, nombresEmpleados);

        listView.setAdapter(arrayAdapter);


    }
}
