package aigilas.statuses.impl;

import aigilas.creatures.BaseCreature;
import aigilas.creatures.StatBuff;
import aigilas.creatures.StatType;
import aigilas.statuses.BaseStatus;
import spx.core.RNG;

public class RandomBuffStatus extends BaseStatus {
    public RandomBuffStatus(BaseCreature target)

    {
        super(target);
        _buff = new StatBuff(StatType.values()[RNG.next(0, 3)], 10);
        setup();
    }
}
