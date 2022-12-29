
package ogrenciisleriotomasyonu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static ogrenciisleriotomasyonu.Personel.idler;


class Personel extends Üye implements İnsan{
    static int i = 0;
    static boolean kayıth = false;
    static ArrayList idler = new ArrayList<>();
    static ArrayList sifreler = new ArrayList<>();
    static ArrayList isimler = new ArrayList<>();
    static ArrayList soyisimler = new ArrayList<>();
    static File idfile = new File("Personel ID.txt");
    static File şifrefile = new File("Personel Şifre.txt");
    static File isimfile = new File("Personel İsim.txt");
    static File soyisimfile = new File("Personel Soyisim.txt");
    static String z = "\n";
    
    @Override
    public boolean giriş(String a, String b) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Personel ID.txt"));
        BufferedReader br1 = new BufferedReader(new FileReader("Personel Şifre.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("Personel İsim.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("Personel Soyisim.txt"));
        
        
        idler.clear();
        while (true) {
	    String yazi = br.readLine();
	    if (yazi != null) {
		idler.add(yazi);
	    }
            else{
                break;
            }
	}
        sifreler.clear();
        while (true) {
	    String yazi1 = br1.readLine();
	    if (yazi1 != null) {
		sifreler.add(yazi1);
	    }
            else{
                break;
            }
            
	}
        isimler.clear();
        while (true) {
	    String yazi1 = br2.readLine();
	    if (yazi1 != null) {
		isimler.add(yazi1);
	    }
            else{
                break;
            }
            
	}
        soyisimler.clear();
        while (true) {
	    String yazi1 = br3.readLine();
	    if (yazi1 != null) {
		soyisimler.add(yazi1);
	    }
            else{
                break;
            }
            
	}
        for(i=0;i<idler.size();i++){
            if(idler.get(i).equals(a)){
                if(sifreler.get(i).equals(b)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean şifreDeğiştir(String şifre, String şifrey) throws IOException{
                if(sifreler.get(i).equals(şifre)){
                    sifreler.set(i,şifrey);
                    PrintWriter writer = new PrintWriter(şifrefile);
                    writer.print("");
                    writer.close();
                    FileOutputStream oat = new FileOutputStream(şifrefile,true);
                    for(int j = 0;j < sifreler.size();j++){
                        oat.write(sifreler.get(j).toString().getBytes());
                        oat.write(z.getBytes());
                    }
                    return true;
                }
        return false;
    }
    @Override
    public boolean kayıt(String a,String b, String c, String d) throws IOException{
        kayıth = true;
        idler.clear();
        FileOutputStream out = new FileOutputStream(idfile,true);
        FileOutputStream oat = new FileOutputStream(şifrefile,true);
        FileOutputStream oet = new FileOutputStream(isimfile,true);
        FileOutputStream oit = new FileOutputStream(soyisimfile,true);
        FileOutputStream oşt = new FileOutputStream("Tüm IDler.txt",true);
        BufferedReader br = new BufferedReader(new FileReader("Tüm IDler.txt"));
        ArrayList tümidler = new ArrayList<>();
        tümidler.clear();
        while(true)
        {
            String yazi1 = br.readLine();
	    if (yazi1 != null) {
		tümidler.add(yazi1);
	    }
            else{
                break;
            }
        }
        for(int j=0;j<tümidler.size();j++)
        {
            if(tümidler.get(j).toString().equals(a))
            {
                kayıth=false;
                break;
                
            }
        }
        if(kayıth==true){
            oat.write(b.getBytes());
            oat.write(z.getBytes());
            out.write(a.getBytes());
            out.write(z.getBytes());
            oet.write(c.getBytes());
            oet.write(z.getBytes());
            oit.write(d.getBytes());
            oit.write(z.getBytes());
            oşt.write(a.getBytes());
            oşt.write(z.getBytes());
        }
        
        return kayıth;
    }
}