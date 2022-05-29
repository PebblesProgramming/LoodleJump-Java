package loodlejump.entities.obstakels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class ZwartGat extends Obstakel {

	public ZwartGat(Coordinate2D initialLocation) {
		super("entities/zwartgat.png", initialLocation, new Size(100, 100));
	}

}
