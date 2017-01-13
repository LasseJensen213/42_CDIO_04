package board;

import java.awt.Color;

import desktop_fields.Brewery;
import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Jail;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_resources.GUI;
import field.Territory;

public class Board {
	private static Board INSTANCE ; 
	
	
	
	field.Field[] ourFields = new field.Field[40];
	Field[] fields = new Field[40];

	public static Board Board() {
		if(INSTANCE == null) 
			INSTANCE = new Board();
		return INSTANCE;
	}
	public static void resetBoard() {
		INSTANCE = null;
	}
	
	public void generateBoard() {
		FieldGenerator.initFields();

				
		int territoryReached = 0;
		int fleetReached = 0;
		int taxReached = 0;
		int breweryReached = 0;
		int chanceReached = 0;
		String desc = "";
		String subtext = "";
		String title = "";
		String image = "";
		Color fgColor = Color.BLACK;
		Color bgColor = Color.BLACK;
		for(int i = 0;i<fields.length;i++) {


			if(FieldGenerator.getStartField().getFieldPosition()==i) {

				desc = FieldGenerator.getStartField().getDesc();
				subtext = FieldGenerator.getStartField().getSubtext();
				title = FieldGenerator.getStartField().getTitle();
				fgColor = FieldGenerator.getFgColors(i);
				Color color = new Color(183, 53, 53);
				ourFields[i] = FieldGenerator.getStartField();
				fields[i] = new Start.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(color).setFgColor(fgColor).build();
			}
			else if(territoryReached<22 && (FieldGenerator.getTerritoryFields(territoryReached).getFieldPosition()==i)) {
				desc = FieldGenerator.getTerritoryFields(territoryReached).getDesc();
				subtext = FieldGenerator.getTerritoryFields(territoryReached).getSubtext();
				title = FieldGenerator.getTerritoryFields(territoryReached).getTitle();
				fgColor = FieldGenerator.getFgColors(i);
				bgColor = FieldGenerator.getTerritoryFields(territoryReached).getColor();
				int price = FieldGenerator.getTerritoryFields(territoryReached).getPrice();
				String priceString = "Kr. "+ price;

				ourFields[i] = FieldGenerator.getTerritoryFields(territoryReached);
				fields[i] = new Street.Builder().setDescription(desc).setSubText(priceString).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();
				territoryReached++;
			}
			else if(breweryReached<2  && (FieldGenerator.getBreweryFields(breweryReached).getFieldPosition()==i)) {
				desc = FieldGenerator.getBreweryFields(breweryReached).getDesc();
				subtext = FieldGenerator.getBreweryFields(breweryReached).getSubtext();
				title = FieldGenerator.getBreweryFields(breweryReached).getTitle();
				fgColor = FieldGenerator.getFgColors(i);
				Color color = new Color(5,81,0);
				image = FieldGenerator.getBreweryFields(breweryReached).getImage();

				ourFields[i] = FieldGenerator.getBreweryFields(breweryReached);
				fields[i] = new Brewery.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setPicture(image).setBgColor(color).setFgColor(fgColor).build();
				breweryReached++;
			}

			else if(chanceReached<6 && (FieldGenerator.getChanceFields(chanceReached).getFieldPosition()==i)) {
				fgColor = FieldGenerator.getFgColors(i);
				bgColor = FieldGenerator.getBgColors(i);

				ourFields[i] = FieldGenerator.getChanceFields(chanceReached);
				fields[i] = new Chance.Builder().setBgColor(Color.CYAN).setFgColor(fgColor).build();
				chanceReached++;
			}
			else if( fleetReached<4 && (FieldGenerator.getFleetFields(fleetReached).getFieldPosition()==i)) {
				desc = FieldGenerator.getFleetFields(fleetReached).getDesc();
				subtext = FieldGenerator.getFleetFields(fleetReached).getSubtext();
				title = FieldGenerator.getFleetFields(fleetReached).getTitle();




				fgColor = FieldGenerator.getFgColors(i);
				Color color = new Color(22,100,255);

				ourFields[i] = FieldGenerator.getFleetFields(fleetReached);
				fields[i] = new Shipping.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(color).setFgColor(fgColor).build();
				fleetReached++;
			}
			else if(FieldGenerator.getGoToJailField().getFieldPosition()==i) {
				desc = FieldGenerator.getGoToJailField().getDesc();
				subtext = FieldGenerator.getGoToJailField().getSubtext();
				title = FieldGenerator.getGoToJailField().getTitle();

				ourFields[i] = FieldGenerator.getGoToJailField();
				fields[i] = new Jail.Builder().setDescription(desc).setSubText(title).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();

			}
			else if(FieldGenerator.getJailField().getFieldPosition()==i) {
				desc = FieldGenerator.getJailField().getDesc();
				subtext = FieldGenerator.getJailField().getSubtext();
				title = FieldGenerator.getJailField().getTitle();

				ourFields[i] = FieldGenerator.getJailField();
				fields[i] = new Jail.Builder().setDescription(desc).setSubText(title).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();

			}
			else if(FieldGenerator.getParkingLotField().getFieldPosition()==i) {
				desc = String.format(FieldGenerator.getParkingLotField().getDesc(), 0);
				subtext = FieldGenerator.getParkingLotField().getSubtext();
				title = FieldGenerator.getParkingLotField().getTitle();
				Color color = new Color(193,255,188);

				ourFields[i] = FieldGenerator.getParkingLotField();
				fields[i] = new Refuge.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setPicture("src/images/Redcar.gif").setBgColor(color).setFgColor(fgColor).build();
			}
			else if(taxReached<2 && (FieldGenerator.getTaxFields(taxReached).getFieldPosition()==i)) {
				desc = FieldGenerator.getTaxFields(taxReached).getDesc();
				subtext = FieldGenerator.getTaxFields(taxReached).getSubtext();
				title = FieldGenerator.getTaxFields(taxReached).getTitle();
				bgColor = FieldGenerator.getBgColors(i);

				ourFields[i] = FieldGenerator.getTaxFields(taxReached);
				fields[i] = new Tax.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();
				taxReached++;
			}




		}
		GUI.create(fields);

	}

	public field.Field getField(int pos){
		return ourFields[pos];
	}

	public field.Field[] getOurFields() {
		return ourFields;
	}

	public Field[] getFields() {
		return fields;
	}


	public void printFields() {
		for(int i = 0;i<ourFields.length;i++) {
			System.out.println(ourFields[i]);
		}
	}



}

