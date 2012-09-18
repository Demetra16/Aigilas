package aigilas.hud;

import aigilas.creatures.BaseCreature;
import aigilas.items.Equipment;
import aigilas.items.GenericItem;
import aigilas.items.ItemSlot;
import spx.core.SpxManager;
import spx.util.StringSquisher;

import java.util.HashMap;

public class EquipmentHud extends BaseHud {
    private final Equipment _equipment;

    public EquipmentHud(BaseCreature owner, Equipment equipment) {
        super(owner, SpxManager.WindowWidth / 2, SpxManager.WindowHeight / 2);
        _equipment = equipment;
    }

    public void draw() {
        if (_isVisible) {
            _textHandler.draw();
        }
    }

    private static final String sep = ":";
    private String display = "EMPTY";
    private final String title = "Equipped\n";
    private final String[] list = new String[10];

    public void update(boolean refresh) {
        if (_isVisible) {
            _textHandler.update();
            _textHandler.clear();
            if (refresh) {
                StringSquisher.clear();
                StringSquisher.squish(title);
                display = StringSquisher.flush();
                HashMap<ItemSlot, GenericItem> items = _equipment.getItems();
                int count = 0;
                for (ItemSlot item : items.keySet()) {
                    count++;
                    if (count < 10) {
                        StringSquisher.clear();
                        StringSquisher.squish(item.toString().substring(0, 1), sep, items.get(item).Name);
                        list[count] = StringSquisher.flush();
                    }
                }
            }
            _textHandler.writeDefault(display, 200, 60, getHudOrigin());
            for (int ii = 0; ii < 10; ii++) {
                if (list[ii] != null) {
                    _textHandler.writeDefault(list[ii], 200, 60 + 40 * ii, getHudOrigin());
                }
            }
        }
    }
}
