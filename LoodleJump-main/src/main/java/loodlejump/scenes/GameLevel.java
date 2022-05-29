package loodlejump.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;

import loodlejump.spawners.ObstakelSpawner;
import loodlejump.LoodleJump;
import loodlejump.entities.Insect;
import loodlejump.entities.text.Levens;
import loodlejump.entities.text.Score;
import loodlejump.spawners.PlatformSpawner;
import loodlejump.spawners.PowerupSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
	
	private LoodleJump loodleJump;
	
	public GameLevel(LoodleJump loodleJump) {
		this.loodleJump = loodleJump;
	}
	
	@Override
	public void setupScene() {
		setBackgroundImage("backgrounds/background.jpg");
	}

	@Override
	public void setupEntities() {

		var levensText = new Levens(new Coordinate2D(getWidth() / 10 * 8, getHeight() / 40));
		var scoreText = new Score(new Coordinate2D(getWidth() / 30, getHeight() / 40));
		var highscoreText = new Score(new Coordinate2D(0, 0));
		
		var insect = new Insect(new Coordinate2D(getWidth() / 2, getHeight() / 3*2), levensText, scoreText, highscoreText, loodleJump);
		
		addEntity(scoreText);
		addEntity(levensText);
		addEntity(insect);

	}

	@Override
	public void setupEntitySpawners() {
		addEntitySpawner(new PlatformSpawner(getWidth(), getHeight()));
		addEntitySpawner(new ObstakelSpawner(getWidth(), getHeight()));
		addEntitySpawner(new PowerupSpawner(getWidth(), getHeight()));
	}

}
