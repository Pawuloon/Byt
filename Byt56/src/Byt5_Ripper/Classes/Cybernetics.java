package Byt5_Ripper.Classes;

public class Cybernetics
{
    private final String name;
    private final int price;
    private final int humanityLoss;

    public Cybernetics(String name, int price, int humanityLoss)
    {
        this.name = name;
        this.price = price;
        this.humanityLoss = humanityLoss;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getHumanityLoss() {
        return humanityLoss;
    }
}
