package loodlejump.entities.wereld;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class Platform extends DynamicRectangleEntity implements SceneBorderCrossingWatcher , Collider {
	
	private static int aantalInWereld;

	public Platform(Coordinate2D initialLocation) {
		super(initialLocation, new Size(80, 15));
		aantalInWereld++;
		setMotion(0.5, 0d);
	}
	
	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		aantalInWereld--;
		remove();
	}
	
	//retourneert het huidige aantal platformen in de wereld
	public static int getAantal() {
		return aantalInWereld;
	}
	
	//reset het aantal platformen naar 0
	public static void verlaagAantal() {
		aantalInWereld--;
	}
	
	//verlaagt de waarde van het aantal platformen met 1
	public static void resetAantal() {
		aantalInWereld = 0;
	}

}
