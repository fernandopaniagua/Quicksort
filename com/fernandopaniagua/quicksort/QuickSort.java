package com.fernandopaniagua.quicksort;
import java.util.ArrayList;
/**
 * Implementación del algoritmo Quicksort<br>
 * <br>
 * Ver explicación del algoritmo Quicksort en <a href="https://es.wikipedia.org/wiki/Quicksort" target="_blank">Wikipedia</a><br>
 * <br>
 * Programado por <a href="http://www.fernandopaniagua.com" target="_blank">Fernando Paniagua</a><br>
 * <br>
 * @version 1.0.
 * @since 2016
 * @author Fernando Paniagua (fernando.paniagua@gmail.com)
 */
public class QuickSort {
    private static final int NUM_ELEMENTOS=1000;//Número máximo de elementos en la lista
    private static final int MAX=100;//Valor máximo de los elementos (el ranto será entre 0 y este valor)
    ArrayList<Integer> lista = new ArrayList();//Lista inicial
    ArrayList<Integer> listaOrdenada = new ArrayList();//Lista ordenada
    /**
     * Ejecuta el algoritmo QuickSort
     */
    private void ejecutaAlgoritmo(){
        this.generarSecuencia();
        this.muestraDatos(lista);
        listaOrdenada = this.getListaOrdenada(lista);
        this.muestraDatos(listaOrdenada);
    }
    /**
     * Realiza una generación aleatoria de los elementos de la lista
     */
    private void generarSecuencia(){
        //Poblamos la lista con valores entre 1 y MAX
        for (int i=0;i<NUM_ELEMENTOS;i++){
            lista.add(new Integer((int)(Math.random()*MAX)));
        }        
    }
    /**
     * Muestra por consola los datos de una lista
     * @param _lista Lista de Integer a mostrar
     */
    private void muestraDatos(ArrayList<Integer> _lista){
        System.out.println("");
        for (Integer numero : _lista) {
            System.out.print(numero + ",");
        }
    }
    /**
     * Obtiene una lista ordenada a partir de una lista de Integer
     * @param _lista Lista a ordenar
     * @return Lista ordenada
     */
    public ArrayList<Integer> getListaOrdenada(ArrayList<Integer> _lista){
        ArrayList<Integer> listaOrdenadaTemporal = new ArrayList();
        ArrayList<Integer> lMenor = new ArrayList();//Lista de elementos menores que el pivote
        ArrayList<Integer> lMayor = new ArrayList();//Lista de elementos mayores que el pivote
        int pivote;
        int actual;
        //Sólo si el tamaño de la lista es > 1.
        if (_lista.size()>1){
            pivote=_lista.get(0);
            for (int i=1;i<_lista.size();i++) {
                actual=_lista.get(i);
                if (actual<pivote){
                    lMenor.add(actual);
                } else {
                    lMayor.add(actual);
                }
            }
            //Llamadas recursivas al método de ordenación
            if (lMenor.size()>1) lMenor = getListaOrdenada(lMenor);
            if (lMayor.size()>1) lMayor = getListaOrdenada(lMayor);
            //Concatena la lista de elementos menores que el pivote + pivote + elementos mayores que el pivote
            listaOrdenadaTemporal.addAll(lMenor);
            listaOrdenadaTemporal.add(pivote);
            listaOrdenadaTemporal.addAll(lMayor);
        }
        return listaOrdenadaTemporal;
    }
    /**
     * Método main de la aplicación
     * @param args Argumentos - Sin uso
     */
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        qs.ejecutaAlgoritmo();
    }
    
    
}
