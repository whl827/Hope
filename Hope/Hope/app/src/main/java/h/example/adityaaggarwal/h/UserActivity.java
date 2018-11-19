package h.example.adityaaggarwal.h;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class UserActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();//Ocultar ActivityBar anterior
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        getSupportFragmentManager().beginTransaction().add(R.id.container, new ListingsFragment()).commit();



        //Create the drawer
        new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_listings).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                                getSupportFragmentManager().beginTransaction().replace(R.id.container, ListingsFragment.getInstance()).commit();
                                return false;
                            }
                        }),
                        //here we use a customPrimaryDrawerItem we defined in our sample app
                        //this custom DrawerItem extends the PrimaryDrawerItem so it just overwrites some methods
                        new PrimaryDrawerItem().withName(R.string.drawer_item_history).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).commit();
                                return false;
                            }
                        }),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_request).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, new RequestFragment()).commit();

                                return false;
                            }
                        })


                ) // add the items we want to use with our Drawer
                .withOnDrawerNavigationListener(new Drawer.OnDrawerNavigationListener() {
                    @Override
                    public boolean onNavigationClickListener(View clickedView) {
                        //this method is only called if the Arrow icon is shown. The hamburger is automatically managed by the MaterialDrawer
                        //if the back arrow is shown. close the activity
                        //AdvancedActivity.this.finish();
                        //return true if we have consumed the event
                        return true;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();

    }



   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.menu_2:
                //show the arrow icon
                result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
                if(getSupportActionBar()!=null)
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                return true;
            case R.id.menu_3:
                //show the hamburger icon
                if(getSupportActionBar()!=null)
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }*/


}
