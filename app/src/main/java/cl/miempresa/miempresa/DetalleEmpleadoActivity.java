package cl.miempresa.miempresa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cl.miempresa.miempresa.Clases.DBHelper;
import cl.miempresa.miempresa.Clases.Empleado;

public class DetalleEmpleadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_empleado);

        Intent intent = getIntent();
        Integer id = intent.getIntExtra("id",-1);

        ImageView avatar = (ImageView)findViewById(R.id.empleado_avatar);
        TextView nombre = findViewById(R.id.empleado_nombre);
        TextView cargo = findViewById(R.id.empleado_cargo);
        TextView correo = findViewById(R.id.empleado_correo);

        DBHelper db = new DBHelper(this);
        Empleado empleado = db.getEmpleado(id);


        //Toast.makeText(getApplicationContext(),Integer.toString(empleado.getAvatar()),Toast.LENGTH_LONG).show();
        avatar.setImageResource(empleado.getAvatar());
        nombre.setText(empleado.getNombre());
        cargo.setText(empleado.getCargo());
        correo.setText(empleado.getCorreo());
    }
}
