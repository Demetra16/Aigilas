package aigilas.hud;

import spx.bridge.DrawDepth;
import spx.core.Point2;
import spx.core.Settings;
import spx.core.SpxManager;
import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.management.Commands;

import com.badlogic.gdx.graphics.Color;

public class SkillHud extends IHud {
	private static String __separator = "|";

	private Point2 _manaPosition = new Point2();

	public SkillHud(ICreature owner) {
		super(owner, Settings.Get().spriteWidth, SpxManager.WindowHeight / 4);
		_manaPosition = new Point2(GetHudOrigin().X, GetHudOrigin().Y - SpxManager.WindowHeight / 4);
	}

	private int CalculateHeight(StatType statType) {
		return (int) ((_parent.Get(statType) / _parent.GetMax(statType)) * _dimensions.Y);
	}

	private int CostOfCurrentSkill() {
		return (int) (_parent.GetCurrentSkillCost() / _parent.GetMax(StatType.MANA) * _dimensions.Y);
	}

	private String GetSkillStrings() {
		return "A:" + _parent.GetActiveSkillName() + __separator + "X:" + _parent.GetHotSkillName(Commands.HotSkill1) + __separator + "Y:" + _parent.GetHotSkillName(Commands.HotSkill2) + __separator + "B:" + _parent.GetHotSkillName(Commands.HotSkill3) + __separator;
	}

	public void Update() {
		if (_isVisible) {
			_textHandler.Update();
			_textHandler.Clear();
			_textHandler.WriteDefault(GetSkillStrings(), (int) GetHudOrigin().X + Settings.Get().spriteWidth, Settings.Get().spriteHeight, GetHudOrigin());
		}
	}

	public void Draw() {
		if (!_isVisible) {
			return;
		}

		SpxManager.Renderer.Draw(_menuBase, GetHudOrigin(), DrawDepth.HudBG, Color.GREEN, Settings.Get().spriteWidth, CalculateHeight(StatType.HEALTH));
		SpxManager.Renderer.Draw(_menuBase, _manaPosition, DrawDepth.HudBG, Color.BLUE, Settings.Get().spriteWidth, CalculateHeight(StatType.MANA));
		SpxManager.Renderer.Draw(_menuBase, _manaPosition, DrawDepth.HudBG, Color.YELLOW, Settings.Get().spriteWidth / 2, CostOfCurrentSkill());

		_textHandler.Draw();
	}
}
