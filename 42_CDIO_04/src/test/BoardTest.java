package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import board.Board;
import board.FieldGenerator;

public class BoardTest {
	Board b;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void generateBoardtest() {
		FieldGenerator.initFields();
		Board b = Board.board();
		b.generateBoard();



		int territoryReached = 0;
		int fleetReached = 0;
		int taxReached = 0;
		int breweryReached = 0;
		int chanceReached = 0;		
		field.Field[] fields = b.getOurFields();

		for(int i = 0;i<fields.length;i++) {
			if(i == FieldGenerator.getStartField().getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getStartField());
			}
			else if((territoryReached<22) && i == FieldGenerator.getTerritoryFields(territoryReached).getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getTerritoryFields(territoryReached));
				territoryReached++;
			}
			else if((breweryReached<2) && i == FieldGenerator.getBreweryFields(breweryReached).getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getBreweryFields(breweryReached));
				breweryReached++;
			}
			else if((taxReached<2) && i == FieldGenerator.getTaxFields(taxReached).getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getTaxFields(taxReached));
				taxReached++;
			}
			else if((chanceReached<6) && i == FieldGenerator.getChanceFields(chanceReached).getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getChanceFields(chanceReached));
				chanceReached++;
			}
			else if((fleetReached<4) && i == FieldGenerator.getFleetFields(fleetReached).getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getFleetFields(fleetReached));
				fleetReached++;
			}
			else if(i == FieldGenerator.getJailField().getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getJailField());
			}
			else if(i==FieldGenerator.getGoToJailField().getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getGoToJailField());
			}
			else if(i == FieldGenerator.getParkingLotField().getFieldPosition()) {
				assertEquals(fields[i],FieldGenerator.getParkingLotField());

			}



		}

	}

}
