package in.javabrains.springframework.bean;

public class PointBean {
	
	private int coordinateX;
	private int coordinateY;
	
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	
	@Override
	public String toString() {
		return " [coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + "]";
	}
	
}
