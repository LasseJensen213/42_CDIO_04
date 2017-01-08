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

public class Board {
	field.Field[] ourFields = new field.Field[40];
	Field[] fields = new Field[40];


	public void generateBoard() {
		FieldGenerator fg = new FieldGenerator();

		
		
		int territoryReached = 0;
		int fleetReached = 0;
		int taxReached = 0;
		int breweryReached = 0;
		int chanceReached = 0;
		String desc = "";
		String subtext = "";
		String title = "";
		int rent = 0;
		Color fgColor = Color.BLACK;
		Color bgColor = Color.BLACK;
		
		for(int i = 0;i<fields.length;i++) {
			
			
			if(FieldGenerator.getStartField().getFieldPosition()==i) {
				
				desc = FieldGenerator.getStartField().getDesc();
				subtext = FieldGenerator.getStartField().getSubtext();
				title = FieldGenerator.getStartField().getTitle();
				fgColor = FieldGenerator.getFgColors(i);
				bgColor = FieldGenerator.getBgColors(i);
				
				fields[i] = new Start.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();
			}
			else if((FieldGenerator.getTerritoryFields(territoryReached).getFieldPosition()==i) && territoryReached<22) {
				desc = FieldGenerator.getTerritoryFields(territoryReached).getDesc();
				subtext = FieldGenerator.getTerritoryFields(territoryReached).getSubtext();
				title = FieldGenerator.getTerritoryFields(territoryReached).getTitle();
				rent = FieldGenerator.getTerritoryFields(territoryReached).getRent();
				fgColor = FieldGenerator.getFgColors(i);
				bgColor = FieldGenerator.getBgColors(i);
				
				fields[i] = new Street.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).setRent("rent").build();
				territoryReached++;
			}
			else if(breweryReached<2  && (FieldGenerator.getBreweryFields(breweryReached).getFieldPosition()==i)) {
				desc = FieldGenerator.getBreweryFields(breweryReached).getDesc();
				subtext = FieldGenerator.getBreweryFields(breweryReached).getSubtext();
				title = FieldGenerator.getBreweryFields(breweryReached).getTitle();
				rent = FieldGenerator.getBreweryFields(breweryReached).getRent();
				fgColor = FieldGenerator.getFgColors(i);
				bgColor = FieldGenerator.getBgColors(i);
				
				fields[i] = new Brewery.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).setPicture("").setRent("rent").build();
				breweryReached++;
			}
			
			else if(chanceReached<6 && (FieldGenerator.getChanceFields(chanceReached).getFieldPosition()==i)) {
				fgColor = FieldGenerator.getFgColors(i);
				bgColor = FieldGenerator.getBgColors(i);
				
				fields[i] = new Chance.Builder().setBgColor(bgColor).setFgColor(fgColor).build();
				chanceReached++;
			}
			else if( fleetReached<4 && (FieldGenerator.getFleetFields(fleetReached).getFieldPosition()==i)) {
				desc = FieldGenerator.getFleetFields(fleetReached).getDesc();
				subtext = FieldGenerator.getFleetFields(fleetReached).getSubtext();
				title = FieldGenerator.getFleetFields(fleetReached).getTitle();
				//What rent?
				
				//rent = fg.getFleetFields(fleetReached).getRent();
				fgColor = FieldGenerator.getFgColors(i);
				bgColor = FieldGenerator.getBgColors(i);
				
				fields[i] = new Shipping.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).setRent("").setPicture("").build();
				fleetReached++;
			}
			else if(FieldGenerator.getGoToJailField().getFieldPosition()==i) {
				desc = FieldGenerator.getGoToJailField().getDesc();
				subtext = FieldGenerator.getGoToJailField().getSubtext();
				title = FieldGenerator.getGoToJailField().getTitle();
				
				fields[i] = new Jail.Builder().setDescription(desc).setSubText(title).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();
				
			}
			else if(FieldGenerator.getJailField().getFieldPosition()==i) {
				desc = FieldGenerator.getJailField().getDesc();
				subtext = FieldGenerator.getJailField().getSubtext();
				title = FieldGenerator.getJailField().getTitle();
				
				
				fields[i] = new Jail.Builder().setDescription(desc).setSubText(title).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();
						
			}
			else if(FieldGenerator.getParkingLotField().getFieldPosition()==i) {
				desc = FieldGenerator.getParkingLotField().getDesc();
				subtext = FieldGenerator.getParkingLotField().getSubtext();
				title = FieldGenerator.getParkingLotField().getTitle();
				
				fields[i] = new Refuge.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).setPicture("").build();
			}
			else if(taxReached<2 && (FieldGenerator.getTaxFields(taxReached).getFieldPosition()==i)) {
				desc = FieldGenerator.getTaxFields(taxReached).getDesc();
				subtext = FieldGenerator.getTaxFields(taxReached).getSubtext();
				title = FieldGenerator.getTaxFields(taxReached).getTitle();
				
				fields[i] = new Tax.Builder().setDescription(desc).setSubText(subtext).setTitle(title).setBgColor(bgColor).setFgColor(fgColor).build();
				taxReached++;
			}
			else if(i==39) {
				System.out.println("I'm done");
			}
			
		
			
		
		}
		GUI.create(fields);
		
	}
	
	public field.Field getField(int pos){
		return ourFields[pos];
	}


	public Field[] getFields() {
		return fields;
	}


	
	
	
}

