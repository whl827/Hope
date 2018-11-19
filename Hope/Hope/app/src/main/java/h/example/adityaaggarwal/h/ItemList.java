package h.example.adityaaggarwal.h;

import java.util.ArrayList;

/**
 * Created by jungholim on 11/11/16.
 */

public class ItemList {

    private ArrayList<Item> items;
    public ItemList() {
        items = new ArrayList<>();
        for(int i =0; i < 10; i++) {
            Item item = new Item(("Item" + (i + 1)), ("Status" + (i + 1)), i);
            items.add(item);
        }
    }

    public ArrayList<Item> getItems() {return items;}
}
