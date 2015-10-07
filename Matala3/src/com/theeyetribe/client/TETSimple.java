package com.theeyetribe.client;

import ballbreaker1.BallBreaker;
import ballbreaker1.MyPadDriver;

import com.theeyetribe.client.GazeManager.ApiVersion;
import com.theeyetribe.client.GazeManager.ClientMode;
import com.theeyetribe.client.data.GazeData;

public class TETSimple
{
	public static MyPadDriver PadDriver;
	
	public void run()
	{

		final GazeManager gm = GazeManager.getInstance();
		boolean success = gm.activate(ApiVersion.VERSION_1_0, ClientMode.PUSH);
		
		final GazeListener gazeListener = new GazeListener();
		
		gm.addGazeListener(gazeListener);
		//TODO: Do awesome gaze control wizardry
		
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{

				gm.removeGazeListener(gazeListener);
				gm.deactivate();
			}
		});
        
	}

	private static class GazeListener implements IGazeListener
	{
		
		public GazeListener()
		{
	    	PadDriver = new MyPadDriver();
	    	new BallBreaker();
		}

		@Override
		public synchronized void onGazeUpdate(GazeData gazeData) {
			// TODO Auto-generated method stub
			
			
			
			PadDriver.leftEyeX=(int) (gazeData.rawCoordinates.x);
        	PadDriver.rightEyeX=(int) (gazeData.rawCoordinates.x);
        	
        	System.out.println(gazeData.leftEye.smoothedCoordinates.x);
        	

		}
	}
}