package com.aigilas.hud;import com.xna.wrapper.*;import java.util.*;import com.aigilas.creatures.*;import com.aigilas.items.*;import com.spx.util.*;import com.spx.core.*;
    public class DeltasHud extends IHud
    {
        private Equipment _equipment;

        public DeltasHud(ICreature owner, Equipment equipment){ super(owner, XnaManager.WindowWidth / 2, XnaManager.WindowHeight / 2);            _equipment = equipment;
        }

        public void Draw()
        {
            if (_isVisible)
            {
                _textHandler.Draw();
            }
        }

        private GenericItem GetEquipmentIn(int slot)
        {
            if (_equipment.GetItems().containsKey(slot))
            {
                return _equipment.GetItems().get(slot);
            }
            return null;
        }

        private static final String delim = "|";
        private static final String positive = "+";
        private static final String title = "Deltas";
        private String display = "EMPTY";

        public void Update(GenericItem item,boolean refresh)
        {
            if (_isVisible)
            {
                _textHandler.Update();
                _textHandler.Clear();
                if (item != null && refresh)
                {
                    if (GetEquipmentIn(Equipment.ClassToSlot(item.GetItemClass())) != null)
                    {
                        StringSquisher.Clear();
                        for (Float stat:GetEquipmentIn(Equipment.ClassToSlot(item.GetItemClass())).Modifers.GetDeltas(item.Modifers))
                        {
                            StringSquisher.Squish(((stat > 0) ? positive : ""),StringStorage.Get(stat),delim);
                        }
                        display = StringSquisher.Flush();
                    }
                }
                _textHandler.WriteDefault(title, 30, 260, GetHudOrigin());
                _textHandler.WriteDefault(display, 30, 290, GetHudOrigin());
            }
        }
    }
