package bounce;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class TestDynamicRectangleShape extends TestCase{
	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	@Test
	public void testTopBounce(){
		DynamicRectangleShape shape = new DynamicRectangleShape(10,10,-1,-20,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 10,10,25,35)(color red)(rectangle 9,0,25,35)"
				+ "(color red)(rectangle 8,20,25,35)",  _painter.toString());
	}

	@Test
	public void testLeftBounce(){
		DynamicRectangleShape shape= new DynamicRectangleShape(10,10,-20,1,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 10,10,25,35)(color red)(rectangle 0,11,25,35,red)"
				+ "(color red)(rectangle 20,12,25,35,red)",  _painter.toString());
	}

	@Test
	public void testRightBounce(){
		DynamicRectangleShape shape= new DynamicRectangleShape(430,430,50,1,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 430,430,25,35)(color red)(rectangle 475,431,25,35,red)"
				+ "(color red)(rectangle 425,432,25,35,red)",  _painter.toString());
	}

	@Test
	public void testBottomBounce(){
		DynamicRectangleShape shape= new DynamicRectangleShape(430,430,1,40,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 430,430,25,35)(color red)(rectangle 431,465,25,35)"
				+ "(color red)(rectangle 432,425,25,35)",  _painter.toString());
	}

	@Test
	public void testTopLeftBounce(){
		DynamicRectangleShape shape= new DynamicRectangleShape(10,10,-25,-25,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 10,10,25,35)(color red)(rectangle 0,0,25,35,red)"
				+ "(color red)(rectangle 25,25,25,35,red)",  _painter.toString());
	}

	@Test
	public void testTopRightBounce(){
		DynamicRectangleShape shape= new DynamicRectangleShape(465,10,25,-25,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 465,10,25,35)(color red)(rectangle 475,0,25,35,red)"
				+ "(color red)(rectangle 450,25,25,35,red)",  _painter.toString());
	}

	@Test
	public void testBottomLeftBounce(){
		DynamicRectangleShape shape= new DynamicRectangleShape(10,455,-25,25,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 10,455,25,35)(color red)(rectangle 0,465,25,35,red)"
				+ "(color red)(rectangle 25,440,25,35,red)",  _painter.toString());
	}

	@Test
	public void testBottomRightBounce(){
		DynamicRectangleShape shape= new DynamicRectangleShape(465,455,25,25,Color.RED);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(color red)(rectangle 465,455,25,35)(color red)(rectangle 475,465,25,35,red)"
				+ "(color red)(rectangle 450,440,25,35,red)",  _painter.toString());
	}
}
