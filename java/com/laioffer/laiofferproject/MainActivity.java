package com.laioffer.laiofferproject;

import android.content.Intent;
import android.content.res.Configuration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements RestaurantListFragment.OnItemSelectListener, RestaurantGridFragment.OnItemSelectListener {
    private RestaurantListFragment mListFragment;
    private RestaurantGridFragment mGridFragment;
    private BackendListFragment mBackendFragment;
    private Button buttonYelp;
    private Button buttonBackend;


    @Override
    public void onListItemSelected(int position) {

        mListFragment.onItemSelected(position);
    }

    @Override
    public void onItemSelected(int position) {
        if (!isTablet()) {
            Intent intent = new Intent(this, RestaurantGridActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        } else {
            mGridFragment.onItemSelected(position);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String service = intent.getStringExtra("Service");

        if (service.equals("Yelp")) {
            mListFragment = new RestaurantListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.restaurant_list_container,
                    mListFragment).commit();
        } else {
            mBackendFragment = new BackendListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.restaurant_list_container,
                    mBackendFragment).commit();
        }
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }

    /**
     * Get resturants names
     */
    private String[] getRestaurantsName() {
        String[] names = {
                "Restaurant1", "Restaurant2", "Restaurant3",
                "Restaurant4", "Restaurant5", "Restaurant6",
                "Restaurant7", "Restaurant8", "Restaurant9",
                "Restaurant10", "Restaurant11", "Restaurant12"};
        return names;
    }


}

