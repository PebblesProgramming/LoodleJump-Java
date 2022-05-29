package loodlejump;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

import loodlejump.scenes.Eindscherm;
import loodlejump.scenes.GameLevel;
import loodlejump.scenes.Hoofdscherm;

public class LoodleJump extends YaegerGame {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void setupGame() {
		setGameTitle("LoodleJump");
	    setSize(new Size(700, 800));
	}

	@Override
	public void setupScenes() {
		addScene(0, new Hoofdscherm(this));
		addScene(1, new GameLevel(this));
		addScene(2, new Eindscherm(this));
		
	}

}
