package com.maxdexter.mvpmoxy.moxy.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface ContractView extends MvpView {
    @StateStrategyType(value = AddToEndStrategy.class)
    void setText(String text);

}
