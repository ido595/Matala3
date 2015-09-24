import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

public class MyPadDriver extends PadDriver
{

	@Override
	public int GetXLeftEye() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		return (int) b.getX();
	}

	@Override
	public int GetYLeftEye() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		return (int) b.getY();
	}

	@Override
	public int GetXRightEye() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		return (int) b.getX();
	}

	@Override
	public int GetYRightEye() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		return (int) b.getY();
	}
	
}
