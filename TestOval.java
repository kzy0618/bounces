package bounce;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class TestOval extends TestCase{
	private MockPainter _painter;
	
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	@Test
	public void testOvalShape() {
		OvalShape shape = new OvalShape();
		shape.paint(_painter);
		assertEquals("(oval 0,0,25,35)",_painter.toString());
	}
	
	@Test
	public void testOvalShape1() {
		OvalShape shape = new OvalShape();
		assertEquals(0,shape.x());
		assertEquals(0,shape.y());
		assertEquals(5,shape.deltaX());
		assertEquals(5,shape.deltaY());
		assertEquals(25,shape.width());
		assertEquals(35,shape.height());
	}
	
	@Test
	public void testOvalShape2() {
		OvalShape shape = new OvalShape(5,10);
		assertEquals(5,shape.x());
		assertEquals(10,shape.y());
		assertEquals(5,shape.deltaX());
		assertEquals(5,shape.deltaY());
		assertEquals(25,shape.width());
		assertEquals(35,shape.height());
	}
	
	@Test
	public void testOvalShape3() {
		OvalShape shape = new OvalShape(10,15,20,60);
		assertEquals(10,shape.x());
		assertEquals(15,shape.y());
		assertEquals(20,shape.deltaX());
		assertEquals(60,shape.deltaY());
		assertEquals(25,shape.width());
		assertEquals(35,shape.height());
	}
	
	@Test
	public void testOvalShape4() {
		OvalShape shape = new OvalShape(10,15,20,60,45,55);
		assertEquals(10,shape.x());
		assertEquals(15,shape.y());
		assertEquals(20,shape.deltaX());
		assertEquals(60,shape.deltaY());
		assertEquals(45,shape.width());
		assertEquals(55,shape.height());
	}
}
