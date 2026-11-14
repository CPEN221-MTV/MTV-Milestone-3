package app.ui;

import app.model.SceneModel;

import javax.swing.JPanel;

/** View (client only). Left panel, bottom: the six preset buttons. */
public class PresetPanel extends JPanel {

    /** The six preset buttons, in display order. */
    public enum Preset {
        ROTATE_X, ROTATE_Y, ROTATE_Z, DOUBLE, HALF, RESET
    }

    /** @pre model non-null @post six buttons shown, in the order of Preset */
    public PresetPanel(SceneModel model) {
        // TODO implement
    }

    /**
     * A preset button pressed.
     * 
     * @post ROTATE_X/Y/Z: model.applyMatrix(Matrix.rotationX90()/Y90/Z90)
     * @post DOUBLE: model.applyMatrix(Matrix.scale(2)); HALF: scale(0.5)
     * @post RESET: model.reset()
     * @post matrix input grid text unchanged
     */
    void handlePreset(Preset preset) {
        // TODO implement
    }
}
