
package ogrenciisleriotomasyonu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import static ogrenciisleriotomasyonu.DerslerOgretim.arrstrdoldur;


class DersVermeOgretim extends JFrame implements ActionListener{
    ArrayList ogrencilertf = new ArrayList<>();
    ArrayList ogrenciidal = new ArrayList<>();
    ArrayList derslertf = new ArrayList<>();
    ArrayList dersleral = new ArrayList<>();
    ArrayList dersisimleral = new ArrayList<>();
    JButton anamenu = new JButton("Ana Menü");
    JLabel derslerl = new JLabel("Ders");
    JLabel ogrencil = new JLabel("Öğrenci");
    Font selam = new Font("selam", Font.BOLD, 15);
    DerslerOgretim ogretim;
    String[] ogrenciderslerstr = new String[10];
    int a=50;
    DersVermeOgretim(){
        try {
            this.ogretim = new DerslerOgretim();
            BufferedReader br = new BufferedReader(new FileReader("Öğrenci Ders.txt"));
            BufferedReader br1 = new BufferedReader(new FileReader("Öğrenci ID.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("Ders İsimleri.txt"));
            while (true) {
	               String yazi = br.readLine();
                if (yazi != null) {
                    dersleral.add(yazi);
                } else {
                    break;
                }
            }
            while (true) {
	               String yazi = br1.readLine();
                if (yazi != null) {
                    ogrenciidal.add(yazi);
                } else {
                    break;
                }
            }
            while (true) {
	               String yazi = br2.readLine();
                if (yazi != null) {
                    dersisimleral.add(yazi);
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DersVermeOgretim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DersVermeOgretim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.add(anamenu);
        this.add(ogrencil);
        this.add(derslerl);
        
        anamenu.setVisible(true);
        anamenu.setBounds(475,575,125,75);
        anamenu.addActionListener(this);
        
        derslerl.setVisible(true);
        derslerl.setBounds(350,10,100,50);
        derslerl.setFont(selam);
        
        ogrencil.setVisible(true);
        ogrencil.setBounds(100,10,100,50);
        ogrencil.setFont(selam);
        
        for(int j=0; j<dersleral.size(); j++){
            ogrenciderslerstr = ((String)dersleral.get(j)).split(",");
            for(int k=0; k<ogrenciderslerstr.length; k++){
                if(arrstrdoldur()[k].equals("t")&&ogrenciderslerstr[k].equals("t")){
                    JLabel ogrenci = new JLabel((String)ogrenciidal.get(j));
                    JLabel ders = new JLabel((String)dersisimleral.get(k));
                    derslertf.add(ders);
                    ogrencilertf.add(ogrenci);
                }
            }
        }
        for(int j=0; j<ogrencilertf.size();j++){
            this.add((JLabel)ogrencilertf.get(j));
            this.add((JLabel)derslertf.get(j));
            ((JLabel)ogrencilertf.get(j)).setVisible(true);
            ((JLabel)ogrencilertf.get(j)).setBounds(100,a,100,50);
            ((JLabel)derslertf.get(j)).setVisible(true);
            ((JLabel)derslertf.get(j)).setBounds(350,a,100,50);
            a+=50;
        }
   }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==anamenu){
            this.dispose();
            new MainMenuOgretim();
        }
    }
}
