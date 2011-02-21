package vacuum;

import junit.framework.*;

public class LocationTest extends TestCase{
	
	public LocationTest(String s){
		
		super (s);
	}
	
	public void testEquals(){
		
		Location l1 = new Location(2,3);
		
		Location l2 = new Location(2,2);
		
		Location l3 = new Location (2,3);
		
		assertTrue("equals for two same objects", l1.equals(l3));
		
		assertFalse("equals for two different objects", l1.equals(l2));
		
	}
	
	public void testPrint(){
		
		Location l1 = new Location(2,3);
		
		Location l2 = new Location(2,2);
		
		Location l3 = new Location (2,3);
		
		l1.print();
		l2.print();
		l3.print();
		
	}
	
	

}
