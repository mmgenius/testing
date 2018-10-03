package main.fr.ut2j.m1ice.ootesting;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestMyPoint 
{

	MyPoint m_PointFirst ;
	MyPoint m_PointSecond;
	
	
	@Mock
	MyPoint m_PointMock ;
	
	@Rule 
	//public MockitoRule rule = MockitoJUnit.rule();
	
	
	
	@Before
	public void setUp() throws Exception 
	{
		m_PointFirst = new MyPoint();
		m_PointSecond =  new MyPoint(0.5,1.0);
		
		m_PointMock = mock(MyPoint.class);
		
	}

	@After
	public void tearDown() throws Exception 
	{
		m_PointFirst = null;
		m_PointSecond = null;
			
	}
	
	//method class test for both construct One and Two 
	@Test
	public void testMyPoint() 
	{
		
		assertEquals(0d, m_PointFirst.getX(), 0.0001);  
		assertEquals(0d, m_PointFirst.getY(), 0.0002);
		
		assertEquals(0.5, m_PointSecond.getX(), 0.0001);
		assertEquals(1.0, m_PointSecond.getY(), 0.0002);
	
	}

	@Ignore
	@Test
	public void testMyPointDoubleDouble() 
	{
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testMyPointMyPoint() 
	{
		fail("Not yet implemented");
	}
	
	//Method test for Set and Get X operations
	@Test
	public void testSetGetX() 
	{		
		m_PointFirst.setX(0.2);
		double m_PointX = m_PointFirst.getX();
		assertEquals(0.2, m_PointX, 0.0000);
	}
	
	//Method test for Set and Get Y operations
	@Test
	public void testSetGetY() 
	{
		
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
		
		assertFalse(m_dTemps == Double.NaN); 
	}

	@Test 
	public void testSetY() 
	{
		m_PointSecond.setY(0.025);
		double m_PointY = m_PointSecond.getY() ; 
		assertFalse(Double.NaN == m_PointY);
	}
	
	//method test for the Third construct Point
	@Test
	public void testMyPointThird() 
	{
		
		MyPoint m_ThirdPoint  = new MyPoint(m_PointFirst); 
		double m_ThirdPointX = m_ThirdPoint.getX(); 
		double m_ThirdPointY = m_ThirdPoint.getY();
		
		assertEquals(m_ThirdPointX, m_PointFirst.getX(), 0.001); 
		assertEquals(m_ThirdPointY, m_PointFirst.getY(), 0.001); 
		
	}
	
	@Test
	public void testScale() 
	{
		MyPoint m_ThirdPoint = new MyPoint(m_PointSecond); 
		double m_ThirdPointX = m_ThirdPoint.getX();
		double m_ThirdPointY = m_ThirdPoint.getY();
		
		assertFalse(!( m_ThirdPointX  == m_PointSecond.getX() ) && ( m_ThirdPointY == m_PointSecond.getY() ) );
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetry() 
	{
		
		MyPoint m_horizontalPoint = m_PointSecond.horizontalSymmetry(null);	
		MyPoint m_horizontalPoint2 = m_PointSecond.horizontalSymmetry(m_PointFirst);
		MyPoint m_horizontalPoint3 = m_PointSecond.horizontalSymmetry(new MyPoint(1.5, 0.5));
		
		
		assertEquals("Good Number", m_horizontalPoint.getX() , (2d * m_PointFirst.getX() - m_PointSecond.getX() ), 0.0001) ;
		
		assertEquals("Good Number", m_horizontalPoint2.getX() , (2d * m_PointFirst.getX() - m_PointSecond.getX() ), 0.001) ;
		
		assertEquals("Good Number", m_horizontalPoint3.getX() , 0.152 , 0.001) ;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryNULL ( ) 
	{		
	    new MyPoint ( 1.0 , 2.0 ) . centralSymmetry ( null ) ;
	}

	@Ignore
	@Test
	public void testComputeAngle() 
	{
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testRotatePoint() 
	{
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testCentralSymmetry() 
	{
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetMiddlePoint() 
	{
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testTranslateDoubleDouble() 
	{
		fail("Not yet implemented");
	}

	
	@Test	
	public void testSetPoint() 
	{	
		MyPoint m_Point = new MyPoint();
		
		Random m_RandomOne = new Random();
		Random m_RandomTwo = new Random(); 
		//when(m_PointMock.setPoint(m_RandomOne, m_RandomTwo)); 
		
	}

	@Ignore
	@Test
	public void testTranslateITranslation() {
		fail("Not yet implemented");
	}

}
