package shapes;

import java.awt.Rectangle;

import constants.GConstants.EDrawingType;

public class GRectangle extends GShape {
	private Rectangle rectangle;
	public GRectangle() {
		super(EDrawingType.TP, new Rectangle(0, 0, 0, 0));
		this.rectangle = (Rectangle)this.getShape();
	}
	public void setLocation(int x, int y) {
		this.rectangle.setLocation(x, y);		
	}
	public void addPoint(int x, int y) {		
	}
	public void moveShape(int x, int y) {
		this.rectangle.x += x - px;
		this.rectangle.y += y - py;
		px = x;
		py = y;
	}
	public void resizeShape(int x, int y) {
		if (this.getCurrentEAnchor()==null) {
			this.rectangle.width = x - this.rectangle.x;
			this.rectangle.height = y - this.rectangle.y;				
			return;
		}
		switch (this.getCurrentEAnchor()) {
		case NN:
			break;
		case NE:
			break;
		case NW:
			break;
		case SS:
			break;
		case SE:
			this.rectangle.width = x - this.rectangle.x;
			this.rectangle.height = y - this.rectangle.y;				
			break;
		case SW:
			break;
		case EE:
			break;
		case WW:
			break;
		default:
			break;
		}
	}
}
