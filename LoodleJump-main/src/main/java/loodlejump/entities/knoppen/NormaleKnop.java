package loodlejump.entities.knoppen;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.input.MouseButton;
import loodlejump.LoodleJump;

public class NormaleKnop extends Knop {
	
	private int activeScene;
	
	public NormaleKnop(Coordinate2D initialLocation, String text, int activeScene, LoodleJump loodleJump) {
		super(initialLocation, text, loodleJump);
		this.activeScene = activeScene;
	}
	
	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		loodleJump.setActiveScene(activeScene);
		
	}

}
