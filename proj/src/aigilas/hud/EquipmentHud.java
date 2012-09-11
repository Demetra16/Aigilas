package aigilas.hud;

import java.util.HashMap;

import spx.core.SpxManager;
import spx.util.StringSquisher;
import aigilas.creatures.ICreature;
import aigilas.items.Equipment;
import aigilas.items.GenericItem;
import aigilas.items.ItemSlot;

public class EquipmentHud extends IHud {
	private Equipment _equipment;

	public EquipmentHud(ICreature owner, Equipment equipment) {
		super(owner, SpxManager.WindowWidth / 2, SpxManager.WindowHeight / 2);
		_equipment = equipment;
	}

	public void Draw() {
		if (_isVisible) {
			_textHandler.Draw();
		}
	}

	private static final String sep = ":";
	private String display = "EMPTY";
	private String title = "Equipped\n";
	private String[] list = new String[10];

	public void Update(boolean refresh) {
		if (_isVisible) {
			_textHandler.Update();
			_textHandler.Clear();
			if (refresh) {
				StringSquisher.Clear();
				StringSquisher.Squish(title);
				display = StringSquisher.Flush();
				HashMap<ItemSlot, GenericItem> items = _equipment.GetItems();
				int count = 0;
				for (ItemSlot item : items.keySet()) {
					count++;
					if (count < 10) {
						StringSquisher.Clear();
						StringSquisher.Squish(item.toString().substring(0, 1), sep, items.get(item).Name);
						list[count] = StringSquisher.Flush();
					}
				}
			}
			_textHandler.WriteDefault(display, 200, 60, GetHudOrigin());
			for (int ii = 0; ii < 10; ii++) {
				if (list[ii] != null) {
					_textHandler.WriteDefault(list[ii], 200, 60 + 40 * ii, GetHudOrigin());
				}
			}
		}
	}
}
