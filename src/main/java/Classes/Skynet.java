package Classes;

import Forms.Listener;
import Forms.Window;
import Graphs.GraphToGUI;
import Graphs.JsonToGraph;
import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Skynet {

    private Window windowRef;
    private String pathUpload;
    private Graph<String, DefaultEdge> beforeGraph;
    private Graph<String, DefaultEdge> afterGraph;

    public Skynet(Window windowRef) {

        this.windowRef = windowRef;
        this.windowRef.setVisible(true);
        Listener listener = new Listener(windowRef.getBtnUpload(), this);
        Listener listener2 = new Listener(windowRef.getBtnAnnihilate(), this);
        initialize();
    }

    public void initialize() {
        windowRef.setVisible(true);
    }

    public void uploadGraph() {

        Graph<String, DefaultEdge> newGraph = JsonToGraph.createGraphFromJson(pathUpload);
        this.beforeGraph = newGraph;
        JComponent graphComponent = GraphToGUI.createTransparentJGraphXGraph(newGraph, false);
        graphComponent.setVisible(true);
        windowRef.getPnlBefore().add(graphComponent);

    }

    public void showAfterGraph(SimpleGraph<String, DefaultEdge> graph){

        JComponent graphComponent = GraphToGUI.createTransparentJGraphXGraph(graph, true);
        graphComponent.setVisible(true);
        windowRef.getPnlAfter().add(graphComponent);

    }
    
    // GETTERs AND SETTERs

    public static void main(String[] args) {
        Skynet skynet = new Skynet(new Window());

    }

    public Window getWindowRef() {
        return windowRef;
    }

    public String getPathUpload() {
        return pathUpload;
    }

    public void setPathUpload(String pathUpload) {
        this.pathUpload = pathUpload;
    }

    public Graph<String, DefaultEdge> getBeforeGraph() {
        return beforeGraph;
    }

    public Graph<String, DefaultEdge> getAfterGraph() {
        return afterGraph;
    }

    public void setBeforeGraph(SimpleGraph<String, DefaultEdge> beforeGraph) {
        this.beforeGraph = beforeGraph;
    }

    public void setAfterGraph(SimpleGraph<String, DefaultEdge> afterGraph) {
        this.afterGraph = afterGraph;
    }
}
