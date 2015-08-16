package fr.com.mowitnow.service;

import fr.com.mowitnow.Direction;
import fr.com.mowitnow.Move;
import fr.com.mowitnow.domain.Point;
import fr.com.mowitnow.domain.Tuple;
import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.utils.ParsingUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static fr.com.mowitnow.domain.Mower.MowerBuilder.withDir;
import static fr.com.mowitnow.utils.ParsingUtils.asQueue;

/**
 * Created by Diana on 10/08/2015.
 */
public class MowerServiceTest {


    @Test
    public void should_return_direction() throws Exception {
        Direction dir = Direction.valueOf("N");
        Assert.assertNotNull(dir);
        Assert.assertEquals(dir, Direction.N);
    }

    @Test
    public void should_move_from_direction() throws Exception {
        Direction dir = Direction.valueOf("E");
        Assert.assertNotNull(dir);
        Assert.assertEquals(Move.G.apply(withDir(dir).andPosition(Point.PointBuilder.withX(1).andY(2)),null).getDir(), Direction.N);
    }

    @Test
    public void should_return_a_mower() throws Exception {
        ArrayList<String> instruction = new ArrayList<>();
        instruction.add("5 5");
        instruction.add("1 2 N");
        instruction.add("GAGAGAGAA");
        MowerService service = new MowerService();
        List<Tuple<String, String>> ins = ParsingUtils.loadTuples(instruction);
        Assert.assertTrue(ins.size() == 1);
        Assert.assertEquals(ins.get(0).first, "1 2 N");
        Assert.assertEquals(ins.get(0).second, "GAGAGAGAA");
    }

    @Test
    public void should_return_two_mowers() throws Exception {
        ArrayList<String> instruction = new ArrayList<>();
        instruction.add("5 5");
        instruction.add("1 2 N");
        instruction.add("GAGAGAGAA");
        instruction.add("3 3 E");
        instruction.add("AADAADADDA");
        MowerService service = new MowerService();
        List<Tuple<String, String>> ins = ParsingUtils.loadTuples(instruction);
        Assert.assertTrue(ins.size() == 2);
        Assert.assertEquals(ins.get(1).first, "3 3 E");
        Assert.assertEquals(ins.get(1).second, "AADAADADDA");
    }

    @Test
    public void should_return_mower_from_Scratch() throws Exception {
        MowerService service = new MowerService();
        String ins = "1 2 N";
        Mower mow = Mower.MowerBuilder.fromStringToMower.apply(ins);
        Assert.assertNotNull(mow);
        Assert.assertTrue(mow.getPosition().getx() == 1);
        Assert.assertTrue(mow.getPosition().gety() == 2);
        Assert.assertTrue(mow.getDir().equals(Direction.N));
    }

    @Test
    public void should_return_null_mower_from_Scratch() throws Exception {
       /* MowerService service = new MowerService();
        String ins = "1 1 N";
        Mower mow = Mower.MowerBuilder.fromStringToMower.apply(ins);
        Assert.assertNull(mow);
        ins = "1 N N";
        try {
            mow = Mower.MowerBuilder.fromStringToMower.apply(ins);
        } catch (Exception e) {
            Assert.assertNull(mow);
        }*/
    }

    @Test
    public void should_move_mower() throws Exception {
        MowerService service = new MowerService();
        String ins = "1 2 N";
        Mower mow = Mower.MowerBuilder.fromStringToMower.apply(ins);
        Assert.assertNotNull(mow);//GAGAGAA
        mow = service.executeInstructions(asQueue("GAGAGAGAA".split("")), mow, Lawn.LawnBuilder.from("5 5").build(), System.out::println);
        Assert.assertEquals(mow.getPosition().getx(), 1);
        Assert.assertEquals(mow.getPosition().gety(), 3);
        Assert.assertEquals(mow.getDir(), Direction.N);
    }

    @Test
    public void should_process_instructions() throws Exception {
        Supplier<List<String>> compute = () -> Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        MowerService service = new MowerService();
        service.computeInstructions(compute, System.out::println);
    }


}