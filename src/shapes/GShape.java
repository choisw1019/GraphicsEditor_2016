package shapes;

import java.awt.Graphics2D;
import java.awt.Shape;

import constants.GConstants.EAnchors;
import constants.GConstants.EDrawingType;

abstract public class GShape {
	// attributes
	private EDrawingType eDrawingType;
	private boolean selected;
	private EAnchors currentEAnchor;
	// components
	private Shape shape;	
	private GAnchors anchors;
	// working
	protected int px, py;
	// getters & setters
	public EDrawingType geteDrawingType() {	return eDrawingType;}
	public boolean isSelected() { return selected; }
	public void setSelected(boolean selected) { this.selected = selected; }
	public EAnchors getCurrentEAnchor() {return currentEAnchor;}
	public void setPoint(int x, int y) {
		px = x;
		py = y;
	}

	protected Shape getShape() { return shape;	}
	
	// constructors
	public GShape(EDrawingType eDrawingType, Shape shape){
		this.eDrawingType = eDrawingType;
		this.selected = false;
		this.shape = shape;
		this.anchors = new GAnchors();
		this.currentEAnchor = null;
		px = py =0;
	}
	public GShape clone() {
		try { return this.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	// methods
	public void draw(Graphics2D g2D) {
		g2D.draw(this.shape);
		if (this.selected) {
			this.anchors.draw(g2D, this.shape.getBounds());
		}
	}
	public EAnchors contnains(int x, int y) {
		this.currentEAnchor = null;
		if (this.selected) {
			this.currentEAnchor = this.anchors.contains(x, y);
			if (this.currentEAnchor != null)
				return this.currentEAnchor;
		}
		if (this.shape.contains(x, y)) {
			this.currentEAnchor = EAnchors.MM;
		}
		return this.currentEAnchor;
	}
	abstract public void setLocation(int x, int y);
	abstract public void addPoint(int x, int y);
	abstract public void moveShape(int x, int y);
	abstract public void resizeShape(int x, int y);
}
