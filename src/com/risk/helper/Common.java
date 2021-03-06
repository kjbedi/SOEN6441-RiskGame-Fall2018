package com.risk.helper;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author sadgi
 *
 */
public class Common {

	public static ArrayList<String> PhaseActions = new ArrayList<>();
	
	/**
	 * Method to convert the enum color into color object of swings
	 * 
	 * @param selectedColor,selected
	 *            color from color enum
	 * @return Color based on the objects
	 */
	public static Color getColor(EnumColor selectedColor) {
		if(selectedColor == null)
			 return null;
		
		if (selectedColor.equals(EnumColor.BLACK)) {
			return Color.BLACK;
		}
		if (selectedColor.equals(EnumColor.RED)) {
			return Color.RED;
		}
		if (selectedColor.equals(EnumColor.GREEN)) {
			return Color.GREEN;
		}
		if (selectedColor.equals(EnumColor.BLUE)) {
			return Color.BLUE;
		}
		if (selectedColor.equals(EnumColor.MAGENTA)) {
			return Color.MAGENTA;
		}

		if (selectedColor.equals(EnumColor.YELLOW)) {
			return Color.yellow;
		}
		return null;

	}

	/**
	 * This will generate the random integers between min(inclusive) and
	 * max(inclusive)
	 * 
	 * @param min
	 *            integer
	 * @param max
	 *            integer
	 * @return random integer
	 */
	public static int getRandomNumberInRange(int min, int max) {

		if(min == max)
			return min;
		
		if (min > max) {
			throw new IllegalArgumentException("Max value must be greater than Min value!");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	
	public ArrayList<String> GetActions() {
		return PhaseActions;
	}
}
