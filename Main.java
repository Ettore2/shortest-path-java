import java.util.Vector;


public class Main {
    public static void main(String[] args){

        //creo grafo
        Graph g = new Graph();

        //creo nodi
        Node casa = new Node("casa");
        Node na = new Node("na");
        Node nb = new Node("nb");
        Node nc = new Node("nc");
        Node nd = new Node("nd");
        Node ne = new Node("ne");
        Node ufficio = new Node("ufficio");

        //creo archi
        new Link(2, casa, na);
        new Link(8, casa, nd);
        new Link(6, na, nb);
        new Link(2, na, nc);
        new Link(2, nc, nd);
        new Link(3, nd, ne);
        new Link(9, nc, ne);
        new Link(1, ne, ufficio);
        new Link(5, nb, ufficio);

        //aggiungo nodi a grafo
        g.addNode(casa);
        g.addNode(na);
        g.addNode(nb);
        g.addNode(nc);
        g.addNode(nd);
        g.addNode(ne);
        g.addNode(ufficio);


        //risoluzione problema
        Vector<Node> path = g.calcolatePath(casa,ufficio);

        //stampa risoluzione problema
        System.out.print("percorso scelto:\n");
        for(Node node : path) {
            System.out.println(node.toString());

        }

        //stampa info nodi
        System.out.print("\ninfo nodi grafo:\n");
        for(Node node : g.getNodes()) {
            System.out.println(node.toString());

        }





    }
}
