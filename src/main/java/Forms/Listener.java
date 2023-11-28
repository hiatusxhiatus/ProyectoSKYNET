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

            annihilateCode = 1;

            if(annihilateCode == 1){

                if (skynet.getBeforeGraph() != null) {
                    skynet.setAfterGraph(AnnihilationsAlgorithms.type1Annihilation(skynet.getBeforeGraph(), 1));
                    skynet.showAfterGraph(skynet.getAfterGraph());
                }

                else JOptionPane.showMessageDialog(skynet.getWindowRef(), "BEFORE GRAPH IS NULL", "ERROR", JOptionPane.ERROR_MESSAGE);

            } else if (annihilateCode == 2){

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
                else JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 2", "ERROR", JOptionPane.ERROR_MESSAGE);

            } else if (annihilateCode == 3){

                if (AnnihilationsAlgorithms.canConvertToDirected(skynet.getBeforeGraph()))
                {
                    JComponent newComponent = AnnihilationsAlgorithms.type3Annihilation(skynet.getBeforeGraph());

                    if(AnnihilationsAlgorithms.isConnected(skynet.getBeforeGraph()))
                        skynet.getWindowRef().getPnlAfter().add(newComponent);

                    else JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT CONVERT TO DIRECTED GRAPH", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                else JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 3", "ERROR", JOptionPane.ERROR_MESSAGE);

            } else if (annihilateCode == 4){

            } else if (annihilateCode == 5){

                skynet.setBeforeGraph(AnnihilationsAlgorithms.convertToDirectedGraph(skynet.getBeforeGraph()));
                List<CustomWeightedEdge> edgeList = AnnihilationsAlgorithms.type5Annihilation(skynet.getBeforeGraph());

                if (edgeList != null){

                    // Mostrar el edgeList que conforma el eulerianPath del grafo
                    System.out.println("EULERIAN PATH FOUNDED");

                }

                else JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 5", "ERROR", JOptionPane.ERROR_MESSAGE);


            } else if (annihilateCode == 6){

                List<CustomWeightedEdge> edgeList = AnnihilationsAlgorithms.type5Annihilation(skynet.getBeforeGraph());

                if (edgeList != null) {

                    System.out.println("\n>> SEQUENCE OF EDGES OF THE EULERIAN PATH<<\n");

                    for (CustomWeightedEdge edge : edgeList) {
                        CustomVertex sourceVertex = skynet.getBeforeGraph().getEdgeSource(edge);
                        CustomVertex targetVertex = skynet.getBeforeGraph().getEdgeTarget(edge);

                        System.out.println("->> Source: " + sourceVertex.getId() + ", Target: " + targetVertex.getId());
                    }

                    skynet.setAfterGraph(AnnihilationsAlgorithms.type6Annihilation(skynet.getBeforeGraph(), edgeList));
                    skynet.showAfterGraph(skynet.getAfterGraph());

                }

                else JOptionPane.showMessageDialog(skynet.getWindowRef(), "CANT EXECUTE ANNIHILATION 6", "ERROR", JOptionPane.ERROR_MESSAGE);

            } else if (annihilateCode == 7){

                skynet.selectCitiesMenu();
                AnnihilationsAlgorithms.changeWeightValue(skynet.getBeforeGraph(), 3);

                List <CustomWeightedEdge> shortestPath = AnnihilationsAlgorithms.findShortestPath(skynet.getBeforeGraph(), skynet.getFirstCity(), skynet.getSecondCity());

                AnnihilationsAlgorithms.addEdgesToList(skynet.getBeforeGraph(), shortestPath);

                skynet.setAfterGraph(AnnihilationsAlgorithms.type7Annihilation(skynet.getBeforeGraph(), shortestPath));
                skynet.showAfterGraph(skynet.getAfterGraph());

            } else if (annihilateCode == 8){

                skynet.selectCitiesMenu();
                AnnihilationsAlgorithms.changeWeightValue(skynet.getBeforeGraph(), 2);

                List <CustomWeightedEdge> shortestPath = AnnihilationsAlgorithms.findShortestPath(skynet.getBeforeGraph(), skynet.getFirstCity(), skynet.getSecondCity());

                AnnihilationsAlgorithms.addEdgesToList(skynet.getBeforeGraph(), shortestPath);

                skynet.setAfterGraph(AnnihilationsAlgorithms.type7Annihilation(skynet.getBeforeGraph(), shortestPath));
                skynet.showAfterGraph(skynet.getAfterGraph());

            } else if (annihilateCode == 9){



            } else if (annihilateCode == 10){

            }

        }

        skynet.getWindowRef().revalidate();
        skynet.getWindowRef().repaint();

    }
}
