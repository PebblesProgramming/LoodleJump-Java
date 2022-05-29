package loodlejump.entities.knoppen;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.input.MouseButton;
import loodlejump.LoodleJump;

public class QuitKnop extends Knop {

	public QuitKnop(Coordinate2D initialLocation, String text, LoodleJump loodleJump) {
		super(initialLocation, text, loodleJump);
	}
	
	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		loodleJump.quit();
		
	}

}
