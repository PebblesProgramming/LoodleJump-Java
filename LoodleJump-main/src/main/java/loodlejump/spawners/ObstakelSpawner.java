package loodlejump.spawners;

import java.util.Random;
import loodlejump.entities.obstakels.Monster;
import loodlejump.entities.obstakels.Obstakel;
import loodlejump.entities.obstakels.ZwartGat;

public class ObstakelSpawner extends Spawner {

	public ObstakelSpawner(double sceneWidth, double sceneHeight) {
		super(1000, sceneWidth, sceneHeight);
	}

	@Override
	protected void spawnEntities() {
		if (Obstakel.getAantalObstakels() < 1) {
			if (new Random().nextInt((int) 20) < 2) {
				Obstakel o = new Monster(randomLocation());
				spawn(o);
			} else if (new Random().nextInt((int) 20) < 2) {
				Obstakel o = new ZwartGat(randomLocation());
				spawn(o);
			}
		}

	}

}
