package Exercise_20;

import java.util.Scanner;

public class countyTax {
    static Scanner input = new Scanner(System.in);

    public static double WisTax = 0.05;
    public static double EAUcLAIRE = 0.005;
    public static double DUNN = 0.004;
    public static double IllinoisTAX = 0.08;

    public static void main(String[] args) {
        countyTax calcTax = new countyTax();

        double subtotal = Double.parseDouble(calcTax.getSubtotal());
        String state = calcTax.getState();

        String county = null;
        if (state.equals("wisconsin") || state.equals("wi")) {
            county = calcTax.getCounty();
        }

        double tax = calcTax.taxCalculator(county, state, subtotal);

        String outputString = calcTax.printOutput(tax, subtotal, state);
        calcTax.output(outputString);//this is just a funny line
    }
    public String getSubtotal() {
        System.out.print("What is the order amount? ");
        return input.nextLine();
    }

    public String getState() {
        System.out.print("What state do you live in? ");
        return input.nextLine().toLowerCase();
    }


    public String getCounty() {
        System.out.print("What county do you live in? ");
        return input.nextLine().toLowerCase();
    }

    public double taxCalculator(String county, String state, double subtotal) {
        double tax = 0;

        if (state.equals("illinois") || state.equals("il")) {
            tax = IllinoisTAX;
        } else if (state.equals("wisconsin") || state.equals("wi")){
            if (county.equals("eau claire")) {
                tax = WisTax + EAUcLAIRE;
            } else if (county.equals("dunn")) {
                tax = WisTax + DUNN;
            } else {
                tax = WisTax;
            }
        }

        return tax * subtotal;
    }

    public String printOutput(double tax, double subtotal, String state) {
        return (state.equals("wi") || state.equals("il") || state.equals("wisconsin") || state.equals("illinois")) ?
                String.format("The tax is $%.2f.\nThe total is $%.2f.", tax, subtotal + tax) :
                String.format("The total is $%.2f.", subtotal + tax);

    }

    public void output (String output) {
        System.out.print(output);
    }
}
