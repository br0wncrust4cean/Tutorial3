import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AddressBookController implements ActionListener {
	private DefaultListModel<BuddyInfo> buddies;
	private Menu menu;
	
	public AddressBookController(DefaultListModel<BuddyInfo> buddies, Menu menu){
		this.buddies = buddies;
		this.menu = menu;
	}
	
	public void add(){
		BuddyInfo b = new BuddyInfo();
		String name = JOptionPane.showInputDialog("Enter a Name");
		String age = JOptionPane.showInputDialog("Enter an Age");
		b.setName(name);
		b.setAge(Integer.parseInt(age));
		this.buddies.addElement(b);
	}
	
	public void edit(int i){
		BuddyInfo temp = buddies.get(i);
		String phoneNumber = JOptionPane.showInputDialog("Change Phone Number");
		temp.setPhoneNumber(Integer.parseInt(phoneNumber));
		buddies.remove(i);
		buddies.addElement(temp);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("add")){
			add();
		} else if (e.getActionCommand().equals("edit")) {
			edit(menu.getAddressList().getSelectedIndex());
		}
	}
}
