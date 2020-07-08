package chattingapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener{
    JPanel jp;
    JTextField jf;
    JButton jb;
    static JTextArea ja;
    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dos;
    Client(){
       jp=new JPanel();
       jp.setLayout(null);
       jp.setBounds(0,0,450, 70);
       jp.setBackground(new Color(7,94,84));
       add(jp);
         
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/3.png"));
       Image  i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(5, 17, 30, 30);
       jp.add(l1);
       
       l1.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent ae){
              System.exit(0);
          }
       });
       
       
       ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/8.png"));
       Image i5=i4.getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel l2=new JLabel(i6);
       l2.setBounds(40,5, 60,60);
       jp.add(l2);
       
       JLabel l6=new JLabel("Anjali");
       l6.setFont(new Font("SAN_SERIF",Font.BOLD,20));
       l6.setForeground(Color.WHITE);
       l6.setBounds(110,15, 100, 18);
       jp.add(l6);
       
       JLabel l7=new JLabel("Online");
       l7.setFont(new  Font("SAN_SERIF",Font.BOLD,14));
       l7.setForeground(Color.WHITE);
       l7.setBounds(110,40,100, 18);
       jp.add(l7);
       
       ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/phone.png"));
       Image i8=i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i9=new ImageIcon(i8);
       JLabel l3=new JLabel(i9);
       l3.setBounds(290, 20, 30, 30);
       jp.add(l3);
        
       ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/video.png"));
       Image i11=i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
       ImageIcon i12=new ImageIcon(i11);
       JLabel l4=new JLabel(i12);
       l4.setBounds(350, 20, 35, 30);
       jp.add(l4);
       
       ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/3icon.png"));
       Image i14=i13.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
       ImageIcon i15=new  ImageIcon(i14);
       JLabel l5=new JLabel(i15);
       l5.setBounds(410, 20, 13, 25);
       jp.add(l5);
      
       jf = new JTextField();
       jf.setBounds(5, 655, 315, 40);
       jf.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       add(jf);
       
       ja=new JTextArea();
       ja.setBounds(5,75,440,575);
       ja.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
       ja.setEditable(false);
       ja.setLineWrap(true);
       ja.setWrapStyleWord(true);
       add(ja);
        
       jb =new JButton("Send");
       jb.setBounds(320, 655, 123, 40);
       jb.setBackground(new Color(37,211,102));
       jb.setForeground(Color.WHITE);
       jb.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       jb.addActionListener(this);
       add(jb);
        
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       setTitle("Chatting Application");
       setSize(450, 700);
       setLocation(1100, 200);
       setUndecorated(true);
       setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
       try{ 
        String out=jf.getText();
        ja.setText(ja.getText()+"\n\t\t\t"+out);
        dos.writeUTF(out);
        jf.setText("");
       }
       catch(Exception e){}
    }
    
    public static void main(String[] args) {
        new Client().setVisible(true);
         try{
          s= new Socket("127.0.0.1", 3000);
          dis=new DataInputStream(s.getInputStream());
          dos=new DataOutputStream(s.getOutputStream());
          String msginput="";
          while(true)
          {
          msginput= dis.readUTF();
          ja.setText(ja.getText()+"\n"+msginput);
          }
     }
        catch(Exception e){}
    }
}

   
 
