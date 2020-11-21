// Esqueleto da classe na qual devem ser implementadas as novas funcionalidades de desenho

public class ImageEx extends Image {
	static final int ANGLE_30 = 30;

	public ImageEx(int w, int h, int r, int g, int b){

		super(w, h, r, g, b);
	}

	public ImageEx(int w, int h){

		super(w, h);
	}

	public void kochCurve(int px, int py, int qx, int qy, int l){
		long c = distanceBetween2Points(px, py, qx, qy);
		if (c < l) {
			drawLine(px,py,qx,qy);
		}else {
			long[] A,B,C;
			long hip = Math.round(c/3d);
			A = calculateA(hip, px, py);
//			B = calculateB(px,py,qx,qy);
//			C = calculateC(px,py);

		}

	}

	private long[] calculateA(long hip, int ax, int ay) {
		long catOp = Math.round(Math.sin(ANGLE_30));
		long catAdj = Math.round(Math.cos(ANGLE_30));

		return new long[]{ax + catOp, ay - catAdj};	}

	private int[] calculateB(int i, int i1) {

		return new int[]{1, 2, 3};	}

	private int[] calculateC(int i, int i1) {

		return new int[]{1, 2, 3};
	}

	public void regionFill(int x, int y, int reference_rgb){

	}

	private static long distanceBetween2Points(int px, int py, int qx, int qy) {
		double c = Math.sqrt(squared(py - px) + squared(qy - qx));

		return Math.round(c);
	}

	private static double squared(double coefficient){
		return Math.pow(2,coefficient);
	}


}
