package h.example.adityaaggarwal.h;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adityaaggarwal on 11/12/16.
 */
public class HistoryFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        getActivity().setTitle(R.string.drawer_item_history);
       View v = inflater.inflate(R.layout.fragment_history, container, false);

        ItemList il = new ItemList();
        ArrayList<Item> items = il.getItems();



        ListView list = (ListView) v.findViewById(R.id.list);
       ItemAdapter mAdapter = new ItemAdapter(items);
        list.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return v;
    }

    public class ItemAdapter extends ArrayAdapter<Item> {
        private ArrayList<Item> mItems;
        public ItemAdapter(ArrayList<Item> items) {
            super(getActivity().getApplicationContext(), 0, items);
            this.mItems = items;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_item , null);
            }
            Item item = mItems.get(position);

            TextView itemName = (TextView) convertView.findViewById(R.id.item_name);
            TextView itemDistance = (TextView) convertView.findViewById(R.id.item_distance);
            ImageView image = (ImageView) convertView.findViewById(R.id.item_image);

            itemName.setText(item.getName());
            itemDistance.setText(String.valueOf(item.getDistance())+" mi");
            image.setImageResource(R.drawable.ic_add_photo);

            return convertView;
        }
    }
}
