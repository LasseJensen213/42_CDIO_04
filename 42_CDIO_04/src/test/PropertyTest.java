package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Image;

import org.junit.Before;
import org.junit.Test;

import field.Fleet;
import field.Territory;
import player.Property;

public class PropertyTest {

	private Property propTest;
	@Before
	public void setUp() throws Exception
	{
		propTest = new Property();
	}
	
	
	@Test
	public void AddFieldstest()
	{
		Fleet fleet = new Fleet("","","",0,0,new int[]{2,3,4,5});
		propTest.addField(fleet);
		int actual = propTest.nFields();
		assertEquals(actual,1);
		actual = propTest.nFleetsOwned();
		assertEquals(actual,1);
		assertEquals(fleet,propTest.getField(0));
		propTest.removeField(fleet);
		actual = propTest.nFields();
		assertEquals(actual,0);
		
		int seriesMax = 20;
		for(int i = 0; i<seriesMax;i++)
		{
			propTest.addField(new Territory("","","",0,0,new int[]{4,5,6,7,8},seriesMax,Color.blue,3000));
		}
		actual = propTest.nFields();
		assertEquals(actual,seriesMax);
		actual = propTest.nDifferentSeries();
		assertEquals(actual,1);
		actual = propTest.nParticularSeries(Color.blue);
		assertEquals(actual, 20);
		assertTrue(propTest.completeSeries(Color.blue));
		actual = propTest.nTerritoriesOwned();
		assertEquals(actual,20);
		assertFalse(propTest.completeSeries(Color.BLACK));
		assertFalse(propTest.hasField(new Territory("","","",0,0,new int[]{4,5,6,7,8},seriesMax,Color.blue,3000)));
		
	}

}
