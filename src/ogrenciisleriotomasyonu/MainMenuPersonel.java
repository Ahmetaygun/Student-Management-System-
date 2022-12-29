
package ogrenciisleriotomasyonu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


class MainMenuPersonel extends JFrame implements ActionListener{
    JButton kisisel = new JButton("Profil");
    JButton ogretim_kayit = new JButton("Öğretim Görevlisi Kayıt");
    JButton duyurular = new JButton("Duyurular");
    JButton personel_kayit = new JButton("Personel Kayıt");
    JButton ogrenci_kayit = new JButton("Öğrenci Kayıt");
    JButton şifred = new JButton("Şifre Değiştir");
    JButton anamenü = new JButton("Ana Menüye Dön");
    JButton çıkış = new JButton("Çıkış Yap");
    public MainMenuPersonel(){
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Personel Ana Menü");
        this.add(kisisel);
        this.add(ogretim_kayit);
        this.add(personel_kayit);
        this.add(duyurular);
        this.add(ogrenci_kayit);
        this.add(şifred);
        this.add(anamenü);
        this.add(çıkış);
        
        çıkış.setVisible(true);
        çıkış.addActionListener(this);
        çıkış.setBounds(255,550,175,100);
        
        kisisel.setVisible(true);
        kisisel.addActionListener(this);
        kisisel.setBounds(55,25,175,100);
        
        ogretim_kayit.setVisible(true);
        ogretim_kayit.addActionListener(this);
        ogretim_kayit.setBounds(55,200,175,100);
        
        personel_kayit.setVisible(true);
        personel_kayit.addActionListener(this);
        personel_kayit.setBounds(55,375,175,100);
        
        duyurular.setVisible(true);
        duyurular.addActionListener(this);
        duyurular.setBounds(455,25,175,100);
        
        ogrenci_kayit.setVisible(true);
        ogrenci_kayit.addActionListener(this);
        ogrenci_kayit.setBounds(455,200,175,100);
        
        şifred.setVisible(true);
        şifred.addActionListener(this);
        şifred.setBounds(455,375,175,100);
        
        anamenü.setVisible(false);
        anamenü.addActionListener(this);
        anamenü.setBounds(330,510,135,75);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ogrenci_kayit){
            this.dispose();
            new KayitOgrenci();
        }
        if(e.getSource()==ogretim_kayit){
            this.dispose();
            new KayitOgretim();
        }
        if(e.getSource()==kisisel){
            this.dispose();
            new ProfilPersonel();
        }
        if(e.getSource()==personel_kayit){
            this.dispose();
            new KayitPersonel();
        }
        if(e.getSource()==şifred){
            this.dispose();
            new SifreDegistirP();
        }
        if(e.getSource()==duyurular){
            this.dispose();
            try {
                new DuyuruPersonel();
            } catch (IOException ex) {
                Logger.getLogger(MainMenuPersonel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==anamenü){
            this.dispose();
            new MainMenuPersonel();
        }
        if(e.getSource()==çıkış){
            this.dispose();
            Ogrenci.i=0;
            Ogrenci.idler.clear();
            new MyFrame();
        }
    }
}