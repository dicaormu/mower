package fr.com.mowitnow.domain;

import fr.com.mowitnow.utils.Constants;

import java.util.*;

import static fr.com.mowitnow.domain.Point.PointBuilder.withX;


public class Lawn {
    private List<Mower> mowers;

    private Point maxCoordinate;

    private Lawn() {
        mowers = new ArrayList();
    }

    private Lawn(Point maxCoordinate) {
        this();
        this.maxCoordinate = maxCoordinate;
    }

    public List<Mower> getMowers() {
        return new ArrayList<>(mowers);
    }

    public void addMower(Mower mower){
        mowers.add(mower);
    }

    public boolean isInside(Point point) {
        return point.getx() <= this.maxCoordinate.getx() &&
                point.gety() <= this.maxCoordinate.gety() &&
                point.getx() >= 0 &&
                point.gety() >= 0;
    }

    public static class LawnBuilder {
        private Point maxCoordinate;

        private LawnBuilder(Point maxCoordinate) {
            this.maxCoordinate = maxCoordinate;
        }

        public static LawnBuilder from(String line) {
            Objects.nonNull(line);
            String[] pocs = line.split(Constants.SEPARATOR);
            Point max = withX(new Integer(pocs[0])).andY(new Integer(pocs[1]));
            return from(max);
        }

        public static LawnBuilder from(Point maxCoordinate) {
            return new LawnBuilder(maxCoordinate);
        }


        public Lawn build() {
            return new Lawn(maxCoordinate);
        }
    }

}
