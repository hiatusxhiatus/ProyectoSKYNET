package Graphs;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToGraph {

    public static Graph<String, DefaultEdge> createGraphFromJson(String jsonString) {
        JSONObject jsonGraph = new JSONObject(jsonString);

        SimpleGraph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        JSONArray nodesArray = jsonGraph.getJSONArray("nodes");
        for (int i = 0; i < nodesArray.length(); i++) {
            String node = nodesArray.getString(i);
            graph.addVertex(node);
        }

        JSONArray edgesArray = jsonGraph.getJSONArray("edges");
        for (int i = 0; i < edgesArray.length(); i++) {
            JSONObject edgeObject = edgesArray.getJSONObject(i);
            String source = edgeObject.getString("source");
            String target = edgeObject.getString("target");
            graph.addEdge(source, target);
        }

        return graph;
    }
}


