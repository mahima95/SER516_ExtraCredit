package client.controller;

import java.util.ArrayList;
import java.util.Observable;

import client.service.FaceClient;
import utility.FaceData;

/**
 * Observer data pattern 
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
public class FaceDataObservable extends Observable {
	private ArrayList<FaceData> faceDataList;
	private static FaceDataObservable expressiveModelObservableInstance ;
	private FaceDataObservable()
	{
		faceDataList = new ArrayList<FaceData>();
		FaceClient.create(this);
	}
	
	public static FaceDataObservable getFaceDataObservableInstance()
	{
		if(expressiveModelObservableInstance == null)
		{
			expressiveModelObservableInstance = new FaceDataObservable();
		}
		return expressiveModelObservableInstance;
	}
	
	/**
	 * Adding face data to a list
	 * Notifying all observers 
	 * 
	 * @param fed Contains the latest affective values
	 */
	
	public void AddToListFaceData(FaceData faceData)
	{
		this.faceDataList.add(faceData);
		setChanged();
		this.notifyObservers(faceData);
	}
	
}
