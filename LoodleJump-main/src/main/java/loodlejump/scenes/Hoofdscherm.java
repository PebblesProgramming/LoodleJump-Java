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
import loodlejump.entities.knoppen.QuitKnop;
import loodlejump.entities.wereld.Platform;

public class Hoofdscherm extends StaticScene {
	
	protected LoodleJump loodleJump;
	
	public Hoofdscherm(LoodleJump loodleJump) {
		this.loodleJump = loodleJump;
	}

	@Override
	public void setupScene() {
		setBackgroundImage("backgrounds/background.jpg");
		Platform.resetAantal();
	}

	@Override
	public void setupEntities() {		
		var loodleJumpText = (new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/4), "LoodleJump"));
		loodleJumpText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		loodleJumpText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
		
		var highscoreText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 40*37), "Highscore: " + Insect.getHighscore());
		highscoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		highscoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
		
		addEntity(highscoreText);
		addEntity(loodleJumpText);
		addEntity(new NormaleKnop(new Coordinate2D(getWidth()/2, getHeight()/2), "Start Spel", 1, loodleJump));
		addEntity(new QuitKnop(new Coordinate2D(getWidth()/2, getHeight()/10 * 6), "Quit", loodleJump));
	}

}
