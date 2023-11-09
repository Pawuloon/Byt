import Byt5_Calculator.Calc.Calculator;
import Byt5_Ripper.Classes.Customer;
import Byt5_Ripper.Classes.Cybernetics;
import Byt5_Ripper.Classes.RipperDoc;
import Byt6_Robot_Factory.Classes.Factories.Militech;
import Byt6_Robot_Factory.Classes.Factories.Arasaka;

import java.util.List;


public class Main
{
    private static void buyProcess(RipperDoc ripperDoc, Customer customer2, Cybernetics cybernetics4, Cybernetics cybernetics5, Cybernetics cybernetics6)
    {
        try
        {
            System.out.println("\n" + customer2.getName() + " buys cybernetics:");
            ripperDoc.buyCybernetics(customer2, cybernetics4);
            ripperDoc.buyCybernetics(customer2, cybernetics5);
            ripperDoc.buyCybernetics(customer2, cybernetics6);
        }
        catch (Exception e)
        {
            System.out.println("Error during purchase due to " + e.getMessage() + "\n");
        }
    }
    public static void main(String[] args)
    {
        // Calculator example with chain of responsibility design pattern
        var calculator = new Calculator();
        System.out.println("\u001B[34m" + "Calculator system:");
        System.out.println("Addition");
        System.out.println(calculator.calculate(1, 2, '+'));
        System.out.println("\nSubtraction");
        System.out.println(calculator.calculate(1, 2, '-'));
        System.out.println("\nMultiplication");
        System.out.println(calculator.calculate(1, 2, '*'));
        System.out.println("\nDivision");
        System.out.println(calculator.calculate(1, 2, '/'));

        // Ripper-doc example with mediator pattern.
        // print with orange color

        var ripperDoc = new RipperDoc();
        var customer1 = new Customer("Johnny", 30000, 100);
        var customer2 = new Customer("V", 1000000, 10000);
        var customer3 = new Customer("Jackie", 500000000, 8888);

        ripperDoc.addCustomer(customer1);
        ripperDoc.addCustomer(customer2);
        ripperDoc.addCustomer(customer3);

        var cybernetics1 = new Cybernetics("Kerenzikov", 10000, 100);
        var cybernetics2 = new Cybernetics("Sandevistan", 20000, 100);
        var cybernetics3 = new Cybernetics("Tyrosine Injector", 30000, 100);
        var cybernetics4 = new Cybernetics("Syn-Lungs", 40000, 100);
        var cybernetics5 = new Cybernetics("Subdermal Armor", 50000, 100);
        var cybernetics6 = new Cybernetics("Gorilla Arms", 60000, 100);

        ripperDoc.addCybernetics(cybernetics1);
        ripperDoc.addCybernetics(cybernetics2);
        ripperDoc.addCybernetics(cybernetics3);
        ripperDoc.addCybernetics(cybernetics4);
        ripperDoc.addCybernetics(cybernetics5);
        ripperDoc.addCybernetics(cybernetics6);

        System.out.println("\u001B[33m" + "\nRipper-doc system:");
        buyProcess(ripperDoc, customer1, cybernetics1, cybernetics2, cybernetics3);
        buyProcess(ripperDoc, customer2, cybernetics4, cybernetics5, cybernetics6);
        buyProcess(ripperDoc, customer3, cybernetics1, cybernetics2, cybernetics3);

        // Robot factory example with builder pattern
        System.out.println("\u001B[32m" + "\nRobot factory system:");
        var militech = new Militech();
        militech.setModel("Light drone");
        militech.setPrice(1000000);
        militech.setPower(100);
        militech.setWeapons(List.of("Machine gun", "Rocket launcher", "Flamethrower"));
        var militechRobo = militech.build();
        System.out.println(militechRobo.toString() + "\n");

        var arasaka = new Arasaka();
        arasaka.setModel("Heavy drone");
        arasaka.setPrice(2000000);
        arasaka.setPower(200);
        arasaka.setWeapons(List.of("Laser gun", "Minigun", "Heavy rocket launcher"));
        var arasakaRobo = arasaka.build();
        System.out.println(arasakaRobo.toString() + "\n");
    }
}