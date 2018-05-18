package ChatBot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Clase DB: Clase utilizada para la creacion del archivo que contiene
 * los datos que utiliza el ChatBot.
 * @author
 */
public class DB {
    
    /**
     * Metodo addLinea: Este metodo agrega una linea nueva de informacion
     * al archivo "datos.txt".
     * @param v
     * @param c
     * @param r
     * @throws IOException 
     */
    public void addLinea(int v, String c, String r) throws IOException{
        BufferedWriter escribe = new BufferedWriter(new FileWriter("datos.txt", true));
        escribe.write(v + "|" + c + "|" + r);
        escribe.newLine();
        escribe.flush();
        escribe.close();
    }
    
//    public String getRespuesta(String c) throws FileNotFoundException, IOException{
//        BufferedReader leer = new BufferedReader(new FileReader("datos.txt"));
//        String linea;
//        String registro[] = new String[3];
//        String respuesta = "Respuesta no registrada";
//        
//        while( (linea = leer.readLine()) != null){
//            registro = linea.split("\\|");
//            if(registro[1].equals(c)){
//                respuesta = registro[2];
//                return respuesta;
//            } else {
//                int decide = (int) (Math.random()*3+1);
//                switch (decide){
//                    case 1:
//                        respuesta = "No entendi eso";
//                        break;
//                    case 2:
//                        respuesta = "?";
//                        break;
//                    case 3:
//                        respuesta = "No puedo responder eso";
//                        break;
//                }
//            }
//        }
//        return respuesta;
//    }
    
}
