package cl.miempresa.miempresa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import cl.miempresa.miempresa.Adaptadores.GridViewCustomAdapter;
import cl.miempresa.miempresa.Adaptadores.GridViewGaleriaCustomAdapter;

public class GaleriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        GridView gv = (GridView) findViewById(R.id.grid_view_galeria);
        gv.setAdapter(new GridViewGaleriaCustomAdapter(this));
    }
}
