package h.example.adityaaggarwal.h;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class FoodFragment extends Fragment {

    private ArrayList<Item> items;
    private ItemAdapter mAdapter;
    private ListView mListView;
    private String categoryName;


    public FoodFragment() {
        // Required empty public constructor

    }

   public static FoodFragment newInstance(String argument) {

        Bundle args = new Bundle();
        args.putCharSequence("Title", argument);
        FoodFragment fragment = new FoodFragment();
        fragment.setArguments(args);

        return fragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState!=null)
            return super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_food, container, false);

        ItemList il = new ItemList();
        items = il.getItems();
        mListView = (ListView)v.findViewById(R.id.listView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AppThemeDialog))
                        .setTitle("Claim Item").setMessage("Are you sure you want to claim this item?")
                        .setPositiveButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        Intent intent = new Intent(getActivity().getApplicationContext(), DetailsActivity.class);
                                        startActivity(intent);
                                        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                    }
                                }
                        )
                        .setNegativeButton(android.R.string.cancel,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                    }
                                }
                        )
                        .create().show();

            }
        });
        mAdapter = new ItemAdapter(items);
        mListView.setAdapter(mAdapter);


        return v;
    }




    public class ItemAdapter extends ArrayAdapter<Item> {
        //array adapters are built on arraylist for data
        private ArrayList<Item> mItems;
        //overloaded constructor (consturctors for custom adpaters are usually similar to this
        public ItemAdapter(ArrayList<Item> items){
            //pass context, row id, data source
            super(getActivity(), 0, items);
            this.mItems = items;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){ // row has never been created
                convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_item, null);
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
