package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import desktop_codebehind.Car;
import field.Fleet;
import field.Territory;
import game.GameLogic;
import player.Player;

public class GameLogicTest {

	GameLogic gLogic;
	Car car;
	Player player;


	@Before
	public void setUp()
	{
		gLogic = new GameLogic();
		car = new Car.Builder().build();
		player = new Player("jens",car,3000);
	}

	@Test
	public void playerIsBrokeNoFieldsTest() {

		gLogic.playerIsBroke(player);



	}
	@Test
	public void playerIsBroke1FleetTest()
	{
		player.getProperty().addField(new Fleet("","","",0,500,new int[]{5,2,3}));
		gLogic.playerIsBroke(player);
	}

	@Test
	public void playerIsBroke1Territory()
	{
		Color color = Color.BLACK;
		player.getProperty().addField(new Territory("","","",0,500,new int[]{3,3,3},2,color , 300 ));
	}

}
