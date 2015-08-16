package fr.com.mowitnow.domain;


import fr.com.mowitnow.Direction;
import fr.com.mowitnow.utils.Constants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.function.Function;

import static fr.com.mowitnow.domain.Point.PointBuilder.withX;

public class Mower {
    private Point position;
    private Direction dir;

    private Mower(Point position, Direction dir) {
        this.dir = dir;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public Direction getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static class MowerBuilder {
        private Direction dir;

        private MowerBuilder(Direction dir) {
            this.dir = dir;
        }

        public static MowerBuilder withDir(Direction dir) {
            return new MowerBuilder(dir);
        }

        public Mower andPosition(Point position) {
            return new Mower(position, dir);
        }

        public static Function<String, Mower> fromStringToMower =
                (line) -> {
                    String coords[] = line.split(Constants.SEPARATOR);
                    return withDir(Direction.valueOf(coords[2]))
                            .andPosition(withX(new Integer(coords[0])).
                                    andY(new Integer(coords[1])));
                };
    }


}


