package app.ui;

import app.model.SceneModel;

import javax.swing.JPanel;

/**
 * View (client only). Right panel: draws the wireframe and contains the Cube and
 * Pyramid buttons.
 */
public class ViewPanel extends JPanel implements SceneModel.Listener {

    /**
     * @pre model non-null
     * @post registered as a listener of model; Cube button highlighted; shape drawn
     */
    public ViewPanel(SceneModel model) {
        // TODO implement
    }

    /** Model changed: highlight the selected shape's button and repaint. */
    @Override
    public void sceneChanged() {
        // TODO implement
    }

    /**
     * Draws model.getTransformedMesh() as a wireframe: fixed camera (30 deg about
     * y then 20 deg about x), orthographic projection, centered, scaled so the
     * original cube fills ~40% of the smaller panel dimension, clipped to bounds.
     */
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        // TODO implement
    }

    /** Cube/Pyramid button pressed: calls model.selectShape(type). */
    void handleShapeButton(app.geometry.Shapes.Type type) {
        // TODO implement
    }
}
