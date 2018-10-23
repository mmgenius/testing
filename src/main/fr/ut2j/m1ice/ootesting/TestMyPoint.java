package main.fr.ut2j.m1ice.ootesting;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


public class TestMyPoint 
{

	MyPoint m_PointFirst ;
	MyPoint m_PointSecond;
	
	
	@Mock
	MyPoint m_PointMock ;
	
	
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
		m_PointSecond.setY(2.05);
		double m_dTemps = m_PointSecond.getY(); 		
		assertEquals(2.05, m_dTemps, 0.0001);	
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
		final double m_scaleParameter = 2.2 ; 
		MyPoint m_ThirdPoint; 
		MyPoint m_tempsPoint = new MyPoint(5.4,2.5);
		m_ThirdPoint = m_tempsPoint.scale(m_scaleParameter);
		
		assertEquals(m_ThirdPoint.getX(), 11.88, 0.001);
		assertEquals(m_ThirdPoint.getY(), 5.5, 0.001);
		
		
	}

	@Test
	public void testHorizontalSymmetry()
	{
		final MyPoint m_originPoint = null ; //new MyPoint(2.5, 3.0);				
		MyPoint m_pointSys = new MyPoint(2.0, 1.0);		
		assertThrows(IllegalArgumentException.class,
                () -> {
                	MyPoint m_horizontalSymPoint = m_pointSys.horizontalSymmetry(m_originPoint);
                });
		
		final MyPoint m_originePointTwo = new MyPoint(2.5, 3.0);
		MyPoint m_horizontalSymPoint2 = m_pointSys.horizontalSymmetry(m_originePointTwo);
		assertEquals(m_horizontalSymPoint2.getX(), 3.0, 0.0001);
			
		
		
	}
	

	@Test
	public void testCentralSymmetry() 
	{
		assertThrows(IllegalArgumentException.class,
                () -> {
                    MyPoint myNewPoint = new MyPoint(3.0, 7.0).centralSymmetry(null);
                });
		
		MyPoint m_centrePoint = new MyPoint(0.0, 3.5);f
		MyPoint myNewPointTwo = new MyPoint(3.5, 7.0).centralSymmetry(m_centrePoint);
		
		
		//assertEquals(myNewPointTwo.getY(), , 0.0001)
	}
	
	@Test	
	public void testSetPoint() 
	{	
		Random m_RandomOne = new Random();
		Random m_RandomTwo = new Random(); 
		when(m_PointMock.setPoint(m_RandomOne, m_RandomTwo)).thenReturn(true); 
		
	}

	@Ignore
	@Test
	public void testTranslateITranslation() {
		fail("Not yet implemented");
	}

}
