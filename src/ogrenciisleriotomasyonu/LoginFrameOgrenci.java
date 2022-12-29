
package ogrenciisleriotomasyonu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class LoginFrameOgrenci extends JFrame implements ActionListener{
    JPasswordField pass = new JPasswordField(4);
    JTextField id = new JTextField(11);
    JLabel şifrel = new JLabel("Şifre: ");
    JButton login1 = new JButton("Giriş Yap");
    JButton back = new JButton("Geri Dön");
    JLabel idl = new JLabel("ID: ");
    ArrayList idler = new ArrayList<>();
    ArrayList şifreler = new ArrayList<>();
    String a,b;
    Ogrenci m = new Ogrenci();
    public LoginFrameOgrenci(){
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğrenci Penceresi");
        this.add(şifrel);
        this.add(pass);
        this.add(login1);
        this.add(id);
        this.add(idl);
        this.add(back);
        
        şifrel.setVisible(true);
        şifrel.setBounds(220,250,100,25);
        
        idl.setVisible(true);
        idl.setBounds(220,210,100,25);
        
        pass.setBounds(270,250,165,25);
        pass.setVisible(true);
        
        id.setVisible(true);
        id.setBounds(270,210,165,25);
        
        login1.setVisible(true);
        login1.setBounds(300,300,100,25);
        login1.addActionListener(this);
        
        back.setVisible(true);
        back.setBounds(300,340,100,25);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login1){
            a = id.getText();
            b = pass.getText();
            try {
                if(m.giriş(a,b)==true){
                    JOptionPane.showMessageDialog(this,"Giriş Başarılı!");
                    this.dispose();
                    new MainMenuOgrenci();
                }
                else{
                    JOptionPane.showMessageDialog(this,"ID ve şifre eşleşmelidir.", "Giriş Başarısız!", HEIGHT);
                    this.dispose();
                    new LoginFrameOgrenci();
                }
            }catch (IOException ex) {
                Logger.getLogger(LoginFrameOgrenci.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==back)
        {
            this.dispose();
            new MyFrame();
        }
    }
}
