import java.sql.Struct;

public class Main {
    public static void main(String args[]){
        Nodo casa=new Nodo("casa");
        Nodo na=new Nodo("na");
        Nodo nb=new Nodo("nb");
        Nodo nc=new Nodo("nc");
        Nodo nd=new Nodo("nd");
        Nodo ne=new Nodo("ne");
        Nodo ufficio=new Nodo("ufficio");

        new Arco(2,casa,na);
        new Arco(8,casa,nd);
        new Arco(6,na,nb);
        new Arco(2,na,nc);
        new Arco(2,nc,nd);
        new Arco(3,nd,ne);
        new Arco(9,nc,ne);
        new Arco(1,ne,ufficio);
        new Arco(5,nb,ufficio);


        System.out.print("percorso scelto: ");
        System.out.println(casa.roadTo(ufficio));

        System.out.println("\nPESI NODI:");
        for(Nodo n:Nodo.nodiCreati){
            System.out.println(n.nome+" "+n.pesoCorrente);
        }

    }
}
