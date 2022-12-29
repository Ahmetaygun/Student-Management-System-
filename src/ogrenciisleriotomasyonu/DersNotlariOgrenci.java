
package ogrenciisleriotomasyonu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.*;
import static ogrenciisleriotomasyonu.Dersler.*;


public class DersNotlariOgrenci extends JFrame implements ActionListener{
    ArrayList derslertf = new ArrayList<>();
    ArrayList arasinavlartf = new ArrayList<>();
    ArrayList finallertf = new ArrayList<>();
    ArrayList harfnotlarıtf = new ArrayList<>();
    JLabel derslerl = new JLabel("Dersler");
    JLabel ders1 = new JLabel("Ders 1");
    JLabel ders2 = new JLabel("Ders 2");
    JLabel ders3 = new JLabel("Ders 3");
    JLabel ders4 = new JLabel("Ders 4");
    JLabel ders5 = new JLabel("Ders 5");
    JLabel ders6 = new JLabel("Ders 6");
    JLabel ders7 = new JLabel("Seçmeli Ders 1");
    JLabel ders8 = new JLabel("Seçmeli Ders 2");
    JLabel ders9 = new JLabel("Seçmeli Ders 3");
    JLabel ders10 = new JLabel("Seçmeli Ders 4");
    JLabel arasınavl = new JLabel("Ara Sınav");
    JLabel arasınav1 = new JLabel();
    JLabel arasınav2 = new JLabel();
    JLabel arasınav3 = new JLabel();
    JLabel arasınav4 = new JLabel();
    JLabel arasınav5 = new JLabel();
    JLabel arasınav6 = new JLabel();
    JLabel arasınav7 = new JLabel();
    JLabel arasınav8 = new JLabel();
    JLabel arasınav9 = new JLabel();
    JLabel arasınav10 = new JLabel();
    JLabel finall = new JLabel("Final");
    JLabel final1 = new JLabel();
    JLabel final2 = new JLabel();
    JLabel final3 = new JLabel();
    JLabel final4 = new JLabel();
    JLabel final5 = new JLabel();
    JLabel final6 = new JLabel();
    JLabel final7 = new JLabel();
    JLabel final8 = new JLabel();
    JLabel final9 = new JLabel();
    JLabel final10 = new JLabel();
    JLabel harfnotul = new JLabel("Harf Notu");
    JLabel harfnotu1 = new JLabel();
    JLabel harfnotu2 = new JLabel();
    JLabel harfnotu3 = new JLabel();
    JLabel harfnotu4 = new JLabel();
    JLabel harfnotu5 = new JLabel();
    JLabel harfnotu6 = new JLabel();
    JLabel harfnotu7 = new JLabel();
    JLabel harfnotu8 = new JLabel();
    JLabel harfnotu9 = new JLabel();
    JLabel harfnotu10 = new JLabel();
    JButton anamenu = new JButton("Ana Menü");
    Font selam = new Font("selam", Font.BOLD, 15);
    Dersler d = new Dersler();
    int a = 50;
    DersNotlariOgrenci(){
        Dersler.ArraylereAt();
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğrenci Ders Notları");
        this.add(derslerl);
        this.add(arasınavl);
        this.add(finall);
        this.add(harfnotul);
        this.add(anamenu);
        
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
        
        arasinavlartf.clear();
        arasinavlartf.add(arasınav1);
        arasinavlartf.add(arasınav2);
        arasinavlartf.add(arasınav3);
        arasinavlartf.add(arasınav4);
        arasinavlartf.add(arasınav5);
        arasinavlartf.add(arasınav6);
        arasinavlartf.add(arasınav7);
        arasinavlartf.add(arasınav8);
        arasinavlartf.add(arasınav9);
        arasinavlartf.add(arasınav10);
        
        finallertf.clear();
        finallertf.add(final1);
        finallertf.add(final2);
        finallertf.add(final3);
        finallertf.add(final4);
        finallertf.add(final5);
        finallertf.add(final6);
        finallertf.add(final7);
        finallertf.add(final8);
        finallertf.add(final9);
        finallertf.add(final10);
        
        harfnotlarıtf.clear();
        harfnotlarıtf.add(harfnotu1);
        harfnotlarıtf.add(harfnotu2);
        harfnotlarıtf.add(harfnotu3);
        harfnotlarıtf.add(harfnotu4);
        harfnotlarıtf.add(harfnotu5);
        harfnotlarıtf.add(harfnotu6);
        harfnotlarıtf.add(harfnotu7);
        harfnotlarıtf.add(harfnotu8);
        harfnotlarıtf.add(harfnotu9);
        harfnotlarıtf.add(harfnotu10);
        
        derslerl.setVisible(true);
        derslerl.setBounds(50,10,100,50);
        derslerl.setFont(selam);
        
        arasınavl.setVisible(true);
        arasınavl.setBounds(200,10,100,50);
        arasınavl.setFont(selam);
        
        finall.setVisible(true);
        finall.setBounds(350,10,100,50);
        finall.setFont(selam);
        
        harfnotul.setVisible(true);
        harfnotul.setBounds(550,10,100,50);
        harfnotul.setFont(selam);
        
        anamenu.setVisible(true);
        anamenu.addActionListener(this);
        anamenu.setBounds(275,600,150,65);
        
        for(int j=0; j<derslertf.size();j++){
            if(str[j].equals("t")){
                this.add((JLabel)derslertf.get(j));
                this.add((JLabel)arasinavlartf.get(j));
                this.add((JLabel)finallertf.get(j));
                this.add((JLabel)harfnotlarıtf.get(j));
                
                
                ((JLabel)derslertf.get(j)).setVisible(true);
                ((JLabel)arasinavlartf.get(j)).setVisible(true);
                ((JLabel)finallertf.get(j)).setVisible(true);
                ((JLabel)harfnotlarıtf.get(j)).setVisible(true);
                ((JLabel)derslertf.get(j)).setBounds(50,a,100,50);
                ((JLabel)arasinavlartf.get(j)).setBounds(230,a,100,50);
                ((JLabel)finallertf.get(j)).setBounds(365,a,100,50);
                ((JLabel)harfnotlarıtf.get(j)).setBounds(580,a,100,50);
                ((JLabel)arasinavlartf.get(j)).setText(str3[j]);
                ((JLabel)finallertf.get(j)).setText(str4[j]);
                ((JLabel)harfnotlarıtf.get(j)).setText(str5[j]);
                
                if(((JLabel)arasinavlartf.get(j)).getText().equals("-")||((JLabel)finallertf.get(j)).getText().equals("-")){
                    
                }else{
                    int vize = parseInt(str3[j]);
                    int finalint = parseInt(str4[j]);
                    int ort = (vize*3)/10 + (finalint*7)/10;
                    if(ort < 30){
                        ((JLabel)harfnotlarıtf.get(j)).setText("FF");
                    }else if(ort < 45){
                        ((JLabel)harfnotlarıtf.get(j)).setText("DD");
                    }else if (ort < 50){
                        ((JLabel)harfnotlarıtf.get(j)).setText("DC");
                    }else if (ort < 55){
                        ((JLabel)harfnotlarıtf.get(j)).setText("CC");
                    }else if (ort < 70){
                        ((JLabel)harfnotlarıtf.get(j)).setText("CB");
                    }else if (ort < 80){
                        ((JLabel)harfnotlarıtf.get(j)).setText("BB");
                    }else if (ort < 90){
                        ((JLabel)harfnotlarıtf.get(j)).setText("BA");
                    }else if(ort <= 100){
                        ((JLabel)harfnotlarıtf.get(j)).setText("AA");
                    }
                }
                a+=50;  
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == anamenu){
            this.dispose();
            new MainMenuOgrenci();
        }
    }
}
