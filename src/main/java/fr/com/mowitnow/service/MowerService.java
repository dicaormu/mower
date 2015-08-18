package fr.com.mowitnow.service;

import fr.com.mowitnow.Move;
import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.domain.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static fr.com.mowitnow.domain.Lawn.LawnBuilder.from;
import static fr.com.mowitnow.domain.Lawn.LawnBuilder.fromStringToLawn;
import static fr.com.mowitnow.domain.Mower.MowerBuilder.fromStringToMower;
import static fr.com.mowitnow.utils.Constants.EMPTY_STRING;
import static fr.com.mowitnow.utils.ParsingUtils.asQueue;
import static fr.com.mowitnow.utils.ParsingUtils.collectToTuples;


public class MowerService {

    private final Logger logger = LoggerFactory.getLogger(MowerService.class);

    public Lawn computeInstructions(Supplier<List<String>> compute, Consumer<Mower> printer) {
        final List<String> allInstructions = compute.get();
        logger.debug("Computing {} instructions ", allInstructions.size());
        final Lawn lawn = fromStringToLawn.apply(allInstructions.get(0));
        final List<Tuple<String, String>> tuples = collectToTuples(allInstructions);
        tuples.stream().forEach(tuple -> {
            logger.debug("Handling mower in position {} with instructions {} ", tuple.first, tuple.second);
            final Mower initialMower = fromStringToMower.apply(tuple.first);
            final String[] movementsLine = tuple.second.split(EMPTY_STRING);
            final Mower newState = executeInstructions(asQueue(movementsLine), initialMower, lawn, printer);
            lawn.addMower(newState);
        });
        logger.debug("Done computing instructions");
        return lawn;
    }

    private Mower executeInstructions(Queue<String> instructions, Mower mower, final Lawn lawn, Consumer<Mower> printer) {
        BiFunction<Mower, Move, Mower> move =
                (oldMower, newMove) -> newMove.apply(oldMower, lawn);
        final Mower mow = move.apply(mower, Move.valueOf(instructions.poll()));
        if (instructions.size() > 0)
            return executeInstructions(instructions, mow, lawn, printer);
        printer.accept(mow);
        return mow;
    }


}
