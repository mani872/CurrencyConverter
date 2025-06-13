import java.util.Scanner;
public class currencyconvert {
    static final double USD_TO_INR = 83.12;
    static final double USD_TO_EUR = 0.93;
    static final double USD_TO_GBP = 0.79;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Currency Converter ===");
        System.out.println("Available currencies: USD, INR, EUR, GBP");

        System.out.print("Enter the source currency (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g., INR): ");
        String toCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        double convertedAmount=convertCurrency(fromCurrency, toCurrency, amount);

        if(convertedAmount!= -1){
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        }
        else {
         System.out.println("Invalid currency input or conversion not supported.");
        }
    scanner.close();
    }

    public static double convertCurrency(String from, String to, double amount) {
    double amountInUSD = switch (from) {
    case "USD" -> amount;
    case "INR" -> amount / USD_TO_INR;
    case "EUR" -> amount / USD_TO_EUR;
    case "GBP" -> amount / USD_TO_GBP;
        default -> -1;
        };

        if(amountInUSD==-1) return -1;

        return switch(to){
        case "USD" -> amountInUSD;
        case "INR" -> amountInUSD * USD_TO_INR;
        case "EUR" -> amountInUSD * USD_TO_EUR;
        case "GBP" -> amountInUSD * USD_TO_GBP;
        default -> -1;
        };
    }
}