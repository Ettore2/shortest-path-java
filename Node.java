import java.util.Vector;


public class Node {
    private String name;
    private final Vector<Link> links;
    private Integer currentWeight;//-1 = infinito
    private Node precedentNode;



    //costruttore
    Node(String name){
        this.name = name;
        links = new Vector<>();
        currentWeight = 0;
        precedentNode = null;

    }


    //setters
    public void setName(String name) {
        this.name = name;

    }
    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;

    }
    public void setPrecedentNode(Node precedentNode) {
        this.precedentNode = precedentNode;

    }


    //getters
    public String getName() {
        return name;

    }
    public Integer getCurrentWeight() {
        return currentWeight;

    }
    public Node getPrecedentNode() {
        return precedentNode;

    }
    public Vector<Link> getLinks() {
        return links;

    }


    //altri metodi
    public void addLink(Link link){
        links.add(link);

    }
    public boolean removeLink(Link link){
        return links.remove(link);

    }


    @Override
    public String toString() {
        String s= "node name: " + name + " | cumulative weight:" + currentWeight + " | precedent node: ";
        if(precedentNode != null){
            s = s + precedentNode.name;
        }else{
            s = s + "*null*";
        }

        return s;
    }
}










