package module6;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.providers.Google.*;

import java.util.List;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;

import java.util.HashMap;


import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;

/**
 * Visualizes life expectancy in different countries. 
 * 
 * It loads the country shapes from a GeoJSON file via a data reader, and loads the population density values from
 * another CSV file (provided by the World Bank). The data value is encoded to transparency via a simplistic linear
 * mapping.
 */
public class LifeExpectancy extends PApplet {

	UnfoldingMap map;
	HashMap<String, Float> lifeExpMap;
	List<Feature> countries;
	List<Marker> countryMarkers;
	Marker lastSelected;
	Marker lastClicked;

	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);

		// Load lifeExpectancy data
		lifeExpMap = ParseFeed.loadLifeExpectancyFromCSV(this,"LifeExpectancyWorldBank.csv");
		

		// Load country polygons and adds them as markers
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		//wrong syntax ((Feature) countryMarkers).addProperty("name",((Feature) countries).getProperty("name"));
		map.addMarkers(countryMarkers);
		System.out.println(countryMarkers.get(0).getId());
		
		// Country markers are shaded according to life expectancy (only once)
		shadeCountries();
		
		
	}
	public void mouseMoved()
	{
		// clear the last selection
		if (lastSelected != null) {
			( lastSelected).setSelected(false);
			lastSelected = null;
		
		}
		selectMarkerIfHover(countryMarkers);
		
		//loop();
	}
	
	public void mousePressed()
	{
		
		if(lastClicked !=null)
		{
			lastClicked=null;
		}
		onClick();
		
	}
	
	private void onClick()
	{
		for (Marker marker : countryMarkers) 
		{
		if (marker.isInside(map,  mouseX, mouseY)) 
		{
			fill(255,255,255);
			//text((String)lastClicked.getProperty("name"),mouseX,mouseY);
			//String out=(String)marker.getId()+"   "+  lifeExpMap.get(marker.getId());
			//text(out,mouseX,mouseY);
			text((String)marker.getProperty("name"),mouseX,mouseY);
			return;
		}
	}}

	private void selectMarkerIfHover(List<Marker> markers)
	{
		// Abort if there's already a marker selected
		if (lastSelected != null) {
			return;
		}
		
		for (Marker marker : markers) 
		{
			
			if (marker.isInside(map,  mouseX, mouseY)) {
				lastSelected = marker;
				fill(100,200,0);
				String out=(String)marker.getId()+"   "+  lifeExpMap.get(marker.getId());
				text(out,mouseX,mouseY);
				
			}
		}
	}
	
	public void draw() {
		// Draw map tiles and country markers
		background(10);
		map.draw();
	}

	//Helper method to color each country based on life expectancy
	//Red-orange indicates low (near 40)
	//Blue indicates high (near 100)
	private void shadeCountries() {
		for (Marker marker : countryMarkers) {
			// Find data for country of the current marker
			String countryId = marker.getId();
			System.out.println(lifeExpMap.containsKey(countryId));
			if (lifeExpMap.containsKey(countryId)) {
				float lifeExp = lifeExpMap.get(countryId);
				// Encode value as brightness (values range: 40-90)
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			}
			else {
				marker.setColor(color(150,150,150));
			}
		}
	}


}
