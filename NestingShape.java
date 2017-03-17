package bounce;

import java.util.ArrayList;
import java.util.List;

public class NestingShape extends Shape{
	protected List<Shape> _shapes=new ArrayList<Shape>();

	public NestingShape() {
		super();
	}

	public NestingShape(int x, int y) {
		super(x,y);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		this.text = text;
	}
	
	public void add(Shape shape){
		if(shape._x<this._x){
			throw new IllegalArgumentException();
		}else if(shape._width+shape._x >this._width+this._x){
			throw new IllegalArgumentException();
		}else if(shape._height+shape._y>this._height+this._y){
			throw new IllegalArgumentException();
		}else if(shape._y <this._y){
			throw new IllegalArgumentException();
		}else if(shape._parent !=null){
			throw new IllegalArgumentException();	
		}else{
			_shapes.add(shape);
			shape.setParent(this);
		}
	}

	protected void doPaint(Painter painter) {
		painter.drawRect(_x,_y,_width,_height);
		painter.translate(_x,_y);
		for(Shape s:_shapes){
			s.paint(painter);
		}
			painter.translate(-_x,-_y);			
	}

	public void move(int width, int height){
		super.move(width, height);
		for(Shape s:_shapes){
			s.move(_width, _height);
		}
	}

	public boolean contains(Shape shape) {
		return _shapes.contains(shape);
	}

	public void remove(Shape shape) {
		_shapes.remove(shape);
		shape._parent=null;
	}

	public Shape shapeAt(int i) {
		if(i>=_shapes.size()){
			throw new IndexOutOfBoundsException();
		}else{
			return _shapes.get(i);
		}
	}

	public int shapeCount() {
		return _shapes.size();
	}

	public int indexOf(Shape shape) {
		if(this.contains(shape)){
			return _shapes.indexOf(shape);
		}else{
			return -1;
		}
	}

}
