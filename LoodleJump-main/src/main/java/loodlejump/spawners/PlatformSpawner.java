package loodlejump.spawners;

import java.util.Random;
import com.github.hanyaeger.api.Coordinate2D;

import loodlejump.entities.wereld.GoedPlatform;
import loodlejump.entities.wereld.Platform;
import loodlejump.entities.wereld.SlechtPlatform;

public class PlatformSpawner extends Spawner {

	public PlatformSpawner(double sceneWidth, double sceneHeight) {
		super(0, sceneWidth, sceneHeight);
	}

	@Override
	protected void spawnEntities() {
		if(Platform.getAantal() < 20) {
			Platform p;
			if (new Random().nextInt((int) 15) > 2) {
				p = new GoedPlatform(new Coordinate2D(randomX(), sceneHeight - Platform.getAantal() *(sceneHeight/20)));
				spawn(p);
			} else {
				p = new SlechtPlatform(new Coordinate2D(randomX(), sceneHeight - Platform.getAantal() *(sceneHeight/20)));
				spawn(p);
			}
		}
		
	}

	//retourneert een random x locatie binnen het scherm
	private double randomX() {
		return new Random().nextInt((int) sceneWidth - 81);
	}

}
