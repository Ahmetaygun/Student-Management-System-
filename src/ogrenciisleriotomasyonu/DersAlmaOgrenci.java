
package ogrenciisleriotomasyonu;

import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import ogrenciisleriotomasyonu.Dersler;
import ogrenciisleriotomasyonu.DerslerOgretim;
import ogrenciisleriotomasyonu.MainMenuOgrenci;
import static ogrenciisleriotomasyonu.Dersler.*;
import static ogrenciisleriotomasyonu.DerslerOgretim.*;

class DersAlmaOgrenci extends JFrame implements ActionListener{
    static ArrayList derskredilertf  = new ArrayList<>();
    static ArrayList derslertf = new ArrayList<>();
    static ArrayList ogretimtf = new ArrayList<>();
    JCheckBox ders1 = new JCheckBox("Ders 1",false);
    JCheckBox ders2 = new JCheckBox("Ders 2",false);
    JCheckBox ders3 = new JCheckBox("Ders 3",false);
    JCheckBox ders4 = new JCheckBox("Ders 4",false);
    JCheckBox ders5 = new JCheckBox("Ders 5",false);
    JCheckBox ders6 = new JCheckBox("Ders 6",false);
    JCheckBox ders7 = new JCheckBox("Seçmeli Ders 1",false);
    JCheckBox ders8 = new JCheckBox("Seçmeli Ders 2",false);
    JCheckBox ders9 = new JCheckBox("Seçmeli Ders 3",false);
    JCheckBox ders10 = new JCheckBox("Seçmeli Ders 4",false);
    JLabel toplamkreditxt = new JLabel();
    JLabel derskredi1 = new JLabel();
    JLabel derskredi2 = new JLabel();
    JLabel derskredi3 = new JLabel();
    JLabel derskredi4 = new JLabel();
    JLabel derskredi5 = new JLabel();
    JLabel derskredi6 = new JLabel();
    JLabel derskredi7 = new JLabel();
    JLabel derskredi8 = new JLabel();
    JLabel derskredi9 = new JLabel();
    JLabel derskredi10 = new JLabel();
    JLabel ogretim1 = new JLabel();
    JLabel ogretim2 = new JLabel();
    JLabel ogretim3 = new JLabel();
    JLabel ogretim4 = new JLabel();
    JLabel ogretim5 = new JLabel();
    JLabel ogretim6 = new JLabel();
    JLabel ogretim7 = new JLabel();
    JLabel ogretim8 = new JLabel();
    JLabel ogretim9 = new JLabel();
    JLabel ogretim10 = new JLabel();
    JLabel toplamkredil = new JLabel("Toplam AKTS:");
    JLabel derslerl = new JLabel("Dersler");
    JLabel kredilerl = new JLabel("Ders AKTS");
    JLabel ogretimuyeleril = new JLabel("Öğretim Üyesi"); 
    JButton kaydet = new JButton("Kaydet");
    JButton anamenü = new JButton("Ana Menü");
    Font selam = new Font("selam", Font.BOLD, 15);
    Dersler d = new Dersler();
    DerslerOgretim ogretim;
    int a = 50;
    int b = 50;
    int toplamkredi = 0;
    DersAlmaOgrenci(){
        Dersler.ArraylereAt();
        try {
            this.ogretim = new DerslerOgretim();
        } catch (IOException ex) {
            Logger.getLogger(DersAlmaOgrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğrenci Ders Alma");
        this.add(kaydet);
        this.add(anamenü);
        this.add(derslerl);
        this.add(kredilerl);
        this.add(ogretimuyeleril);
        this.add(toplamkreditxt);
        this.add(toplamkredil);
        
        ogretimtf.clear();
        ogretimtf.add(ogretim1);
        ogretimtf.add(ogretim2);
        ogretimtf.add(ogretim3);
        ogretimtf.add(ogretim4);
        ogretimtf.add(ogretim5);
        ogretimtf.add(ogretim6);
        ogretimtf.add(ogretim7);
        ogretimtf.add(ogretim8);
        ogretimtf.add(ogretim9);
        ogretimtf.add(ogretim10);
        
        
        derslertf.clear();
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
        
        derskredilertf.clear();
        derskredilertf.add(derskredi1);
        derskredilertf.add(derskredi2);
        derskredilertf.add(derskredi3);
        derskredilertf.add(derskredi4);
        derskredilertf.add(derskredi5);
        derskredilertf.add(derskredi6);
        derskredilertf.add(derskredi7);
        derskredilertf.add(derskredi8);
        derskredilertf.add(derskredi9);
        derskredilertf.add(derskredi10);
        
        toplamkredil.setVisible(true);
        toplamkredil.setBounds(100,550,100,50);
        toplamkredil.setFont(selam);
        
        ogretimuyeleril.setVisible(true);
        ogretimuyeleril.setBounds(450,10,100,50);
        ogretimuyeleril.setFont(selam);
        
        kredilerl.setVisible(true);
        kredilerl.setBounds(265,10,100,50);
        kredilerl.setFont(selam);
        
        derslerl.setVisible(true);
        derslerl.setBounds(125,10,100,50);
        derslerl.setFont(selam);
        
        anamenü.setVisible(true);
        anamenü.addActionListener(this);
        anamenü.setBounds(455,600,150,65);
        
        kaydet.setVisible(true);
        kaydet.addActionListener(this);
        kaydet.setBounds(95,600,150,65);
        
        for(int j = 0; j < derslertf.size(); j++){
            this.add((JCheckBox)derslertf.get(j));
            ((JCheckBox)derslertf.get(j)).setVisible(true);
            ((JCheckBox)derslertf.get(j)).setBounds(100,a,200,50);
            if(str[j].equals("t")){
                ((JCheckBox)derslertf.get(j)).setSelected(true);
            }
            else if(str[j].equals("f")){
                ((JCheckBox)derslertf.get(j)).setSelected(false);
            }
            if(((JCheckBox)derslertf.get(j)).isSelected()){
                toplamkredi = toplamkredi + parseInt(str2[j]);
            }
            a += 50;
        }
        for(int j=0; j<derskredilertf.size(); j++){
            this.add((JLabel)derskredilertf.get(j));
            ((JLabel)derskredilertf.get(j)).setVisible(true);
            ((JLabel)derskredilertf.get(j)).setBounds(300,b,100,50);
            ((JLabel)derskredilertf.get(j)).setText(str2[j]);
            this.add((JLabel)ogretimtf.get(j));
            ((JLabel)ogretimtf.get(j)).setVisible(true);
            ((JLabel)ogretimtf.get(j)).setBounds(450,b,100,50);
            ((JLabel)ogretimtf.get(j)).setText(DerslerOgretim.arrstr2[j]);
            b += 50;
        }
        
        toplamkreditxt.setVisible(true);
        toplamkreditxt.setBounds(300,550,100,50);
        toplamkreditxt.setText(String.valueOf(toplamkredi));
        toplamkreditxt.setFont(selam);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == anamenü){
            this.dispose();
            new MainMenuOgrenci();
        }
        
        if(e.getSource() == kaydet){
            toplamkredi=0;
            for(int j=0; j<derslertf.size();j++){
                if(((JCheckBox)derslertf.get(j)).isSelected()){
                toplamkredi = toplamkredi + parseInt(str2[j]);
            }
            }
            if(toplamkredi<20){
                JOptionPane.showMessageDialog(this, "En Az 20 AKTS Seçebilirsiniz!");
                this.dispose();
                new DersAlmaOgrenci();
            }
            else if(toplamkredi>40){
                JOptionPane.showMessageDialog(this, "En Fazla 40 AKTS Seçebilirsiniz!");
                this.dispose();
                new DersAlmaOgrenci();
            }
            else{
                for(int j=0; j<derslertf.size(); j++){
                    if(j<derslertf.size()-1){
                        if(((JCheckBox)derslertf.get(j)).isSelected()){
                            Dersler.dersler.add("t,");
                        }
                        else
                            Dersler.dersler.add("f,");
                    }
                    else{
                        if(((JCheckBox)derslertf.get(j)).isSelected()){
                            Dersler.dersler.add("t");
                        }
                        else
                            Dersler.dersler.add("f");
                    }
                }
                try {    
                    d.DersSecGecici();
                } catch (IOException ex) {
                    Logger.getLogger(DersAlmaOgrenci.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    d.DersSec(Dersler.dersler);
                    JOptionPane.showMessageDialog(this, "Ders Seçme Başarılı!");
                    Dersler.dersler.clear();
                    this.dispose();
                    new DersAlmaOgrenci();

                } catch (IOException ex) {
                    Logger.getLogger(DersAlmaOgrenci.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
