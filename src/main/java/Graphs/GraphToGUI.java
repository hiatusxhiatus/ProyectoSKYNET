package Graphs;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.mxgraph.view.mxStylesheet;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.Graph;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GraphToGUI {

    public static mxGraphComponent createTransparentJGraphXGraph(Graph<String, DefaultEdge> jGraphTGraph, boolean isAfterGraph) {

        mxGraph jGraphXGraph = new mxGraph();
        Object parent = jGraphXGraph.getDefaultParent();
        jGraphXGraph.setCellsResizable(false);
        jGraphXGraph.setCellsEditable(false);
        jGraphXGraph.setConnectableEdges(false);
        jGraphXGraph.setEdgeLabelsMovable(false);

        jGraphXGraph.getModel().beginUpdate();
        try {
            // Mapear nombres de vértices a celdas en JGraphX
            Map<String, Object> vertexCellMap = new HashMap<>();

            int x = 0;
            int y = 10;

            for (String vertex : jGraphTGraph.vertexSet()) {
                Object vertexCell = jGraphXGraph.insertVertex(parent, null, vertex, x, y, 40, 40);
                vertexCellMap.put(vertex, vertexCell);
                x += 30;
                y += 40;

                // Cambiar el color del nodo
                String style = mxConstants.STYLE_FILLCOLOR + "=#FFFFFF;" + mxConstants.STYLE_FONTCOLOR + "=#000000;"; // Por ejemplo, rojo
                jGraphXGraph.getModel().setStyle(vertexCell, style);

            }

            for (DefaultEdge edge : jGraphTGraph.edgeSet()) {
                String source = jGraphTGraph.getEdgeSource(edge);
                String target = jGraphTGraph.getEdgeTarget(edge);

                // Obtener celdas correspondientes a los vértices fuente y destino
                Object sourceCell = vertexCellMap.get(source);
                Object targetCell = vertexCellMap.get(target);

                // Insertar la arista en JGraphX
                Object edgeCell = jGraphXGraph.insertEdge(parent, null, "", sourceCell, targetCell);

                // Cambiar el color del borde de la arista
                String style = mxConstants.STYLE_STROKECOLOR + "=#FFFFFF;" +
                        mxConstants.STYLE_STROKEWIDTH + "=6;" +
                        mxConstants.STYLE_ENDARROW + "=" + mxConstants.NONE; // Puedes ajustar el color y el ancho según tus necesidades
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

}

