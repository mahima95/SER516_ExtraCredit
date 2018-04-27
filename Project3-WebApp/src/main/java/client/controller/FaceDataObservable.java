package client.controller;

import java.util.ArrayList;
import java.util.Observable;

import client.service.FaceClient;
import utility.FaceData;

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
	
	public void AddToListFaceData(FaceData faceData)
	{
		this.faceDataList.add(faceData);
		setChanged();
		this.notifyObservers(faceData);
	}
	
}
