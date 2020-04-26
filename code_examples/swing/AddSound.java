import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class AddSound extends JFrame{
 JButton Play = new JButton("play"); 
  JButton Loop = new JButton("Loop");
  JButton Stop = new JButton("Stop");
  
  URL url = AddSound.class.getResource("Overworld Theme - Super Mario Run Soundtrack (OST).wav");
  AudioClip clip = Applet.newAudioClip(url);
  
  public AddSound(){
  super("AddingSound");
  setLayout(new FlowLayout());
  
  Play.addActionListener(new ActionListener(){
    
    public void actionPerformanced(ActionEvent event) {
     clip.play(); 
    }
  });
  
  Loop.addActionListener(new ActionListener(){
    
    public void actionPerformanced(ActionEvent event) {
     clip.loop(); 
    }
  }  );
  
  Stop.addActionListener(new ActionListener(){
    
    public void actionPerformanced(ActionEvent event) {
     clip.stop(); 
    }
  }  );
  add(Play);
  add(Loop);
  add(Stop);
  }
  
  public static void main(String args[]){
  JFrame frame = new AddSound();
  frame.setDefaultCloseOperation(JFrame.Exit_ON_CLOSE);
  frame.setSize(90,90);
  frame.setVisible(true);
  }
}