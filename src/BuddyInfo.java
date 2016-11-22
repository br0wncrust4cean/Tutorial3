
import java.io.Serializable;
import java.util.Scanner;


public class BuddyInfo implements Serializable{
	private String name;
	private int age;
	private int phoneNumber;
	
	public BuddyInfo(){
		this.name = "";
		this.age = 0;
		this.phoneNumber = 0;
	}
	
	public BuddyInfo(BuddyInfo b){
		this.name = b.getName();
		this.age = b.getAge();
		this.phoneNumber = b.getPhoneNumber();
	}
	
	public BuddyInfo(String n){
		this.name = n;
		this.age = 0;
		this.phoneNumber = 0;
	}
	
	public BuddyInfo(String n, int age, int phoneNumber){
		this.name=n;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String sayHi(){
		return "Hi there, " + this.name + "!";
	}
	
	public boolean isOver18(){
		return age > 18;
	}
	
	public static BuddyInfo importBuddy(String s){
		Scanner scan = new Scanner(s).useDelimiter(", ");
		String name = scan.next();
		int age = scan.nextInt();
		int phoneNumber = scan.nextInt();
		return new BuddyInfo(name, age, phoneNumber);
	}
	
	public String toString(){
		//return "Name: " + this.name + "/Age: " + this.age + "/Phone Number: " + this.phoneNumber;
		return name + ", " + age + ", " + phoneNumber;
	}
	
	@Override
	public boolean equals(Object o){
		if (o == this) return true;
		if (!(o instanceof BuddyInfo) || (o == null)) return false;
		BuddyInfo b = (BuddyInfo) o;
		
		return b.getAge() == this.age && b.getName().equals(this.name) && b.getPhoneNumber() == this.phoneNumber;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String buddy = "Bhavik, 20, 212121";
		System.out.println(importBuddy(buddy));
	}
}
