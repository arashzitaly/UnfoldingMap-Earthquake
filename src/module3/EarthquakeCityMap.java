package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.GeoMapApp;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap extends PApplet {

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = false;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	
	public void setup() {
		size(950, 600, OPENGL);

		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new GeoMapApp.TopologicalGeoMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
			
	    // The List you will populate with new SimplePointMarkers
	    List<Marker> markers = new ArrayList<Marker>();

	    //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    //TODO (Step 3): Add a loop here that calls createMarker (see below) 
	    // to create a new SimplePointMarker for each PointFeature in 
	    // earthquakes.  Then add each new SimplePointMarker to the 
	    // List markers (so that it will be added to the map in the line below)
	    
	    for(int i = 0;  i < earthquakes.size(); i++)
	    {
	    	PointFeature f = earthquakes.get(i);
	    	System.out.println(f.getProperties());
	    	Object magObj = f.getProperty("magnitude");
	    	float mag = Float.parseFloat(magObj.toString());
	    	
	    	markers.add(createMarker(f, mag));
//	    	markers.add(new SimplePointMarker(f.getLocation()));
	    	Marker marker = markers.get(i);	    	
	    	
	    	if(mag < THRESHOLD_LIGHT)//Minor earthquakes (less than magnitude 4.0) 
	    	{
	    		marker.setColor(color(0,0,255)); // set marker blue	    		
	    	}else if(mag < THRESHOLD_MODERATE){//Light earthquakes (between 4.0-4.9) 
	    		marker.setColor(color(255,255,0)); // set marker yellow
	    	}else{//Moderate and higher earthquakes (5.0 and over) 
	    		marker.setColor(color(255,0,0)); // set marker red
	    	}
	    	map.addMarker(marker);
	    }
	    
	    
	    // Add the markers to the map so that they are displayed
	    map.addMarkers(markers);
	}
		
	/* createMarker: A suggested helper method that takes in an earthquake 
	 * feature and returns a SimplePointMarker for that earthquake
	 * 
	 * In step 3 You can use this method as-is.  Call it from a loop in the 
	 * setp method.  
	 * 
	 * TODO (Step 4): Add code to this method so that it adds the proper 
	 * styling to each marker based on the magnitude of the earthquake.  
	*/
	private SimplePointMarker createMarker(PointFeature feature, float mg) {  
		
		SimplePointMarker marker = new SimplePointMarker(feature.getLocation());
		// finish implementing and use this method, if it helps.
		
		if(mg < THRESHOLD_LIGHT)//Minor earthquakes (less than magnitude 4.0) 
    	{
    		marker.setRadius(5.0f);// set marker smaller    		
    	}else if(mg < THRESHOLD_MODERATE){//Light earthquakes (between 4.0-4.9) 
    		marker.setRadius(10.0f);// set marker medium
    	}else{//Moderate and higher earthquakes (5.0 and over) 
    		marker.setRadius(20.0f);// set marker bigger
    	}
		return marker;
	}
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}


	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key
	private void addKey() 
	{	
		// Remember you can use Processing's graphics methods here
				/*
				 * canvas
				 */
				int box_x = 20;
				int box_y = 50;
				int box_width = 155;
				int box_height = 250;
				
				fill(240);
				rect(box_x, box_y, box_width, box_height);
				
				/*
				 * tile
				 */	
				String title = "Earthquake Key";
				int title_x = box_x + 75;
				int title_y = box_y + 20;
				int title_size = 14;
				fill(0);
				textAlign(CENTER);
				textSize(title_size);
				text(title, title_x, title_y );  // Text wraps within text box
				
				/*
				 * key1
				 */
				String key1 = "5.0+ Magnitude";
				int key1_x = title_x -  20;
				int key1_y = title_y + 40;
				int key1_size = 12;
				
				fill(0);
				textAlign(LEFT);
				textSize(key1_size);
				text(key1, key1_x, key1_y );  // Text wraps within text box
				
				float key1_icon_width = 17.0f;
				float key1_icon_height = 17.0f;
				int key1_icon_x = key1_x - 30;
				int key1_icon_y = key1_y - (int)key1_icon_height/2;
				
				fill(255, 0, 0);
				ellipse(key1_icon_x, key1_icon_y, key1_icon_width, key1_icon_height);
				
				/*
				 * key2
				 */
				String key2 = "4.0+ Magnitude";
				int key2_x = key1_x;
				int key2_y = key1_y + 50;
				int key2_size = 12;
				
				fill(0);
				textAlign(LEFT);
				textSize(key2_size);
				text(key2, key2_x, key2_y );  // Text wraps within text box
				
				float key2_icon_width = 8.0f;
				float key2_icon_height = 8.0f;
				int key2_icon_x = key2_x - 30;
				int key2_icon_y = key2_y - (int)key2_icon_height/2;
				
				fill(255, 255, 0);
				ellipse(key2_icon_x, key2_icon_y, key2_icon_width, key2_icon_height);
				
				/*
				 * key3
				 */
				String key3 = "Below 4.0";
				int key3_x = key2_x;
				int key3_y = key2_y + 50;
				int key3_size = 12;
				
				fill(0);
				textAlign(LEFT);
				textSize(key3_size);
				text(key3, key3_x, key3_y );  // Text wraps within text box
				
				float key3_icon_width = 3.0f;
				float key3_icon_height = 3.0f;
				int key3_icon_x = key3_x - 30;
				int key3_icon_y = key3_y - (int)key3_icon_height/2;
				
				fill(0, 0, 255);
				ellipse(key3_icon_x, key3_icon_y, key3_icon_width, key3_icon_height);
	
	}
}
