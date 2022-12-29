
package ogrenciisleriotomasyonu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


class MainMenuOgrenci extends JFrame implements ActionListener{
    JButton kisisel = new JButton("Profil");
    JButton ders_alma = new JButton("Ders Alma");
    JButton duyurular = new JButton("Duyurular");
    JButton notlar = new JButton("Ders Notları");
//    JButton dokuman = new JButton("Döküman Paylaşımı");
    JButton şifred = new JButton("Şifre Değiştir");
    JButton anamenü = new JButton("Ana Menüye Dön");
    JButton çıkış = new JButton("Çıkış Yap");
    public MainMenuOgrenci(){
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğrenci Ana Menü");
        this.add(kisisel);
        this.add(ders_alma);
        this.add(notlar);
        this.add(duyurular);
//        this.add(dokuman);
        this.add(şifred);
        this.add(anamenü);
        this.add(çıkış);
        
        çıkış.setVisible(true);
        çıkış.addActionListener(this);
        çıkış.setBounds(255,550,175,100);
        
        kisisel.setVisible(true);
        kisisel.addActionListener(this);
        kisisel.setBounds(55,25,175,100);
        
        ders_alma.setVisible(true);
        ders_alma.addActionListener(this);
        ders_alma.setBounds(55,200,175,100);
        
        notlar.setVisible(true);
        notlar.addActionListener(this);
        notlar.setBounds(55,375,175,100);
        
        duyurular.setVisible(true);
        duyurular.addActionListener(this);
        duyurular.setBounds(455,25,175,100);
        
//        dokuman.setVisible(true);
//        dokuman.addActionListener(this);
//        dokuman.setBounds(455,200,175,100);
        
        şifred.setVisible(true);
        şifred.addActionListener(this);
        şifred.setBounds(455,375,175,100);
        
        anamenü.setVisible(false);
        anamenü.addActionListener(this);
        anamenü.setBounds(330,510,135,75);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==kisisel){
            this.dispose();
            new ProfilOgrenci();
        }
        if(e.getSource()==ders_alma){
            this.dispose();
            new DersAlmaOgrenci();
        }
        if(e.getSource()==notlar){
            this.dispose();
            new DersNotlariOgrenci();
        }
        if(e.getSource()==şifred){
            this.dispose();
            new SifreDegistirOgrenci();
        }
        if(e.getSource()==anamenü){
                this.dispose();
                new MainMenuOgrenci();
        }
        if(e.getSource()==çıkış){
            this.dispose();
            Ogrenci.i=0;
            Ogrenci.idler.clear();
            new MyFrame();
        }
        if(e.getSource()==duyurular){
            this.dispose();
            try {
                new DuyuruOgrenci();
            } catch (IOException ex) {
                Logger.getLogger(MainMenuOgrenci.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}