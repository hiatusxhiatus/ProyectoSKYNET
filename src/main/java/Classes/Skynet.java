package Classes;

import Forms.Listener;
import Forms.Window;
import Graphs.GraphToGUI;
import Graphs.JsonToGraph;
import org.jgrapht.Graph;
import javax.swing.*;
import Graphs.CustomVertex;
import Graphs.CustomWeightedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Skynet {

    private Window windowRef;
    private String pathUpload;
    private Graph<CustomVertex, CustomWeightedEdge> beforeGraph;
    private Graph<CustomVertex, CustomWeightedEdge> afterGraph;
    private CustomVertex firstCity;
    private CustomVertex secondCity;
    private Scanner scanner;

    public Skynet(Window windowRef)
    {
        this.windowRef = windowRef;
        this.windowRef.setVisible(true);

        Listener listener = new Listener(windowRef.getBtnUpload(), this);
        Listener listener2 = new Listener(windowRef.getBtnAnnihilate(), this);

        this.scanner = new Scanner(System.in);

        initialize();
    }

    // CLASS METHODS

    public void initialize()
    {
        windowRef.setVisible(true);
    }

    public void uploadGraph()
    {
        Graph<CustomVertex, CustomWeightedEdge> newGraph = JsonToGraph.createWeightedGraphFromJson(pathUpload);
        this.beforeGraph = newGraph;

        JComponent graphComponent = GraphToGUI.createTransparentJGraphXGraph(newGraph, false);

        graphComponent.setVisible(true);
        windowRef.getPnlBefore().add(graphComponent);
    }

    public void showAfterGraph(Graph<CustomVertex, CustomWeightedEdge> graph)
    {
        JComponent graphComponent = GraphToGUI.createTransparentJGraphXGraph(graph, true);
        graphComponent.setVisible(true);
        windowRef.getPnlAfter().add(graphComponent);
    }

    public void showBeforeGraph(Graph<CustomVertex, CustomWeightedEdge> graph)
    {
        JComponent graphComponent = GraphToGUI.createTransparentJGraphXGraph(graph, true);
        graphComponent.setVisible(true);
        windowRef.getPnlBefore().add(graphComponent);
    }

    public void nextRound(boolean indicator){

        if(indicator) {
            setBeforeGraph(getAfterGraph());

            windowRef.getPnlAfter().removeAll();
            windowRef.getPnlAfter().revalidate();
            windowRef.getPnlAfter().repaint();

            windowRef.getPnlBefore().removeAll();
            windowRef.getPnlBefore().revalidate();
            windowRef.getPnlBefore().repaint();

            showBeforeGraph(getBeforeGraph());

        }

        // Caso para el 3 y 5
        else {

        }
    }

    public void selectCitiesMenu(){

        String city1 = "";
        String city2 = "";

        System.out.println("\n >>> CITIES AVAILABLE <<<\n");

        Set<CustomVertex> vertices = beforeGraph.vertexSet();
        ArrayList<CustomVertex> verticesArray = new ArrayList<CustomVertex>();

        int i = 1;

        for (CustomVertex vertex : vertices){

            verticesArray.add(vertex);
            System.out.println("->> " + i + ". " + vertex.getId());
            i++;

        }

        System.out.print("First City: ");
        city1 = scanner.nextLine();
        System.out.println();
        System.out.print ("Second City: ");
        city2 = scanner.nextLine();

        setFirstCity(verticesArray.get(Integer.parseInt(city1)-1));
        setSecondCity(verticesArray.get(Integer.parseInt(city2)-1));

    }

    // CLASS MAIN

    public static void main(String[] args)
    {
        Skynet skynet = new Skynet(new Window());
    }

    // GETTERs AND SETTERs

    public Window getWindowRef() {
        return windowRef;
    }

    public String getPathUpload() {
        return pathUpload;
    }

    public void setPathUpload(String pathUpload) {
        this.pathUpload = pathUpload;
    }

    public Graph<CustomVertex, CustomWeightedEdge> getBeforeGraph() {
        return beforeGraph;
    }

    public Graph<CustomVertex, CustomWeightedEdge> getAfterGraph() {
        return afterGraph;
    }

    public void setBeforeGraph(Graph<CustomVertex, CustomWeightedEdge> beforeGraph) {
        this.beforeGraph = beforeGraph;
    }

    public void setAfterGraph(Graph<CustomVertex, CustomWeightedEdge> afterGraph) {
        this.afterGraph = afterGraph;
    }

    public CustomVertex getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(CustomVertex firstCity) {
        this.firstCity = firstCity;
    }

    public CustomVertex getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(CustomVertex secondCity) {
        this.secondCity = secondCity;
    }
}
