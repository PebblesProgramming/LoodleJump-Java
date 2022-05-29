package loodlejump.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

public class Levens extends Text {

	public Levens(Coordinate2D initialLocation) {
		super(initialLocation);
		// TODO Auto-generated constructor stub
	}
	
	//zet een String levens + het meegegevn aantal
	public void setLevensText(int aantal) {
		setText("Levens: " + aantal);
	}

}
