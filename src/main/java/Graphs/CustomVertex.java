package Graphs;

public class CustomVertex {
    private String id;
    private int soldiers;
    private int missiles;
    private int techLevel;

    public CustomVertex (){



    }

    public CustomVertex(String id, int soldiers, int missiles, int techLevel) {
        this.id = id;
        this.soldiers = soldiers;
        this.missiles = missiles;
        this.techLevel = techLevel;
    }

    // GETTERs AND SETTERs

    public String getId() {
        return id;
    }

    public int getSoldiers() {
        return soldiers;
    }

    public int getMissiles() {
        return missiles;
    }

    public int getTechLevel(){
        return techLevel;
    }
}
