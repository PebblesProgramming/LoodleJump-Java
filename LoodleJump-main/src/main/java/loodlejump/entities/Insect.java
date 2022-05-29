package loodlejump.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import loodlejump.LoodleJump;
import loodlejump.entities.obstakels.Monster;
import loodlejump.entities.obstakels.Obstakel;
import loodlejump.entities.obstakels.ZwartGat;
import loodlejump.entities.powerups.Jetpack;
import loodlejump.entities.powerups.Powerups;
import loodlejump.entities.powerups.Trampoline;
import loodlejump.entities.text.Levens;
import loodlejump.entities.text.Score;
import loodlejump.entities.wereld.GoedPlatform;

import java.util.Set;


public class Insect extends DynamicSpriteEntity
		implements KeyListener, Newtonian, Collider, Collided, SceneBorderCrossingWatcher {
	
	private LoodleJump loodleJump;

	private Levens levensText;
	private Score scoreText;
	private Score highscoreText;
	
	private int levens;
	private static int score;
	private static int highscore;
	

	public Insect(Coordinate2D initialLocation, Levens levensText, Score scoreText, Score highscoreText, LoodleJump loodleJump) {
		super("entities/insectgeknipt.png", initialLocation, new Size(90, 90));
		this.loodleJump = loodleJump;

		this.levensText = levensText;
		levens = 3;
		levensText.setLevensText(levens);
		
		this.scoreText = scoreText;
		score = 0;
		scoreText.setScoreText(score);
		
		this.highscoreText = highscoreText;
		highscoreText.setHighscoreText(highscore);

		setGravityConstant(0.2);
		setFrictionConstant(0.04); 
		
		setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
	}

	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.LEFT)) {
			setMotion(6, 250d);
		} else if (pressedKeys.contains(KeyCode.RIGHT)) {
			setMotion(6, 110d);
		}
	}

	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof GoedPlatform 
				&& ((GoedPlatform) collidingObject).getAnchorLocation().getX() < getAnchorLocation().getX() + 30 
				&& ((GoedPlatform) collidingObject).getAnchorLocation().getX() + 80 > getAnchorLocation().getX() - 30
				&& ((GoedPlatform) collidingObject).getAnchorLocation().getY() + 5 > getAnchorLocation().getY()) {
			setMotion(12, 180d);
			scoreText.setScoreText(++score);
		}
		if (collidingObject instanceof Monster) {
			levensText.setLevensText(--levens);
			Obstakel.verlaagAantal();
			if(levens <= 0) {
				loodleJump.setActiveScene(2);
			}
		}
		else if(collidingObject instanceof ZwartGat) {
			loodleJump.setActiveScene(2);
			Obstakel.verlaagAantal();
		} 
		else if(collidingObject instanceof Jetpack){
			setMotion(32,180d);
			Powerups.verlaagAantal();
			score += 20;
			scoreText.setScoreText(score);
		} 
		else if(collidingObject instanceof Trampoline){
			setMotion(23,180d);
			Powerups.verlaagAantal();
			score += 5;
			scoreText.setScoreText(score);
		}
		
		if(score > highscore) {
			highscore = score;
			highscoreText.setHighscoreText(highscore);
		}
	}
	

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		if (border.equals(SceneBorder.RIGHT)) {
			setAnchorLocationX(-45);
		} else if (border.equals(SceneBorder.LEFT)) {
			setAnchorLocationX(getSceneWidth() - 60);
		} 
			else if (border.equals(SceneBorder.TOP)) {
			setAnchorLocationY(getSceneHeight() - 45);
		}
			else if (border.equals(SceneBorder.BOTTOM)) {
			loodleJump.setActiveScene(2);
		}
	}
	
	//retoruneert de huidige score
	public static int getScore(){
		return score;
	}
	
	//retourneert de huidige highscore
	public static int getHighscore() {
		return highscore;
	}

}

