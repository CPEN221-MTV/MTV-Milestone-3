package app.geometry;

/** Factory for the original (untransformed) shapes. Client only; stateless. */
public final class Shapes {

    /** The shapes the user can select. */
    public enum Type {
        CUBE, PYRAMID
    }

    private Shapes() {
    }

    /**
     * @return a Mesh with 8 vertices at (+-1,+-1,+-1) and the 12 edges joining
     *         vertices that differ in exactly one coordinate
     */
    public static Mesh cube() {
        // TODO replace with actual implementation
        return null;
    }

    /**
     * @return a Mesh with base vertices (+-1,-1,+-1), apex (0,1,0), and 8 edges
     *         (4 base edges, 4 base-to-apex edges)
     */
    public static Mesh pyramid() {
        // TODO replace with actual implementation
        return null;
    }

    /** @pre type non-null @return cube() or pyramid() matching type */
    public static Mesh create(Type type) {
        // TODO replace with actual implementation
        return null;
    }
}
