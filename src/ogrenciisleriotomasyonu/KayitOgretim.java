
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
import static ogrenciisleriotomasyonu.DersSecOgretimUyesi.*;

class KayitOgretim extends JFrame implements ActionListener{
    JPasswordField pass = new JPasswordField();
    JTextField id = new JTextField();
    JTextField isim = new JTextField();
    JTextField soyisim = new JTextField();
    JLabel şifrel = new JLabel("Şifre: ");
    JLabel soyisiml = new JLabel("Soyisim: ");
    JLabel isiml = new JLabel("İsim: ");
    JButton kayit = new JButton("İleri");
    JButton anamenu = new JButton("Ana Menü");
    JLabel idl = new JLabel("ID: ");
    JLabel uyarı = new JLabel("(ID 11 haneli tam sayı ve şifre 4 haneli tam sayı olmalıdır.)");
    ArrayList idler = new ArrayList<>();
    ArrayList şifreler = new ArrayList<>();
    OgretimUyesi ogretim;
    String x,f,g,h;
    public KayitOgretim(){
        this.setVisible(true);
        this.setSize(500,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğretim Üyesi Kayıt Penceresi");
        this.add(id);
        this.add(idl);
        this.add(pass);
        this.add(şifrel);
        this.add(kayit);
        this.add(uyarı);
        this.add(isim);
        this.add(isiml);
        this.add(soyisim);
        this.add(soyisiml);
        this.add(anamenu);
        
        uyarı.setVisible(true);
        uyarı.setBounds(80,320,350,25);
        
        kayit.setVisible(true);
        kayit.setBounds(190,430,100,25);
        kayit.addActionListener(this);
        
        anamenu.setVisible(true);
        anamenu.setBounds(190,480,100,25);
        anamenu.addActionListener(this);
        
        şifrel.setVisible(true);
        şifrel.setBounds(110,200,100,25);
        
        idl.setVisible(true);
        idl.setBounds(110,160,165,25);
        
        pass.setBounds(180,200,165,25);
        pass.setVisible(true);
        
        isim.setVisible(true);
        isim.setBounds(180,240,165,25);
        
        soyisim.setVisible(true);
        soyisim.setBounds(180,280,165,25);
        
        isiml.setVisible(true);
        isiml.setBounds(110,240,165,25);
        
        soyisiml.setVisible(true);
        soyisiml.setBounds(110,280,165,25);
        
        id.setVisible(true);
        id.setBounds(180,160,165,25);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==anamenu){
            this.dispose();
            new MainMenuPersonel();
        }
        if(e.getSource()==kayit){
            x = id.getText();
            f = pass.getText();
            g= isim.getText();
            h = soyisim.getText();
            if((id.getText()).isEmpty()||(pass.getText()).isEmpty()||(isim.getText()).isEmpty()||(soyisim.getText()).isEmpty()){
                JOptionPane.showMessageDialog(this, "Boşlukları Doldurunuz.", "Kayıt Başarısız!", HEIGHT);
                this.dispose();
                new KayitOgretim();
            }
            else{
//                try {
//                    ogretim.kayıt(x, f, g, h);
////                    if(OgretimUyesi.kayıth){
////                        DersSecOgretimUyesi bosluk = new DersSecOgretimUyesi();
////                        bosluk.a = id.getText();
////                        bosluk.b = pass.getText();
////                        bosluk.c = isim.getText();
////                        bosluk.d = soyisim.getText();
////                        this.dispose();
////                    }
////                    else{
////                        JOptionPane.showMessageDialog(this, "Var olan ID ile kayıt olunamaz.", "Kayıt Başarısız!", HEIGHT);
////                    }
//                } catch (IOException ex) {
//                    Logger.getLogger(KayitOgretim.class.getName()).log(Level.SEVERE, null, ex);
//                }
                DersSecOgretimUyesi bosluk = new DersSecOgretimUyesi();
                bosluk.a = id.getText();
                bosluk.b = pass.getText();
                bosluk.c = isim.getText();
                bosluk.d = soyisim.getText();
                this.dispose();
            }
        }
    }
}
