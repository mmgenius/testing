package main.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyPoint {

	MyPoint m_PointFirst ;
	MyPoint m_PointSecond;
	
	@Before
	public void setUp() throws Exception {
		m_PointFirst = new MyPoint();
		m_PointSecond =  new MyPoint(0.5,1.0);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	//method class test for both construct One and Two 
	@Test
	public void testMyPoint() {
		
		assertEquals(0d, m_PointFirst.getX(), 0.0001);  
		assertEquals(0d, m_PointFirst.getY(), 0.0002);
		
		assertEquals(0.5, m_PointSecond.getX(), 0.0001);
		assertEquals(1.0, m_PointSecond.getY(), 0.0002);
	
	}

	@Test
	public void testMyPointDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testMyPointMyPoint() {
		fail("Not yet implemented");
	}
	
	//Method test for Set and Get X operations
	@Test
	public void testSetGetX() {		
		m_PointFirst.setX(0.2);
		double m_PointX = m_PointFirst.getX();
		assertEquals(0.3, m_PointX, 0.0001);
	}
	
	//Method test for Set and Get Y operations
	@Test
	public void testSetGetY() {
		
		double m_PointY = m_PointSecond.getY();
		m_PointSecond.setY(2.05);
		double m_dTemps = m_PointSecond.getY(); 
		
		assertEquals(m_PointY, m_dTemps, 0.0001);	
	}
	
	@Test 
	public void testSetX() 
	{		
		double m_dTemps = m_PointFirst.getX();
		m_PointFirst.setX(Double.NaN);
		
		assertEquals(m_dTemps, Double.NaN, 0.01); 
	}

	@Test 
	public void testSetY() 
	{
		m_PointSecond.setY(0.025);
		double m_PointY = m_PointSecond.getY() ; 
		assertEquals(Double.NaN, m_PointY , 0.0001);
	}
	
	//method test for the Third construct Point
	@Test
	public void testMyPointThird() {
		
		MyPoint m_ThirdPoint  = new MyPoint(m_PointFirst); 
		double m_ThirdPointX = m_ThirdPoint.getX(); 
		double m_ThirdPointY = m_ThirdPoint.getY();
		
		assertEquals(m_ThirdPointX, m_PointFirst.getX(), 0.001); 
		assertEquals(m_ThirdPointY, m_PointFirst.getY(), 0.001); 
		
	}
	
	@Test
	public void testScale() {
		MyPoint m_ThirdPoint = new MyPoint(m_PointSecond); 
		double m_ThirdPointX = m_ThirdPoint.getX();
		double m_ThirdPointY = m_ThirdPoint.getY();
		
		assertFalse(!( m_ThirdPointX  == m_PointSecond.getX() ) && ( m_ThirdPointY == m_PointSecond.getY() ) );
		
	}

	@Test
	public void testHorizontalSymmetry() {
		fail("Not yet implemented");
	}

	@Test
	public void testComputeAngle() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotatePoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testCentralSymmetry() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMiddlePoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testTranslateDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testTranslateITranslation() {
		fail("Not yet implemented");
	}

}
