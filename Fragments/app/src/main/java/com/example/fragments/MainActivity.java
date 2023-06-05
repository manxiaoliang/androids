package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, FragmentTest.newInstance(FragmentTest.NODIR));
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        FragmentTest f = (FragmentTest)getSupportFragmentManager().findFragmentById(R.id.layout_main);
        if(id == R.id.style_move){
            assert f != null;
            f.setAnimationStyle(FragmentTest.MOVE);
            return true;
        }else if(id == R.id.style_cube){
            assert f != null;
            f.setAnimationStyle(FragmentTest.CUBE);
            return true;
        }else if(id == R.id.style_flip){
            assert f != null;
            f.setAnimationStyle(FragmentTest.FLIP);
            return true;
        }else if(id == R.id.style_pushpull){
            assert f != null;
            f.setAnimationStyle(FragmentTest.PUSHPULL);
            return true;
        }else if(id == R.id.style_sides){
            assert f != null;
            f.setAnimationStyle(FragmentTest.SIDES);
            return true;
        }else if(id == R.id.style_cubemove){
            assert f != null;
            f.setAnimationStyle(FragmentTest.CUBEMOVE);
            return true;
        }else if(id == R.id.style_movecube){
            assert f != null;
            f.setAnimationStyle(FragmentTest.MOVECUBE);
            return true;
        }else if(id == R.id.style_pushmove){
            assert f != null;
            f.setAnimationStyle(FragmentTest.PUSHMOVE);
            return true;
        }else if(id == R.id.style_movepull){
            assert f != null;
            f.setAnimationStyle(FragmentTest.MOVEPULL);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}