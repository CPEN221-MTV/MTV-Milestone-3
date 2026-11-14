package app.model;

import app.geometry.Mesh;
import app.geometry.Shapes;
import app.math.Matrix;

/**
 * Model (client only). Single source of truth: the selected shape and the
 * cumulative transformation matrix. Notifies listeners after every change.
 * UI panels call its methods directly and listen for changes.
 */
public class SceneModel {

    /** Notified after the selected shape or cumulative matrix changes. */
    public interface Listener {
        /** @post the listener may read the model's new state */
        void sceneChanged();
    }

    /** @post selected shape is CUBE; cumulative matrix is the identity */
    public SceneModel() {
        // TODO implement
    }

    /** @pre listener non-null @post listener is notified on every later change */
    public void addListener(Listener listener) {
        // TODO implement
    }

    /**
     * @pre m non-null
     * @post cumulative matrix = m x (previous cumulative matrix); selected shape
     *       unchanged; listeners notified once
     */
    public void applyMatrix(Matrix m) {
        // TODO implement
    }

    /**
     * @post cumulative matrix is identity; selected shape unchanged; listeners
     *       notified
     */
    public void reset() {
        // TODO implement
    }

    /**
     * @pre type non-null
     * @post selected shape == type; cumulative matrix unchanged; listeners notified
     */
    public void selectShape(Shapes.Type type) {
        // TODO implement
    }

    /** @return the currently selected shape (never null) */
    public app.geometry.Type getSelectedShape() {
        // TODO replace with actual implementation
        return Shapes.Type.CUBE;
    }

    /** @return the cumulative matrix (immutable) */
    public Matrix getCumulativeMatrix() {
        // TODO replace with actual implementation
        return Matrix.identity();
    }

    /**
     * @return the selected shape's original mesh transformed by the cumulative
     *         matrix (cumulative matrix x each original vertex)
     */
    public Mesh getTransformedMesh() {
        // TODO replace with actual implementation
        return null;
    }
}
