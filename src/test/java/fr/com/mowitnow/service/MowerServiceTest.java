package fr.com.mowitnow.service;

import fr.com.mowitnow.Direction;
import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.domain.Point;
import fr.com.mowitnow.suppliers.FileComputeSupplier;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static fr.com.mowitnow.utils.ParsingUtils.asQueue;
import static org.junit.Assert.*;


public class MowerServiceTest {

    @Test
    public void should_compute_instructions_from_list() {
        Supplier<List<String>> compute = () -> Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        MowerService service = new MowerService();
        Lawn lawn = service.computeInstructions(compute, System.out::println);
        assertTrue(lawn.isInside(Point.PointBuilder.withX(5).andY(5)));
        assertFalse(lawn.isInside(Point.PointBuilder.withX(6).andY(5)));

        List<Mower> mowers = lawn.getMowers();
        assertEquals(mowers.size(), 2);

        Mower firstMower = mowers.get(0);
        assertEquals(firstMower.getPosition(), Point.PointBuilder.withX(1).andY(3));
        assertEquals(firstMower.getDir(), Direction.N);

        Mower secondMower = mowers.get(1);
        assertEquals(secondMower.getPosition(), Point.PointBuilder.withX(5).andY(1));
        assertEquals(secondMower.getDir(), Direction.E);
    }

    @Test
    public void should_compute_instructions_from_file() {
        Supplier<List<String>> supplier = new FileComputeSupplier(MowerService.class
                .getClassLoader().getResource("file.txt").getPath());
        MowerService service = new MowerService();
        Lawn lawn=service.computeInstructions(supplier, System.out::println);
        assertTrue(lawn.isInside(Point.PointBuilder.withX(5).andY(5)));
        assertFalse(lawn.isInside(Point.PointBuilder.withX(6).andY(5)));

        List<Mower> mowers = lawn.getMowers();
        assertEquals(mowers.size(), 2);

        Mower firstMower = mowers.get(0);
        assertEquals(firstMower.getPosition(), Point.PointBuilder.withX(1).andY(3));
        assertEquals(firstMower.getDir(), Direction.N);

        Mower secondMower = mowers.get(1);
        assertEquals(secondMower.getPosition(), Point.PointBuilder.withX(5).andY(1));
        assertEquals(secondMower.getDir(), Direction.E);
    }




}