package loodlejump.spawners;

import java.util.Random;
import loodlejump.entities.powerups.Jetpack;
import loodlejump.entities.powerups.Powerups;
import loodlejump.entities.powerups.Trampoline;

public class PowerupSpawner extends Spawner {

	public PowerupSpawner(double sceneWidth, double sceneHeight) {
		super(1000, sceneWidth, sceneHeight);

	}

	@Override
	protected void spawnEntities() {
		if (Powerups.getAantalPowerups() < 2) {
			if (new Random().nextInt((int) 20) < 2) {
				Powerups p = new Jetpack(randomLocation());
				spawn(p);
			} else if (new Random().nextInt((int) 20) < 2) {
				Powerups p = new Trampoline(randomLocation());
				spawn(p);
			}
		}

	}

}
