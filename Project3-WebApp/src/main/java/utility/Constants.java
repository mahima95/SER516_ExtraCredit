package utility;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

import javax.swing.JLabel;

/**
 * Constants holds system-wide values that are shared by both the server and the
 * client. Most typically these are values for colors, fonts, etc. in order to
 * ensure consistency between the two applications.
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
	public static volatile int CHANNELS = 2;
	public static final int MAX_RETRIES = 10;
	public static volatile int DEFAULT_FREQ = 2;
	public static final String MEDITATION = "Meditation";
	public static final String ENGAGEMENT = "Engagement";
	public static final String FRUSTATION = "Frustation";
	public static final String EXCITEMENTLT = "Excitement Long Term";
	public static final String EXCITEMENTST = "Excitement Short Term";
	public static final String FOCUS = "Focus";
	public final static String DISPLAY_LENGTH = "Length:";
	public final static String SECONDS = "Seconds";
	public final static Color FOCUS_COLOR = Color.BLACK;
	public final static Color GRAPHPANEL = new Color(238, 238, 238);
	public final static Color GRAPHLABEL_BACKGROUND = Color.GRAY;
	public final static Color GRAPHLABEL_FOREGROUND = Color.WHITE;
	public static Color meditationColor = Color.GREEN;
	public static Color engagementColor = Color.RED;
	public static Color frustationColor = Color.MAGENTA;
	public static Color relaxationColor = Color.YELLOW;
	public static Color excitementstColor = Color.BLUE;
	public static Color excitementltColor = Color.BLACK;
	public static final Font BLINKINGTEXTFONT = new Font("Courier New", Font.BOLD, 20);
	public static volatile int DEFAULT_MIN = 0;
	public static volatile int DEFAULT_MAX = 100;
	public static final JLabel faceLabel = new JLabel("    Face Expression");
	public static final JLabel timeLabel = new JLabel("    Time:");
	public static final JLabel graphLabel = new JLabel("    Graph Charts");
	public final static JLabel perfLabel = new JLabel("    Performance Matrix");
	public static final JLabel colLabel = new JLabel("    Colors");

}
