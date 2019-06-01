package Controllers;

import View.Panel;
import javafx.scene.layout.VBox;

public class PanelController {

    public static PanelController panelController = new PanelController();

    Panel panel = new Panel();

    public VBox getPanelVBox()
    {
        return panel.getPanel();
    }

    public void setWhoseTurnToPlayLabel(String name)
    {
        Panel.lblPlayersTurn.setText(name);
    }
}
