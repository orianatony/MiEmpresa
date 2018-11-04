package cl.miempresa.miempresa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cl.miempresa.miempresa.Clases.DBHelper;
import cl.miempresa.miempresa.Clases.Empleado;
import cl.miempresa.miempresa.Clases.Servicio;

public class ListaServiciosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicios);

        ListView listView = (ListView) findViewById(R.id.list_view_servicios);

        DBHelper db = new DBHelper(this);
        final List<Servicio> listaServicios = db.getServicios();

        final ArrayAdapter<Servicio> arrayAdapter = new ArrayAdapter<Servicio>
                (this, android.R.layout.simple_list_item_1, listaServicios);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Servicio servicio = listaServicios.get(position);
                Intent d_e_intent = new Intent(ListaServiciosActivity.this,DetalleServicioActivity.class);
                d_e_intent.putExtra("id",servicio.getId());
                ListaServiciosActivity.this.startActivity(d_e_intent);
            }
        });
    }
}
