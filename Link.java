import org.jetbrains.annotations.NotNull;

public class Link {
    public int weight;
    private final Node node1, node2;


    //costruttore
    public Link(int weight, @NotNull Node n1, @NotNull Node n2){
            this.weight =weight;
            this.node1 =n1;
            this.node2 =n2;
            n1.addLink(this);
            n2.addLink(this);
    }


    //getters
    public Node getOther(Node n){
        if(node1 ==n)return node2;
        if(node2 ==n)return node1;
        return null;
    }


    @Override
    public String toString() {
        return "weight: "+ weight + " | n1: " + node1.getName() + " | n2: " + node2.getName();

    }
}












