package ChatBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Clase Arbol: Crea el Nodo raiz y las variables que se usaran para
 * dar una respuesta final por parte del ChatBot.
 * @author 
 */
public class Arbol {
    Nodo raiz;
    public String rFinal;
    public String rError;
    public boolean pase = true;
    
    public Arbol(){
        raiz = null;
    }
    
    /**
     * Metodo addNodo: Este metodo es el encargado de agregar y ubicar
     * los nuevos nodos a el arbol.
     * @param v - valor (Sirve para ordenar el arbol)
     * @param c - comentario (Es lo que el usuario engresa)
     * @param r  - respuesta (Es lo que la IA responde)
     */
    public void addNodo(int v, String c, String r)    {
        Nodo nuevo = new Nodo(v, c, r);
        if (raiz == null){
            raiz = nuevo;
        } else{
            Nodo auxiliar = raiz;
            Nodo padre;
            while (true){
                padre = auxiliar;
                if(v < auxiliar.valor) {
                    auxiliar = auxiliar.izquierdo;
                    if (auxiliar == null){
                        padre.izquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.derecho;
                    if( auxiliar == null){
                        padre.derecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    
    /**
     * Metodo inOrden: Metodo utilizado para visualizar el arbol de forma
     * plana.
     * @param r 
     */
    public void inOrden(Nodo r){
        if(r!=null){
            inOrden(r.izquierdo);
            System.out.print(r.valor+" | "+r.comentario + " | " + r.respuesta + "\n");
            inOrden(r.derecho);
        }
    }
    
    /**
     * Metodo recorrido: Este metodo es el que recorre el arbol en busca
     * de una coincidencia, de encontrarla guarda la respuesta en rFinal,
     * de lo contrario usa el metodo error para asignar una resuesta de
     * error.
     * @param r
     * @param c 
     */
    public void recorrido(Nodo r, String c){
        if(r!=null){
            recorrido(r.izquierdo, c);
                if((r.comentario).equals(c)){
                    rFinal = r.respuesta;
                    pase = false;
                } else if (pase == true){
                    rFinal ="";
                    error(rFinal);
                }
            recorrido(r.derecho, c);
        }
    }
    
    /**
     * Metodo error: Asigna aleatoriamente una respuesta de error a la
     * variable rFinal.
     * @param rF 
     */
    public void error(String rF){
        if (rF == ""){
            int decide = (int) (Math.random()*3+1);
            switch (decide){
                case 1:
                    rError = "No entendi eso";
                    break;
                case 2:
                    rError = "?";
                    break;
                case 3:
                    rError = "No puedo responder eso";
                    break;
            }
        }
        rFinal = rError;
    }
    
    /**
     * Metodo llenarArbol: Lee el archivo "datos.txt" y separa su contendio
     * en nuevos nodos utilizando el metodo addNodo.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void llenarArbol() throws FileNotFoundException, IOException{
        BufferedReader dato = new BufferedReader(new FileReader("datos.txt"));
        String linea;
        String registro[] = new String[3];
        
        while( (linea = dato.readLine()) != null){
            registro = linea.split("\\|");
            addNodo(Integer.parseInt(registro[0]), registro[1], registro[2]);
        }
     
    }
    
    /**
     * Metodo reset: Limpia el contenido de la variable rFinal y le asigna
     * un valor de true a la variable pase.
     */    
    public void reset(){
        this.rFinal = "";
        this.pase = true;
    }
}
