package com.example.orama.util;

import com.example.infrastructure.response.Fee;
import com.example.infrastructure.response.Fund;
import com.example.infrastructure.response.FundManager;
import com.example.infrastructure.response.Specification;

public class FakeFund {

    public static Fund getFund() {
        return new Fund(true, null, "Oaktree Global Credit FIC FIM IE",
                getSpecification(), null, "0.032739",
                null, getFundManager(), "Longo prazo", true, getFee());
    }

    public static Specification getSpecification() {
        return new Specification("Renda Fixa Global",
                "Multimercado",
                "Multimercado Investimento no Exterior",
                "Fundos que podem investir mais de 40% do seu patrimônio líquido em ativos financeiros no exterior.");
    }

    public static Fee getFee() {
        return new Fee("1,5%",
                "0.00",
                "1,00%",
                "Não há",
                "20% do que exceder o CDI");
    }

    public static FundManager getFundManager() {
        return new FundManager("A Mongeral Aegon Investimentos (MAI) é uma empresa de Asset Management independente, com mais de R$ 3,5 bilhões de ativos sob gestão, sendo R$ 1,66 bilhão em Multimercados, R$ 1,55 bilhão em Renda Fixa e R$ 274 milhões em outras categorias. A MAI iniciou suas atividades como empresa autorizada pela CVM em Janeiro de 2013 para atuar como gestora de recursos do Grupo Mongeral Aegon. A empresa é 100% controlada pela Mongeral Aegon Holding SA, companhia de controle compartilhado entre os sócios brasileiros (famílias Mota e Molina com 50% e Aegon Investments com 50%). A MAI conta com a estrutura de Pesquisa e Gestão do Grupo Aegon, presente em 24 países, com cerca de US$ 950 bilhões em ativos",
                "Mongeral Aegon Investimentos", "Mongeral Aegon Investimentos LTDA");
    }

}
