package fr.com.mowitnow;


import fr.com.mowitnow.mowstrategy.ComputeMove;
import fr.com.mowitnow.mowstrategy.SimpleMoveComputeStrategy;
import fr.com.mowitnow.mowstrategy.SimpleTurnComputeStrategy;

public enum Move {
    D('D', new SimpleTurnComputeStrategy('D')) {
        @Override
        public Direction move(Direction oldDirection) {
            return oldDirection.getNext();
        }
    },
    G('G', new SimpleTurnComputeStrategy('G')) {
        @Override
        public Direction move(Direction oldDirection) {
            return oldDirection.getPrevious();
        }
    },
    A('A', new SimpleMoveComputeStrategy(1)) {
        @Override
        public Direction move(Direction oldDirection) {
            return oldDirection;
        }
    };

    private int numPositions;
    private ComputeMove strategy;

    Move(int numPositions, ComputeMove strategy) {
        this.numPositions = numPositions;
        this.strategy = strategy;
    }

    public static Move getMove(char value) {
        return Move.valueOf(Character.valueOf(value).toString());
    }

    public int getNumPositions() {
        return numPositions;
    }

    public ComputeMove getStrategy() {
        return strategy;
    }

    public abstract Direction move(Direction oldDirection);
}
