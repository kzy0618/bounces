package bounce;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestGemShape extends TestCase{
	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	@Test
	public void testSmallGemShape() {
		GemShape shape = new GemShape(0,0,5,5,30,20);
		shape.paint(_painter);
		assertEquals("(line 15,0,0,10)(line 0,10,15,20)"
				+ "(line 15,20,30,10)(line 15,0,30,10)",_painter.toString());
	}

	@Test
	public void testRegularGemShape(){
		GemShape shape = new GemShape(0,0,5,5,60,20);
		shape.paint(_painter);
		assertEquals("(line 20,0,40,0)(line 40,0,60,10)"
				+ "(line 60,10,40,20)(line 40,20,20,20)"
				+ "(line 20,20,0,10)(line 20,0,0,10)",_painter.toString());
	}
}
