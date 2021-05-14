package com.example.orama.components.fundcomponent;

import android.app.Activity;

import com.example.orama.R;
import com.example.orama.components.ComponentUnitTest;
import com.example.orama.ui.component.FundComponent;
import com.example.orama.util.FakeFund;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

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
        Assert.assertEquals("Oaktree Global Credit FIC FIM IE", fundComponent.getFund().getSimpleName());
    }

    @Test
    public void test_if_tax_classification_is_correct() {
        Assert.assertEquals("Longo prazo", fundComponent.getFund().getTaxClassification());
    }

    @Test
    public void test_if_is_activite_is_correct() {
        Assert.assertEquals(true, fundComponent.getFund().getActive());
    }

    @Test
    public void test_if_is_volatility12m_is_correct() {
        Assert.assertEquals("0.032739", fundComponent.getFund().getVolatility12m());
    }

}

