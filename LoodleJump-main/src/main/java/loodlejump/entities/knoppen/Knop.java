package loodlejump.entities.knoppen;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;

import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import loodlejump.LoodleJump;

public abstract class Knop extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
	
	protected LoodleJump loodleJump;

	public Knop(Coordinate2D initialLocation, String text, LoodleJump loodleJump) {
		super(initialLocation, text);
		this.loodleJump = loodleJump;
		
	    setAnchorPoint(AnchorPoint.CENTER_CENTER);
	    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
	}

	@Override
	public void onMouseExited() {
	    setFill(Color.BLACK);
	    setCursor(Cursor.DEFAULT);
	}

	@Override
	public void onMouseEntered() {
	    setFill(Color.GOLD);
	    setCursor(Cursor.HAND);
	}

}
