package com.example.orama.fragments;

import androidx.test.rule.ActivityTestRule;

import com.example.orama.R;
import com.example.orama.activities.MainActivityTest;
import com.example.orama.robot.ScreenRobot;
import com.example.orama.ui.activities.MainActivity;
import com.example.orama.ui.fragments.MainFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainFragmentTest extends ScreenRobot<MainActivityTest> {

    private final int TIME_GET_ALL_FUND = 15;

    @Rule
    public ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initFragment() {
        try {
            mActivity.getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commit();
            sleep(TIME_GET_ALL_FUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_if_loading_icon_is_visible() {
        clickOnView(R.id.activity_main_home_image_view);
        checkIsDisplayed(R.id.main_fragment_progress_bar);
    }

    @Test
    public void test_if_loading_icon_is_gone_after_submit_list_to_recycler_view() {
        clickOnView(R.id.activity_main_home_image_view);
        checkIsDisplayed(R.id.main_fragment_progress_bar);
    }

    @Test
    public void test_if_text_toolbar_is_correct() {
        checkViewContainsText(mActivity.getActivity().getApplicationContext().getString(R.string.fund_list));
    }

    @Test
    public void test_if_fragment_contains_recycler_view() {
        checkIsDisplayed(R.id.main_fragment_recycler_view_fund);
    }

    @Test
    public void test_recycler_view_scroll_down() {
        scrollViewDown(R.id.main_fragment_recycler_view_fund);
    }

    @Test
    public void test_recycler_view_scroll_up() {
        scrollViewDown(R.id.main_fragment_recycler_view_fund);
        scrollViewUp(R.id.main_fragment_recycler_view_fund);
    }

}
