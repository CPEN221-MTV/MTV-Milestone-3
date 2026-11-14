package app;

import app.model.SceneModel;
import app.net.MatrixOfTheDayClient;
import app.ui.MatrixInputPanel;
import app.ui.PresetPanel;
import app.ui.ViewPanel;

/**
 * Entry point. Creates the SceneModel, a MatrixOfTheDayClient, and the three UI
 * panels, wires the panels
 * to the model (and the client to MatrixInputPanel), and shows the single
 * application window (left panel:
 * MatrixInputPanel + PresetPanel, right panel: ViewPanel).
 */
public class Main {

    /**
     * @post a window is visible containing all three panels, each registered with
     *       the same SceneModel; the window and its contents resize together
     */
    public static void main(String[] args) {
        // TODO implement
    }
}
