import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    ArrayList<String> results = new ArrayList<>();

    public void runner() throws IOException {

        System.out.println("Please choose an option (1/2/3):");
        System.out.println("1. Dollars to Shekels");
        System.out.println("2. Shekels to Dollars");
        System.out.println("3. Shekels to EURO");

        Scanner scanner = new Scanner(System.in);
        int convChosen = scanner.nextInt();
        double input ;
        double value;


        switch (convChosen) {
            case 1:
                System.out.println("You have chosen to Convert Dollars to Shekels");
                System.out.println("Please enter an amount to convert");
                input = scanner.nextDouble();
                Coin usdValue = CoinFactory.getCoinInstance(Coins.USD);
                value = usdValue.calculate(input);
                System.out.println(input + " Dollar/s are " + value + " Shekels");
                results.add(value + ", USD to ILS");
                //values.add(value + ", USD to ILS");
                WriteToLog.getTextAndWriteToLog(value + ", USD to ILS");
                break;
            case 2:
                System.out.println("You have chosen to Convert Shekels to Dollars");
                System.out.println("Please enter an amount to convert");
                input = scanner.nextDouble();
                Coin ilsValue = CoinFactory.getCoinInstance(Coins.ILS);
                value = ilsValue.calculate(input);
                System.out.println(input + " Shekels are " + value + " Dollar/s");
                results.add(value + ",ILS to USD");
                WriteToLog.getTextAndWriteToLog(value + ", ILS to USD");
                break;
            case 3:
                System.out.println("You have chosen to Convert Shekels to EURO");
                System.out.println("Please enter an amount to convert");
                input = scanner.nextDouble();
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
    }

    private void endScreen(){
        System.out.println("Thanks for using our currency converter.");

            System.out.println(results);
            openFile.openFile();

    }
}
