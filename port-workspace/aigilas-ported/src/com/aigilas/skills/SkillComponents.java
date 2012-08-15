package com.aigilas.skills;import com.xna.wrapper.*;import java.util.*;import com.aigilas.creatures.*;import com.aigilas.entities.*;    public class SkillComponents    {        protected List<Integer> _elements;        protected StatBuff _buff;        protected float _effectStrength = 0;        protected boolean _isPersistent = false;        protected List<Integer> _targetTypes = Arrays.asList(com.aigilas.EntityType.WALL);        public SkillComponents(float strength,boolean isPersistent)        {            _effectStrength = strength;            _isPersistent = isPersistent;            _elements = new ArrayList<Integer>();        }        public void AddElements(int... elements)        {        	for(int element:elements){        		_elements.add(element);        	}        }        public void Buff(ICreature target)        {            target.AddBuff(_buff);        }        public void SetBuff(String stat, float amount)        {            _buff = new StatBuff(stat, amount);        }        public float GetStrength()        {            return _effectStrength;        }        public boolean IsPersistent()        {            return _isPersistent;        }        public List<Integer> GetElements()        {            return _elements;        }        public List<Integer> GetTargetTypes()        {            return _targetTypes;        }    }