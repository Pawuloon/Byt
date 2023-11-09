package Byt6_Robot_Factory.Classes.Factories;

import Byt6_Robot_Factory.Classes.Interfaces.IRobotBuilder;
import Byt6_Robot_Factory.Classes.Robots.ArasakaRobo;
import Byt6_Robot_Factory.Classes.Robots.Robo;

import java.util.List;

public class Arasaka implements IRobotBuilder
{
    private final ArasakaRobo robo;

    public Arasaka()
    {
        this.robo = new ArasakaRobo();
    }

    @Override
    public void setModel(String model)
    {
        robo.setModel(model);
    }

    @Override
    public void setPrice(int price)
    {
        robo.setPrice(price);
    }

    @Override
    public void setPower(int power)
    {
        robo.setPower(power);
    }

    @Override
    public void setWeapons(List<String> weapons)
    {
        robo.setWeapons(weapons);
    }

    @Override
    public Robo build()
    {
        return robo;
    }
}
