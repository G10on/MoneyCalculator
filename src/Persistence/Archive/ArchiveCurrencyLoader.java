package Persistence.Archive;

import Model.Currency;
import Persistence.CurrencyLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchiveCurrencyLoader implements CurrencyLoader{
    private final String FilePathname;
    public ArchiveCurrencyLoader(String FilePathname) {
        this.FilePathname = FilePathname;
    }
    @Override
    public List<Currency> load() {
        List<Currency> currencies = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.FilePathname)));
            String line = reader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                currencies.add(new Currency(splitLine[0], splitLine[1], splitLine[2]));
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return currencies;
    }
}
