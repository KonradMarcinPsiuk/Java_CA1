package com.Helpers;

import java.awt.*;

public class GetContrastColor {
    /**
     * This class return color that is in contrast to the color passed as the parameter
     * @param color
     * @return
     */
    public static Color getContrast(Color color){
        return new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue());
    }
}
