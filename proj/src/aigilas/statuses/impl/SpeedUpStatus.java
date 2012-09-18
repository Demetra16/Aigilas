package aigilas.statuses.impl;

import aigilas.creatures.BaseCreature;
import aigilas.creatures.StatBuff;
import aigilas.creatures.StatType;
import aigilas.statuses.BaseStatus;

public class SpeedUpStatus extends BaseStatus {
    public SpeedUpStatus(BaseCreature target)

    {
        super(target);
        _buff = new StatBuff(StatType.MOVE_COOL_DOWN, 5f);
        setup();
    }
}
