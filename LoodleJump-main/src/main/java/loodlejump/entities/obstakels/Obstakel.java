package loodlejump.entities.obstakels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class Obstakel extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
	
	private static int aantalObstakels;

	protected Obstakel(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		aantalObstakels++;
		setMotion(0.5, 0d);
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		aantalObstakels--;
		remove();
	}
	
	//retourneert het huidige aantal obstakels
	public static int getAantalObstakels() {
		return aantalObstakels;
	}
	
	//reset het aantal obstakels naar 0
	public static void resetAantal(){
		aantalObstakels = 0;
	}
	
	//verlaagt de waarde van het aantal obstakels met 1
	public static void verlaagAantal() {
		aantalObstakels--;
	}

}
