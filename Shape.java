
package bounce;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * @author Ian Warren
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0; 
	
	protected static final int DEFAULT_Y_POS = 0;  
	
	protected static final int DEFAULT_DELTA_X = 5; 
	
	protected static final int DEFAULT_DELTA_Y = 5; 
	
	protected static final int DEFAULT_HEIGHT = 35; 

	protected static final int DEFAULT_WIDTH = 25;  
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;//top left

	protected int _y;//top left

	protected int _deltaX;// velocity right=+

	protected int _deltaY;// velocity left=+

	protected int _width; //height of the shape

	protected int _height; // width of the shape
	
	protected int _outdeltaX=0;
	
	protected int _outdeltaY=0;
	
	protected NestingShape _parent;
	
	protected List<Shape> _path=new ArrayList<Shape>();
	
	protected String text="";
	
	// ===

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
	}

	public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		this.text = text;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width width of two-dimensional world.
	 * @param height height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
	}

	public void innermove(int x, int y, int height, int width){
		int nextX = _x + _deltaX+_outdeltaX;
		int nextY = _y + _deltaY+_outdeltaY;

		if (nextX <= x) {
			nextX = x;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= x+width) {
			nextX = width + x - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= y) {
			nextY = y;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= y+height) {
			nextY = height + y - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
		
		_outdeltaX=_parent._outdeltaX+_parent._deltaX;
		_outdeltaY=_parent._outdeltaY+_parent._deltaY;		
	}
	
	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	public void paint(Painter painter){
		painter.drawCentredText(text, _x, _y, _width, _height);
		doPaint(painter);	
	}

	protected abstract void doPaint(Painter painter);

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	public String text(){
		return text;
	}
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "bounce.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}

	public NestingShape parent(){
		return _parent;
	};
	
	public void setParent(NestingShape shape){
		_parent=shape;
		this._outdeltaX=shape.deltaX()+shape._outdeltaX;
		this._outdeltaY=shape.deltaY()+shape._outdeltaY;
	}

	public List<Shape> path() {
		List<Shape> fullPath = null;
		if( _parent != null ) {
			fullPath = _parent.path();
			fullPath.add( this );
		}
		else {
			fullPath = new ArrayList<Shape>();
			fullPath.add( this );
		}
		return fullPath;
	}
	
	public void drawText(Painter painter){
		if(text!=null){
			painter.drawCentredText(text,_x,_y,_width,_height);
		}
	}
}
