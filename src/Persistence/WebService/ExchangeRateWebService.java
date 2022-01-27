package Persistence.WebService;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeRateWebService implements ExchangeRateLoader {

    private final String baseURL;

    public ExchangeRateWebService(String baseURL) {
        this.baseURL = baseURL;
    }
    
    @Override
    public ExchangeRate getRate(Currency from, Currency to) {
        URL link = null;
        try {
            link = new URL(this.baseURL + from.getCode().toLowerCase() + "/" + to.getCode().toLowerCase() + ".json");
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            line = reader.readLine();
            while (line != null && !line.contains(to.getCode().toLowerCase())) {
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Double rate = Double.parseDouble(line.split(":")[1]);;
        return new ExchangeRate(rate, from, to);
    }
    
}
