package client.controller;

import java.util.ArrayList;
import java.util.Observable;

import client.service.FaceClient;
import model.FaceData;

/**
 * Observable class that notifies the observer when value of FaceData changes
 * Class implements the singleton class pattern and the observer pattern
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
public class FaceDataObservable extends Observable {
	private ArrayList<FaceData> faceDataList;
	private static FaceDataObservable faceDataObservableInstance;

	/**
	 * Private constructor for implementation of singleton pattern Creates the face
	 * client for sending and receiving JSON data
	 * 
	 * 
	 */
	private FaceDataObservable() {
		faceDataList = new ArrayList<FaceData>();
		FaceClient.create(this);
	}

	/**
	 * Method to ensure that only one instance of the class is made Implementation
	 * of singleton pattern
	 * 
	 * 
	 */

	public static FaceDataObservable getFaceDataObservableInstance() {
		if (faceDataObservableInstance == null) {
			faceDataObservableInstance = new FaceDataObservable();
		}
		return faceDataObservableInstance;
	}

	/**
	 * FaceClient sends a new FaceData object with changed values which is added
	 * into the list to signify change occurred Observers of the observable class
	 * are notified when this change occurs
	 * 
	 * @param fed
	 *            Contains the latest affective values
	 */

	public void AddToListFaceData(FaceData faceData) {
		this.faceDataList.add(faceData);
		setChanged();
		this.notifyObservers(faceData);
	}

}
