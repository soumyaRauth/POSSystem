package com.soumya.possystem;

import android.app.Notification;
import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;


public class SalesActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private NavigationView navigationView;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        //Setting the toolbar

        mToolbar=(Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);


        //Navigation Drawer Code

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Fragment Transaction
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new SalesFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("");
        navigationView=(NavigationView)findViewById(R.id.navigation_view);     //Setting the navigation view
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.sales_id:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new SalesFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;

                    //REMAINING CODE FOR FRAGMENT to be implemented
                    case R.id.receipts_id:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new ReceiptFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Receipts");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.items_id:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new ItemsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Items");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;

                }

                return true;
            }
        });

        //TOOLBAR MENU OPTION CODE




        //TOOLBAR CODE ENDS


    }
    //TOOLBAR RIGHT SIDE
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
//
//        return true;
//    }






    //ENDS


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//
//        if (id == R.id.add_user) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
}
