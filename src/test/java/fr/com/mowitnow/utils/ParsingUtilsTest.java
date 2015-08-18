package fr.com.mowitnow.utils;

import fr.com.mowitnow.domain.Tuple;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Diana on 18/08/2015.
 */
public class ParsingUtilsTest {

    @Test
    public void should_return_a_tuple() throws Exception {
        List<String> instruction= Arrays.asList("5 5", "1 2 N", "GAGAGAGAA");
        List<Tuple<String, String>> ins = ParsingUtils.collectToTuples(instruction);
        Assert.assertTrue(ins.size() == 1);
        Assert.assertEquals(ins.get(0).first, "1 2 N");
        Assert.assertEquals(ins.get(0).second, "GAGAGAGAA");
    }

    @Test
    public void should_return_two_tuples() throws Exception {
        List<String> instruction=Arrays.asList("5 5","1 2 N","GAGAGAGAA","3 3 E","AADAADADDA");
        List<Tuple<String, String>> ins = ParsingUtils.collectToTuples(instruction);
        Assert.assertTrue(ins.size() == 2);
        Assert.assertEquals(ins.get(1).first, "3 3 E");
        Assert.assertEquals(ins.get(1).second, "AADAADADDA");
    }
}