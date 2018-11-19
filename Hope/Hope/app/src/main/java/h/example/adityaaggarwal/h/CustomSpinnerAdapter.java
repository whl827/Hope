package h.example.adityaaggarwal.h;

/**
 * Created by adityaaggarwal on 11/11/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    String[] objects;
    String firstElement;
    boolean isFirstTime;
    boolean arrowDisappear;

    public CustomSpinnerAdapter(Context context, int textViewResourceId, String[] objects, String defaultText) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
        this.isFirstTime = true;
        arrowDisappear = false;
        setDefaultText(defaultText);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(isFirstTime) {
            objects[0] = firstElement;
            isFirstTime = false;
        }
        arrowDisappear = true;
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        notifyDataSetChanged();
        return getCustomView(position, convertView, parent);
    }

    public void setDefaultText(String defaultText) {
        this.firstElement = objects[0];
        objects[0] = defaultText;
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = null;
        if(position!=0 || arrowDisappear) {
            row = inflater.inflate(R.layout.spinner_row, parent, false);
        } else {
            row = inflater.inflate(R.layout.spinner_row_category, parent, false);
        }
        TextView label = (TextView) row.findViewById(R.id.spinnerLabel);
        label.setText(objects[position]);
        if(arrowDisappear)
            arrowDisappear = false;
        return row;
    }

}
