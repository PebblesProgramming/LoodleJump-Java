 package loodlejump.spawners;

import java.util.Random;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public abstract class Spawner extends EntitySpawner {

	protected final double sceneWidth;
	protected final double sceneHeight;

	public Spawner(long ms, double sceneWidth, double sceneHeight) {
		super(ms);
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
	}

	@Override
	protected abstract void spawnEntities();
	
	//retourneert een coordinaat met een random x en een y met de waarde 0
	protected Coordinate2D randomLocation() {
		double x = new Random().nextInt((int) sceneWidth - 100);
		return new Coordinate2D(x, 0); //-100
	}

}
