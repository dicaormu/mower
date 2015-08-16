package fr.com.mowitnow.mowstrategy;

import fr.com.mowitnow.Move;
import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;

import static fr.com.mowitnow.domain.Mower.MowerBuilder.withDir;

public class SimpleTurnComputeStrategy implements ComputeMove {

    private char move;

    public SimpleTurnComputeStrategy(char move) {
        this.move = move;
    }

    @Override
    public Mower move(Mower pos, Lawn availability) {
        return withDir(Move.getMove(move).move(pos.getDir())).andPosition(pos.getPosition());
    }

}
