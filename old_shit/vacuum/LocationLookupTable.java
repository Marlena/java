package vacuum;


import java.util.*;
import java.util.Random;


public class LocationLookupTable {
	
	/**
	 * The LocationLookupMap object consist of key value pairs where keys are up, down, left, right and values are arraylists containg locations of squares
	 * Floor locations:
	 * 						[0,0][1,0]
	 * 						[0,1][1,1]
	 * 
	 * if vacuum is in square 	[0][0] -> down || right
	 * 									 [0][1]  [1][0]
	 * 							[1][0] -> down || left
	 * 									 [1][1]  [0][0]
	 * 							[0][1] -> up  || right
	 * 									 [0][0]  [1][1]
	 * 							[1][1] -> up  || left
	 * 									 [1][0]  [0][1]

	 */
	
	
	HashMap <Integer, ArrayList<Location>> mapTable;
	//HashMap<Location, ArrayList> mapTable; //had problems getting keys set for this one.
	ArrayList <Location> zeroZero, zeroOne, oneZero, oneOne;//a row for each location on the 2x2 square
	
	
	public LocationLookupTable(){
		
		
		mapTable = new HashMap <Integer, ArrayList<Location>>();
		
		//create the value lists for the map.  There will be one for each table location
		this.initZeroZero();
		this.initZeroOne();
		this.initOneZero();
		this.initOneOne();
		
		
		Location l = new Location (0,0);
		
		
		
		
		mapTable.put(00, zeroZero);
		mapTable.put(01, zeroOne);
		mapTable.put(10, oneZero);
		mapTable.put(11, oneOne);
		
		
				
	}
	
	public void initZeroZero(){//locations that can be reached from location 0,0
		zeroZero = new ArrayList <Location>();
		zeroZero.add(new Location(0,1));
		zeroZero.add(new Location(1,0));
	}
	
	public void initOneZero(){//locations that can be reached from location 1,0
		
		oneZero = new ArrayList <Location>(); 
		oneZero.add(new Location(1,1));
		oneZero.add(new Location(0,0));
	}
	
	public void initZeroOne(){
		zeroOne = new ArrayList<Location>();//locations that can be reached from location 0,1
		zeroOne.add(new Location(0,0));
		zeroOne.add(new Location(1,1));

	}
	
	public void initOneOne(){//locations that can be reached from location 1,1
		oneOne = new ArrayList<Location>();
		oneOne.add(new Location(1,0));
		oneOne.add(new Location(0,1));
	}

	public HashMap<Integer, ArrayList<Location>> getMapTable() {
		return mapTable;
	}

	public void setMapTable(HashMap<Integer, ArrayList<Location>> mapTable) {
		this.mapTable = mapTable;
	}

	
	
	/**
	 * Takes a location on the 2x2 square and retrieves possible locations the vacuum can move to next.
	 * One of the 2 possible locations are randomly selected and returned.
	 * 
	 */
	public Location getRandomLocationValue(Location l){
		
		ArrayList <Location> locList = new ArrayList <Location>();
		
		if ((l.getColumn()==0) && (l.getRow()==0)){
			//pull values for 00
			locList=this.getMapTable().get(00);
			
		}
		else if ((l.getColumn()==0) && (l.getRow()==1)){
			//pull values for 01
			locList=this.getMapTable().get(01);

		}
		else if ((l.getColumn()==1) && (l.getRow()==0)){
			//pull values for 10
			locList=this.getMapTable().get(10);

		}
		else{
			//pull values for 11
			locList=this.getMapTable().get(11);

		}
		
		//randomly pull 1st or 2nd element from array list.
		Random ranNum = new Random();
		int valIndex = ranNum.nextInt(2);
		
		Location nextLocation = locList.get(valIndex);
		
		
		return nextLocation;
	}
	
	

}
