package bounce;

import java.awt.Color;
import java.lang.reflect.Field;

public class DynamicRectangleShape extends Shape{
	private String _appearance="2"; //1 for colored rectangle shape, 2 for normal rectangle shape
	private Color _color=Color.BLACK;
	private String colorString;

	public static String getColorName(Color c) {
		for (Field f : Color.class.getFields()) {
			try {
				if (f.getType() == Color.class && f.get(null).equals(c)) {
					return f.getName();
				}
			} catch (java.lang.IllegalAccessException e) {
				// it should never get to here
			} 
		}
		return "unknown";
	}
	public DynamicRectangleShape() {
		super();
		colorString=getColorName(_color);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
		colorString=getColorName(_color);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
		colorString=getColorName(_color);
	}

	public DynamicRectangleShape(Color c) {
		super();
		_color=c;
		colorString=getColorName(_color);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color c) {
		super(x,y,deltaX,deltaY);
		_color=c;
		colorString=getColorName(_color);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color c) {
		super(x,y,deltaX,deltaY,width,height);
		_color=c;
		colorString=getColorName(_color);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		this.text = text;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color c) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		this.text = text;
		_color = c;
	}

	protected void doPaint(Painter painter) {
		Color temp=painter.getColor(); 
		String tempcolor=getColorName(temp);
		painter.setColor(_color,colorString);
		if (_appearance.equals("1")){
			painter.fillRect(_x,_y,_width,_height,colorString);
		} else{
			painter.drawRect(_x,_y,_width,_height);
		}
		painter.setColor(temp,tempcolor);
	}

	public void move(int width, int height) {
		super.move(width, height);
		if (_x==0 || (_x+_width)==width){
			_appearance="1";
		} else if ( _y==0||(_y +_height) == height){
			_appearance="2";
		}

	}

	public void innermove(int x, int y, int height, int width){
		super.innermove(x, y, height, width);
		if (_x==x || (_x+_width)==(x+width)){
			_appearance="1";
		} else if ( _y==y||(_y +_height) == (y+height)){
			_appearance="2";
		}
	}
}
