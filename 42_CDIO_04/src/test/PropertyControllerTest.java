package test;

import static org.junit.Assert.*;

import org.junit.Test;

import desktop_codebehind.Car;
import field.Territory;
import game.PropertyController;
import player.Player;
import player.PlayerList;

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
