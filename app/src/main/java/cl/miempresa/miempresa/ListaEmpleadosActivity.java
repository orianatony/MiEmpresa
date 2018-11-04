package cl.miempresa.miempresa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        final List<Empleado> listaEmpleados = db.getEmpleados();

        final ArrayAdapter<Empleado> arrayAdapter = new ArrayAdapter<Empleado>
                (this, android.R.layout.simple_list_item_1, listaEmpleados);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Empleado empleado = listaEmpleados.get(position);
                Intent d_e_intent = new Intent(ListaEmpleadosActivity.this,DetalleEmpleadoActivity.class);
                d_e_intent.putExtra("id",empleado.getId());
                ListaEmpleadosActivity.this.startActivity(d_e_intent);
            }
        });


    }
}
