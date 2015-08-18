package fr.com.mowitnow.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static fr.com.mowitnow.domain.Point.PointBuilder;

public class LawnTest {

    Lawn lawn;

    @Before
    public final void setUp() {
        lawn = Lawn.LawnBuilder.fromStringToLawn.apply("5 5");
    }

    @Test
    public final void should_return_lawn_from_scratch() {
        Lawn newLawn = Lawn.LawnBuilder.fromStringToLawn.apply("7 7");
        Assert.assertNotNull(newLawn);
    }

    @Test(expected = NumberFormatException.class)
    public final void should_return_numberformat_exception_lawn_from_scratch() {
        Lawn.LawnBuilder.fromStringToLawn.apply("");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public final void should_return_arrayoutofbounds_exception_lawn_from_scratch() {
        Lawn.LawnBuilder.fromStringToLawn.apply("1");
    }

    @Test(expected = NumberFormatException.class)
    public final void should_return_runtime_exception_lawn_from_scratch() {
        Lawn.LawnBuilder.fromStringToLawn.apply("a a");
    }

    @Test
    public void should_return_point_is_inside() throws Exception {
        final Point point = PointBuilder.withX(3).andY(2);
        Assert.assertTrue(lawn.isInside(point));
    }

    @Test
    public void should_return_point_is_outside() throws Exception {
        final Point point = PointBuilder.withX(6).andY(7);
        Assert.assertFalse(lawn.isInside(point));
    }

    @Test
    public void should_return_point_is_outside_lower_than_zero() throws Exception {
        final Point point = PointBuilder.withX(-1).andY(7);
        Assert.assertFalse(lawn.isInside(point));
    }

    @Test
    public void should_return_point_is_inside_max_size() throws Exception {
        final Point point = PointBuilder.withX(5).andY(5);
        Assert.assertTrue(lawn.isInside(point));
    }

    @Test
    public void should_return_point_is_inside_min_pos() throws Exception {
        final Point point = PointBuilder.withX(0).andY(0);
        Assert.assertTrue(lawn.isInside(point));
    }

}