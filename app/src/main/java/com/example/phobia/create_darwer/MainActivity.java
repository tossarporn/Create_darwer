package com.example.phobia.create_darwer;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ActionBarDrawerToggle actionBarDrawerToggle ;
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView navList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navList = (ListView) findViewById(R.id.navlist);
        ArrayList<String> navArray = new ArrayList<String>();
        navArray.add("Home");
        navArray.add("Fragement");
        navArray.add("Fragement2");
        navArray.add("Fragement3");
        navArray.add("Fragement4");
        navArray.add("Fragement5");
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
         fragmentManager = getSupportFragmentManager();

        loadSelection(0);
    }//main method

    private void loadSelection(int i) {
        navList.setItemChecked(i,true);
        switch (i) {
            case 0 : HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, homeFragment);
                fragmentTransaction.commit();
                break;
            case 1 :
                MyFragment myfragment = new MyFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, myfragment);
                fragmentTransaction.commit();
                break;
            case 2 :
                MyFragment1 myFragment1 = new MyFragment1();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, myFragment1);
                fragmentTransaction.commit();
                 break;
            case 3 :
                MyFragment2 myfragment2 = new MyFragment2();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, myfragment2);
                fragmentTransaction.commit();
                 break;
            case 4 : break;
            case 5 : break;
        }

    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
        } else {
            if (id == android.R.id.home) {
                if (drawerLayout.isDrawerOpen(navList)) {
                    drawerLayout.closeDrawer(navList);
                } else {
                    drawerLayout.openDrawer(navList);
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        drawerLayout.closeDrawer(navList);
    }
}//main class
