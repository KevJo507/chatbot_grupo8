package ChatBot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class chatbot extends JFrame {
    //Area de texto
    private JTextField txtEntrada = new JTextField();
    
    //Area del Chat
    private JTextArea txtChat = new JTextArea();
    
    public Arbol arbol = new Arbol();
    
    public chatbot() throws IOException{
        
        arbol.llenarArbol();
        
        //Atributos del Frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Chat Bot");
        this.setLocationRelativeTo(null);
                
        //Atributos de txtEntrada
        txtEntrada.setLocation(2, 540);
        txtEntrada.setSize(590, 30);
        
        //Evento de txtEntrada
        txtEntrada.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String texto = txtEntrada.getText();
                
                //Impreson en ventana de lo que el usuario escribe
                txtChat.append("Tu: "+ texto + "\n");
                txtEntrada.setText("");
                
                /*Recorrido de arbol en busca de una coincidencia del texto 
                ingresado e impresion de la respuesta del ChatBot*/
                arbol.recorrido(arbol.raiz, texto);
                txtChat.append("IA: " + arbol.rFinal + "\n");
                arbol.reset();
            }
        });
        
        //Atributos de txtChat
        txtChat.setLocation(15, 5);
        txtChat.setSize(560, 510);
        
        //Items del Frame
        this.add(txtEntrada);
        this.add(txtChat);
        txtEntrada.requestFocus();
    }
    
    public static void main(String[] args) throws IOException {
        new chatbot();
    }
}
