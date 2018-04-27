package utility;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

/**
* Constants holds system-wide values that are shared by both the server
* and the client. Most typically these are values for colors, fonts, etc.
* in order to ensure consistency between the two applications.
*/
public class Constants {

    public static final int PORT_NUMBER = 1519;
    public static final Color LIGHTBLUE = new Color(228, 233, 239);
    public static final Color LIGHTRED = new Color(255, 228, 225);
    public static final Color FRAMECOLOR = new Color(207, 220, 239);
    public static final Color CONSOLECOLOR = new Color(211, 211, 211);
    public static final Color MAINPANELCOLOR = new Color(220, 220, 220);
    public static final Color GRAPHBG = new Color(238, 238, 238);
    public static final Font COURIERFONT = new Font("Courier New", Font.PLAIN, 18);
    public static final String HOSTNAME = "localhost";
    public static final int BORDER_GAP = 0;
    public static final Stroke GRAPH_STROKE = new BasicStroke(1f);
    public static final int GRAPH_POINT_WIDTH = 1;
    public static final int MAX_LIST_SIZE = 30;
    

}
