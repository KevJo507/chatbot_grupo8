package ChatBot;

/**
 * Clase Nodo: En esta clase se define la estructura de cada nodo que 
 * contrendra el arbol.
 * @author 
 */
public class Nodo {
    public int valor;
    public String comentario , respuesta;
    public Nodo derecho, izquierdo;
    
    public Nodo (int v, String c, String r){
        this.valor = v;
        this.comentario = c;
        this.respuesta = r;
        this.derecho = null;
        this.izquierdo = null;
    }

    public int getValor() {
        return valor;
    }
    
    public String getComentario() {
        return comentario;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
