import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

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
	
	public String toXML(){
		String info = "<AddressBook>\n";
		
		for(BuddyInfo b: buddies){
			info += b.toXML();
		}
		
		info += "</AddressBook>";
		
		return info;
	}
	
	public void exportToXMLFile(){
		try {
			
			File f = new File("C:\\Users\\bhaviktailor\\Desktop\\AddressBook.xml");
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(this.toXML().getBytes());
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*for(BuddyInfo buddy: buddies){
			System.out.println(buddy.toString());
		}*/
	}
	
	public static AddressBook importFromXMLFileDOM() throws Exception{
		File f = new File("C:\\Users\\bhaviktailor\\Desktop\\AddressBook.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder d = factory.newDocumentBuilder();
		Document doc = d.parse(f);
		doc.getDocumentElement().normalize();
		
		AddressBook newBook = new AddressBook();
		System.out.println("Root: " + doc.getDocumentElement().getNodeName());
		
		NodeList lst = doc.getElementsByTagName("BuddyInfo");
		for(int i = 0; i < lst.getLength(); i++){
			Node n = lst.item(i);
			BuddyInfo tempBud = new BuddyInfo();
			if (n.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) n;
				String name = element.getElementsByTagName("Name").item(0).getTextContent();
				tempBud.setName(name);
				
				int age = Integer.parseInt(element.getElementsByTagName("Age").item(0).getTextContent());
				tempBud.setAge(age);
				
				int phoneNumber = Integer.parseInt(element.getElementsByTagName("PhoneNumber").item(0).getTextContent());
				tempBud.setPhoneNumber(phoneNumber);
			}
			newBook.addBuddy(tempBud);
		}
		return newBook;
	}
	
	public String toString(){
		String info ="";
		for(BuddyInfo b:buddies){
			info += "Name: " + b.getName() + "\nAge: " + b.getAge() + "\nPhoneNumber: " + b.getPhoneNumber() + "\n\n";
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
		BuddyInfo b1 = new BuddyInfo("Bhavik", 19, 212121);
		BuddyInfo b2 = new BuddyInfo("Taz", 20, 2333331);
		AddressBook a1 = new AddressBook();
		a1.addBuddy(b1);
		a1.addBuddy(b2);
		a1.exportToXMLFile();
		AddressBook a2 = new AddressBook();
		try {	
			a2 = AddressBook.importFromXMLFileDOM();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(a2.toString());
		//a1.exportObject();
		
		/*AddressBook a1 = new AddressBook();
		ArrayList<BuddyInfo> bTemp = a1.importObject();
		a1.setBuddies(bTemp);
		System.out.println(a1.toString());*/
	}
	
	
	
}
