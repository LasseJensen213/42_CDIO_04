package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import board.Board;
import board.FieldGenerator;

public class BoardTest {
	FieldGenerator f;
	Board b;
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
		Board b = null;
		FieldGenerator f = null;
	}

	@Test
	public void generateBoardtest() {
		int correct = 0;
		Board b = Board.Board();
		FieldGenerator fg = new FieldGenerator();
		b.generateBoard();
		int breweryReached = 0;
		int territoryReached = 0;
		int fleetReached = 0;
		int taxReached = 0;
		int chanceReached = 0;
		
		field.Field[] fields = b.getOurFields();
		
		for(int i = 0;i<fields.length;i++) {

			if(i == FieldGenerator.getStartField().getFieldPosition()) {
				if(fields[i] == FieldGenerator.getStartField()) {
					correct++;
				}
				else {
					System.out.println("Fejl start");
				}
			}
			else if((territoryReached<22) && i == FieldGenerator.getTerritoryFields(territoryReached).getFieldPosition()) {
				if(fields[i] == FieldGenerator.getTerritoryFields(territoryReached)) {
					correct++;
				}
				else {
					System.out.println("Fejl Territory" + fields[i].getTitle());
				}
				territoryReached++;
			}
			else if((breweryReached<2) && i == FieldGenerator.getBreweryFields(breweryReached).getFieldPosition()) {
				if(fields[i] == FieldGenerator.getBreweryFields(breweryReached)) {
					correct++;
				}
				else {
					System.out.println("Fejl Brewery" + fields[i].getTitle());
				}
				breweryReached++;
			}
			else if((taxReached<2) && i == FieldGenerator.getTaxFields(taxReached).getFieldPosition()) {
				if(fields[i] == FieldGenerator.getTaxFields(taxReached)) {
					correct++;
				}
				else {
					System.out.println("Fejl chance" + fields[i].getTitle());
				}
				taxReached++;
			}
			else if((chanceReached<6) && i == FieldGenerator.getChanceFields(chanceReached).getFieldPosition()) {
				if(fields[i] == FieldGenerator.getChanceFields(chanceReached)) {
					correct++;
				}
				else {
					System.out.println("Fejl chance" + fields[i].getTitle());
				}
				chanceReached++;
			}
			else if((fleetReached<4) && i == FieldGenerator.getFleetFields(fleetReached).getFieldPosition()) {
				if(fields[i] == FieldGenerator.getFleetFields(fleetReached)) {
					correct++;
				}
				else 
					System.out.println("fejl fleet" + fields[i].getTitle());
				fleetReached++;
			}
			else if(i == FieldGenerator.getJailField().getFieldPosition()) {
				if(fields[i] == FieldGenerator.getJailField()) {
					correct++;
				}
				else 
					System.out.println("fejl Jail" + fields[i].getTitle());
			}
			else if(i==FieldGenerator.getGoToJailField().getFieldPosition()) {
				if(fields[i] == FieldGenerator.getGoToJailField()) {
					correct++;
				}
				else 
					System.out.println("fejl GoToJail" + fields[i].getTitle());
			}
			else if(i == FieldGenerator.getParkingLotField().getFieldPosition()) {
				if(fields[i] == FieldGenerator.getParkingLotField()) {
					correct++;
				}
				else 
					System.out.println("fejl ParkingLot" + fields[i].getTitle());
			}
	


		}
		assertEquals(40,correct);
		
	}

}
