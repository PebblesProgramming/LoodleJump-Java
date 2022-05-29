package loodlejump.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

public class Score extends Text {

	public Score(Coordinate2D initialLocation) {
		super(initialLocation);
	}
	
	//zet een String score + het meegegevn aantal
	public void setScoreText(int aantal) {
		setText("Score: " + aantal);
	}
	
	//zet een String highscore + het meegegevn aantal
	public void setHighscoreText(int aantal) {
		setText("Highscore: " + aantal);
	}

	

}
