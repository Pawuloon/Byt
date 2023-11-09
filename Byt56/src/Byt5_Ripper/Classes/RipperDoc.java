package Byt5_Ripper.Classes;

import Byt5_Ripper.Classes.Customer;
import Byt5_Ripper.Classes.Cybernetics;
import Byt5_Ripper.Classes.Interfaces.IRipperDoc;

import java.util.ArrayList;
import java.util.List;

public class RipperDoc implements IRipperDoc
{
    private final List<Cybernetics> cybernetics = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();

    public void addCybernetics(Cybernetics cybernetic)
    {
        cybernetics.add(cybernetic);
    }
    public void removeCybernetics(Cybernetics cybernetic)
    {
        cybernetics.remove(cybernetic);
    }
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public void removeCustomer(Customer customer)
    {
        customers.remove(customer);
    }
    @Override
    public void buyCybernetics(Customer customer, Cybernetics cybernetics)
    {
        if(!customers.contains(customer))
        {
            throw new IllegalArgumentException("Customer not found");
        }
        if(!this.cybernetics.contains(cybernetics))
        {
            throw new IllegalArgumentException("Cybernetics not found");
        }
        if(customer.getMoney() < cybernetics.getPrice())
        {
            throw new IllegalArgumentException("Customer does not have enough money");
        }
        if(customer.getHumanity() < cybernetics.getHumanityLoss())
        {
            throw new IllegalArgumentException("Customer does not have enough humanity");
        }
        customer.setMoney(customer.getMoney() - cybernetics.getPrice());
        customer.setHumanity(customer.getHumanity() - cybernetics.getHumanityLoss());
        this.cybernetics.remove(cybernetics);
        System.out.println("Customer " + customer.getName() + " bought " + cybernetics.getName());
    }

    @Override
    public void sellCybernetics(Customer customer, Cybernetics cybernetics)
    {
        if(!customers.contains(customer))
        {
            throw new IllegalArgumentException("Customer not found");
        }
        if(!this.cybernetics.contains(cybernetics))
        {
            throw new IllegalArgumentException("Cybernetics not found");
        }
        customer.setMoney(customer.getMoney() + cybernetics.getPrice());
        customer.setHumanity(customer.getHumanity() + cybernetics.getHumanityLoss());
        this.cybernetics.add(cybernetics);
        System.out.println("Customer " + customer.getName() + " sold " + cybernetics.getName());
    }
}
