package cl.miempresa.miempresa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import cl.miempresa.miempresa.Clases.DBHelper;
import cl.miempresa.miempresa.Clases.Servicio;

public class DetalleServicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_servicio);

        Intent intent = getIntent();
        Integer id = intent.getIntExtra("id",-1);

        ImageView avatar = (ImageView)findViewById(R.id.servicio_avatar);
        TextView nombre = findViewById(R.id.servicio_nombre);
        TextView descripcion = findViewById(R.id.servicio_descripcion);

        DBHelper db = new DBHelper(this);
        Servicio servicio = db.getServicioById(id);

        avatar.setImageResource(servicio.getAvatar());
        nombre.setText(servicio.getNombre());
        descripcion.setText(servicio.getDescripcion());
    }
}
