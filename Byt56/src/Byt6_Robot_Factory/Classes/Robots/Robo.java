package Byt6_Robot_Factory.Classes.Robots;

import java.util.List;

public class Robo
{
    private String model;
    private int price;
    private int power;
    private List<String> Weapons;

    public Robo(){}

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setPower(int power)
    {
        this.power = power;
    }

    public void setWeapons(List<String> weapons)
    {
        Weapons = weapons;
    }

    @Override
    public String toString()
    {
        return " Model:" + model + " Price:" + price + " Power:" + power + " Weapons:" + Weapons.toString();
    }
}
