package fr.com.mowitnow.utils;

import fr.com.mowitnow.domain.Tuple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.collectingAndThen;


public class ParsingUtils {

    static Function<List<String>, Tuple<String, String>> collectLine = line ->
            new Tuple<>(line.get(0), line.get(1));

    public static List<Tuple<String, String>> collectToTuples(List<String> instructions) {
        List<Tuple<String, String>> ins = new ArrayList<>();
        for (int skip = 1; skip < instructions.size(); skip += 2) {
            final Tuple<String, String> tuple = instructions.stream().skip(skip).limit(2).
                    collect(collectingAndThen(Collectors.toList(), collectLine));
            ins.add(tuple);
        }
        return ins;
    }

    public  static Queue<String> asQueue(String[] value) {
        return new LinkedList<>(asList(value));
    }

}
