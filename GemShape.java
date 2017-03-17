package bounce;

public class GemShape extends Shape {
	public GemShape() {
		super();
	}
	
	public GemShape(int x, int y) {
		super(x,y);
	}
	
	public GemShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		this.text = text;
	}
	
	protected void doPaint(Painter painter) {
		if(_width<40){
			int[] point1={_x+_width/2,_y};   //top point
			int[] point2={_x,_y+_height/2};  //left point
			int[] point3={_x+_width/2,_y+_height};  //bottom point
			int[] point4={_x+_width,_y+_height/2};  //right point
			painter.drawLine(point1[0],point1[1],point2[0],point2[1]);
			painter.drawLine(point2[0],point2[1],point3[0],point3[1]);
			painter.drawLine(point3[0],point3[1],point4[0],point4[1]);
			painter.drawLine(point1[0],point1[1],point4[0],point4[1]);
		} else{
			int[] point1={_x+20,_y};  //top left point
			int[] point2={_x+_width-20,_y};  //top right point 
			int[] point3={_x+_width,_y+_height/2};  //right point
			int[] point4={_x+_width-20,_y+_height};  //bottom right point 
			int[] point5={_x+20,_y+_height};  //bottom left point 
			int[] point6={_x,_y+_height/2};  //left point
			painter.drawLine(point1[0],point1[1],point2[0],point2[1]);
			painter.drawLine(point2[0],point2[1],point3[0],point3[1]);
			painter.drawLine(point3[0],point3[1],point4[0],point4[1]);
			painter.drawLine(point4[0],point4[1],point5[0],point5[1]);
			painter.drawLine(point5[0],point5[1],point6[0],point6[1]);
			painter.drawLine(point1[0],point1[1],point6[0],point6[1]);
		}

	}

}
