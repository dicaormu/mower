package fr.com.mowitnow.domain;

import fr.com.mowitnow.Direction;
import fr.com.mowitnow.domain.Mower.MowerBuilder;
import fr.com.mowitnow.service.MowerService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class MowerTest {

    @Test
    public void should_return_mower_from_Scratch()  {
        String ins = "1 2 N";
        Mower mow = MowerBuilder.fromStringToMower.apply(ins);
        assertEquals(mow.getPosition().getx(), 1);
        assertEquals(mow.getPosition().gety(), 2);
        assertEquals(mow.getDir(), Direction.N);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void should_return_arrayindexoutofbounds_exception_in_mower_from_Scratch(){
        String ins = "1 N";
        MowerBuilder.fromStringToMower.apply(ins);
    }

    @Test(expected = NumberFormatException.class)
    public void should_return_numberformat_exception_in_mower_from_Scratch()  {
        String ins = "N N N";
        MowerBuilder.fromStringToMower.apply(ins);
    }

    @Test
    public void should_return_mower()  {
        Point point= Point.PointBuilder.withX(1).andY(2);
        Mower mow= MowerBuilder.withDir(Direction.N).andPosition(point);
        assertEquals(mow.getPosition().getx(), 1);
        assertEquals(mow.getPosition().gety(), 2);
        assertEquals(mow.getDir(), Direction.N);
    }
}