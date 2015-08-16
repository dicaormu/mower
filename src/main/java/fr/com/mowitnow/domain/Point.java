package fr.com.mowitnow.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Point {


    private int x;
    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcBuilder = new HashCodeBuilder();
        return hcBuilder.append(x).append(y).toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static class PointBuilder {
        int x;

        private PointBuilder(int x) {
            this.x = x;
        }

        public static PointBuilder withX(int x) {
            return new PointBuilder(x);
        }

        public Point andY(int y) {
            return new Point(x, y);
        }
    }
}
