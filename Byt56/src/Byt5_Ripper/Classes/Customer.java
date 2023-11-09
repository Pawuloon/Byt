package Byt5_Ripper.Classes;

public class Customer
{
    private String name;
    private int money;
    private int humanity;

    public Customer(String name, int money, int humanity)
    {
        this.name = name;
        this.money = money;
        this.humanity = humanity;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getHumanity() {
        return humanity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setHumanity(int humanity) {
        this.humanity = humanity;
    }
}
