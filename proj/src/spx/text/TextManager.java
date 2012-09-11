package spx.text;

import java.util.ArrayList;
import java.util.List;

import spx.core.SpxManager;

public class TextManager {
	static private List<Text> _contents = new ArrayList<Text>();

	public static void Add(Text textToAdd) {
		if (!_contents.contains(textToAdd)) {
			_contents.add(textToAdd);
		}
	}

	public static void Clear() {
		_contents.clear();
	}

	public static void Update() {
		for (int ii = 0; ii < _contents.size(); ii++) {
			if (_contents.get(ii).Update() <= 0) {
				_contents.remove(_contents.get(ii));
				ii--;
			}
		}
	}

	public static void Draw() {
		for (Text component : _contents) {
			if (SpxManager.Renderer != null) {
				component.Draw();
			}
		}
	}
}
