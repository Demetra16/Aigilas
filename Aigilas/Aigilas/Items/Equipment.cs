﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Aigilas.Creatures;

namespace Aigilas.Items
{
    public class Equipment
    {
        public static int ClassToSlot(int iClass)
        {
            switch(iClass)
            {
                case ItemClass.Melee_Weapon:
                    return ItemSlot.RIGHT_HAND;
                case ItemClass.Ranged_Weapon:
                    return ItemSlot.RIGHT_HAND;
                case ItemClass.Ranged_Ammo:
                    return ItemSlot.LEFT_HAND ;
                case ItemClass.Ring:
                    return ItemSlot.LEFT_FINGER;
                case ItemClass.Leggings: 
                    return ItemSlot.LEGS;
                case ItemClass.Torso_Garb:
                    return ItemSlot.TORSO;
                case ItemClass.Feet:
                    return ItemSlot.FEET;
                case ItemClass.Head_Gear:
                    return ItemSlot.HEAD;
                case ItemClass.Gloves:
                    return ItemSlot.HANDS;
                case ItemClass.Shield:
                    return ItemSlot.LEFT_HAND;
            }
            return ItemSlot.NULL;
        }

        private readonly Dictionary<int, GenericItem> _slots = new Dictionary<int, GenericItem>();
        private readonly ICreature _parent;


        public Equipment(ICreature owner)
        {
            _parent = owner;
        }

        public void Unequip(GenericItem item)
        {
            if (IsRegistered(item))
            {
                Unregister(item);
            }
        }

        public void Register(GenericItem item)
        {
            var itemSlot = ClassToSlot(item.GetItemClass());
            if(_slots.ContainsKey(itemSlot))
            {
                Unequip(_slots[itemSlot]);
                _slots[itemSlot] = item;
            }
            else
            {
                _slots.Add(itemSlot, item);
            }
            
        }

        public void Unregister(GenericItem item)
        {
            var itemSlot = ClassToSlot(item.GetItemClass());
            if (_slots.ContainsKey(itemSlot))
            {
                _parent.PickupItem(_slots[itemSlot]);
                _slots.Remove(itemSlot);
            }
        }

        public bool IsRegistered(GenericItem item)
        {
            var itemClass = ClassToSlot(item.GetItemClass());
            if(_slots.ContainsKey(itemClass))
            {
                return (item == _slots[itemClass]) ;
            }
            return false;
        }

        private float bonusSum;
        public float CalculateBonus(string stat)
        {
            bonusSum = 0;
            foreach (var slot in _slots)
            {
                bonusSum += slot.Value.GetStatBonus(stat);
            }
            return bonusSum;
        }

        public Dictionary<int,GenericItem> GetItems()
        {
            return _slots;
        }
    }
}