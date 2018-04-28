package client.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Class to draw a face and represent the facial expressions.
 * 
 * @SER516 Project3_Team03
 * @version 1.0
 */
@SuppressWarnings("serial")
public class FacePaint extends JPanel {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	private static final int head_radiusval = 30;
	private static final int eye_radiusval = 5;
	private static final int eye_left_xpos = 40;
	private static final int eye_right_xpos = 60;
	private static final int eye_ypos = 40;
	private static final int pupil_size = 2;
	private static final int eyebrow_left_left_x = 35;
	private static final int eyebrow_left_right_x = 45;
	private static final int eyebrow_right_left_x = 55;
	private static final int eyebrow_right_right_x = 65;
	private static final int eyebrow_y = 30;
	private static final int mouth_ypos = 65;
	private static final int nose_apex_x = 50;
	private static final int nose_apex_y = 45;
	private static final int nose_ypos = 54;
	private static final int nose_width = 8;
	private double x_factor, y_factor;
	private int x_origin, y_origin;
	double[] vectorValues = new double[13];
	
	/**
	 * Used to change the value of the vector
	 * @param vector contains new expression values
	 */
	public void changeVector(double[] vector){
		vectorValues = vector;
	}
	
	/**
	 * Draws the face with the required expressions
	 * @param g Is a Graphics Object
	 * @param v Contains the array of expressions
	 * @param x Specifies the starting point on the x axis
	 * @param y Specifies the starting point on the y axis
	 * @param height Specifies the height of the window
	 * @param width Specifies the width of the window
	 */
	public void drawFace(Graphics graphics, int xCoordinate, int yCoordinate, int height, int width) {
		String direction = "Center";
		boolean blinkl = false;
		boolean blinkr = false;
		if (vectorValues[8] == 1) {
			blinkl = true;
			blinkr = true;
		} else if (vectorValues[9] == 1) {
			blinkl = true;
		} else if (vectorValues[10] == 1) {
			blinkr = true;
		} else if (vectorValues[11] == 1) {
			direction = "Left";
		} else if (vectorValues[12] == 1) {
			direction = "Right";
		}
		calc_scaleFactors(xCoordinate, yCoordinate, height, width);
		make_head(graphics);
		make_eye(graphics, blinkl, blinkr);
		make_pupil(graphics, direction, blinkl, blinkr);
		make_eyebrows(graphics, vectorValues[1], vectorValues[2]);
		make_nose(graphics);
		make_mouth(graphics, vectorValues[3], vectorValues[4], vectorValues[5], vectorValues[6], vectorValues[7]);
	}

	/**
	 * Finds the scaling factors so as to scale the face according to the background.
	 * @param x Specifies the starting point on the x axis
	 * @param y Specifies the starting point on the y axis
	 * @param height Specifies the height of the window
	 * @param width Specifies the width of the window
	 */
	public void calc_scaleFactors(int xCoordinate, int yCoordinate, int height, int width) {
		x_factor = width / 100.0;
		y_factor = height / 100.0;
		x_origin = xCoordinate;
		y_origin = yCoordinate;
	}

	/**
	 * Gets the dimension of the outer panel.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

	/**
	 * Makes outer structure of the face
	 * @param g Is a Graphics Object
	 */
	public void make_head(Graphics graphics) {
		createCircle(graphics, 50, 50, head_radiusval);
	}

