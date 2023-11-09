package Byt5_Ripper.Classes.Interfaces;

import Byt5_Ripper.Classes.Customer;
import Byt5_Ripper.Classes.Cybernetics;

public interface IRipperDoc
{
    void buyCybernetics(Customer customer, Cybernetics cybernetics);
    void sellCybernetics(Customer customer, Cybernetics cybernetics);
}
