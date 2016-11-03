package menus;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GConstants;

public class GFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public GFileMenu() {
		super(GConstants.FILEMENU_TITLE);
		for (int i=0; i<GConstants.EFileMenuItem.values().length; i++) {
			JMenuItem menuItem = new JMenuItem(
					GConstants.EFileMenuItem.values()[i].getText());
			this.add(menuItem);
		}
	}		
}
