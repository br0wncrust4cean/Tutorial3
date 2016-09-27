
public class BuddyInfo {
	private String name = "Taz";
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

	private int age = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuddyInfo me = new BuddyInfo();
		System.out.println("Hello " + me.getName());
	}
}
