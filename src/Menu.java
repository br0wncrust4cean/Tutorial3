import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
	
	public Menu(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menu = new JMenuBar();
		
		JMenu addressBook = new JMenu("Address Book");
		JMenu buddyInfo = new JMenu("Buddy Info");
		
		menu.add(addressBook);
		menu.add(buddyInfo);
		
		JMenuItem create = new JMenuItem("Create");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem display = new JMenuItem("Display");
		addressBook.add(create);
		addressBook.add(save);
		addressBook.add(display);
		
		JMenuItem add = new JMenuItem("Add");
		buddyInfo.add(add);
		
		this.setJMenuBar(menu);
		this.setSize(350, 350);
		this.setVisible(true);
	}
}
