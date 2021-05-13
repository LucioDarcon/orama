package com.example.orama.components;

import com.example.infrastructure.response.Description;
import com.example.infrastructure.response.Fund;
import com.example.infrastructure.response.FundManager;
import com.example.infrastructure.response.Operability;
import com.example.infrastructure.response.Profitabilities;
import com.example.infrastructure.response.Specification;

public class FakeFund {

    public static Fund getFund() {
        return new Fund(true, null, "SimpleName",
                null, null, "volatily",
                null, null, "Hard", true);
    }

}
