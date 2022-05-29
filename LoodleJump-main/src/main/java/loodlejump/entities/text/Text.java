package loodlejump.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Text extends TextEntity {

	public Text(Coordinate2D initialLocation) {
		super(initialLocation);
		
		setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));
		setFill(Color.BLACK);
	}

}