	/**
	 * Makes the eyes along with the various expressions needed
	 * @param g Is a Graphics Object
	 * @param bl Contains value for blinking of the left eye
	 * @param br Contains value for blinking of the right eye
	 */
	public void make_eye(Graphics graphics, boolean blinkLeft, boolean blinkRight) {
		if (blinkLeft == true && blinkRight == true) {
			createLine(graphics, eye_left_xpos + eye_radiusval, eye_ypos, eye_left_xpos - eye_radiusval, eye_ypos);
			createLine(graphics, eye_right_xpos - eye_radiusval, eye_ypos, eye_right_xpos + eye_radiusval, eye_ypos);
		} else if (blinkLeft == true) {

			createOval(graphics, eye_left_xpos, eye_ypos, eye_radiusval, eye_radiusval);
			createLine(graphics, eye_right_xpos - eye_radiusval, eye_ypos, eye_right_xpos + eye_radiusval, eye_ypos);
		} else if (blinkRight == true) {
			createLine(graphics, eye_left_xpos + eye_radiusval, eye_ypos, eye_left_xpos - eye_radiusval, eye_ypos);
			createOval(graphics, eye_right_xpos, eye_ypos, eye_radiusval, eye_radiusval);
		} else {
			createOval(graphics, eye_left_xpos, eye_ypos, eye_radiusval, eye_radiusval);
			createOval(graphics, eye_right_xpos, eye_ypos, eye_radiusval, eye_radiusval);
		}
	}

