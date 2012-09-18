package aigilas.statuses.impl;

import aigilas.creatures.CreatureAction;
import aigilas.creatures.BaseCreature;
import aigilas.statuses.BaseStatus;

public class BlockHealingStatus extends BaseStatus {
    public BlockHealingStatus(BaseCreature target)

    {
        super(target);

        _prevents.add(CreatureAction.ReceiveHealing);
    }
}
