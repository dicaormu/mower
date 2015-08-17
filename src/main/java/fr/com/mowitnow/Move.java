package fr.com.mowitnow;


import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.domain.Mower.MowerBuilder;
import fr.com.mowitnow.domain.Point;

import java.util.function.BiFunction;

public enum Move implements BiFunction<Mower, Lawn, Mower> {
    D {
        @Override
        public Mower apply(Mower oldMower, Lawn lawn) {
            Direction direction = oldMower.getDir();
            return MowerBuilder.withDir(direction.getNext()).andPosition(oldMower.getPosition());
        }

    },
    G {
        @Override
        public Mower apply(Mower oldMower, Lawn lawn) {
            Direction direction = oldMower.getDir();
            return MowerBuilder.withDir(direction.getPrevious()).andPosition(oldMower.getPosition());
        }

    },
    A {
        @Override
        public Mower apply(Mower oldMower, Lawn lawn) {
            final int step = 1;
            final Point newPoint = oldMower.getDir().
                    estimateNewPoint(oldMower.getPosition().getx(), oldMower.getPosition().gety(), step);
            return lawn.isInside(newPoint) ?
                    MowerBuilder.withDir(oldMower.getDir()).andPosition(newPoint) :
                    MowerBuilder.withDir(oldMower.getDir()).andPosition(oldMower.getPosition());

        }
    };

}
