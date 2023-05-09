import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public class Graph {
    private final Vector<Node> nodes;


    //costruttore
    public Graph(){
        nodes = new Vector<>();

    }


    //setters
    public void settaPesiAdInfinito(){
        for (Node node : nodes) {
            node.setCurrentWeight(-1);
        }
    }


    //getters
    public Vector<Node> getNodes() {
        return nodes;

    }
    public Node getNode(int index){
        return nodes.get(index);

    }


    //altri metodi
    public void addNode(@NotNull Node n){
        nodes.add(n);

    }
    public Boolean removeNode(@NotNull Node n){
        return nodes.remove(n);

    }
    public Vector<Node> calcolatePath(@NotNull Node start, @NotNull Node end){

        //se i nodi inseriti appartengono al grafico
        if(nodes.contains(start) && nodes.contains(end)){

            Vector<Node> path = new Vector<>();
            Vector<Node> nodiVisitati = new Vector<>();
            Node curNodo, nodoTmp;

            //inizializzo algoritmo
            settaPesiAdInfinito();
            start.setCurrentWeight(0);
            start.setPrecedentNode(null);

            //attraverso tutti i nodi
            do{
                //imposto cur nodo a nodo non visitato con perso minore
                curNodo = null;
                for (Node node : nodes) {
                    if (!nodiVisitati.contains(node) && (curNodo == null || (node.getCurrentWeight() != -1 && node.getCurrentWeight() < curNodo.getCurrentWeight()))) {
                        curNodo = node;
                    }
                }

                //se ho selezionato un nodo da visitare
                if(curNodo != null){
                    //visito il nodo
                    nodiVisitati.add(curNodo);

                    //controllo tutti i nodi collegati al nodo da visitare
                    for(int i = 0; i < curNodo.getLinks().size(); i++){
                        nodoTmp=curNodo.getLinks().get(i).getOther(curNodo);

                        //se posso migliorare il peso del nodo collegato
                        if(nodoTmp.getCurrentWeight() == -1 || nodoTmp.getCurrentWeight() > curNodo.getCurrentWeight() + curNodo.getLinks().get(i).weight){
                            nodoTmp.setCurrentWeight(curNodo.getCurrentWeight() + curNodo.getLinks().get(i).weight);//aggiorno peso
                            nodoTmp.setPrecedentNode(curNodo);//aggiorno nodo precedente
                        }

                    }

                }

            }while(curNodo != null);


            //compongo path
            curNodo = end;
            while (curNodo.getPrecedentNode() != null){
                path.add(curNodo);
                curNodo = curNodo.getPrecedentNode();
            }
            path.add(curNodo);

            //inverto path
            Vector<Node> invertedPath= new Vector<>(path.size(),1);
            for(int i = path.size()-1; i >= 0; i--){
                invertedPath.add(path.get(i));
            }


            //restituisco path invertito
            return invertedPath;
        }
        return null;
    }


}
