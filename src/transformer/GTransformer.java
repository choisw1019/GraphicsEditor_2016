package transformer;

import java.awt.Graphics2D;
import java.awt.Point;

import shapes.GShape;

abstract public class GTransformer {
	private GShape shape;
	private Point point;
	
	public GShape getShape() { return this.shape; }
	protected void setPoint(Point point) { this.point = point; }
	protected Point getPoint() { return this.point; }
	
	public GTransformer(GShape shape) {
		this.shape = shape;
		this.point = new Point(0, 0);
	}
	abstract public void initTransforming(int x, int y, Graphics2D g2d);
	abstract public void keepTransforming(int x, int y, Graphics2D g2d);
	abstract public void finishTransforming(int x, int y, Graphics2D g2d);	
	abstract public void continueTransforming(int x, int y, Graphics2D g2d);
}
