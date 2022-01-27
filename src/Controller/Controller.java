package Controller;

import Model.*;
import Persistence.ExchangeRateLoader;
import View.Window;

public class Controller {
    ExchangeRateLoader exchangeRate;
    Window dialog;
    public Controller(ExchangeRateLoader exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    public void updateDialog(Window dialog) {
        this.dialog = dialog;
    }
    public void updateData() {
        Currency from = dialog.getCurrencyFrom();
        Currency to = dialog.getCurrencyTo();
        ExchangeRate rate = exchangeRate.getRate(from, to);
        dialog.updateDisplay(new Money(dialog.getMoney().getAmount()*rate.getRate(), rate.getTo()));
    }
}