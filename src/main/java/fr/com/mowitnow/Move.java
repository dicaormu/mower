package fr.com.mowitnow;


import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.domain.Point;
import fr.com.mowitnow.mowstrategy.ComputeMove;

import java.util.function.BiFunction;

import static fr.com.mowitnow.domain.Mower.MowerBuilder.withDir;

public enum Move implements BiFunction<Mower, Lawn, Mower> {
    D() {
        @Override
        public Mower apply(Mower oldMower, Lawn lawn) {
            Direction direction = oldMower.getDir();
            return withDir(direction.getNext()).andPosition(oldMower.getPosition());
        }

    },
    G() {
        @Override
        public Mower apply(Mower oldMower, Lawn lawn) {
            Direction direction = oldMower.getDir();
            return withDir(direction.getPrevious()).andPosition(oldMower.getPosition());
        }

    },
    A() {
        @Override
        public Mower apply(Mower oldMower, Lawn lawn) {
            final Point newPoint = oldMower.getDir().
                    addInPoint(oldMower.getPosition().getx(), oldMower.getPosition().gety(), 1);
            return lawn.isInside(newPoint) ?
                    withDir(oldMower.getDir()).andPosition(newPoint) :
                    withDir(oldMower.getDir()).andPosition(oldMower.getPosition());

        }
    };

}
