package com.example.orama.util;

import androidx.fragment.app.Fragment;

import com.example.orama.R;
import com.example.orama.ui.activities.MainActivity;

public class FakeActivity extends MainActivity {

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

}
