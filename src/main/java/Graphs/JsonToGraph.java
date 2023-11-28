package Graphs;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToGraph {

    public static Graph<CustomVertex, CustomWeightedEdge> createWeightedGraphFromJson(String jsonString) {
        JSONObject jsonGraph = new JSONObject(jsonString);

        SimpleDirectedWeightedGraph<CustomVertex, CustomWeightedEdge> graph =
                new SimpleDirectedWeightedGraph<>(CustomWeightedEdge.class);

        JSONArray nodesArray = jsonGraph.getJSONArray("nodes");
        for (int i = 0; i < nodesArray.length(); i++) {
            JSONObject nodeObject = nodesArray.getJSONObject(i);
            String nodeId = nodeObject.getString("id");
            int soldiers = nodeObject.getInt("soldiers");
            int missiles = nodeObject.getInt("missiles");
            int techLevel = nodeObject.getInt("techLevel");

            // Crear un vértice con información adicional
            CustomVertex vertex = new CustomVertex(nodeId,soldiers, missiles, techLevel);
            graph.addVertex(vertex);
        }

        JSONArray edgesArray = jsonGraph.getJSONArray("edges");
        for (int i = 0; i < edgesArray.length(); i++) {
            JSONObject edgeObject = edgesArray.getJSONObject(i);
            String source = edgeObject.getString("source");
            String target = edgeObject.getString("target");
            int military = edgeObject.getInt("military");
            int goods = edgeObject.getInt("goods");
            int distancia = edgeObject.getInt("distance");

            // Obtener los vértices correspondientes
            CustomVertex sourceVertex = findVertexById(graph, source);
            CustomVertex targetVertex = findVertexById(graph, target);

            // Crear una arista ponderada de source a target
            CustomWeightedEdge weightedEdge = new CustomWeightedEdge(distancia, goods, military);
            graph.addEdge(sourceVertex, targetVertex, weightedEdge);

            // Crear una arista ponderada de target a source (bidireccional)
            CustomWeightedEdge reverseWeightedEdge = new CustomWeightedEdge(distancia, goods, military);
            graph.addEdge(targetVertex, sourceVertex, reverseWeightedEdge);
        }

        return graph;
    }

    private static CustomVertex findVertexById(Graph<CustomVertex, CustomWeightedEdge> graph, String nodeId) {
        for (CustomVertex vertex : graph.vertexSet()) {
            if (vertex.getId().equals(nodeId)) {
                return vertex;
            }
        }
        return null;
    }
}


