package guiModule;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PApplet;
import processing.core.PImage;

public class MyDisplay extends PApplet{
	
	private UnfoldingMap map;

	public void setup() {
		
		Location valloc = new Location(-38.14f, -73.03f);
		Feature valEq = new PointFeature(valloc);
		valEq.addProperty("title", "Valdivia, Chile");
		valEq.addProperty("Magnitude", "9,5");
		valEq.addProperty("date", "May 22, 1996");
		valEq.addProperty("Year", "1996");
		
		Marker valMk = new SimplePointMarker(valloc, valEq.getProperties());
		map.addMarker(valMk);
	}
	
	public void draw() {
		
		fill(255, 255, 0);
		ellipse(200, 200, 390, 390);
		fill(0,0,0);
		ellipse(120, 130, 50, 70);
		ellipse(280, 130, 50, 70);
		arc(200, 280, 75, 75, 0, PI);
		
	}
}
