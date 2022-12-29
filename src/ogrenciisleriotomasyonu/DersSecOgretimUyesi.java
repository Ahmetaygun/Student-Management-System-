
package ogrenciisleriotomasyonu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static ogrenciisleriotomasyonu.DerslerOgretim.*;
import static ogrenciisleriotomasyonu.KayitOgretim.*;


class DersSecOgretimUyesi extends JFrame implements ActionListener{
    ArrayList derslertf = new ArrayList<>();
    JButton geri = new JButton("Geri Dön");
    JButton kayıt = new JButton("Kaydet");
    JLabel derslerl = new JLabel("Dersler");
    JCheckBox ders1 = new JCheckBox("Ders 1", false);
    JCheckBox ders2 = new JCheckBox("Ders 2", false);
    JCheckBox ders3 = new JCheckBox("Ders 3", false);
    JCheckBox ders4 = new JCheckBox("Ders 4", false);
    JCheckBox ders5 = new JCheckBox("Ders 5", false);
    JCheckBox ders6 = new JCheckBox("Ders 6", false);
    JCheckBox ders7 = new JCheckBox("Seçmeli Ders 1", false);
    JCheckBox ders8 = new JCheckBox("Seçmeli Ders 2", false);
    JCheckBox ders9 = new JCheckBox("Seçmeli Ders 3", false);
    JCheckBox ders10 = new JCheckBox("Seçmeli Ders 4", false);
    Font selam = new Font("selam", Font.BOLD, 15);
    String a = null,b = null,c = null,d = null;
    int e = 50;
    OgretimUyesi ogretim;
    DerslerOgretim derslerc;
    DersSecOgretimUyesi(){
        try {
            this.ogretim = new OgretimUyesi();
        } catch (IOException ex) {
            Logger.getLogger(DersSecOgretimUyesi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.derslerc = new DerslerOgretim();
        } catch (IOException ex) {
            Logger.getLogger(DersSecOgretimUyesi.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğretim Üyesi Kayıt");
        this.add(derslerl);
        this.add(kayıt);
        this.add(geri);
        
        derslertf.add(ders1);
        derslertf.add(ders2);
        derslertf.add(ders3);
        derslertf.add(ders4);
        derslertf.add(ders5);
        derslertf.add(ders6);
        derslertf.add(ders7);
        derslertf.add(ders8);
        derslertf.add(ders9);
        derslertf.add(ders10);
        
        derslerl.setVisible(true);
        derslerl.setBounds(100,10,100,50);
        derslerl.setFont(selam);
        
        kayıt.setVisible(true);
        kayıt.setBounds(300,575,100,25);
        kayıt.addActionListener(this);
        
        geri.setVisible(true);
        geri.setBounds(300,610,100,25);
        geri.addActionListener(this);
        
        for(int j=0; j<derslertf.size();j++){
            this.add((JCheckBox)derslertf.get(j));
            ((JCheckBox)derslertf.get(j)).setVisible(true);
            ((JCheckBox)derslertf.get(j)).setBounds(100,e,150,50);
            e+=50;
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == kayıt){
            for (int j = 0; j < derslertf.size(); j++) {
                if (j < derslertf.size() - 1) {
                    if (((JCheckBox) derslertf.get(j)).isSelected()) {
                        dersler.add("t,");
                    } else {
                        dersler.add("f,");
                    }
                } else {
                    if (((JCheckBox) derslertf.get(j)).isSelected()) {
                        dersler.add("t");
                    } else {
                        dersler.add("f");
                    }
                }
            }
            try {
                derslerc.DersSecGecici();
                ogretim.kayıt(a, b, c, d);
                if(OgretimUyesi.kayıth){
                    derslerc.DersSecOgretim(dersler);
                    JOptionPane.showMessageDialog(this, "Ders Seçme Başarılı!");
                    dersler.clear();
                }else{
                    
                }
                
            } catch (IOException ex) {
                Logger.getLogger(KayitOgrenci.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (OgretimUyesi.kayıth) {
                JOptionPane.showMessageDialog(this, "Kayıt Başarılı!");
            } else {
                JOptionPane.showMessageDialog(this, "Varolan ID ile kayıt olunamaz", "Kayıt Başarısız!", HEIGHT);
            }
            this.dispose();
            new MainMenuPersonel();
        }
        if(e.getSource() == geri){
            this.dispose();
            new KayitOgretim();
        }
    }
}
