
package ogrenciisleriotomasyonu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;


class MyFrame extends JFrame implements ActionListener {
    JButton ogrenci = new JButton("Öğrenci");
    JButton ogretim_uyesi = new JButton("Öğretim Üyesi");
    JButton personel = new JButton("Personel");
    
    public MyFrame() {
    this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.add(ogrenci);
        this.add(ogretim_uyesi);
        this.add(personel);
        this.setTitle("Öğrenci İşleri Otomasyonu");
        
        ogrenci.setBounds(55,250,175,100);
        ogrenci.setVisible(true);
        ogrenci.addActionListener(this);
        
        ogretim_uyesi.setBounds(255,250,175,100);
        ogretim_uyesi.setVisible(true);
        ogretim_uyesi.addActionListener(this);
        
        personel.setBounds(455,250,175,100);
        personel.setVisible(true);
        personel.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ogrenci){
            this.dispose();
            new LoginFrameOgrenci();
        }
        else if(e.getSource()==personel){
            this.dispose();
            new LoginFramePersonel();
        }
        else if(e.getSource()==ogretim_uyesi){
            this.setVisible(false);
            new LoginFrameOgretim();
        }
    }
}