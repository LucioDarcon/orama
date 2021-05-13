package com.example.orama.components;

import android.app.Activity;

import com.example.orama.ui.component.FundComponent;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

public class FundComponentTest extends ComponentUnitTest {

    FundComponent fundComponent;

    @Override
    public void setupComponent(@NotNull Activity activity) {
        fundComponent = new FundComponent(activity);
    }

    @Test
    public void whenFundComponentIsCompleted() {
        fundComponent.setFund(FakeFund.getFund());
    }

    @Test
    public void whenFundSimpleNameIsEquals() {
        Assert.assertEquals("SimpleName", fundComponent.getFund().getSimpleName());
    }

}
