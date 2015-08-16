package fr.com.mowitnow.mowstrategy;

import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;


public interface ComputeMove {

    public Mower move(Mower pos, Lawn available);
}
