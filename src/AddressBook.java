import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AddressBook extends Observable implements Serializable{
	
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
	
	public void setBuddies(ArrayList<BuddyInfo> buddies){
		this.buddies = buddies;
	}
	
	public ArrayList<BuddyInfo> getBuddies(){
		return buddies;
	}
	
	public static AddressBook importFile(){
		AddressBook retBook = new AddressBook();
		try {
			File f = new File("C:\\Users\\bhaviktailor\\Desktop\\AddressBook.txt");
			Scanner s = new Scanner(f);
			//s.useDelimiter(System.getProperty("line.separator"));
			while(s.hasNext()){
				BuddyInfo b = BuddyInfo.importBuddy(s.nextLine());
				retBook.addBuddy(b);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retBook;
	}
	
	public void export(){
		try {
			
			File f = new File("C:\\Users\\bhaviktailor\\Desktop\\AddressBook.txt");
			FileOutputStream fos = new FileOutputStream(f);
			for(BuddyInfo buddy: buddies){
				fos.write(buddy.toString().getBytes());
				fos.write("\n".getBytes());
			}
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*for(BuddyInfo buddy: buddies){
			System.out.println(buddy.toString());
		}*/
	}
	
	public void exportObject(){
		try {
			File f = new File("C:\\Users\\bhaviktailor\\Desktop\\AddressBook.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream ops = new ObjectOutputStream(fos);
			ops.writeObject(buddies);
			ops.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BuddyInfo> importObject(){
		ArrayList<BuddyInfo> retArr = null;
		try {
			File f = new File("C:\\Users\\bhaviktailor\\Desktop\\AddressBook.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			retArr = (ArrayList<BuddyInfo>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			
		}
		return retArr;
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
	
	@Override
	public boolean equals(Object o){
		if (o == this) return true;
		if (!(o instanceof AddressBook) || o == null) return false;
		
		AddressBook book = (AddressBook) o;
		
		return book.getBuddies().equals(this.buddies);
	}
	
	public static void main(String args[]){
		/*BuddyInfo b1 = new BuddyInfo("Bhavik", 19, 212121);
		BuddyInfo b2 = new BuddyInfo("Taz", 20, 2333331);
		AddressBook a1 = new AddressBook();
		a1.addBuddy(b1);
		a1.addBuddy(b2);
		a1.exportObject();*/
		
		AddressBook a1 = new AddressBook();
		ArrayList<BuddyInfo> bTemp = a1.importObject();
		a1.setBuddies(bTemp);
		System.out.println(a1.toString());
	}
	
	
	
}
