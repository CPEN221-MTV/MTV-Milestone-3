package app.geometry;

import app.math.Matrix;
import app.math.Vector;

/** Immutable wireframe: vertices plus edges (index pairs). Client only. */
public final class Mesh {

    /**
     * @pre vertices and edges non-null; every edge index is in [0, vertices.length)
     */
    public Mesh(Vector[] vertices, int[][] edges) {
        // TODO implement
    }

    /** @return a copy of the vertices */
    public Vector[] getVertices() {
        // TODO replace with actual implementation
        return new Vector[0];
    }

    /** @return a copy of the edges; each entry is {indexA, indexB} */
    public int[][] getEdges() {
        // TODO replace with actual implementation
        return new int[0][0];
    }

    /**
     * @pre m is non-null
     * @return a new Mesh with every vertex v replaced by m x v and the same edges;
     *         this mesh is not modified
     */
    public Mesh transform(Matrix m) {
        // TODO replace with actual implementation
        return this;
    }
}
