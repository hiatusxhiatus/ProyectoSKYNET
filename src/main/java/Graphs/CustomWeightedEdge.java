package Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;

    public class CustomWeightedEdge extends DefaultWeightedEdge {
    private int distance;
    private int goods;
    private int military;

    public CustomWeightedEdge(){

    }

    public CustomWeightedEdge(int distance, int goods, int military) {
        this.distance = distance;
        this.military = military;
        this.goods = goods;
    }

    // Getter para la información adicional
    public int getDistance() {
        return distance;
    }

    public void setDistane(int distancia) {
        this.distance = distancia;
    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }

    public int getMilitary() {
        return military;
    }

    public void setMilitary(int military) {
        this.military = military;
    }
}
