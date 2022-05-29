package loodlejump.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;

import loodlejump.entities.Insect;

public class Trampoline extends Powerups implements Collided {

    public Trampoline( Coordinate2D initialLocation) {
        super("entities/trampoline.jpg", initialLocation, new Size(50,50));
        
    }

    @Override
    public void onCollision(Collider collidingObject) {
     if(collidingObject instanceof Insect){
         remove();
     }
        
    }
    
}
