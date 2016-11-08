import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBuddyInfo {
	private BuddyInfo buddy;
	private BuddyInfo copyBuddy;
	
	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("Bhavik", 19, 212121);
		copyBuddy = new BuddyInfo(buddy);
		buddy.setAge(17);
	}

	@After
	public void tearDown() throws Exception {
		buddy = null;
		copyBuddy = null;
	}

	@Test
	public void test() {
		assertEquals("Testing if constructor works", 19, copyBuddy.getAge());
		assertFalse("Testing over 18 method", buddy.isOver18());
		assertEquals("Testing Greeting", "Hi there, Bhavik!", buddy.sayHi());
		assertEquals("Testing setAge and getAge", 17, buddy.getAge());
	}
	
}
