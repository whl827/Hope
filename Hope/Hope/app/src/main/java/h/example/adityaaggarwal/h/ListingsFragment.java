package h.example.adityaaggarwal.h;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by adityaaggarwal on 11/12/16.
 */
public class ListingsFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    private static ListingsFragment listingsFragment;
    public static ListingsFragment getInstance() {
        if(listingsFragment==null) {
            listingsFragment = new ListingsFragment();
        }
        return listingsFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.drawer_item_request);
        View v = inflater.inflate(R.layout.fragment_listings, container, false);





        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);








        tabLayout.setupWithViewPager(viewPager);
        //change the color


        viewPager.setAdapter(new CustomAdapter(getChildFragmentManager()));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    private class CustomAdapter extends FragmentPagerAdapter {

        private String fragments[] = {"Food", "Drink", "Shelter", "Medicine", "Other"};
        private HashMap<Integer, Fragment> fragmentsHashMap = new HashMap<>();
        public CustomAdapter(FragmentManager supportFragmentManger) {
            super(supportFragmentManger);

        }

        @Override
        public Fragment getItem(int position) {

            fragmentsHashMap.put(position, FoodFragment.newInstance(fragments[position]));
            return fragmentsHashMap.get(position);



        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
//        @Override
//        public void setPrimaryItem(ViewGroup container, int position, Object object) {
//            super.setPrimaryItem(container, position, object);
//            if()
//            fragmentsHashMap.get(position).onCreateView(getActivity().getLayoutInflater(), container, fragmentsHashMap.get(position).getArguments());
//        }
    }
}
