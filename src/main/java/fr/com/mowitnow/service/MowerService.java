package fr.com.mowitnow.service;

import fr.com.mowitnow.Move;
import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.domain.Tuple;

import java.util.List;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static fr.com.mowitnow.domain.Lawn.LawnBuilder.from;
import static fr.com.mowitnow.domain.Mower.MowerBuilder.fromStringToMower;
import static fr.com.mowitnow.utils.Constants.EMPTY_STRING;
import static fr.com.mowitnow.utils.ParsingUtils.asQueue;
import static fr.com.mowitnow.utils.ParsingUtils.loadTuples;


public class MowerService {

    public Lawn computeInstructions(Supplier<List<String>> compute, Consumer<Mower> printer) {
        final List<String> instructions = compute.get();
        final Lawn lawn = from(instructions.get(0)).build();
        final List<Tuple<String, String>> tuples = loadTuples(instructions);
        tuples.stream().forEach(tuple -> {
            final Mower initialMower = fromStringToMower.apply(tuple.first);//TODO mejorar lawn.getMowers
            Mower newState = executeInstructions(asQueue(tuple.second.split(EMPTY_STRING)), initialMower, lawn,printer);
            lawn.getMowers().add(newState);
        });
        return lawn;
    }

    public Mower executeInstructions(Queue<String> instructions, Mower mower, final Lawn lawn, Consumer<Mower> printer) {
        BiFunction<Mower, Move, Mower> move =
                (oldMower, newMove) -> newMove.apply(oldMower, lawn);
        final Mower mow = move.apply(mower, Move.valueOf(instructions.poll()));
        if (instructions.size() > 0)
            return executeInstructions(instructions, mow, lawn, printer);
        printer.accept(mow);
        return mow;
    }


}
