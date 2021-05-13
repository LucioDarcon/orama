package com.example.orama.activities;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.orama.R;
import com.example.orama.robot.ScreenRobot;
import com.example.orama.ui.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest extends ScreenRobot<MainActivityTest> {

    @Rule
    public ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_if_container_is_displayed() {
        checkIsDisplayed(R.id.activity_main_toolbar);
    }

    @Test
    public void test_if_toolbar_is_displayed() {
        checkIsDisplayed(R.id.activity_main_toolbar);
    }

    @Test
    public void test_if_image_view_is_displayed() {
        checkIsDisplayed(R.id.activity_main_home_image_view);
    }

    @Test
    public void test_if_image_view_is_clickable() {
        checkIsClickable(R.id.activity_main_home_image_view);
    }

}
