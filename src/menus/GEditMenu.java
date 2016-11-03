package menus;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GConstants;

public class GEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public GEditMenu() {
		super(GConstants.EDITMENU_TITLE);
		for (GConstants.EEditMenuItem eMenuItem: GConstants.EEditMenuItem.values()) {
			JMenuItem menuItem = new JMenuItem(eMenuItem.getText());
			this.add(menuItem);
		}
	}
}
