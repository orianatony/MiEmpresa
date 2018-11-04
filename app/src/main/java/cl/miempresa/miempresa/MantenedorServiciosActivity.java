package cl.miempresa.miempresa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.miempresa.miempresa.Clases.DBHelper;
import cl.miempresa.miempresa.Clases.Servicio;

public class MantenedorServiciosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenedor_servicios);

        final EditText txt_id = findViewById(R.id.txt_servicio_id);
        final EditText txt_nombre = findViewById(R.id.txt_servicio_nombre);
        final EditText txt_descripcion = findViewById(R.id.txt_servicio_descripcion);

        Button btn_servicio_agregar = findViewById(R.id.btn_servicio_agregar);
        Button btn_servicio_buscar = findViewById(R.id.btn_servicio_buscar);
        Button btn_servicio_editar = findViewById(R.id.btn_servicio_editar);
        Button btn_servicio_borrar = findViewById(R.id.btn_servicio_borrar);
        Button btn_servicio_limpiar = findViewById(R.id.btn_servicio_limpiar);

        btn_servicio_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_id.setText("");
                txt_nombre.setText("");
                txt_descripcion.setText("");
            }
        });

        btn_servicio_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = txt_nombre.getText().toString();
                String descripcion = txt_descripcion.getText().toString();

                if(nombre.equals("") || descripcion.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar nombre y descripcion",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    Servicio servicio = new Servicio();
                    servicio.setNombre(nombre);
                    servicio.setDescripcion(descripcion);

                    long servicio_id = db.crearServicio(servicio);
                    Toast.makeText(getApplicationContext(),"Se ha ingresado el servicio con ID " + Long.toString(servicio_id),Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_servicio_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_id.getText().toString();
                String nombre = txt_nombre.getText().toString();
                String descripcion = txt_descripcion.getText().toString();

                List<String> data = new ArrayList<String>();
                data.add(id);
                data.add(nombre);
                data.add(descripcion);

                if(id.equals("") && nombre.equals("") && descripcion.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar campo de busqueda.",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    Servicio servicio = db.getServicio(data);
                    if(servicio == null){
                        Toast.makeText(getApplicationContext(),"No se ha encontrado servicio.",Toast.LENGTH_LONG).show();
                    }else{
                        if(id.equals("")){
                            txt_id.setText(Integer.toString(servicio.getId()));
                        }
                        if(nombre.equals("")){
                            txt_nombre.setText(servicio.getNombre());
                        }
                        if(descripcion.equals("")){
                            txt_descripcion.setText(servicio.getDescripcion());
                        }

                        Toast.makeText(getApplicationContext(),"Se ha encontrado servicio.",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        btn_servicio_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_id.getText().toString();
                String nombre = txt_nombre.getText().toString();
                String descripcion = txt_descripcion.getText().toString();

                if(id.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar ID de servicio.",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    Servicio servicio = new Servicio();
                    servicio.setNombre(txt_nombre.getText().toString());
                    servicio.setDescripcion(txt_descripcion.getText().toString());
                    servicio.setId(Integer.parseInt(txt_id.getText().toString()));

                    int servicio_id = db.actualizarServicio(servicio);
                    if(servicio_id == 1){
                        Toast.makeText(getApplicationContext(),"Se ha actualizado el servicio.",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Ha ocurrido un problema.",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btn_servicio_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_id.getText().toString();

                if(id.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar ID de servicio.",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    db.borrarServicio(Integer.parseInt(txt_id.getText().toString()));
                    Toast.makeText(getApplicationContext(),"Se ha eliminado el servicio.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
