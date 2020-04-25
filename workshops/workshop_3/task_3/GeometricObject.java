package week4;

import java.awt.Color;

public abstract class GeometricObject {

	private boolean filled = false;
	private Color colour = Color.BLACK;

	public abstract double getArea();
	public abstract double getPerimiter();
	public abstract boolean isEmpty();

	@Override
	public abstract String toString();

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean f) {
		if(!isEmpty())
			filled = f;
		else
			filled = false;
	}

	public String getColor() {
		return "R: " + colour.getRed() + " G: " + colour.getGreen() + " B: " + colour.getBlue();
	}

	public void setColor(int r, int g, int b) {
		if(!isEmpty()) {
			if(r < 0 || r > 255)
				r = 0;

			if(g < 0 || r > 255)
				g = 0;

			if(b < 0 || r > 255)
				b = 0;

			colour = new Color(r, g, b);
		}
	}

}
