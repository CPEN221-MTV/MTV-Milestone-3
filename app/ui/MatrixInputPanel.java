package app.ui;

import app.model.SceneModel;
import app.net.MatrixOfTheDayClient;

import javax.swing.JPanel;

/**
 * View (client only). Left panel, top: 3x3 text field grid, Apply button,
 * "Matrix of the Day" button with its date label, and error message. Parses and validates the text, then calls the SceneModel.
 */
public class MatrixInputPanel extends JPanel implements SceneModel.Listener {

    /** @pre model and client non-null @post registered as a listener of model; grid shows identity; no error displayed */
    public MatrixInputPanel(SceneModel model, MatrixOfTheDayClient client) {
        // TODO implement
    }

    /**
     * Apply pressed. Reads the 9 field strings.
     * @post if every field is a valid number (optional "-", digits, optional ".",
     *       digits): model.applyMatrix(M) called once, error cleared
     * @post otherwise: model not called; an error message is shown and each
     *       invalid field highlighted
     * @post grid text unchanged in both cases
     */
    void handleApply() {
        // TODO implement
    }

    /**
     * "Matrix of the Day" button pressed.
     * @post the button is disabled until the request finishes; UI stays responsive
     * @post on success: the 9 fields hold the returned matrix (row-major), the date
     *       label shows "Matrix of the Day: YYYY-MM-DD"; the model is NOT called
     * @post on failure: grid unchanged; error "Could not load the Matrix of the Day."
     *       shown; the button is enabled again
     */
    void handleLoadDaily() {
        // TODO implement
    }

    /** Model changed (preset, shape change, or valid Apply): clears any error. */
    @Override
    public void sceneChanged() {
        // TODO implement
    }

    /** @post no error message and no highlighted fields; grid text unchanged */
    public void clearError() {
        // TODO implement
    }
}
