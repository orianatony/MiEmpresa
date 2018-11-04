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
import cl.miempresa.miempresa.Clases.Empleado;

public class MantenedorEmpleadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenedor_empleados);

        final EditText txt_id = findViewById(R.id.txt_empleado_id);
        final EditText txt_nombre = findViewById(R.id.txt_empleado_nombre);
        final EditText txt_cargo = findViewById(R.id.txt_empleado_cargo);
        final EditText txt_correo = findViewById(R.id.txt_empleado_correo);

        Button btn_empleado_agregar = findViewById(R.id.btn_empleado_agregar);
        Button btn_empleado_buscar = findViewById(R.id.btn_empleado_buscar);
        Button btn_empleado_editar = findViewById(R.id.btn_empleado_editar);
        Button btn_empleado_borrar = findViewById(R.id.btn_empleado_borrar);
        Button btn_empleado_limpiar = findViewById(R.id.btn_empleado_limpiar);

        btn_empleado_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_id.setText("");
                txt_nombre.setText("");
                txt_cargo.setText("");
                txt_correo.setText("");
            }
        });

        btn_empleado_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = txt_nombre.getText().toString();
                String cargo = txt_cargo.getText().toString();
                String correo = txt_correo.getText().toString();

                if(nombre.equals("") || cargo.equals("") || correo.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar nombre,cargo y correo",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    Empleado empleado = new Empleado();
                    empleado.setNombre(nombre);
                    empleado.setCargo(cargo);
                    empleado.setCorreo(correo);

                    long empleado_id = db.crearEmpleado(empleado);
                    Toast.makeText(getApplicationContext(),"Se ha ingresado el empleado con ID " + Long.toString(empleado_id),Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_empleado_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_id.getText().toString();
                String nombre = txt_nombre.getText().toString();
                String cargo = txt_cargo.getText().toString();
                String correo = txt_correo.getText().toString();

                List<String> data = new ArrayList<String>();
                data.add(id);
                data.add(nombre);
                data.add(cargo);
                data.add(correo);

                if(id.equals("") && nombre.equals("") && cargo.equals("") && correo.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar campo de busqueda.",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    Empleado empleado = db.getEmpleado(data);
                    if(empleado == null){
                        Toast.makeText(getApplicationContext(),"No se ha encontrado empleado.",Toast.LENGTH_LONG).show();
                    }else{
                        if(id.equals("")){
                            txt_id.setText(Integer.toString(empleado.getId()));
                        }
                        if(nombre.equals("")){
                            txt_nombre.setText(empleado.getNombre());
                        }
                        if(correo.equals("")){
                            txt_correo.setText(empleado.getCorreo());
                        }
                        if(cargo.equals("")){
                            txt_cargo.setText(empleado.getCargo());
                        }
                        Toast.makeText(getApplicationContext(),"Se ha encontrado empleado.",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        btn_empleado_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_id.getText().toString();
                String nombre = txt_nombre.getText().toString();
                String cargo = txt_cargo.getText().toString();
                String correo = txt_correo.getText().toString();

                if(id.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar ID de empleado.",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    Empleado empleado = new Empleado();
                    empleado.setNombre(txt_nombre.getText().toString());
                    empleado.setCargo(txt_cargo.getText().toString());
                    empleado.setCorreo(txt_correo.getText().toString());
                    empleado.setId(Integer.parseInt(txt_id.getText().toString()));

                    int empleado_id = db.actualizarEmpleado(empleado);
                    if(Integer.toString(empleado_id).equals(txt_id.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Se ha actualizado el empleado.",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Ha ocurrido un problema.",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btn_empleado_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txt_id.getText().toString();

                if(id.equals("")){
                    Toast.makeText(getApplicationContext(),"Debe ingresar ID de empleado.",Toast.LENGTH_LONG).show();
                }else{
                    DBHelper db = new DBHelper(getBaseContext());
                    db.borrarEmpleado(Integer.parseInt(txt_id.getText().toString()));
                    Toast.makeText(getApplicationContext(),"Se ha eliminado el empleado.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
