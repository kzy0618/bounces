package bounce;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Ian Warren
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
	}

	/**
	 * @see bounce.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}	

	/**
	 * @see bounce.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	public void fillRect(int x, int y, int width, int height, String color){
		_g.fillRect(x, y, width, height);
	}

	public Color getColor(){
		return _g.getColor();
	}

	public void setColor(Color c,String color){
		_g.setColor(c);;
	}

	public void drawCentredText(String text, int x, int y, int width, int height){
		FontMetrics metrics = _g.getFontMetrics();
		x = x+(width/2)-(metrics.stringWidth(text)/2);
		y = height/2+(metrics.getAscent()-metrics.getDescent())/2+y;
		_g.drawString(text, x, y);
	}

	public void translate(int x, int y){
		_g.translate(x,y);
	}

	@Override
	public void drawImage(Image _picture, int _x, int _y, int _width,
			int _height) {
		_g.drawImage(_picture, _x, _y, _width, _height, null);

	}
}
