
package ogrenciisleriotomasyonu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static ogrenciisleriotomasyonu.Dersler.dersfile;
import static ogrenciisleriotomasyonu.OgretimUyesi.dersler_ogretim;
import static ogrenciisleriotomasyonu.OgretimUyesi.i;


public class DerslerOgretim {
    static ArrayList dersler = new ArrayList<>();
    static File dersfile = new File("Dersler.txt");
    static String[] arrstr = new String[10];
    static String[] arrstr2 = new String[10];
    int k=0;
    DerslerOgretim()throws IOException{
        for(int j=0; j<arrstr.length;j++){
            arrstr2[j] = "-";
        }
        OgretimUyesi hoca = new OgretimUyesi();
        for(k=0;k<OgretimUyesi.dersler_ogretim.size();k++){
            arrstr = ((String)dersler_ogretim.get(k)).split(",");
            for(int l=0; l<arrstr.length;l++){
                if(arrstr[l].equals("t")){
                    arrstr2[l] = (((String)OgretimUyesi.isimler.get(k))+" "+((String)OgretimUyesi.soyisimler.get(k)));
                }
            }
        }
//        arrstr = ((String)dersler_ogretim.get(i)).split(",");
    }
    public void DersSecGecici()throws IOException{
        PrintWriter writer = new PrintWriter(dersfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(dersfile, true);
        for (int j = 0; j < dersler.size(); j++) {
            out.write(dersler.get(j).toString().getBytes());
        }
        dersler.clear();
        BufferedReader br1 = new BufferedReader(new FileReader(dersfile));
        while(true){
            String yazi1 = br1.readLine();
            if (yazi1 != null){
                dersler.add(yazi1);
            }
            else
                break;
        }
    }
    public boolean DersSecOgretim(ArrayList a)throws IOException{
        dersler_ogretim.set(OgretimUyesi.i, dersler.get(0));
        PrintWriter writer = new PrintWriter(OgretimUyesi.dersfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(OgretimUyesi.dersfile, true);
        for (int j = 0; j < dersler_ogretim.size(); j++) {
            out.write(dersler_ogretim.get(j).toString().getBytes());
            out.write(OgretimUyesi.z.getBytes());
        }
        return true;
    }
    public static String[] arrstrdoldur(){
        arrstr = ((String)dersler_ogretim.get(i)).split(",");
        return arrstr;
    }
}
