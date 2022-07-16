package chapter9;

/**
 * @author swarfte
 * @title The Stock class
 */
public class Ch9Ex2 {
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL", "OracleCorporation", 34.5, 34.35);
        System.out.println(stock.getChangePercent());
    }
}

/**
 * UML diagram
 * <p>
 * Stock
 * <p>
 * - symbol: String
 * <p>
 * - name: String
 * <p>
 * - previousClosingPrice: double
 * <p>
 * - currentPrice: double
 * <p>
 * + Stock(symbol: String, name: String, previousClosingPrice: double, currentPrice: double)
 * <p>
 * + getChangePercent(): double
 */

class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    public double getChangePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice;
    }
}