// Created by Ziad in the OOSE Vorlesung

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI extends JPanel {
  JButton b1 = new JButton ("knopf 1");
  JButton b2 = new JButton ("knopf 2");
  JTextField tf = nesw JTextField(30);


  //Erstellung einer inneren Klasse innheralb einer Klasse
  private class ZweiteAktion implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
      tf.setText(tf.getText().toUpperCase());
    }
  }

  public GUI () {
    this.add(b1);
    this.add(b2);
    this.add(tf);

    //1. Möglichkeit Action Listener durch externe normale Klasse implementiert
    b1.addActionListener(new ErsteAktion);

    // 2. Möglichkeit: ActionLIstener durch innere Klasse implementiert
    // Vorteil: alles in einer Datei. Innere Klassen kennt
    //alles aus eigener Umgebung
    b1.addActionListener(new ZweiteAktion());

    //3. Möglichkeit: Anonyme Klasse
    //wenn man nur ein Objekt der Klasse braucht
    b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Version 2");
        tf.setText(tf.getText().toUpperCase());
      }
    });

    //4. Möglichkeit: Lambda Ausdruck
    //Original
    b1.addActionListener((x)->tf.setText(tf.getText().toUpperCase()));
    b1.addActionListener((x)-> {
      tf.setText(tf.getText().toUpperCase())
              system
    }
    });
    //mehrere Anweisungen


    //5. Möglichkeit: Du bist der ActionListener
    b1.addActionListener(this);

    b2.addActionListener((e)-> tf.setText(""));
  }

  public static void main(String[] args){
    JFrame f = new JFrame();

    f.addWindowListener(new WindowListener() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    f.add(new GUI());
    f.pack();
    f.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==b1) tf.setText(tf.getText().toUpperCase());
    else if (e.getSource()==b1) tf.setText("");
  }
}
