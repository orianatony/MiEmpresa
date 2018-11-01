package cl.miempresa.miempresa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridViewCustomAdapter extends BaseAdapter {

    private Context _context;

    private Integer[] gv_pictures = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6
    };

    /**
     * Metodo constructor.
     * @param context
     */
    public GridViewCustomAdapter(Context context){
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
            imageView.setLayoutParams(new ViewGroup.LayoutParams(550, 550));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(3, 3, 3, 3);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(gv_pictures[position]);
        return imageView;
    }
}
