public class ABB{
    private Nodo raiz;

    ABB(){
        this.raiz = null;
    } 

    public boolean esVacio(){
        return (this.raiz == null); 
    }

    public Nodo getRaiz(){
        return this.raiz;
    }

    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }
        else insertarNodo(valor, this.raiz);
    }

    public void insertarNodo(int valor, Nodo nodoRef){
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            }
            else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        }
        else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                }
                else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }

    public void arbolHorizontal(int nivel, Nodo nodoRef){
        if(nodoRef == null){
            return; 
        }
        else{

            arbolHorizontal(nivel + 1, nodoRef.derecho);

            for(int i=0;i<nivel;i++){
                System.out.print("   ");
            }

            System.out.println("["+ nodoRef.dato + "]");
            arbolHorizontal(nivel + 1,nodoRef.izquierdo);
        }
    }

    public void inOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        inOrden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        inOrden(nodoRef.derecho);
    }

    public void preOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        System.out.print(nodoRef.dato + " - ");
        preOrden(nodoRef.izquierdo);
        preOrden(nodoRef.derecho);
    }

    public void postOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        postOrden(nodoRef.izquierdo);
        postOrden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }

    public boolean busqueda(int x, Nodo nodoRef){
        if (nodoRef==null)
            return false;
        else if(x<nodoRef.dato)
            return busqueda(x,nodoRef.izquierdo);
        else if(x>nodoRef.dato)
            return busqueda(x,nodoRef.derecho);
        else 
            return true; 
    }

    public void podarArbol(Nodo nodoRef)
    {
        if(nodoRef==null)
            return; //Termina

        //Se elimina el subnodoRef izquierdo
        podarArbol(nodoRef.izquierdo);
        //Se elimina el subnodoRef derecho
        podarArbol(nodoRef.derecho);
        //Se elimina el nodo actual
        nodoRef = null;
    }

    public Nodo buscaMayor(Nodo nodoRef) {
        if (nodoRef == null) {
            return null;
        } else if (nodoRef.derecho == null) {
            return nodoRef;
        } else {
            return buscaMayor(nodoRef.derecho);
        }
    }

    public void eliminarPredecesor(int x, Nodo nodoRef) {
        if (nodoRef == null) {
            return;
        } else if (x < nodoRef.dato) {
            eliminarPredecesor(x, nodoRef.izquierdo);
        } else if (x > nodoRef.dato) {
            eliminarPredecesor(x, nodoRef.derecho);
        } else if (nodoRef.izquierdo != null && nodoRef.derecho != null) {
            Nodo mayor = buscaMayor(nodoRef.izquierdo);
            nodoRef.dato = mayor.dato;
            eliminarPredecesor(mayor.dato, nodoRef.izquierdo);
        } else {
            if (nodoRef.izquierdo == null) {
                nodoRef = nodoRef.derecho;
            } else if (nodoRef.derecho == null) {
                nodoRef = nodoRef.izquierdo;
            }
        }
    }
}
