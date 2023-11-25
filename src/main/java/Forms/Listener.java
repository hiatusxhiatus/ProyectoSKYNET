package Forms;

import Classes.JsonUtils;
import Classes.Skynet;
import Forms.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    JButton button;
    Skynet skynet;

    public Listener(JButton button, Skynet skynet) {
        this.button = button;
        this.skynet = skynet;
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(skynet.getWindowRef().getBtnUpload())) {
            skynet.getWindowRef().getPnlBefore().removeAll();
            skynet.getWindowRef().getPnlAfter().removeAll();
            skynet.setPathUpload(JsonUtils.readJsonFileAsString(skynet.getWindowRef().getTxfUploadGraph().getText().trim()));
            skynet.uploadGraph();

        } else if (e.getSource().equals(skynet.getWindowRef().getBtnAnnihilate())) {
            //skynet.setAfterGraph(skynet.convertToDisconnectedGraph(skynet.getBeforeGraph()));
            //skynet.showAfterGraph(skynet.getAfterGraph());
        }

        skynet.getWindowRef().revalidate();
        skynet.getWindowRef().repaint();

    }
}
