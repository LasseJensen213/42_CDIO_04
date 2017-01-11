package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dice.Dice;

public class DiceTest {

Dice dice;
	
	
	@Before
	public void setUp() throws Exception {
		dice = new Dice(6);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFaceValue() {
		int expected = 6;
		dice.setFaceValue(6);
		int actual = dice.getFaceValue();
		assertEquals(expected,actual);
		}
		
	
	@Test
	public void testDiceFairness() {
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;

		int expected = 10000;
		int  faceValue;
		for(int i= 0 ; i<60000;i++)
		{
			dice.roll();
			faceValue = dice.getFaceValue();

			switch(faceValue)
			{
			case 1: one++;
			break;
			case 2: two++;
			break;
			case 3: three++;
			break;
			case 4: four++;
			break;
			case 5: five++;
			break; 
			case 6: six++;
			break;
			default: System.out.println("Error! bad value");;
			}
			
		}
		assertEquals(expected, one,400);
		assertEquals(expected, two,400);
		assertEquals(expected, three,400);
		assertEquals(expected, four,400);
		assertEquals(expected, five,400);
		assertEquals(expected, six,400);
		
	}

}
