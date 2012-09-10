package spx.graphics;import spx.bridge.DrawDepth;import spx.core.GameManager;import spx.core.Point2;import spx.core.SpxManager;import aigilas.management.SpriteType;import com.badlogic.gdx.graphics.Color;import com.badlogic.gdx.graphics.g2d.Sprite;public class AnimatedTexture {	private int _currentFrame;	private SpriteInfo _spriteInfo;	private int _animationTimer;	private Color _color = Color.WHITE;	private Sprite _texture;	private DrawDepth _depth = DrawDepth.AnimatedTexture;	protected Point2 _position = Point2.Zero;	public void LoadContent(SpriteType assetName) {		_spriteInfo = SpriteSheetManager.GetSpriteInfo(assetName);		_currentFrame = 0;		_animationTimer = GameManager.AnimationFps;	}	public void Draw() {		if (_texture == null) {			_texture = SpxManager.GetSpriteAsset(_spriteInfo.SpriteIndex);		}		if (_color.a > 0) {			UpdateAnimation();			SpxManager.Renderer.Draw(_texture, _position, _depth, _color);		}	}	private void UpdateAnimation() {		if (_spriteInfo.MaxFrame != 1) {			_animationTimer--;			if (_animationTimer <= 0) {				_currentFrame = (_currentFrame + 1) % _spriteInfo.MaxFrame;				_animationTimer = GameManager.AnimationFps;			}		}	}	public void SetSpriteInfo(SpriteInfo sprite) {		if (_spriteInfo != sprite) {			_spriteInfo = sprite;			_currentFrame = 0;		}	}	public void SetPosition(float x, float y) {		_position.X = (int) x;		_position.Y = (int) y;	}	public void SetPosition(Point2 position) {		_position = new Point2(position.PosX, position.PosY);	}	public void SetColor(Color color) {		_color = color;	}	public Color GetColor() {		return _color;	}	public void SetAlpha(int alpha) {		_color = new Color(_color.r, _color.g, _color.b, alpha);	}	public void SetDrawDepth(DrawDepth depth) {		_depth = depth;	}}