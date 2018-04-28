package model;

/**
 * Model class containing the face data.
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
public class FaceData {
	FaceExpressionData faceExpressionData;
	FaceAffectiveData faceAffectiveData;
	Double timeElapsed = 0.0;

	/**
	 * Converts the received affective data into string.
	 */
	public String toString() {
		return "FaceData{" + "faceExpressionData=" + faceExpressionData + ", faceAffectiveData=" + faceAffectiveData
				+ '}';
	}

	/**
	 * 
	 * Getters and Setters Begin
	 */

	public FaceExpressionData getFaceExpressionData() {
		return faceExpressionData;
	}

	public void setFaceExpressionData(FaceExpressionData faceExpressionData) {
		this.faceExpressionData = faceExpressionData;
	}

	public FaceAffectiveData getFaceAffectiveData() {
		return faceAffectiveData;
	}

	public void setFaceAffectiveData(FaceAffectiveData faceAffectiveData) {
		this.faceAffectiveData = faceAffectiveData;
	}

	public Double getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(Double timeElapsed) {
		this.timeElapsed = timeElapsed;
	}
	/**
	 * Getters and Setters end
	 */

}
