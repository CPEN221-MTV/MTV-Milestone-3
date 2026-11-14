package app.math;

/** Immutable 3x3 matrix (row-major). Pure maths; resides on the client only. */
public final class Matrix {

    /**
     * @pre m is a 3x3 array of finite doubles; m[row][col]. The array is copied.
     */
    public Matrix(double[][] m) {
        // TODO implement
    }

    /** @return the 3x3 identity matrix */
    public static Matrix identity() {
        // TODO replace with actual implementation
        return null;
    }

    /** @return [[1,0,0],[0,0,-1],[0,1,0]]: 90 degrees counterclockwise about +x */
    public static Matrix rotationX90() {
        // TODO replace with actual implementation
        return null;
    }

    /** @return [[0,0,1],[0,1,0],[-1,0,0]]: 90 degrees counterclockwise about +y */
    public static Matrix rotationY90() {
        // TODO replace with actual implementation
        return null;
    }

    /** @return [[0,-1,0],[1,0,0],[0,0,1]]: 90 degrees counterclockwise about +z */
    public static Matrix rotationZ90() {
        // TODO replace with actual implementation
        return null;
    }

    /** @return k times the identity, i.e. uniform scale by k */
    public static Matrix scale(double k) {
        // TODO replace with actual implementation
        return null;
    }

    /** @pre 0 <= row, col <= 2 @return the element at (row, col) */
    public double get(int row, int col) {
        // TODO replace with actual implementation
        return 0;
    }

    /**
     * @pre other is non-null
     * @return the matrix product this x other; neither operand is modified
     */
    public Matrix times(Matrix other) {
        // TODO replace with actual implementation
        return this;
    }

    /**
     * @pre v is non-null
     * @return the vector this x v; v is not modified
     */
    public Vector times(Vector v) {
        // TODO replace with actual implementation
        return v;
    }
}
