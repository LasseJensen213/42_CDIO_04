package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.PropertyController;

public class PropertyControllerTest {

	@Test
	public void testAddToArray() {
		PropertyController prop = new PropertyController();
		String[] strArr = new String[0];
		
		strArr = prop.addToArray(strArr,"Bob");
		System.out.println("Bob");
		System.out.println(strArr[0]);
		assertEquals(strArr[0],"Bob");
		
		strArr = prop.addToArray(strArr, "WoW");
		assertEquals(strArr[1],"WoW");
	
		
	}
	
	

}
