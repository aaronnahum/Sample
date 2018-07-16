package DSP;

import java.util.ArrayList;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class BorderClass{
    

    public static Line LineBlackNoFill(double x1, int y1, double x2, int y2) {

        Line line = new Line(x1, y1, x2, y2); 
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1.0); 
        line.getStrokeDashArray().addAll(10.0,0.0,10.0,0.0);

        return line;
    }
    
}
