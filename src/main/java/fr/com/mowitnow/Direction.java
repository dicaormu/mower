package fr.com.mowitnow;

import fr.com.mowitnow.domain.Point;

import static fr.com.mowitnow.domain.Point.PointBuilder.withX;

public enum Direction {
    N('W', 'E') {
        @Override
        public Point addInPoint(int x, int y, int val) {
            return withX(x).andY(y + val);
        }
    },
    S('E', 'W') {
        @Override
        public Point addInPoint(int x, int y, int val) {
            return withX(x).andY(y - val);
        }
    },
    E('N', 'S') {
        @Override
        public Point addInPoint(int x, int y, int val) {
            return withX(x + val).andY(y);
        }
    },
    W('S', 'N') {
        @Override
        public Point addInPoint(int x, int y, int val) {
            return withX(x - val).andY(y);
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

    public abstract Point addInPoint(int x, int y, int val);

}