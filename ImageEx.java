// Esqueleto da classe na qual devem ser implementadas as novas funcionalidades de desenho

public class ImageEx extends Image {

    public ImageEx(int w, int h, int r, int g, int b) {

        super(w, h, r, g, b);
    }

    public ImageEx(int w, int h) {

        super(w, h);
    }

    public void kochCurve(int px, int py, int qx, int qy, long l) {
        long c = distanceBetween2Points(px, py, qx, qy);
        if (c < l) {
            drawLine(px, py, qx, qy);
            return;
        }

        /** Calcula A,B e C **/
        //Inicializa variáveis
        double[] A = new double[2], B = new double[2], C = new double[2], M = new double[2];

        //Calcula A e C
        A[0] = findPointInLine(1 / 3d, px, qx);
        A[1] = findPointInLine(1 / 3d, py, qy);
        C[0] = findPointInLine(2 / 3d, px, qx);
        C[1] = findPointInLine(2 / 3d, py, qy);

        //Inicializa as variáveis
        double[] v = new double[2], rv = new double[2], u = new double[2];
        int ax, ay, bx, by, cx, cy;

        //Calcula B
        M[0] = findPointInLine(1 / 2d, px, qx);
        M[1] = findPointInLine(1 / 2d, py, qy);
        v[0] = qx - px;
        v[1] = qy - py;
        rv[0] = v[1];
        rv[1] = v[0] * -1;
        u[0] = rv[0] * (Math.sqrt(3) / 6);
        u[1] = rv[1] * (Math.sqrt(3) / 6);
        B[0] = M[0] + u[0];
        B[1] = M[1] + u[1];

        //Faz arredondamento para int nas funções
        ax = (int) Math.round(A[0]);
        ay = (int) Math.round(A[1]);
        bx = (int) Math.round(B[0]);
        by = (int) Math.round(B[1]);
        cx = (int) Math.round(C[0]);
        cy = (int) Math.round(C[1]);

        //Chama as funções recursivamente
        kochCurve(px, py, ax, ay, l);
        kochCurve(ax, ay, bx, by, l);
        kochCurve(bx, by, cx, cy, l);
        kochCurve(cx, cy, qx, qy, l);
    }

    public void regionFill(int x, int y, int reference_rgb) {

    }

    public double findPointInLine(double alpha, int P, int Q) {
        return (1 - alpha) * P + alpha * Q;
    }

    private static long distanceBetween2Points(int px, int py, int qx, int qy) {
        double c = Math.sqrt(squared(qx - px) + squared(qy - py));

        return Math.round(c);
    }

    private static double squared(double coefficient) {
        return Math.pow(coefficient, 2);
    }
}
