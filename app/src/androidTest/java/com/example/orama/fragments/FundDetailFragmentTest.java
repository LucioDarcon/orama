package com.example.orama.fragments;

import androidx.test.rule.ActivityTestRule;

import com.example.orama.R;
import com.example.orama.activities.MainActivityTest;
import com.example.orama.robot.ScreenRobot;
import com.example.orama.ui.activities.MainActivity;
import com.example.orama.ui.fragments.FundDetailFragment;
import com.example.orama.util.FakeFund;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class FundDetailFragmentTest extends ScreenRobot<MainActivityTest> {

    @Rule
    public ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initFragment() {
        mActivity.getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, FundDetailFragment.newInstance(FakeFund.getFund()))
                .commit();
    }

    @Test
    public void test_if_button_fee_expandable_layout_is_clickable() {
        clickOnView(R.id.fund_detail_fragment_fees_expandable_button);
    }

    @Test
    public void test_if_button_specification_expandable_layout_is_clickable() {
        clickOnView(R.id.fund_detail_fragment_specification_expandable_button);
    }

    @Test
    public void test_if_expandable_layout_specification_is_expandable() {
        test_if_button_specification_expandable_layout_is_clickable();
        checkViewContainsText(FakeFund.getSpecification().getFundMainStrategyName());
    }

    @Test
    public void test_if_expandable_layout_fee_is_expandable() {
        test_if_button_fee_expandable_layout_is_clickable();
        checkViewContainsText(FakeFund.getFee().getAdministrationFee());
    }

    @Test
    public void test_if_card_view_is_visible() {
        checkIsDisplayed(R.id.cardView);
    }

    @Test
    public void test_if_fund_manager_full_name_is_visible() {
        checkIsDisplayed(R.id.fund_detail_fragment_fund_manager_name);
    }

    @Test
    public void test_if_fund_manager_name_is_visible() {
        checkIsDisplayed(R.id.fund_detail_fragment_title);
    }

    @Test
    public void test_if_document_label_is_visible() {
        checkIsDisplayed(R.id.fund_detail_Fragment_document_list_label);
    }

}
