package aigilas.reactions.impl;

import aigilas.creatures.BaseCreature;
import aigilas.reactions.IReaction;
import aigilas.statuses.Status;
import aigilas.statuses.StatusFactory;

public class ScorchReaction implements IReaction {
    @Override
    public void affect(BaseCreature target)

    {
        StatusFactory.apply(target, Status.WeakKnees);
    }
}
