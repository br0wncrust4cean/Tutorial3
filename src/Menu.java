import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class Menu extends JFrame implements Observer{
	
	private DefaultListModel<BuddyInfo> buddies;
	private AddressBookController controller;
	private JPanel addressList;
	private JPanel buttons;
	private JList<BuddyInfo> addresses;
	private JButton add;
	private JButton edit;
	
	public Menu(){
		super();
		buddies = new DefaultListModel<BuddyInfo>();
		controller = new AddressBookController(buddies, this);
		buddies.addElement(new BuddyInfo("Bhavik", 19, 31313131));
		buddies.addElement(new BuddyInfo("Taz", 20, 2121212));
		buddies.addElement(new BuddyInfo("Kshamina", 20, 42424242));
		buddies.addElement(new BuddyInfo("Supriya", 19, 5151515));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		addressList = new JPanel();
		addressList.setLayout(new BorderLayout());
		buttons = new JPanel();
		addressList.setSize(300, 300);
		
		addresses = new JList<BuddyInfo>(buddies);
		addresses.setSize(300, 300);
		
		add = new JButton("Add");
		add.setActionCommand("add");
		add.addActionListener(controller);
		edit = new JButton("Edit");
		edit.setActionCommand("edit");
		edit.addActionListener(controller);
		
		addressList.add(addresses);
		buttons.add(add);
		buttons.add(edit);
		
		this.add(addresses, BorderLayout.NORTH);
		this.add(buttons, BorderLayout.SOUTH);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg){
		
	}
	
	public JList<BuddyInfo> getAddressList(){
		return this.addresses;
	}
	/*@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addBuddyInfo){
			createBuddy = new JButton("Create Buddy");
			this.add(createBuddy);
			SwingUtilities.updateComponentTreeUI(this);
		} 
	}*/
}
