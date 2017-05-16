package net.samron.samloginsignupmvp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.samron.samloginsignupmvp.main.MainFragment;

public class MainActivity extends AppCompatActivity {


    private FragmentManager mFragmentManager;
//    private SharedPreferences mSharedPreferences = this.getSharedPreferences("users", Context.MODE_PRIVATE);
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mFragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) mFragmentManager.findFragmentByTag("MainFragment");
        

        if (mainFragment == null) {
            Log.e("MainFragment:", "is null");

            mainFragment = new MainFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt("width", width);
//            bundle.putInt("height", height);
//            bundle.putInt("id", id);
//            baseDetailsFragment.setArguments(bundle);

            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.add(R.id.main_container, mainFragment, "MainFragment").commitAllowingStateLoss();

        }
        
        
    }



    @Override
    protected void onResume() {
        super.onResume();
    }





}
