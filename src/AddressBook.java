import java.util.ArrayList;

public class AddressBook {
	private ArrayList<BuddyInfo> buddies = new ArrayList<>();
	
	
	public void addBuddy(BuddyInfo bi) {
		buddies.add(bi);
	}
	
	public void removeBuddy(BuddyInfo bi) {
		buddies.remove(bi);
		
	}
	
	public static void main(String args[]) {
		System.out.print("Top Kek");
		BuddyInfo bi = new BuddyInfo("Bhavik");
		BuddyInfo bi2 = new BuddyInfo("Taz");
		AddressBook ab = new AddressBook();
		ab.addBuddy(bi);
		ab.addBuddy(bi2);
		ab.removeBuddy(bi);
		ab.removeBuddy(bi2);
	}
}
