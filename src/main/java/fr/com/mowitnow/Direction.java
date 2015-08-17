package fr.com.mowitnow;

import fr.com.mowitnow.domain.Point;

import static fr.com.mowitnow.domain.Point.PointBuilder.withX;

public enum Direction {
    N('W', 'E') {
        @Override
        public Point estimateNewPoint(int x, int y, int step) {
            return withX(x).andY(y + step);
        }
    },
    S('E', 'W') {
        @Override
        public Point estimateNewPoint(int x, int y, int step) {
            return withX(x).andY(y - step);
        }
    },
    E('N', 'S') {
        @Override
        public Point estimateNewPoint(int x, int y, int step) {
            return withX(x + step).andY(y);
        }
    },
    W('S', 'N') {
        @Override
        public Point estimateNewPoint(int x, int y, int step) {
            return withX(x - step).andY(y);
        }
    };

    Character previous, next;

    Direction(char prev, char next) {
        this.previous = prev;
        this.next = next;
    }

    public Direction getPrevious() {
        return valueOf(previous.toString());
    }

    public Direction getNext() {
        return valueOf(next.toString());
    }

    public abstract Point estimateNewPoint(int x, int y, int step);

}