package vacuum;

import junit.framework.*;
import java.util.*;

public class LocationLookupTableTest extends TestCase{
	
	public LocationLookupTableTest (String s){
		
		super(s);
		
	}
	
	public void testTableConstructor(){
		
		LocationLookupTable t = new LocationLookupTable();
		
		
		
	}
	
	public void testGetLocationsfromMap(){
		
		LocationLookupTable t = new LocationLookupTable();
		
		ArrayList <Location> l = new ArrayList<Location>();
		
		Location zero = new Location (0,0);
		
		
		Integer locZero = new Integer (00);
		l = t.getMapTable().get(00);
		
		assertEquals("there are keys in the map", true, t.getMapTable().containsKey(00));
		
		//Location loc01 = new Location(0,1);
		
		//assertEquals("list for 0,0 has right keys",loc01, l.get(0));

		
	}
	
	public void testGetArrayListfromMap(){
		
		LocationLookupTable t = new LocationLookupTable();
		
		ArrayList <Location> l;
		
		Location zero = new Location (0,0);
		
		l = t.getMapTable().get(00);
		
		
		Location loc01 = l.get(0);

		
		assertEquals("test getting location element from a list", 0, loc01.getColumn());
		
	}
	
	public void testNextLocations(){
		
		LocationLookupTable t = new LocationLookupTable();
		
		ArrayList <Location> locList = new ArrayList<Location>();
		
		Location l00 = new Location(0,0);
		Location l01 = new Location(0,1);
		Location l10 = new Location (1,0);
		Location l11 = new Location (1,1);
		
		boolean isLocationValid = false;
		
		Location locTest = t.getRandomLocationValue(l00);
		
		if ((locTest.getColumn()==0 && locTest.getRow()==1) || (locTest.getColumn()==1 && locTest.getRow()==0));
			isLocationValid =true;
		
		assertTrue("test getting next location for 00", isLocationValid );

		
		
	}

}
