package Model;

public class Currency {
    private final String code;
    private final String name;
    private final String symbol;
    public Currency (String code, String name, String symbol){
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }
    @Override
    public String toString() {
        return this.code + "  -  " + this.name + "  ( " + this.symbol + " )";
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
}