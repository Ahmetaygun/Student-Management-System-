
package ogrenciisleriotomasyonu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ogrenciisleriotomasyonu.DersAlmaOgrenci.derslertf;
import static ogrenciisleriotomasyonu.Ogrenci.*;

class Dersler {
    static ArrayList dersler = new ArrayList<>();
    static ArrayList derskredi = new ArrayList<>();
    static ArrayList vizenotları = new ArrayList<>();
    static ArrayList finalnotları = new ArrayList<>();
    static File derskredifile = new File("Dersler Kredi.txt");
    static File dersfile = new File("Dersler.txt");
    static String[] str = new String[10];
    static String[] str2 = new String[10];
    static String[] str3 = new String[10];
    static String[] str4 = new String[10];
    static String[] str5 = new String[10];
            
    Dersler(){
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(derskredifile));
            String yazil = br1.readLine();
            str2 = yazil.split(",");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dersler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dersler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean DersSec(ArrayList a)throws IOException{
        
        dersler_ogrenci.set(Ogrenci.i, a.get(0));
        PrintWriter writer = new PrintWriter(Ogrenci.dersfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(Ogrenci.dersfile, true);
        for (int j = 0; j < dersler_ogrenci.size(); j++) {
            out.write(dersler_ogrenci.get(j).toString().getBytes());
            out.write(Ogrenci.z.getBytes());
        }
        String[] str = ((String)dersler_ogrenci.get(Ogrenci.i)).split(",");
        return true;
    }
    public void DersSecGecici()throws IOException{
        FileOutputStream out = new FileOutputStream(dersfile, true);
        PrintWriter writer = new PrintWriter(dersfile);
        writer.print("");
        writer.close();
        for (int j = 0; j < dersler.size(); j++) {
            out.write(dersler.get(j).toString().getBytes());
        }
        dersler.clear();
        BufferedReader br1 = new BufferedReader(new FileReader("Dersler.txt"));
        while(true){
            String yazi1 = br1.readLine();
            if (yazi1 != null){
                dersler.add(yazi1);
            }
            else
                break;
        }   
    }
    static public void NotlarGirildi(int k)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Öğrenci Ara Sınavlar.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("Öğrenci Finaller.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("Dersler.txt"));
        PrintWriter writer = new PrintWriter(dersfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(dersfile, true);
        for(int j=0; j<str3.length;j++){
            if(j<str3.length-1){
                out.write(str3[j].getBytes());
                out.write(",".getBytes());
            }
            else
                out.write(str3[j].getBytes());
        }
        OgretimNotGir.vizeler.set(k, br3.readLine());
        PrintWriter writer2 = new PrintWriter("Öğrenci Ara Sınavlar.txt");
        writer2.print("");
        writer2.close();
        FileOutputStream oat = new FileOutputStream("Öğrenci Ara Sınavlar.txt", true);
        for(int j=0; j<OgretimNotGir.vizeler.size();j++){
            oat.write(OgretimNotGir.vizeler.get(j).toString().getBytes());
            oat.write("\n".getBytes());
        }
        writer.print("");
        writer.close();
        for(int j=0; j<str4.length;j++){
            if(j<str4.length - 1){
                out.write(str4[j].getBytes());
                out.write(",".getBytes());
            }
            else
                out.write(str4[j].getBytes());
        }
        OgretimNotGir.finaller.set(k, br3.readLine());
        PrintWriter writer3 = new PrintWriter("Öğrenci Finaller.txt");
        writer3.print("");
        writer3.close();
        FileOutputStream oet = new FileOutputStream("Öğrenci Finaller.txt", true);
        for(int j=0;j<OgretimNotGir.finaller.size();j++){
            oet.write(OgretimNotGir.finaller.get(j).toString().getBytes());
            oet.write("\n".getBytes());
        }
    }
    static public void ArraylereAt(){
        str = ((String)dersler_ogrenci.get(Ogrenci.i)).split(",");
        str3 = ((String)arasinav_ogrenci.get(Ogrenci.i)).split(",");
        str4 = ((String)final_ogrenci.get(Ogrenci.i)).split(",");
        str5 = ((String)harfnotu_ogrenci.get(Ogrenci.i)).split(",");
    }
    static public void ArraylereAtNot(int k){
        str3 = ((String)OgretimNotGir.vizeler.get(k)).split(",");
        str4 = ((String)OgretimNotGir.finaller.get(k)).split(",");
    }
}
