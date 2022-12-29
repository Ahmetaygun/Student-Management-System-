
package ogrenciisleriotomasyonu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;


class MainMenuOgretim extends JFrame implements ActionListener{
    JButton kisisel = new JButton("Profil");
    JButton ders_verme = new JButton("Ders Verilen Öğrenciler");
    JButton duyurular = new JButton("Duyurular");
    JButton notlar = new JButton("Ders Notları");
//    JButton dokuman = new JButton("Döküman Paylaşımı");
    JButton şifred = new JButton("Şifre Değiştir");
    JButton anamenü = new JButton("Ana Menüye Dön");
    JButton çıkış = new JButton("Çıkış Yap");
    public MainMenuOgretim(){
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğretim Üyesi Ana Menü");
        this.add(kisisel);
        this.add(ders_verme);
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
        
        ders_verme.setVisible(true);
        ders_verme.addActionListener(this);
        ders_verme.setBounds(55,200,175,100);
        
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
            new ProfilOgretim();
        }
        if(e.getSource()==şifred){
            this.dispose();
            new SifreDegistirOgretim();
        }
        if(e.getSource()==anamenü){
                this.dispose();
                new MainMenuOgretim();
        }
        if(e.getSource()==çıkış){
            this.dispose();
            Ogrenci.i=0;
            Ogrenci.idler.clear();
            new MyFrame();
        }
        if(e.getSource()==notlar){
            this.dispose();
            new OgretimNotGirOgrenciSec();
        }
        if(e.getSource()==ders_verme){
            this.dispose();
            new DersVermeOgretim();
        }
        if(e.getSource()==duyurular){
            this.dispose();
            try {
                new DuyuruOgretim();
            } catch (IOException ex) {
                Logger.getLogger(MainMenuOgretim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}