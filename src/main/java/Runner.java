import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    ArrayList<String> results = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int number;
    double input;
    double value;

    public void runner() throws IOException {

        coinToConvert();

        amountToConvert();

        coinsConversions();

        startOver();
    }

    private int coinToConvert() throws IOException {

        do {
            System.out.println("Please choose an option (1/2/3):");
            System.out.println("1. Dollars to Shekels");
            System.out.println("2. Shekels to Dollars");
            System.out.println("3. Shekels to EURO");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid Choice, please try again");
                scanner.next(); // this is important!
                runner();
            }
            number = scanner.nextInt();
            return number;
        } while (number <= 0);
    } //User interface to choose coin to convert

    private double amountToConvert() throws IOException {

        do {
            System.out.println("Please enter an amount to convert");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid Choice, please try again");
                scanner.next(); // this is important!
                runner();
            }
            input = scanner.nextDouble();
            return input;
        } while (input <= 0);
    }// User interface to insert amount of coin to convert

    private void coinsConversions() throws IOException {
        switch (number) {
            case 1:
                System.out.println("You have chosen to Convert Dollars to Shekels");
//                System.out.println("Please enter an amount to convert");
//                input = scanner.nextDouble();
                Coin usdValue = CoinFactory.getCoinInstance(Coins.USD);
                value = usdValue.calculate(input);
                System.out.println(input + " Dollar/s are " + value + " Shekels");
                results.add(value + ", USD to ILS");
                //values.add(value + ", USD to ILS");
                WriteToLog.getTextAndWriteToLog(value + ", USD to ILS");
                break;
            case 2:
                System.out.println("You have chosen to Convert Shekels to Dollars");
//                System.out.println("Please enter an amount to convert");
//                input = scanner.nextDouble();
                Coin ilsValue = CoinFactory.getCoinInstance(Coins.ILS);
                value = ilsValue.calculate(input);
                System.out.println(input + " Shekels are " + value + " Dollar/s");
                results.add(value + ",ILS to USD");
                WriteToLog.getTextAndWriteToLog(value + ", ILS to USD");
                break;
            case 3:
                System.out.println("You have chosen to Convert Shekels to EURO");
//                System.out.println("Please enter an amount to convert");
//                input = scanner.nextDouble();
                Coin eurValue = CoinFactory.getCoinInstance(Coins.EUR);
                value = eurValue.calculate(input);
                System.out.println(input + " Shekels are " + value + " EURO/S");
                results.add(value + ", ILS to EUR");
                WriteToLog.getTextAndWriteToLog(value + ", ILS to EUR");
                break;
            default:
                System.out.println("Invalid Choice, please start over");
                runner();
        }
    } //Makes the converter calculations with switch case

    private void startOver() throws IOException {
        System.out.println("Do you wish to start over Y/N?");
        String startOver = scanner.next();


        switch (startOver) {
            case "Y", "y":
                runner();
                break;
            case "N", "n":
                endScreen();
                break;
            default:
                System.out.println("Invalid Choice, please start over");
                runner();
        }
    } // start over screen, no will print the list collection and will open the result txt file


    private void endScreen() {  /// Display thanks message and call OpenFile method
        System.out.println("Thanks for using our currency converter.");
        System.out.println(results);
        openFile.openFile();

    }
}
