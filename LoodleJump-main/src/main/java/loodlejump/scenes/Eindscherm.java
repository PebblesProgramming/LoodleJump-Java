package loodlejump.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import loodlejump.LoodleJump;
import loodlejump.entities.Insect;
import loodlejump.entities.knoppen.NormaleKnop;
import loodlejump.entities.obstakels.Obstakel;
import loodlejump.entities.powerups.Powerups;
import loodlejump.entities.wereld.Platform;

public class Eindscherm extends StaticScene {
	
	private LoodleJump loodleJump;
	
	public Eindscherm(LoodleJump loodleJump) {
		this.loodleJump = loodleJump;
	}

	@Override
	public void setupScene() {
		setBackgroundImage("backgrounds/background.jpg");
		Platform.resetAantal();
		Obstakel.resetAantal();
		Powerups.resetPowerups();
		
	}

	@Override
	public void setupEntities() {
		var gameOverText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/4), "Game Over!");
		gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

		var eindScore = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2.5), "Score: " + Insect.getScore() );
		eindScore.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		eindScore.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
		
		var highscoreText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 40*37), "Highscore: " + Insect.getHighscore());
		highscoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		highscoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
		
		addEntity(gameOverText);
		addEntity(eindScore);
		addEntity(highscoreText);
		addEntity(new NormaleKnop(new Coordinate2D(getWidth()/2, getHeight()/2), "Speel opnieuw", 1, loodleJump));
		addEntity(new NormaleKnop(new Coordinate2D(getWidth()/2, getHeight()/10*6), "Hoofdscherm", 0, loodleJump));
	}

}
