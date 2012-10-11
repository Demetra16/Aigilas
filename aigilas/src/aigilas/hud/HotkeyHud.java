package aigilas.hud;

import aigilas.creatures.BaseCreature;
import aigilas.items.GenericItem;
import aigilas.management.Commands;
import sps.core.SpxManager;
import sps.io.Input;

import java.util.Arrays;
import java.util.List;

public class HotkeyHud extends BaseHud {
    public HotkeyHud(BaseCreature owner) {
        super(owner, SpxManager.VirtualWidth / 2, SpxManager.VirtualHeight / 2);
        _isVisible = true;
    }

    public void draw() {
    }

    private static final List<Commands> _hotSkills = Arrays.asList(Commands.HotSkill1, Commands.HotSkill2, Commands.HotSkill3);

    public void update(GenericItem item, boolean refresh) {
        if (Input.isActive(Commands.LockSkill, _parent.getPlayerIndex(), false)) {
            for (Commands hotSkill : _hotSkills) {
                if (Input.isActive(hotSkill, _parent.getPlayerIndex(), false)) {
                    _parent.markHotSkill(hotSkill);
                }
            }
        }
    }
}