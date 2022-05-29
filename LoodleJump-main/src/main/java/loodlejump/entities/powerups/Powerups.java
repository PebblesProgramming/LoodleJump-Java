package loodlejump.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class Powerups extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {

    private static int aantalPowerups;

    protected Powerups(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
         aantalPowerups++;
		setMotion(0.5, 0d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        aantalPowerups--;
        remove();
    }
    
	//retourneert het huidige aantal powerups
    public static int getAantalPowerups(){
        return aantalPowerups;

    }
	//reset het aantal powerups naar 0
    public static void resetPowerups(){
        aantalPowerups = 0;
    }
    
	//verlaagt de waarde van het aantal powerups met 1
    public static void verlaagAantal() {
    	aantalPowerups--;
    }

    
}
