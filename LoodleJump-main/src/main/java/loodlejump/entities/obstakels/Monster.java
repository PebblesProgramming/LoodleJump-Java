package loodlejump.entities.obstakels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;

import loodlejump.entities.Insect;

public class Monster extends Obstakel implements Collided {

	public Monster(Coordinate2D initialLocation) {
		super("entities/monster.png", initialLocation, new Size(100, 100));
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if(collidingObject instanceof Insect) {
			remove();
		}
		
	}

}
