package fr.com.mowitnow;

import fr.com.mowitnow.domain.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static fr.com.mowitnow.domain.Point.*;

public class DirectionTest {
    int step;

    @Before
    public final void setUp() {
       step=1;
    }

    @Test
    public void should_return_previous_from_north() {
        Assert.assertEquals(Direction.N.getPrevious(), Direction.W);
    }

    @Test
    public void should_return_next_from_north() {
        Assert.assertEquals(Direction.N.getNext(), Direction.E);
    }

    @Test
    public void should_move_to_north() {
        final Point expected = PointBuilder.withX(2).andY(2);
        final Point actual = Direction.N.estimateNewPoint(2, 1, step);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_move_to_south() {
        final Point expected = PointBuilder.withX(2).andY(2);
        final Point actual = Direction.S.estimateNewPoint(2, 3, step);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_move_to_east() {
        final Point expected = PointBuilder.withX(2).andY(2);
        final Point actual = Direction.E.estimateNewPoint(1, 2, step);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_move_to_west() {
        final Point expected = PointBuilder.withX(2).andY(2);
        final Point actual = Direction.W.estimateNewPoint(3, 2, step);
        Assert.assertEquals(expected, actual);
    }
}