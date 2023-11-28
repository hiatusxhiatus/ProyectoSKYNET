package Classes;

import Forms.Listener;
import Forms.SelectCitiesMenu;
import Forms.Window;
import Forms.showConsoleMenu;
import Graphs.GraphToGUI;
import Graphs.JsonToGraph;
import org.jgrapht.Graph;
import javax.swing.*;
import Graphs.CustomVertex;
import Graphs.CustomWeightedEdge;

import java.util.ArrayList;

import java.util.Set;

public class Skynet {

    private Window windowRef;
    private SelectCitiesMenu citiesMenuRef;
    private showConsoleMenu consoleMenu;
    private String pathUpload;
    private Graph<CustomVertex, CustomWeightedEdge> beforeGraph;
    private Graph<CustomVertex, CustomWeightedEdge> afterGraph;
    private Set<CustomVertex> vertices;
    private ArrayList<CustomVertex> verticesArray;
    private CustomVertex firstCity;
    private CustomVertex secondCity;

    public Skynet(Window windowRef, SelectCitiesMenu citiesMenuRef, showConsoleMenu consoleMenu)
    {
        this.windowRef = windowRef;
        this.citiesMenuRef = citiesMenuRef;
        this.consoleMenu = consoleMenu;
        this.windowRef.setVisible(true);

        new Listener(windowRef.getBtnUpload(), this);
        new Listener(windowRef.getBtnAnnihilate(), this);
        new Listener(citiesMenuRef.getBtnAccept(), this);
        new Listener(windowRef.getBtnNextRound(), this);
        new Listener(consoleMenu.getBtnAccept(), this);

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

    public void nextRound(boolean indicator) {

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

            windowRef.getPnlAfter().removeAll();
            windowRef.getPnlAfter().revalidate();
            windowRef.getPnlAfter().repaint();

            windowRef.getPnlBefore().removeAll();
            windowRef.getPnlBefore().revalidate();
            windowRef.getPnlBefore().repaint();

            showBeforeGraph(getBeforeGraph());

        }
    }

    public void selectCitiesMenu() {

        this.vertices = beforeGraph.vertexSet();
        this.verticesArray = new ArrayList<>();

        int i = 1;
        String str = "";

        for (CustomVertex vertex : vertices)
        {
            verticesArray.add(vertex);
            str += i + ". " + vertex.getId() + "\n";
            i++;
        }

        citiesMenuRef.getTxaFirst().setText(str);
        citiesMenuRef.getTxaSecond().setText(str);
        citiesMenuRef.setVisible(true);
    }

    // CLASS MAIN

    public static void main(String[] args)
    {
        Skynet skynet = new Skynet(new Window(), new SelectCitiesMenu(), new showConsoleMenu());
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

    public SelectCitiesMenu getCitiesMenuRef() {
        return citiesMenuRef;
    }

    public Set<CustomVertex> getVertices() {
        return vertices;
    }

    public ArrayList<CustomVertex> getVerticesArray() {
        return verticesArray;
    }

    public showConsoleMenu getConsoleMenu() {
        return consoleMenu;
    }
}
