package ChatBot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class chatbot extends JFrame {
    //Area de texto
    private JTextField txtEntrada = new JTextField();
    
    //Area del Chat
    private JTextArea txtChat = new JTextArea();
    
    public chatbot(){
        
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
                txtChat.append("Tu: "+ texto + "\n");
                txtEntrada.setText("");
            }
        });
        
        //Atributos de txtChat
        txtChat.setLocation(15, 5);
        txtChat.setSize(560, 510);
        
        //Items del Frame
        this.add(txtEntrada);
        this.add(txtChat);
    }

    public static void main(String[] args) {
        new chatbot();
    }
    
}
