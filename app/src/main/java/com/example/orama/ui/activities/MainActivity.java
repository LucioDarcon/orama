package com.example.orama.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.orama.R;
import com.example.orama.ui.fragments.MainFragment;
import com.example.orama.ui.fragments.PdfFragment;

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
                        MainFragment.newInstance()).commitNow();
    }

}