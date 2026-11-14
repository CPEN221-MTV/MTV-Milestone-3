package app.math;

/** Immutable 3D vector. Pure data/maths; resides on the client only. */
public final class Vector {

    public final double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @pre other is non-null
     * @return the component-wise sum; neither operand is modified
     */
    public Vector plus(Vector other) {
        // TODO replace with actual implementation
        return this;
    }

    /** @return this vector multiplied by scalar k; this is not modified */
    public Vector scale(double k) {
        // TODO replace with actual implementation
        return this;
    }
}
