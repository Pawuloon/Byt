package Byt6_Robot_Factory.Classes.Factories;

import Byt6_Robot_Factory.Classes.Interfaces.IRobotBuilder;
import Byt6_Robot_Factory.Classes.Robots.MilitechRobo;
import Byt6_Robot_Factory.Classes.Robots.Robo;

import java.util.List;

public class Militech implements IRobotBuilder
{
    private final MilitechRobo robo;

    public Militech()
    {
        this.robo = new MilitechRobo();
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
