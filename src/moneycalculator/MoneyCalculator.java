package moneycalculator;

import Controller.Controller;
import Model.Currency;
import Persistence.Archive.ArchiveCurrencyLoader;
import Persistence.ExchangeRateLoader;
import Persistence.WebService.ExchangeRateWebService;
import View.Window;
import java.util.List;

public class MoneyCalculator {
    public static void main(String[] args) {
        List<Currency> currencies = new ArchiveCurrencyLoader("currencies.csv").load();
        
        // ExchangeRateLoader exchangeRate = new ArchiveExchangeRate("exchangeRates.csv");
        ExchangeRateLoader exchangeRate = new ExchangeRateWebService(
                "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/");
        
        Controller controller = new Controller(exchangeRate);
        
        Window dialog = new Window(currencies, controller);
        
        controller.updateDialog(dialog); dialog.setVisible(true);
    }
}