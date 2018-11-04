package cl.miempresa.miempresa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        List<Servicio> listaServicios = db.getServicios();

        List<String> nombresServicios = new ArrayList<String>();

        for(Servicio servicio : listaServicios){
            nombresServicios.add(servicio.getNombre());
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, nombresServicios);

        listView.setAdapter(arrayAdapter);
    }
}
