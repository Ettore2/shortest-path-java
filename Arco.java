public class Arco {
    public int peso;
    Nodo n1,n2;



    public Arco(int perso,Nodo n1,Nodo n2){
        if(n1!=null&&n2!=null){
            this.peso=perso;
            this.n1=n1;
            this.n2=n2;
            n1.archi.add(this);
            n2.archi.add(this);
        }
    }


    public Nodo getOther(Nodo n){
        if(n1==n)return n2;
        if(n2==n)return n1;
        return null;
    }

}












