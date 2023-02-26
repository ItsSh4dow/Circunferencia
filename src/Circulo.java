import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circulo extends JFrame{
    private int x = 250, y=180; 
    private JButton derecha, izquierda;
    private JPanel panel;

    public Circulo(){
        super("Dibujar un triangulo");
        this.setSize(650,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        inicarComponentes();
    }
    public void inicarComponentes(){
        agregarPanel();
        colocarBotones();
    } 
    public void agregarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }   
    public void colocarBotones(){
        izquierda = new JButton("Izquierda");
        izquierda.setBounds(50, 380, 150, 30);
        izquierda.setFont(new Font("Century Gothic", Font.PLAIN,20));
        panel.add(izquierda);

        derecha = new JButton("Derecha");
        derecha.setBounds(380, 380, 150, 30);
        derecha.setFont(new Font("Century Gothic", Font.PLAIN,20));

        panel.add(derecha);

        moverCirculo();
    }
    public void moverCirculo(){
        ActionListener eventosBotones = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == izquierda)
                    x -= 10;
                else if(e.getSource() == derecha)
                    x += 10;
                
            }

        };
        izquierda.addActionListener(eventosBotones);
        derecha.addActionListener(eventosBotones);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 100, 100);
        repaint();
    }
}