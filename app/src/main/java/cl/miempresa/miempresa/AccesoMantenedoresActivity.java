package cl.miempresa.miempresa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccesoMantenedoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_mantenedores);

        Button empleados = findViewById(R.id.btn_empleado);
        Button servicios = findViewById(R.id.btn_servicio);

        empleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e_intent = new Intent(AccesoMantenedoresActivity.this,MantenedorEmpleadosActivity.class);
                AccesoMantenedoresActivity.this.startActivity(e_intent);
            }
        });

        servicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s_intent = new Intent(AccesoMantenedoresActivity.this,MantenedorServiciosActivity.class);
                AccesoMantenedoresActivity.this.startActivity(s_intent);
            }
        });
    }
}
