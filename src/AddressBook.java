import java.util.ArrayList;
import java.util.Observable;
import java.awt.event.*;

public class AddressBook extends Observable{
	
	private ArrayList<BuddyInfo> buddies = new ArrayList<>();
	
	
	public void addBuddy(BuddyInfo bi) {
		buddies.add(bi);
	}
	
	public void removeBuddy(BuddyInfo bi) {
		buddies.remove(bi);
		
	}
	
	public int size(){
		return buddies.size();
	}
	
	public void clear(){
		buddies.clear();
	}
	
	public String toString(){
		String info ="";
		for(BuddyInfo b:buddies){
			info += "Name: " + b.getName() + "\nAge: " + b.getAge() + "\n\n";
		}
		return info;
	}
	
}
