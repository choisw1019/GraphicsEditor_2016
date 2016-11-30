package shapes;

import java.awt.Polygon;

import constants.GConstants.EDrawingType;

public class GPolygon extends GShape {
	private Polygon polygon;
	public GPolygon() {
		super(EDrawingType.NP, new Polygon());
		this.polygon = (Polygon)this.getShape();
	}
	@Override
	public void setLocation(int x, int y) {
		this.polygon.addPoint(x, y);
		this.polygon.addPoint(x, y);
	}
	@Override
	public void addPoint(int x, int y) {
		this.polygon.addPoint(x, y);
	}
	@Override
	public void moveShape(int x, int y) {
		for (int i=0; i<this.polygon.npoints; i++) {
			this.polygon.xpoints[i] += x - px;
			this.polygon.ypoints[i] += y - py;
		}
		this.polygon.invalidate();
		px = x;
		py = y;
	}
	@Override
	public void resizeShape(int x, int y) {
		// TODO Auto-generated method stub
	}
}
