package com.example.orama.components.newtest;

import android.app.Activity;

import androidx.databinding.DataBindingUtil;

import com.example.orama.R;
import com.example.orama.components.ComponentUnitTest;
import com.example.orama.components.FakeFund;
import com.example.orama.databinding.FundItemComponentBinding;
import com.example.orama.ui.component.FundComponent;

import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.res.android.Asset;
import org.robolectric.shadows.ShadowToast;

@RunWith(RobolectricTestRunner.class)
public class FundComponentTest extends ComponentUnitTest {

    FundComponent fundComponent;

    @Override
    public void setupComponent(@NotNull Activity activity) {
        activity.setContentView(R.layout.fund_item_component);
        fundComponent = new FundComponent(activity);
        fundComponent.setFund(FakeFund.getFund());
    }

    @Test
    public void test_if_simple_name_is_correct() {
        Assert.assertEquals("SimpleName", fundComponent.getFund().getSimpleName());
    }

}

