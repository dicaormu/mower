package fr.com.mowitnow;

import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.domain.Mower.MowerBuilder;
import fr.com.mowitnow.domain.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MoveTest {

    @Test
    public void should_move_from_east_to_north() throws Exception {
        Direction dirInitial = Direction.E;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.G.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.N);
    }

    @Test
    public void should_move_from_east_to_south() throws Exception {
        Direction dirInitial = Direction.E;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.D.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.S);
    }

    @Test
    public void should_move_from_west_to_north() throws Exception {
        Direction dirInitial = Direction.W;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.D.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.N);
    }

    @Test
    public void should_move_from_west_to_south() throws Exception {
        Direction dirInitial = Direction.W;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.G.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.S);
    }

    @Test
    public void should_move_from_north_to_east() throws Exception {
        Direction dirInitial = Direction.N;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.D.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.E);
    }

    @Test
    public void should_move_from_north_to_west() throws Exception {
        Direction dirInitial = Direction.N;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.G.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.W);
    }

    @Test
    public void should_move_from_south_to_east() throws Exception {
        Direction dirInitial = Direction.S;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.G.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.E);
    }

    @Test
    public void should_move_from_south_to_west() throws Exception {
        Direction dirInitial = Direction.S;
        final Point positionInitial = Point.PointBuilder.withX(1).andY(2);
        final Mower initialMower = MowerBuilder.withDir(dirInitial).andPosition(positionInitial);
        final Mower mowerAfterMove = Move.D.apply(initialMower, null);
        assertEquals(mowerAfterMove.getDir(), Direction.W);
    }

}