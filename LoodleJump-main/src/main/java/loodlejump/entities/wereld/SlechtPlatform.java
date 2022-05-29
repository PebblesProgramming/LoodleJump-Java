package loodlejump.entities.wereld;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;

import javafx.scene.paint.Color;
import loodlejump.entities.Insect;

public class SlechtPlatform extends Platform implements Collided {

	public SlechtPlatform(Coordinate2D initialLocation) {
		super(initialLocation);
		setFill(Color.BROWN);
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Insect) {
			Platform.verlaagAantal();
			remove();
		}
	}

}
