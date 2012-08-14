package com.aigilas.hud;import com.xna.wrapper.*;import java.util.*;import com.aigilas.creatures.*;import com.aigilas.management.*;import com.aigilas.items.*;import com.spx.core.*;
    public class HudManager
    {
        private InventoryHud _inventory;
        private SkillHud _skill;
        private ICreature _parent;
        private HotkeyHud _hotkey;

        private static List<Vector2> playerHudPositions = Arrays.asList(new Vector2(0, 0),
            new Vector2(XnaManager.WindowWidth-200, 0),
            new Vector2(0,XnaManager.WindowHeight-100),
            new Vector2(XnaManager.WindowWidth-200,XnaManager.WindowHeight-100));

        public HudManager(ICreature parent,Inventory inventory,Equipment equipment)
        {
            _parent = parent;
            _inventory = new InventoryHud(parent, inventory, equipment);
            _skill = new SkillHud(parent);
            _skill.Toggle();
            _hotkey = new HotkeyHud(parent);
        }

        public boolean ToggleInventory()
        {
            _inventory.Toggle();
            _skill.Toggle();
            return _inventory.IsVisible();
        }

        public void Update()
        {
            _inventory.Update();
            _skill.Update();
        }

        public void Draw()
        {
            _inventory.Draw();
            _skill.Draw();
        }
    }
