import java.util.Vector;


public class Nodo {
    //cose statiche
    static Vector<Nodo>nodiCreati=new Vector<>();


    //cose non statiche
    public String nome;
    Vector<Arco> archi;
    Integer pesoCorrente;//null=infinito



    //costruttore
    Nodo(String nome){
        this.nome=nome;
        nodiCreati.add(this);
        archi=new Vector<>();
    }


    //altri metodi
    public String roadTo(Nodo destinazione){
        String s="";
        Nodo nTmp;
        Vector<Nodo> nodiDaVisitare;

        Vector<Nodo> nodiDaVisitareTmp;
        setOvunquePesoInfinito();
        this.pesoCorrente=0;

        //creo vettore archi collegati
        Vector<Arco> archiOrd=getArchi();

        //ordino il vettore in base al peso
        for(int i=0;i<archiOrd.size()-1;i++){
            //se devo scambiare
            if(archiOrd.get(i).peso>archiOrd.get(i+1).peso){
                //metto il ndo alla fine della lista
                archiOrd.remove(archiOrd.get(i));
                archiOrd.add(archiOrd.get(i));

                //indietreggio
                i--;
            }
        }

        //visito i nodi
        visitaRicorsivo(destinazione);

        //creo strada ottimale
        //creo stringa return
        Vector<Nodo> nodiGiaPercorsi=new Vector<>();
        Vector<Nodo> strada=new Vector<>();
        Nodo nScelto;
        Nodo pos=destinazione;
        strada.add(pos);
        s=s+this.nome+"  ";
        while(pos!=this){
            nScelto=lightestNode(pos,nodiGiaPercorsi);
            nodiGiaPercorsi.add(pos);
            strada.add(pos);
            pos=nScelto;
        }

        //creo stringa return
        for(int i=strada.size()-1;i>0;i--){
            s=s+strada.get(i).nome+"  ";

        }

        return s;
    }
    private void visitaRicorsivo(Nodo destinazione){
        if(this!=destinazione){
            //System.out.print(this.nome+" inizio v ricorsivo archi:"+this.getArchiOrdinati().size());
            Nodo nTmp;
            Vector<Arco> archiOrd=getArchi();
            Arco arcoTmp;

            //ordino il vettore in base al peso
            for(int i=0;i<archiOrd.size()-1;i++){
                //se devo scambiare
                if(archiOrd.get(i).peso>archiOrd.get(i+1).peso){
                    //metto il ndo alla fine della lista
                    arcoTmp=archiOrd.get(i);
                    archiOrd.remove(i);
                    archiOrd.add(arcoTmp);

                    //indietreggio
                    i--;
                }
            }
            //System.out.println(" "+archiOrd.size());

            //visito i nodi
            for(Arco a:archiOrd){
                //System.out.println("loop "+this.nome+" per archi nodo da raggiungere: "+a.getOther(this).nome+" peso di questo nodo:"+this.pesoCorrente+" peso di arco:"+a.peso+"|");
                nTmp=a.getOther(this);
                if(nTmp.pesoCorrente==null||nTmp.pesoCorrente>this.pesoCorrente+a.peso){
                    //System.out.print("aggiorno perso  ");
                    //System.out.println(nTmp.pesoCorrente==null);
                    nTmp.pesoCorrente=this.pesoCorrente+a.peso;//peso
                    nTmp.visitaRicorsivo(destinazione);//attivo visitazione ricorsivi
                    //System.out.println("-----------");
                }
            }
            //System.out.println(this.nome+" fine v ricorsivo");
        }
    }
    public Vector<Nodo> customClone(Vector<Nodo> v){
        Vector<Nodo> vettore=new Vector<Nodo>();
        for(Nodo n:v){
            vettore.add(n);
        }
        return vettore;
    }

    public Vector<Arco> getArchi(){
        Vector<Arco> archiCollegati=new Vector<>();

        for(int i=0;i<archi.size();i++){
            archiCollegati.add(archi.get(i));
            //System.out.print("arco a: "+archi.get(i).getOther(this).nome);
        }
        //System.out.print("\n");

        return archiCollegati;
    }


    //netodi statici
    public static void setOvunquePesoInfinito(){
        for (Nodo n:nodiCreati){
            n.pesoCorrente=null;
        }
    }
    public static Nodo lightestNode(Nodo nodo,Vector<Nodo> nProibiti){
        if(nProibiti==null){
            nProibiti=new Vector<>();
        }
        Nodo winner=null;
        Nodo curNodo;
        for(int i=0;i<nodo.archi.size();i++){
            curNodo=nodo.archi.get(i).getOther(nodo);
            if((winner==null||curNodo.pesoCorrente<winner.pesoCorrente)&&!nProibiti.contains(curNodo)){
                winner=curNodo;
            }
        }
        //System.out.println("da:"+nodo.nome+" a lightestNode:"+winner.nome);
        return winner;
    }




}










