package aigilas.hud;

import aigilas.creatures.BaseCreature;
import com.badlogic.gdx.graphics.g2d.Sprite;
import sps.core.Point2;
import sps.core.SpxManager;
import sps.text.TextHandler;

import java.util.ArrayList;
import java.util.List;

public class BaseHud {
    protected boolean _isVisible = false;
    protected final BaseCreature _parent;
    protected static Sprite _menuBase;
    protected final TextHandler _textHandler = new TextHandler();
    protected final List<Point2> playerHudPositions = new ArrayList<Point2>();
    protected final Point2 _dimensions;

    protected BaseHud(BaseCreature owner, int width, int height) {
        _parent = owner;
        if (_menuBase == null) {
            _menuBase = SpxManager.getMenuBaseAsset();
        }
        _dimensions = new Point2(width, height);
        playerHudPositions.add(new Point2(0, SpxManager.WindowHeight - _dimensions.Y));
        playerHudPositions.add(new Point2(SpxManager.WindowWidth - _dimensions.X, SpxManager.WindowHeight + _dimensions.Y));
        playerHudPositions.add(new Point2(0, 0));
        playerHudPositions.add(new Point2(SpxManager.WindowWidth - _dimensions.X, 0));
    }

    public void toggle() {
        _isVisible = !_isVisible;
    }

    public boolean isVisible() {
        return _isVisible;
    }

    public void loadContent() {
        _menuBase = SpxManager.getMenuBaseAsset();
    }

    protected Point2 getHudOrigin() {
        return playerHudPositions.get(_parent.getPlayerIndex());
    }
}
