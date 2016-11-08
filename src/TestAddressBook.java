import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAddressBook {
	private AddressBook addressBook;
	private BuddyInfo buddy1;
	private BuddyInfo buddy2;
	private BuddyInfo buddy3;
	
	@Before
	public void setUp() throws Exception {
		addressBook = new AddressBook();
		buddy1 = new BuddyInfo("Bhavik", 19, 2222222);
		buddy2 = new BuddyInfo("Taz", 19, 3333333);
		buddy3 = new BuddyInfo("Kshamina", 20, 4444444);
		addressBook.addBuddy(buddy1);
		addressBook.addBuddy(buddy2);
		addressBook.addBuddy(buddy3);
	}

	@After
	public void tearDown() throws Exception {
		addressBook = null;
		buddy1 = null;
		buddy2 = null;
		buddy3 = null;
	}

	@Test
	public void test() {
		assertEquals("Testing size", 3, addressBook.size());
	}
	
	@Test
	public void clear(){
		addressBook.clear();
		assertEquals("Testing clear", 0, addressBook.size());
	}


}
