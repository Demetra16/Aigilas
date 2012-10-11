package aigilas.skills.impl;

import aigilas.creatures.BaseCreature;
import aigilas.skills.AnimationType;
import aigilas.skills.BaseSkill;
import aigilas.skills.SkillId;
import aigilas.statuses.Status;

public class SpeedUpSkill extends BaseSkill {
    public SpeedUpSkill()

    {
        super(SkillId.SPEED_UP, AnimationType.SELF);


    }

    @Override
    public void activate(BaseCreature source) {
        super.activate(source);
        applyToPlayers(Status.SpeedUp);

    }

}