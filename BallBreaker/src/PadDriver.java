
public abstract class PadDriver 
{
	/*
	 * implement this methods by creating a new class that implement this interface
	 * 
	 * IF NO DATA have been sent return null
	 */
	
	public static int NO_DATA = -1;
	
	/*
	 * AFTER YOU CREATE THE NEW CLASS PLS CREATE INSTANSE AND SET THIS VALUE TO THE THE INSTANSE
	 */
	
	public static PadDriver PadDriver;
	
	public PadDriver() 
	{
		PadDriver = this;
	}

	/*
	 * 
	 * this methods return information about the left eye and the right eye of the user 
	 * if right eye or left eye is unavaible simple return NO_DATA
	 */
	 public abstract int GetXLeftEye();
	 public abstract int GetYLeftEye();
	
	 public abstract int GetXRightEye();
	 public abstract int GetYRightEye();
}
