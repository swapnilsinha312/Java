package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	public void draw(PGraphics pg, float x, float y) {
		// For starter code just drawMaker(...)
		if (!hidden) {
			drawMarker(pg, x, y);
			if (selected) {
				showTitle(pg, x, y);  // You will implement this in the subclasses
			}
		}
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(100,200,0);
		pg.ellipse(x, y, 10,10);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, 
		pg.textWidth(getTitle()) +6, 18, 5);
		pg.fill(0);
		pg.text(getTitle(), x + 3 , y +18);
		// show routes
		
		
	}
	public String getTitle() {
		return (String) getProperty("title");	
		
	}
	
	
}
