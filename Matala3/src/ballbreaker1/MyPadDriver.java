package ballbreaker1;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.IGazeListener;
import com.theeyetribe.client.GazeManager.ApiVersion;
import com.theeyetribe.client.GazeManager.ClientMode;
import com.theeyetribe.client.data.GazeData;

public class MyPadDriver extends PadDriver {
	public  int leftEyeX = 0;
	public  int  rightEyeX = 0;
	public  int leftEyeY = 0;
	public  int  rightEyeY = 0;

	
	@Override
	public int GetXLeftEye() {
		// TODO Auto-generated method stub
		System.out.println(leftEyeX);
		return leftEyeX;
	}

	@Override
	public int GetYLeftEye() {
		// TODO Auto-generated method stub
		return leftEyeY;
	}

	@Override
	public int GetXRightEye() {
		// TODO Auto-generated method stub
		System.out.println(rightEyeX);
		return rightEyeX;
	}

	@Override
	public int GetYRightEye() {
		// TODO Auto-generated method stub
		return rightEyeY;
	}
}
