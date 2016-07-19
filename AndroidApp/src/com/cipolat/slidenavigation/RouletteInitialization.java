package com.cipolat.slidenavigation;

import java.util.Random;


import android.content.Context;
import android.database.Cursor;

public class RouletteInitialization {
	private SectorsDbAdapter mDbHelper;
	private Cursor mSectorsCursor;
	private Random mRandomGenerator;
    private final Context mCtx;
	
	public RouletteInitialization(Context ctx) {
        this.mCtx = ctx;
        mRandomGenerator = new Random();
		mDbHelper = new SectorsDbAdapter(mCtx);
		mDbHelper.open();
	}
	
	public void initRoulette(String[] answers){
		mDbHelper.deleteAll();	
		String new_a = answers[mRandomGenerator.nextInt(answers.length)];	    
		mDbHelper.createSector("Ejemplo1");
		mDbHelper.createSector("Ejemplo2");
		mDbHelper.createSector("Ejemplo3");
		mDbHelper.createSector("Ejemplo4");

		/*for (int i = 0; i < 7; i++)                {
			createRandomSector(answers);
        }*/
	}
	
	public void createRandomSector(String[] answers){
	mSectorsCursor = mDbHelper.fetchAllSectors();
	int sectors = mSectorsCursor.getCount();
	String[] used = new String[sectors];
	mSectorsCursor.moveToFirst();
	for (int i = 0; i < sectors ; i++)
	{
		used[i] = mSectorsCursor.getString(1);
		mSectorsCursor.moveToNext();
	}

	String new_a = "text";
	boolean found = false;
	while (found == false)
	{
		found = true;
		new_a = answers[mRandomGenerator.nextInt(answers.length)];
		for (int j = 0; j < used.length; j++)
		{
			if (new_a.equals(used[j]))
			{
				found = false;
			}
		}
	}
	mDbHelper.createSector(new_a);		
}
	

}
