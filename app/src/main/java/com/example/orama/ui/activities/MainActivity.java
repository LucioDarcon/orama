package com.example.orama.ui.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.orama.R;
import com.example.orama.ui.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            goToMainFragment();
        }

        setListener();
    }

    public void setListener() {
        findViewById(R.id.activity_main_home_image_view).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            finish();
    }

    public void changeTitleActionBar(String newTitle) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        toolbar.setTitle(newTitle);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_home_image_view:
                goToMainFragment();
                break;
            default:
                break;
        }
    }

    private void goToMainFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,
                        MainFragment.newInstance()).addToBackStack("MainFragment").commit();
    }

}