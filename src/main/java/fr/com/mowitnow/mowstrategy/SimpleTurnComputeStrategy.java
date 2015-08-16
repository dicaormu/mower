package fr.com.mowitnow.mowstrategy;

import fr.com.mowitnow.Direction;
import fr.com.mowitnow.Move;
import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;

import static fr.com.mowitnow.domain.Mower.MowerBuilder.withDir;

public class SimpleTurnComputeStrategy implements ComputeMove {

    private String command;

    public SimpleTurnComputeStrategy(String move) {
        this.command = move;
    }

    @Override
    public Mower move(Mower oldMower, Lawn availability) {
        Direction direction = oldMower.getDir();
        return withDir(direction).andPosition(oldMower.getPosition());
    }

}
