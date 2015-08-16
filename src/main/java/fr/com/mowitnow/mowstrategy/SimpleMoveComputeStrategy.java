package fr.com.mowitnow.mowstrategy;

import fr.com.mowitnow.domain.Lawn;
import fr.com.mowitnow.domain.Mower;
import fr.com.mowitnow.domain.Point;

import static fr.com.mowitnow.domain.Mower.MowerBuilder.withDir;


public class SimpleMoveComputeStrategy implements ComputeMove {
    private int stepSize;

    public SimpleMoveComputeStrategy(int stepSize) {
        this.stepSize = stepSize;
    }

    @Override
    public Mower move(Mower pos, Lawn available) {
        final Point newPoint = pos.getDir().
                addInPoint(pos.getPosition().getx(), pos.getPosition().gety(), stepSize);

        //return withDir(pos.getDir()).andPosition(newPoint);
        return available.isInside(newPoint) ? withDir(pos.getDir()).andPosition(newPoint) : withDir(pos.getDir()).andPosition(pos.getPosition());
    }
}