	/**
	 * Makes the pupils along with the various expressions needed.
	 * @param g Is a Graphics Object
	 * @param direction Contains the direction values for looking left or right
	 * @param bl Contains value for blinking of the left eye
	 * @param br Contains value for blinking of the right eye
	 */
	public void make_pupil(Graphics graphics, String direction, boolean blinkLeft, boolean blinkRight) {
		double d = 0.5;
		if (direction.equals("Right")) {
			d = 0.3;
			fillOval(graphics, eye_left_xpos + (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);
			fillOval(graphics, eye_right_xpos + (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);
		} else if (direction.equals("Left")) {
			d = 0.3;
			fillOval(graphics, eye_left_xpos - (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);
			fillOval(graphics, eye_right_xpos - (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);
		} else {
			if (blinkLeft == true && blinkRight == false) {
				fillOval(graphics, eye_left_xpos - (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);
			} else if (blinkRight == true && blinkLeft == false) {
				fillOval(graphics, eye_right_xpos + (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);

			} else if (blinkLeft == false && blinkRight == false) {
				fillOval(graphics, eye_left_xpos - (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);
				fillOval(graphics, eye_right_xpos + (int) ((d - 0.5) * 10), eye_ypos, pupil_size, pupil_size);
			}
		}
	}

	/**
	 * Makes the eyebrows along with the various expressions needed.
	 * @param graphics Is a Graphics Object
	 * @param raiseBrow Raises the brows according to this input
	 * @param furrowBrow Furrows the brows according to this input
	 */
	public void make_eyebrows(Graphics graphics, double raiseBrow, double furrowBrow) {
		int y1, y2;
		if (raiseBrow != 0.0) {
			y1 = eyebrow_y + (int) (raiseBrow * 5);
			y2 = eyebrow_y - (int) (raiseBrow * 5);
		} else if (furrowBrow != 0.0) {
			y1 = eyebrow_y - (int) (furrowBrow * 5);
			y2 = eyebrow_y + (int) (furrowBrow * 5);
		} else {
			y1 = eyebrow_y;
			y2 = eyebrow_y;
		}
		createLine(graphics, eyebrow_left_left_x, y1, eyebrow_left_right_x, y2);
		createLine(graphics, eyebrow_right_left_x, y2, eyebrow_right_right_x, y1);
	}

	/**
	 * Makes the nose.
	 * @param g Is a Graphics Object
	 */
	public void make_nose(Graphics graphics) {
		createLine(graphics, nose_apex_x, nose_apex_y, nose_apex_x - (nose_width / 2), nose_ypos);
		createLine(graphics, nose_apex_x - (nose_width / 2), nose_ypos, nose_apex_x + (nose_width / 2), nose_ypos);
		createLine(graphics, nose_apex_x + (nose_width / 2), nose_ypos, nose_apex_x, nose_apex_y);
	}

	/**
	 * Makes the mouth along with the expressions needed.
	 * @param g Is a Graphics Object
	 * @param p3 Contains input for making the face smile
	 * @param p4 Contains input to make the face clench
	 * @param p5 Contains input for making the face smirk left
	 * @param p6 Contains input for making the face smirk right
	 * @param p7 Contains input for making the face laugh
	 */
	public void make_mouth(Graphics g, double smile, double clench, double leftSmirk, double rightSmirk, double laugh) {
		double x1 = 40;
		double y1 = mouth_ypos;
		double x2 = 60;
		double y2 = mouth_ypos;
		double x3 = ((x2 - x1) / 2) + x1;
		double y3 = mouth_ypos;
		double y3lower = mouth_ypos;
		if (smile > 0.0) {
			x1 = x1 - (smile * 5);
			x2 = x2 + (smile * 5);
			y3 = y3 + ((smile / 2.0) * 10);
			y3lower = y3;
		}
		if (clench > 0.0) {
			x1 = x1 - (clench * 5);
			x2 = x2 + (clench * 5);
			y3 = y3 - ((clench / 2.0) * 10);
			y3lower = y3lower + ((clench / 2.0) * 10);
		}
		if (leftSmirk > 0.0) {
			x1 = x1 + (leftSmirk * 3);
			x2 = x2 + (leftSmirk * 3);
			y2 = y2 - (leftSmirk * 5);
		}
		if (rightSmirk > 0.0) {
			x1 = x1 - (rightSmirk * 3);
			x2 = x2 - (rightSmirk * 3);
			y1 = y1 - (rightSmirk * 5);
		}
		if (laugh > 0.0) {
			x1 = x1 - (laugh * 5);
			x2 = x2 + (laugh * 5);
			y3lower = y3lower + ((laugh / 2.0) * 10);
		}
		make_lips(g, x1, y1, x2, y2, x3, y3);
		make_lips(g, x1, y1, x2, y2, x3, y3lower);
	}

	/**
	 * Used to make the lips
	 * @param g Is a Graphics Object
	 * @param x1 Contains the starting point of the lips on the horizontal plane
	 * @param y1 Contains the starting point of the lips on the vertical plane
	 * @param x2 Contains the ending point of the lips on the horizontal plane
	 * @param y2 Contains the ending point of the lips on the vertical plane
	 * @param x3 Contains the center point of the lips on the horizontal plane
	 * @param y3 Contains the center point of the lips on the vertical plane
	 */
	public void make_lips(Graphics graphics, double lipsHorizonatalStart, double lipsVerticalStart, double lipsHorizontalEnd, double lipsVerticalEnd, double lipsHorizonatlCenter, double lipsVerticalCenter) {
		int i, new_x, new_y, last_x, last_y;
		double denom = (Math.pow(lipsHorizonatalStart, 2) * (lipsHorizontalEnd - lipsHorizonatlCenter)) + (lipsHorizonatalStart * (Math.pow(lipsHorizonatlCenter, 2) - Math.pow(lipsHorizontalEnd, 2)))
				+ (Math.pow(lipsHorizontalEnd, 2) * lipsHorizonatlCenter) + -(Math.pow(lipsHorizonatlCenter, 2) * lipsHorizontalEnd);

		double a = ((lipsVerticalStart * (lipsHorizontalEnd - lipsHorizonatlCenter)) + (lipsHorizonatalStart * (lipsVerticalCenter - lipsVerticalEnd)) + (lipsVerticalEnd * lipsHorizonatlCenter) + -(lipsVerticalCenter * lipsHorizontalEnd)) / denom;

		double bb = ((Math.pow(lipsHorizonatalStart, 2) * (lipsVerticalEnd - lipsVerticalCenter)) + (lipsVerticalStart * (Math.pow(lipsHorizonatlCenter, 2) - Math.pow(lipsHorizontalEnd, 2))) + (Math.pow(lipsHorizontalEnd, 2) * lipsVerticalCenter)
				+ -(Math.pow(lipsHorizonatlCenter, 2) * lipsVerticalEnd)) / denom;

		double c = ((Math.pow(lipsHorizonatalStart, 2) * ((lipsHorizontalEnd * lipsVerticalCenter) - (lipsHorizonatlCenter * lipsVerticalEnd)))
				+ (lipsHorizonatalStart * ((Math.pow(lipsHorizonatlCenter, 2) * lipsVerticalEnd) - (Math.pow(lipsHorizontalEnd, 2) * lipsVerticalCenter)))
				+ (lipsVerticalStart * ((Math.pow(lipsHorizontalEnd, 2) * lipsHorizonatlCenter) - (Math.pow(lipsHorizonatlCenter, 2) * lipsHorizontalEnd)))) / denom;

		for (i = (int) lipsHorizonatalStart, last_x = (int) lipsHorizonatalStart, last_y = (int) lipsVerticalStart; i <= lipsHorizontalEnd; i++) {
			new_x = i;
			new_y = (int) ((a * Math.pow(i, 2)) + (bb * i) + c);
			createLine(graphics, last_x, last_y, new_x, new_y);
			last_x = new_x;
			last_y = new_y;
		}
	}

	/**
	 * Creates a hollow Circle
	 * @param g Is a Graphics Object
	 * @param x Contains the x position with respect to the background
	 * @param y Contains the y position with respect to the background
	 * @param radius Contains the radius of the circle to be drawn
	 */
	public void createCircle(Graphics graphics, int xPosition, int yPosition, int circleRadius) {
		graphics.drawOval(scale_x(xPosition - circleRadius) + x_origin, scale_y(yPosition - circleRadius) + y_origin, scale_x(circleRadius * 2),
				scale_y(circleRadius * 2));
	}

	/**
	 * Creates a hollow Oval
	 * @param g Is a Graphics Object
	 * @param x Contains the x position with respect to the background
	 * @param y Contains the y position with respect to the background
	 * @param height Contains the height to the oval to be drawn
	 * @param width Contains the width of the oval to be drawn
	 */
	public void createOval(Graphics graphics, int xPosition, int yPosition, int ovalHeight, int ovalWidth) {
		graphics.drawOval(scale_x(xPosition - ovalWidth) + x_origin, scale_y(yPosition - ovalHeight) + y_origin, scale_x(ovalWidth * 2),
				scale_y(ovalHeight * 2));
	}

	/**
	 * Used to fill the hollow Oval
	 * 
	 * @param g Is a Graphics Object
	 * @param x Contains the x position with respect to the background
	 * @param y Contains the y position with respect to the background
	 * @param height Contains the height till which the oval to be filled
	 * @param width Contains the width till which the oval to be filled
	 */
	public void fillOval(Graphics graphics, int xPosition, int yPosition, int hollowOvalHeight, int hollowOvalWidth) {
		graphics.fillOval(scale_x(xPosition - hollowOvalWidth) + x_origin, scale_y(yPosition - hollowOvalHeight) + y_origin, scale_x(hollowOvalWidth * 2),
				scale_y(hollowOvalHeight * 2));
	}

	/**
	 * Used to create a line
	 * @param g Is a Graphics Object
	 * @param x1 Contains the horizontal starting position of the line
	 * @param y1 Contains the vertical starting position of the line
	 * @param x2 Contains the horizontal ending position of the line
	 * @param y2 Contains the vertical ending position of the line
	 */
	public void createLine(Graphics graphics, int lineHorizontalStart, int lineVerticalStart, int lineHorizontalEnd, int lineVerticalEnd) {
		graphics.drawLine(scale_x(lineHorizontalStart) + x_origin, scale_y(lineVerticalStart) + x_origin, scale_x(lineHorizontalEnd) + x_origin, scale_y(lineVerticalEnd) + x_origin);
	}

	/**
	 * Used to scale the input according to the horizontal factor of the background
	 * @param x Parameter needed to be scaled
	 * @return Scaled parameter
	 */
	public int scale_x(int xScale) {
		return (int) (xScale * x_factor);
	}

	/**
	 * Used to scale the input according to the vertical factor of the background
	 * @param y Parameter needed to be scaled
	 * @return Scaled parameter
	 */
	public int scale_y(int yScale) {
		return (int) (yScale * y_factor);
	}

	/**
	 * Paints the desired face.
	 */
	public void paintComponent(Graphics graphics) {
		drawFace(graphics,0, 0, getHeight(), getWidth());
	}

}
