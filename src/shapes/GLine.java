package shapes;

import java.awt.geom.Line2D;
import constants.GConstants.EDrawingType;

public class GLine extends GShape {
	private Line2D line;
	public GLine() {
		super(EDrawingType.TP, new Line2D.Double(0, 0, 0, 0));
		this.line = (Line2D.Double)this.getShape();
	}
	@Override
	public void setLocation(int x, int y) {
		line.setLine(x, y, x, y);
	}
	@Override
	public void addPoint(int x, int y) {
	}
	@Override
	public void moveShape(int x, int y) {

		px = x;
		py = y;
	}
	@Override
	public void resizeShape(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
