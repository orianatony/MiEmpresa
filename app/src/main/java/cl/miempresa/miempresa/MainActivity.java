package cl.miempresa.miempresa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import cl.miempresa.miempresa.Adaptadores.GridViewCustomAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = (GridView) findViewById(R.id.gv_main);
        gv.setAdapter(new GridViewCustomAdapter(this));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                switch(position){
                    case 0:
                        Toast.makeText(getApplicationContext(),"Bienvenidos a Kibernum",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Intent e_intent = new Intent(MainActivity.this,ListaEmpleadosActivity.class);
                        MainActivity.this.startActivity(e_intent);
                        break;
                    case 2:
                        Intent s_intent = new Intent(MainActivity.this,ListaServiciosActivity.class);
                        MainActivity.this.startActivity(s_intent);
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Mantenedores",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Galeria : Nuestros Socios Alianzas y certificaciones",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"Contacto : " +
                                "San antonio 580, piso 9, Santiago Llamanos (+56 2) 22 816 35 00\n" +
                                "(+56 2) 22 816 36 00",Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });
    }

}
