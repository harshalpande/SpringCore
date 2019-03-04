package in.javabrains.springframework.bean;

public class TriangleBean {
	
	/*private String type;
	private int height;
	
	public TriangleBean(String type, int height) {
		this.height = height;
		this.type = type;
	}
	
	public TriangleBean(String type) {
		this.type = type;
	}
	
	public TriangleBean(int height) {
		this.height = height;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type, String height) {
		this.type = type;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	*/
	
	private PointBean pointA;
	private PointBean pointB;
	private PointBean pointC;
	
	public PointBean getPointA() {
		return pointA;
	}

	public void setPointA(PointBean pointA) {
		this.pointA = pointA;
	}

	public PointBean getPointB() {
		return pointB;
	}

	public void setPointB(PointBean pointB) {
		this.pointB = pointB;
	}

	public PointBean getPointC() {
		return pointC;
	}

	public void setPointC(PointBean pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("Point A" + getPointA().toString());
		System.out.println("Point B" + getPointB().toString());
		System.out.println("Point C" + getPointC().toString());
	}
}
