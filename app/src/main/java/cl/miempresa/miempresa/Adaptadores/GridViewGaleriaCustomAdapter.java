package cl.miempresa.miempresa.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import cl.miempresa.miempresa.R;

public class GridViewGaleriaCustomAdapter extends BaseAdapter {

    private Context _context;

    private Integer[] gv_pictures = {
            R.drawable.g1,
            R.drawable.g2,
            R.drawable.g3,
            R.drawable.g4,
            R.drawable.g5,
            R.drawable.g6,
            R.drawable.g7,
            R.drawable.g8,
            R.drawable.g9,
            R.drawable.g10,
            R.drawable.g11,
            R.drawable.g12,
            R.drawable.g13,
            R.drawable.g14,
            R.drawable.g15,
            R.drawable.g16,
            R.drawable.g17,
            R.drawable.g18
    };

    /**
     * Metodo constructor.
     * @param context
     */
    public GridViewGaleriaCustomAdapter(Context context){
        _context = context;
    }

    @Override
    public int getCount() {
        return gv_pictures.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(_context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(gv_pictures[position]);
        return imageView;
    }
}
