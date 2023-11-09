package Byt6_Robot_Factory.Classes.Interfaces;

import Byt6_Robot_Factory.Classes.Robots.Robo;

import java.util.List;

public interface IRobotBuilder
{
    void setModel(String model);
    void setPrice(int price);
    void setPower(int power);
    void setWeapons(List<String> weapons);
    Robo build();
}
