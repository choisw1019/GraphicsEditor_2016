package frames;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import constants.GConstants.EDrawingType;
import shapes.GShape;

public class GDrawingPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// object states
	private enum EState {idle, drawing};
	// components
	private Vector<GShape> shapeVector;	
	// associative attributes
	private GShape selectedShape;
	public void setSelectedShape(GShape selectedShape) {
		this.selectedShape = selectedShape;
	}	
	// working objects;
	private GShape currentShape;
	
	public GDrawingPanel() {
		MouseEventHandler mouseEventHandler = new MouseEventHandler();
		this.addMouseListener(mouseEventHandler);
		this.addMouseMotionListener(mouseEventHandler);
		
		this.shapeVector = new Vector<GShape>();
	}
	public void initialize() {
	}
	
	public void paint(Graphics g) {
		for (GShape shape: this.shapeVector) {
			shape.draw((Graphics2D)g);
		}
	}
	
	private void initDrawing(int x, int y) {
		this.currentShape= this.selectedShape.clone();
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.initDrawing(x, y, g2D);
	}
	private void keepDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.keepDrawing(x, y, g2D);
	}
	private void continueDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.continueDrawing(x, y, g2D);
	}
	private void finishDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.finishDrawing(x, y, g2D);
		this.shapeVector.add(this.currentShape);
	}
	
	class MouseEventHandler 
		implements MouseInputListener, MouseMotionListener {
		private EState eState = EState.idle;
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				mouse1Clicked(e);
			} else if (e.getClickCount() == 2) {
				mouse2Clicked(e);
			}
 		}
		private void mouse1Clicked(MouseEvent e) {
			if (eState == EState.idle) {
				if (selectedShape.geteDrawingType() == EDrawingType.NP) {
					initDrawing(e.getX(), e.getY());
					eState = EState.drawing;
					System.out.println("mouse1Clicked/idle");
				}
			} else if (eState == EState.drawing) {	
				continueDrawing(e.getX(), e.getY());			
				System.out.println("mouse1Clicked/drawing");
			}
		}
		private void mouse2Clicked(MouseEvent e) {
			if (eState == EState.drawing) {		
				finishDrawing(e.getX(), e.getY());
				eState = EState.idle;
				System.out.println("mouse2Clicked/drawing");
			}			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if (eState == EState.idle) {
				initDrawing(e.getX(), e.getY());
				eState = EState.drawing;
				System.out.println("mousePressed/idle");
			}		
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if (eState == EState.drawing) {		
				finishDrawing(e.getX(), e.getY());
				eState = EState.idle;
				System.out.println("mouseReleased/drawing");
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			if (eState == EState.drawing) {
				keepDrawing(e.getX(), e.getY());
				System.out.println("mouseMoved/drawing");
			}
		}		
		@Override
		public void mouseDragged(MouseEvent e) {
			if (eState == EState.drawing) {
				keepDrawing(e.getX(), e.getY());
				System.out.println("mouseDragged/drawing");
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
		}
	}

}
