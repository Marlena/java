package vacuum;


import junit.framework.*;

public class TestVacuum extends TestCase {
	
	public TestVacuum (String s){
		
		super(s);
	}
	
	public void testPrintVacuum(){
		
		Vacuum v = new Vacuum();
		
		assertEquals("vacuum size is 4", 4, v.getTheVacuumSize());
		
		assertEquals("character at vacuum home col:0, row:0 is <", '<', v.getVacuumLocationVal(0, 0));
		
		assertEquals("character at vacuum home location is <", '<', v.getVacuumLocationVal(v.getHomeLocation()));
		
		boolean numDirtyisValid = false;
		
		if ((v.getTheFloor().getNumDirty()==1) ||(v.getTheFloor().getNumDirty()==2)|| (v.getTheFloor().getNumDirty()==3) || (v.getTheFloor().getNumDirty()==4) )
			numDirtyisValid=true;
		
		assertTrue("num of dirty squares is 1, 2,3 or 4 ", numDirtyisValid);
		
		//v.printVacuum();
	}
	
	public void testInitLocationsVacuum(){
		
		Vacuum v = new Vacuum();
		
		assertEquals("location 1,0 is blank space", ' ', v.getVacuumLocationVal(1, 0));
		assertEquals("location 0,1 is blank space", ' ', v.getVacuumLocationVal(0, 1));
		assertEquals("location 1,1 is blank space", ' ', v.getVacuumLocationVal(1, 1));
		
	}
	
	public void testVacuumDecideTrue(){
		Vacuum v = new Vacuum();
		
		Location l1 = new Location (0,1);
		v.addPastLocation(new Location (0,1));
		
		assertTrue("vacuum already visited 0,1", v.haveIBeenThere(new Location(0,1)));
		
	}
	
	/*public void testVacuumDecideFalse(){
		
		Vacuum v = new Vacuum();
		
		Location l1 = new Location (1,1);
		v.addPastLocation(new Location (0,1));
		
		assertFalse("vacuum has not visited 0,1", v.haveIBeenThere(new Location(1,1)));
		
		
	}*/
	
	

}
