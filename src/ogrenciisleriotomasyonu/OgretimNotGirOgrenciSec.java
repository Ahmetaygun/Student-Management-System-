
package ogrenciisleriotomasyonu;

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


public class OgretimNotGirOgrenciSec extends JFrame implements ActionListener{
    ArrayList idler = new ArrayList<>();
    JLabel id = new JLabel("Öğrenci ID:");
    JTextField idtxt = new JTextField();
    JButton ileri = new JButton("İleri");
    JButton anamenu = new JButton("Ana Menü");
    static int sıra = 0;
    OgretimNotGirOgrenciSec(){
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Öğretim Öğrenci Seç");
        
        this.add(idtxt);
        this.add(id);
        this.add(ileri);
        this.add(anamenu);
        
        id.setVisible(true);
        id.setBounds(190,250,100,25);
        
        idtxt.setBounds(270,250,165,25);
        idtxt.setVisible(true);
        
        ileri.setVisible(true);
        ileri.setBounds(300,300,100,25);
        ileri.addActionListener(this);
        
        anamenu.setVisible(true);
        anamenu.setBounds(300,340,100,25);
        anamenu.addActionListener(this);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Öğrenci ID.txt"));
            idler.clear();
            while (true) {
	               String yazi = br.readLine();
                if (yazi != null) {
                    idler.add(yazi);
                } else {
                    break;
                }
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OgretimNotGirOgrenciSec.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OgretimNotGirOgrenciSec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==anamenu){
            this.dispose();
            new MainMenuOgretim();
        }
        if(e.getSource()==ileri){
            for(sıra=0;sıra<idler.size();sıra++){
                if(idtxt.getText().equals(idler.get(sıra))){
                    this.dispose();
                    new OgretimNotGir();
                    break;
                }else if(sıra == idler.size()-1){
                    JOptionPane.showMessageDialog(this,"Böyle Bir Öğrenci Bulunmamaktadır");
                    this.dispose();
                    new OgretimNotGirOgrenciSec();
                }
            }
        }
    }
}
