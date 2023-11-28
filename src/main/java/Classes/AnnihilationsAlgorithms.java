package Classes;

import Graphs.CustomVertex;
import Graphs.CustomWeightedEdge;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.cycle.HierholzerEulerianCycle;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.alg.interfaces.EulerianCycleAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import javax.swing.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnnihilationsAlgorithms {

    public AnnihilationsAlgorithms ()
    {

    }

    // ANNIHILATIONS

    public static Graph<CustomVertex, CustomWeightedEdge> type1Annihilation(Graph<CustomVertex, CustomWeightedEdge> actualGraph, int indicator)
    {

        Graph<CustomVertex,CustomWeightedEdge> copy = cloneGraph(actualGraph);

        if (isConnected(copy))
        {
            List<CustomVertex> verticesToRemove= findVerticesToRemove(copy,indicator);

            if (verticesToRemove == null){

                type1Annihilation(copy, ++indicator);

            }

            else {
                for (CustomVertex vertexToRemove : verticesToRemove)
                    copy.removeVertex(vertexToRemove);
            }
        }

        return copy;
    }

    public static Graph<CustomVertex, CustomWeightedEdge> type2Annihilation(Graph<CustomVertex, CustomWeightedEdge> actualGraph)
    {

        Graph<CustomVertex,CustomWeightedEdge> copy = cloneGraph(actualGraph);

        if (isConnected(copy)) {

            Graph<CustomVertex, CustomWeightedEdge> mstGraph = getMinimumSpanningTree(copy);

            return mstGraph;

        }

        return null;
    }

    public static JComponent type3Annihilation(Graph<CustomVertex, CustomWeightedEdge> actualGraph)
    {
        convertToDirectedGraph(actualGraph);

        JComponent newComponent = createDirectedGraphGUI(actualGraph, true);

        return newComponent;
    }

    public static void type4Annihilation(Graph<CustomVertex, CustomWeightedEdge> actualGraph)
    {


    }

    public static List<CustomWeightedEdge> type5Annihilation(Graph<CustomVertex, CustomWeightedEdge> actualGraph)
    {
        List <CustomWeightedEdge> edgeList  = findAndPrintEulerianPath(actualGraph);

        return edgeList;
    }

    public static Graph<CustomVertex, CustomWeightedEdge> type6Annihilation(Graph<CustomVertex, CustomWeightedEdge> originalGraph, List<CustomWeightedEdge> eulerianPath)
    {

        return removeMostVisitedVertices(originalGraph, eulerianPath);

    }

    public static Graph<CustomVertex, CustomWeightedEdge> type7Annihilation(Graph<CustomVertex, CustomWeightedEdge> actualGraph, List<CustomWeightedEdge> shortestPath)
    {
        return removeEdgesFromGraph(actualGraph, shortestPath);
    }
    public static Graph<CustomVertex, CustomWeightedEdge> type8Annihilation(Graph<CustomVertex, CustomWeightedEdge> actualGraph, List<CustomWeightedEdge> shortestPath)
    {
        return type7Annihilation(actualGraph, shortestPath);
    }
    public void type9Annihilation()
    {

    }
    public void type10Annihilation()
    {

    }

    // AUX ALGORITHMS

    public static boolean isConnected(Graph<CustomVertex, CustomWeightedEdge> graph)
    {
        ConnectivityInspector<CustomVertex, CustomWeightedEdge> inspector = new ConnectivityInspector<>(graph);
        return inspector.isConnected();
    }

    public static void changeWeightValue(Graph<CustomVertex, CustomWeightedEdge> actualGraph, int indicator)
    {


        for (CustomWeightedEdge edge : actualGraph.edgeSet()) {

            switch (indicator){

                case 1:
                    actualGraph.setEdgeWeight(edge, edge.getGoods());
                    break;

                case 2:
                    actualGraph.setEdgeWeight(edge, edge.getMilitary());
                    break;

                case 3:
                    actualGraph.setEdgeWeight(edge, edge.getDistance());
                    break;

                default:
                    System.out.println("ERROR CHANGING WEIGHT VALUES");
                    break;
            }

        }
    }

    public static Graph<CustomVertex,CustomWeightedEdge> cloneGraph(Graph<CustomVertex,CustomWeightedEdge> originalGraph){

        Graph<CustomVertex,CustomWeightedEdge> clone = new SimpleDirectedWeightedGraph<>(CustomWeightedEdge.class);

        for (CustomVertex vertex : originalGraph.vertexSet())
            clone.addVertex(vertex);

        for (CustomWeightedEdge edge : originalGraph.edgeSet()){

            CustomVertex sourceVertex = originalGraph.getEdgeSource(edge);
            CustomVertex targetVertex = originalGraph.getEdgeTarget(edge);

            clone.addEdge(sourceVertex,targetVertex);

        }

        return clone;
    }

    // ALGORITHM #1

    private static List<CustomVertex> findVerticesToRemove(Graph<CustomVertex, CustomWeightedEdge> graph, int numVerticesToRemove)
    {
        List<CustomVertex> verticesToRemove = new ArrayList<>();

        if (numVerticesToRemove > graph.vertexSet().size()) {
            // Si se solicita eliminar más vértices de los disponibles, regresar nulo
            return null;
        }

        for (CustomVertex vertex : new ArrayList<>(graph.vertexSet())) {
            graph.removeVertex(vertex);

            ConnectivityInspector<CustomVertex, CustomWeightedEdge> inspector = new ConnectivityInspector<>(graph);
            if (!inspector.isConnected()) {
                verticesToRemove.add(vertex);

                if (verticesToRemove.size() == numVerticesToRemove) {
                    // Si se han eliminado suficientes vértices, salir del bucle
                    break;
                }
            } else {
                graph.addVertex(vertex);
            }
        }

        // Restaurar los vértices al grafo antes de devolver la lista
        for (CustomVertex vertex : verticesToRemove) {
            graph.addVertex(vertex);
        }

        // Verificar si se eliminaron suficientes vértices
        return verticesToRemove.size() == numVerticesToRemove ? verticesToRemove : null;
    }

    // ALGORITHM #2

    private static Graph<CustomVertex, CustomWeightedEdge> getMinimumSpanningTree(Graph<CustomVertex, CustomWeightedEdge> graph)
    {

        SpanningTreeAlgorithm<CustomWeightedEdge> kruskal =
                new KruskalMinimumSpanningTree<>(graph);

        SpanningTreeAlgorithm.SpanningTree<CustomWeightedEdge> kruskalSpanningTree = kruskal.getSpanningTree();

        Graph<CustomVertex, CustomWeightedEdge> mstGraph =
                new SimpleWeightedGraph<>(CustomWeightedEdge.class);

        for (CustomVertex vertex : graph.vertexSet()) {
            mstGraph.addVertex(vertex);
        }

        for (CustomWeightedEdge edge : kruskalSpanningTree.getEdges()) {
            CustomVertex sourceVertex = graph.getEdgeSource(edge);
            CustomVertex targetVertex = graph.getEdgeTarget(edge);

            mstGraph.addEdge(sourceVertex, targetVertex, edge);
            mstGraph.setEdgeWeight(edge, graph.getEdgeWeight(edge));
        }

        return mstGraph;
    }

    public static List<CustomWeightedEdge> getMinimumSpanningTreeEdges(Graph<CustomVertex, CustomWeightedEdge> graph) {
        SpanningTreeAlgorithm<CustomWeightedEdge> kruskal =
                new KruskalMinimumSpanningTree<>(graph);

        SpanningTreeAlgorithm.SpanningTree<CustomWeightedEdge> kruskalSpanningTree = kruskal.getSpanningTree();

        return new ArrayList<>(kruskalSpanningTree.getEdges());
    }

    public static Graph<CustomVertex, CustomWeightedEdge> removeEdges(Graph<CustomVertex, CustomWeightedEdge> graph, List<CustomWeightedEdge> edgesToRemove) {

        List<CustomWeightedEdge> edgesCopy = new ArrayList<>(edgesToRemove);

        for (CustomWeightedEdge edge : edgesCopy) {
            boolean removed = graph.removeEdge(edge);
            System.out.println("Removal result: " + removed);
        }

        return graph;
    }

    // ALGORITHM #3

    public static Graph<CustomVertex, CustomWeightedEdge> convertToDirectedGraph(
            Graph<CustomVertex, CustomWeightedEdge> actualGraph
    ) {
        Set<CustomWeightedEdge> edgesToRemove = new HashSet<>();

        for (CustomWeightedEdge edge1 : actualGraph.edgeSet()) {
            for (CustomWeightedEdge edge2 : actualGraph.edgeSet()) {

                if (areEdgesEqual(actualGraph, edge1, edge2) && isRemovalConnected(actualGraph, edge2)) {
                    edgesToRemove.add(edge2);
                    break;
                }
            }
        }

        for (CustomWeightedEdge edgeToRemove : edgesToRemove) {
            actualGraph.removeEdge(edgeToRemove);
        }

        return actualGraph;
    }

    private static boolean areEdgesEqual(
            Graph<CustomVertex, CustomWeightedEdge> actualGraph,
            CustomWeightedEdge edge1,
            CustomWeightedEdge edge2
    ) {
        CustomVertex source1 = actualGraph.getEdgeSource(edge1);
        CustomVertex target1 = actualGraph.getEdgeTarget(edge1);

        CustomVertex source2 = actualGraph.getEdgeSource(edge2);
        CustomVertex target2 = actualGraph.getEdgeTarget(edge2);

        return (source1.equals(target2) && target1.equals(source2)) ||
                (source1.equals(source2) && target1.equals(target2));
    }

    private static boolean isRemovalConnected(
            Graph<CustomVertex, CustomWeightedEdge> graph,
            CustomWeightedEdge edgeToRemove
    ) {
        Graph<CustomVertex, CustomWeightedEdge> tempGraph = new SimpleWeightedGraph<>(CustomWeightedEdge.class);
        for (CustomVertex vertex : graph.vertexSet()) {
            tempGraph.addVertex(vertex);
        }

        for (CustomWeightedEdge edge : graph.edgeSet()) {
            if (!edge.equals(edgeToRemove)) {
                tempGraph.addEdge(graph.getEdgeSource(edge), graph.getEdgeTarget(edge), edge);
            }
        }

        ConnectivityInspector<CustomVertex, CustomWeightedEdge> inspector = new ConnectivityInspector<>(tempGraph);
        return inspector.isConnected();
    }

    public static boolean canConvertToDirected(Graph<CustomVertex, CustomWeightedEdge> actualGraph) {
        for (CustomVertex vertex : actualGraph.vertexSet()) {
            Set<CustomWeightedEdge> incidentEdges = actualGraph.edgesOf(vertex);
            if (incidentEdges.size() < 2) {
                return false;
            }
        }
        return true;
    }

    public static mxGraphComponent createDirectedGraphGUI(Graph<CustomVertex, CustomWeightedEdge> customGraph, boolean isAfterGraph){
        mxGraph jGraphXGraph = new mxGraph();
        Object parent = jGraphXGraph.getDefaultParent();
        jGraphXGraph.setCellsResizable(false);
        jGraphXGraph.setCellsEditable(false);
        jGraphXGraph.setConnectableEdges(false);
        jGraphXGraph.setEdgeLabelsMovable(false);

        jGraphXGraph.getModel().beginUpdate();

        try {

            // Mapear vértices a celdas en JGraphX
            Map<CustomVertex, Object> vertexCellMap = new HashMap<>();

            int x = 10;
            int y = 10;

            for (CustomVertex vertex : customGraph.vertexSet()) {
                Object vertexCell = jGraphXGraph.insertVertex(parent, null, vertex.getId(), x, y, 40, 40);
                vertexCellMap.put(vertex, vertexCell);

                x += 50;

                if(x >= 500){
                    y += 80;
                    x = 10;
                }

                // Cambiar el color del nodo
                String style = mxConstants.STYLE_FILLCOLOR + "=#FFFFFF;" + mxConstants.STYLE_FONTCOLOR + "=#000000;";
                jGraphXGraph.getModel().setStyle(vertexCell, style);
            }

            for (CustomWeightedEdge edge : customGraph.edgeSet()) {
                CustomVertex source = customGraph.getEdgeSource(edge);
                CustomVertex target = customGraph.getEdgeTarget(edge);

                // Obtener celdas correspondientes a los vértices fuente y destino
                Object sourceCell = vertexCellMap.get(source);
                Object targetCell = vertexCellMap.get(target);

                // Insertar la arista en JGraphX en ambas direcciones
                Object edgeCell = jGraphXGraph.insertEdge(parent, null, "", sourceCell, targetCell);

                // Cambiar el color del borde de las aristas
                String style = mxConstants.STYLE_STROKECOLOR + "=#FFFFFF;" +
                        mxConstants.STYLE_STROKEWIDTH + "=6;" +
                        mxConstants.STYLE_ENDARROW + "=" + mxConstants.ARROW_CLASSIC;

                jGraphXGraph.getModel().setStyle(edgeCell, style);
            }
        } finally {
            jGraphXGraph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(jGraphXGraph);
        graphComponent.setSize(520,500);
        graphComponent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        if (isAfterGraph)
            graphComponent.setBackgroundImage(new ImageIcon("src/main/resources/Images/bgAfter.png"));
        else
            graphComponent.setBackgroundImage(new ImageIcon("src/main/resources/Images/bgBefore.png"));

        return graphComponent;
    }

    // ALGORITM #4

    // ALGORITHM #5

    public static List<CustomWeightedEdge> findAndPrintEulerianPath(Graph<CustomVertex, CustomWeightedEdge> actualGraph) {

        if (isEulerianGraph(actualGraph)) {

            EulerianCycleAlgorithm<CustomVertex, CustomWeightedEdge> epAlg =
                    new HierholzerEulerianCycle<>();

            GraphPath<CustomVertex, CustomWeightedEdge> eulerianPath = epAlg.getEulerianCycle(actualGraph);

            if (eulerianPath != null) {
                return eulerianPath.getEdgeList();
            } else {
                return null;
            }

        }

        else return null;
    }

    private static boolean isEulerianGraph(Graph<CustomVertex, CustomWeightedEdge> graph) {

        for (CustomVertex vertex : graph.vertexSet()) {
            Set<CustomWeightedEdge> incidentEdges = graph.edgesOf(vertex);
            if (incidentEdges.size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    // ALGORITHM #6

    private static Graph<CustomVertex, CustomWeightedEdge> removeMostVisitedVertices(
            Graph<CustomVertex, CustomWeightedEdge> originalGraph,
            List<CustomWeightedEdge> eulerianPath) {

        Graph<CustomVertex, CustomWeightedEdge> copiedGraph = new DefaultDirectedWeightedGraph<>(CustomWeightedEdge.class);
        originalGraph.vertexSet().forEach(copiedGraph::addVertex);
        originalGraph.edgeSet().forEach(edge -> copiedGraph.addEdge(originalGraph.getEdgeSource(edge), originalGraph.getEdgeTarget(edge), edge));

        Map<CustomVertex, Long> vertexVisits = eulerianPath.stream()
                .map(edge -> originalGraph.getEdgeSource(edge))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        long maxVisits = Collections.max(vertexVisits.values());

        List<CustomVertex> mostVisitedVertices = vertexVisits.entrySet().stream()
                .filter(entry -> entry.getValue() == maxVisits)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (CustomVertex vertex : mostVisitedVertices) {
            copiedGraph.removeVertex(vertex);
        }

        return copiedGraph;
    }

    // ALGORITHM #7

    public static List<CustomWeightedEdge> findShortestPath(
            Graph<CustomVertex, CustomWeightedEdge> graph,
            CustomVertex sourceVertex,
            CustomVertex targetVertex) {

        DijkstraShortestPath<CustomVertex, CustomWeightedEdge> dijkstraAlg =
                new DijkstraShortestPath<>(graph);

        GraphPath<CustomVertex, CustomWeightedEdge> shortestPath =
                dijkstraAlg.getPath(sourceVertex, targetVertex);

        return shortestPath.getEdgeList();
    }

    public static Graph<CustomVertex, CustomWeightedEdge> removeEdgesFromGraph(
            Graph<CustomVertex, CustomWeightedEdge> graph,
            List<CustomWeightedEdge> edgesToRemove) {

        Graph<CustomVertex, CustomWeightedEdge> copy = graph;

        for (CustomWeightedEdge edge : edgesToRemove) {
            copy.removeEdge(edge);
            System.out.println("AAA");
        }

        return copy;
    }

    public static void addEdgesToList(Graph<CustomVertex, CustomWeightedEdge> actualGraph, List<CustomWeightedEdge> edgesList) {

        ArrayList<CustomWeightedEdge> extras = new ArrayList<CustomWeightedEdge>();

        for (CustomWeightedEdge graphEdge : actualGraph.edgeSet()) {
            for (CustomWeightedEdge listEdge : edgesList) {

                CustomVertex graphEdgeSource = actualGraph.getEdgeSource(graphEdge);
                CustomVertex graphEdgeTarget = actualGraph.getEdgeTarget(graphEdge);
                CustomVertex listEdgeSource = actualGraph.getEdgeSource(listEdge);
                CustomVertex listEdgeTarget = actualGraph.getEdgeTarget(listEdge);

                if ((graphEdgeSource.equals(listEdgeTarget) && graphEdgeTarget.equals(listEdgeSource))) {
                    extras.add(graphEdge);
                    break;
                }
            }
        }

        for (CustomWeightedEdge edge : extras){

            edgesList.add(edge);

        }
    }

    // ALGORITHM #8

    // ALGORITHM #9

    // ALGORITHM #10

}
