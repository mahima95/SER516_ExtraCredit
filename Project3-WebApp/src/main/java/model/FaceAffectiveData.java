package model;

/**
 * Model class containing Affective part of the face data.
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
public class FaceAffectiveData {

	private Double meditation = 0.0;
	private Double engagementBoredom = 0.0;
	private Double excitementShortTerm = 0.0;
	private Double frustation = 0.0;
	private Double excitementLongTerm = 0.0;

	/**
	 * Initializes the face affective data values to default
	 */
	public FaceAffectiveData() {
		this.meditation = new Double(0.0);
		this.engagementBoredom = new Double(0.0);
		this.excitementShortTerm = new Double(0.0);
		this.frustation = new Double(0.0);
		this.excitementLongTerm = new Double(0.0);
	}

	/**
	 * Resets the face affective values to default
	 */
	public void reset() {
		meditation = 0.0;
		engagementBoredom = 0.0;
		excitementShortTerm = 0.0;
		frustation = 0.0;
		excitementLongTerm = 0.0;

	}

	/**
	 * Stores face affective values into an array
	 * 
	 * @return contains the affective data array
	 */
	public double[] fetchVectors() {
		double[] faceAffectiveValues = new double[5];
		faceAffectiveValues[0] = getMeditation();
		faceAffectiveValues[1] = getEngagementBoredom();
		faceAffectiveValues[2] = getExcitementShortTerm();
		faceAffectiveValues[3] = getFrustation();
		faceAffectiveValues[4] = getExcitementLongTerm();
		return faceAffectiveValues;
	}

	/**
	 * Converts the received affective data into string.
	 */
	public String toString() {
		return "FaceAffectiveData{" + "meditation=" + meditation + ", engagementBoredom=" + engagementBoredom
				+ ", excitementShortTerm=" + excitementShortTerm + ", frustation=" + frustation
				+ ", excitementLongTerm=" + excitementLongTerm + '}';
	}

	/**
	 * 
	 * Getters and Setters Begin
	 */
	public Double getMeditation() {
		return meditation;
	}

	public void setMeditation(Double meditation) {
		this.meditation = meditation;
	}

	public Double getEngagementBoredom() {
		return engagementBoredom;
	}

	public void setEngagementBoredom(Double engagementBoredom) {
		this.engagementBoredom = engagementBoredom;
	}

	public Double getExcitementShortTerm() {
		return excitementShortTerm;
	}

	public void setExcitementShortTerm(Double excitementShortTerm) {
		this.excitementShortTerm = excitementShortTerm;
	}

	public Double getFrustation() {
		return frustation;
	}

	public void setFrustation(Double frustation) {
		this.frustation = frustation;
	}

	public Double getExcitementLongTerm() {
		return excitementLongTerm;
	}

	public void setExcitementLongTerm(Double excitementLongTerm) {
		this.excitementLongTerm = excitementLongTerm;
	}

	/**
	 * Getters and Setters end
	 */

}
