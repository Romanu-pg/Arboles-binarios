import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase ABB
        ABB arbol = new ABB();
        //Nodo raizArbolPtr = arbol.getRaiz();

        // Insertar nodos en el árbol 9,2,1,16,6,11,8,4
        arbol.insertarValor(9);
        arbol.insertarValor(2);
        arbol.insertarValor(1);
        arbol.insertarValor(16);
        arbol.insertarValor(6);
        arbol.insertarValor(11);
        arbol.insertarValor(8);
        arbol.insertarValor(4);

        // Mostrar el árbol horizontalmente
        arbol.arbolHorizontal(0, arbol.getRaiz());

        // Realizar recorridos en orden, preorden y postorden
        System.out.println("Recorrido en orden:");
        arbol.inOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en preorden:");
        arbol.preOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en postorden:");
        arbol.postOrden(arbol.getRaiz());

        // Buscar un valor en el árbol
        int valorBuscado = 16;
        if(arbol.busqueda(valorBuscado, arbol.getRaiz()))
            System.out.println("\nEl valor " + valorBuscado + " se encuentra en el árbol.");
        else
            System.out.println("\nEl valor " + valorBuscado + " no se encuentra en el árbol.");

        // Eliminar todos los nodos del árbol
        arbol.eliminarPredecesor(6,arbol.getRaiz());   
        arbol.arbolHorizontal(0, arbol.getRaiz());
    }
}
