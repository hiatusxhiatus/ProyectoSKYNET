package Forms;

import Classes.AnnihilationsAlgorithms;
import Classes.JsonUtils;
import Classes.Skynet;
import Forms.Window;
import Graphs.CustomVertex;
import Graphs.CustomWeightedEdge;
import org.jgrapht.Graph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Listener implements ActionListener {

    private JButton button;
    private Skynet skynet;
    private int annihilateCode;

    public Listener(JButton button, Skynet skynet)
    {
        this.button = button;
        this.skynet = skynet;
        this.annihilateCode = -1;
        button.addActionListener(this);
    }

    // CLASS METHODS

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(skynet.getWindowRef().getBtnUpload()))
        {
                skynet.getWindowRef().getPnlBefore().removeAll();
                skynet.getWindowRef().getPnlAfter().removeAll();
                skynet.setPathUpload(JsonUtils.readJsonFileAsString(skynet.getWindowRef().getTxfUploadGraph().getText().trim()));
                skynet.uploadGraph();

        } else if (e.getSource().equals(skynet.getWindowRef().getBtnAnnihilate())) {

            switch (skynet.getWindowRef().getCbxAnnihilateCode().getSelectedIndex()+1)
            {
                case 1:
                    if (skynet.getBeforeGraph() != null)
                    {
                        skynet.setAfterGraph(AnnihilationsAlgorithms.type1Annihilation(skynet.getBeforeGraph(), 1));
                        skynet.showAfterGraph(skynet.getAfterGraph());
                    }
                    else
                        JOptionPane.showMessageDialog(skynet.getWindowRef(), "BEFORE GRAPH IS NULL", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                    if(AnnihilationsAlgorithms.type2Annihilation(skynet.getBeforeGraph()) != null){

                        AnnihilationsAlgorithms.changeWeightValue(skynet.getBeforeGraph(),1);
                        skynet.setAfterGraph(AnnihilationsAlgorithms.type2Annihilation(skynet.getBeforeGraph()));
                        skynet.showAfterGraph(skynet.getAfterGraph());

                        Timer timer = new Timer(10000, e1 -> {

                            skynet.getWindowRef().getPnlAfter().removeAll();

                            List<CustomWeightedEdge> edges = AnnihilationsAlgorithms.getMinimumSpanningTreeEdges(skynet.getBeforeGraph());
                            AnnihilationsAlgorithms.addEdgesToList(skynet.getBeforeGraph(),edges);

                            skynet.setBeforeGraph(AnnihilationsAlgorithms.removeEdges(skynet.getBeforeGraph(),edges));

                            skynet.showAfterGraph(skynet.getBeforeGraph());

                            skynet.getWindowRef().getPnlAfter().revalidate();
                            skynet.getWindowRef().getPnlAfter().repaint();

                        });

                        timer.setRepeats(false);
                        timer.start();

                    }
                    else
                        JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 2", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                    if (AnnihilationsAlgorithms.canConvertToDirected(skynet.getBeforeGraph()))
                    {
                        JComponent newComponent = AnnihilationsAlgorithms.type3Annihilation(skynet.getBeforeGraph());

                        if(AnnihilationsAlgorithms.isConnected(skynet.getBeforeGraph()))
                            skynet.getWindowRef().getPnlAfter().add(newComponent);

                        else JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT CONVERT TO DIRECTED GRAPH", "ERROR", JOptionPane.ERROR_MESSAGE);

                    } else
                        JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 3", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                case 5:

                    //skynet.setBeforeGraph(AnnihilationsAlgorithms.convertToDirectedGraph(skynet.getBeforeGraph()));
                    List<CustomWeightedEdge> edgeList = AnnihilationsAlgorithms.type5Annihilation(skynet.getBeforeGraph());

                    if (edgeList != null){
                        JOptionPane.showMessageDialog(skynet.getWindowRef(), "EURELIAN PATH FOUNDED.\n RESULTS SHOWED IN CONSOLE");

                        String str = "";

                        for (CustomWeightedEdge edge : edgeList) {
                            CustomVertex sourceVertex = skynet.getBeforeGraph().getEdgeSource(edge);
                            CustomVertex targetVertex = skynet.getBeforeGraph().getEdgeTarget(edge);
                            //System.out.println("->> Source: " + sourceVertex.getId() + ", Target: " + targetVertex.getId());
                            str  = str + "->> Source: " + sourceVertex.getId() + ", Target: " + targetVertex.getId() + "\n";
                        }

                        System.out.println(str);

                        /*
                        System.out.println(skynet.getConsoleMenu().getTxaEulerianPath().getText());
                        skynet.getConsoleMenu().getTxaEulerianPath().setText("AAAAAAAAAAAAAAAAAA");
                        skynet.getConsoleMenu().setVisible(true);
                        skynet.getConsoleMenu().getTxaEulerianPath().revalidate();
                        skynet.getConsoleMenu().getTxaEulerianPath().repaint();
                        */


                    } else
                        JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 5", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                case 6:
                    List<CustomWeightedEdge> edgeList_ = AnnihilationsAlgorithms.type5Annihilation(skynet.getBeforeGraph());

                    if (edgeList_ != null) {

                        JOptionPane.showMessageDialog(skynet.getWindowRef(), "EURELIAN PATH FOUNDED.\n RESULTS SHOWED IN CONSOLE");
                        System.out.println("\n>> SEQUENCE OF EDGES OF THE EULERIAN PATH<<\n");

                        String str = "";

                        for (CustomWeightedEdge edge : edgeList_) {
                            CustomVertex sourceVertex = skynet.getBeforeGraph().getEdgeSource(edge);
                            CustomVertex targetVertex = skynet.getBeforeGraph().getEdgeTarget(edge);
                            str += "->> Source: " + sourceVertex.getId() + ", Target: " + targetVertex.getId() + "\n";
                        }

                        skynet.setAfterGraph(AnnihilationsAlgorithms.type6Annihilation(skynet.getBeforeGraph(), edgeList_));
                        skynet.showAfterGraph(skynet.getAfterGraph());


                        System.out.println(str);
                        /*
                        //skynet.getConsoleMenu().getTxaConsole().setText(str);
                        skynet.getConsoleMenu().setVisible(true);
                        skynet.getConsoleMenu().revalidate();
                        skynet.getConsoleMenu().repaint();

                        */

                    } else
                        JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 6", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                case 7:
                    skynet.selectCitiesMenu();
                    break;
                case 8:
                    skynet.selectCitiesMenu();
                    break;
                case 10:
                    skynet.selectCitiesMenu();
                    break;
            }

        } else if (e.getSource().equals(skynet.getCitiesMenuRef().getBtnAccept())) {

            if (skynet.getWindowRef().getCbxAnnihilateCode().getSelectedIndex()+1 == 7)
            {

                skynet.setFirstCity(skynet.getVerticesArray().get(Integer.parseInt(skynet.getCitiesMenuRef().getTxfFirst().getText())-1));
                skynet.setSecondCity(skynet.getVerticesArray().get(Integer.parseInt(skynet.getCitiesMenuRef().getTxfSecond().getText())-1));
                AnnihilationsAlgorithms.changeWeightValue(skynet.getBeforeGraph(), 3);

                List <CustomWeightedEdge> shortestPath = AnnihilationsAlgorithms.findShortestPath(skynet.getBeforeGraph(), skynet.getFirstCity(), skynet.getSecondCity());

                AnnihilationsAlgorithms.addEdgesToList(skynet.getBeforeGraph(), shortestPath);

                skynet.setAfterGraph(AnnihilationsAlgorithms.type7Annihilation(skynet.getBeforeGraph(), shortestPath));
                skynet.showAfterGraph(skynet.getAfterGraph());

            } else if (skynet.getWindowRef().getCbxAnnihilateCode().getSelectedIndex()+1 == 8) {

                skynet.setFirstCity(skynet.getVerticesArray().get(Integer.parseInt(skynet.getCitiesMenuRef().getTxfFirst().getText())-1));
                skynet.setSecondCity(skynet.getVerticesArray().get(Integer.parseInt(skynet.getCitiesMenuRef().getTxfSecond().getText())-1));
                AnnihilationsAlgorithms.changeWeightValue(skynet.getBeforeGraph(), 2);

                List <CustomWeightedEdge> shortestPath_ = AnnihilationsAlgorithms.findShortestPath(skynet.getBeforeGraph(), skynet.getFirstCity(), skynet.getSecondCity());

                AnnihilationsAlgorithms.addEdgesToList(skynet.getBeforeGraph(), shortestPath_);

                skynet.setAfterGraph(AnnihilationsAlgorithms.type7Annihilation(skynet.getBeforeGraph(), shortestPath_));
                skynet.showAfterGraph(skynet.getAfterGraph());

            } else if (skynet.getWindowRef().getCbxAnnihilateCode().getSelectedIndex()+1 == 10) {

                skynet.setFirstCity(skynet.getVerticesArray().get(Integer.parseInt(skynet.getCitiesMenuRef().getTxfFirst().getText())-1));
                skynet.setSecondCity(skynet.getVerticesArray().get(Integer.parseInt(skynet.getCitiesMenuRef().getTxfSecond().getText())-1));
                AnnihilationsAlgorithms.changeWeightValue(skynet.getBeforeGraph(), 2);

                skynet.setAfterGraph(AnnihilationsAlgorithms.type10Annihilation(skynet.getBeforeGraph(), skynet.getFirstCity(), skynet.getSecondCity()));
                skynet.showAfterGraph(skynet.getAfterGraph());

            }

            skynet.getCitiesMenuRef().setVisible(false);
            skynet.getCitiesMenuRef().getTxaFirst().setText("");
            skynet.getCitiesMenuRef().getTxaSecond().setText("");
            skynet.getCitiesMenuRef().getTxfFirst().setText("");
            skynet.getCitiesMenuRef().getTxfSecond().setText("");

        } else if (e.getSource().equals(skynet.getConsoleMenu().getBtnAccept())) {

            //skynet.getConsoleMenu().getTxaConsole().setText("");
            skynet.getConsoleMenu().setVisible(false);

        }

        skynet.getWindowRef().revalidate();
        skynet.getWindowRef().repaint();

    }
}
