
package ogrenciisleriotomasyonu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


interface İnsan{
    public boolean giriş(String a, String b) throws IOException;
}
abstract class Üye{
    public boolean kayıt(String a,String b, String c, String d) throws IOException{
        return true;
    }
    public boolean şifreDeğiştir(String id, String şifre, String şifrey) throws IOException{
        return false;
    }
}
class Ogrenci extends Üye implements İnsan{
    static int i = 0;
    static boolean kayıth = false;
    static ArrayList idler = new ArrayList<>();
    static ArrayList sifreler = new ArrayList<>();
    static ArrayList isimler = new ArrayList<>();
    static ArrayList soyisimler = new ArrayList<>();
    static ArrayList dersler_ogrenci = new ArrayList<>();
    static ArrayList harfnotu_ogrenci = new ArrayList<>();
    static ArrayList arasinav_ogrenci = new ArrayList<>();
    static ArrayList final_ogrenci = new ArrayList<>();
    static File idfile = new File("Öğrenci ID.txt");
    static File şifrefile = new File("Öğrenci Şifre.txt");
    static File isimfile = new File("Öğrenci İsim.txt");
    static File soyisimfile = new File("Öğrenci Soyisim.txt");
    static File harfnotfile = new File("Öğrenci Harf Notları.txt");
    static File arasınavfile = new File("Öğrenci Ara Sınavlar.txt");
    static File finalfile = new File("Öğrenci Finaller.txt");
    static File dersfile = new File("Öğrenci Ders.txt");
    static String z = "\n";
    static String notlar = "-,-,-,-,-,-,-,-,-,-";
    static String aldıalmadı = "f,f,f,f,f,f,f,f,f,f";
    Duyurular d;
    
    @Override
    public boolean giriş(String a, String b) throws IOException{
        FileOutputStream out = new FileOutputStream(idfile,true);
        FileOutputStream oat = new FileOutputStream(şifrefile,true);
        FileOutputStream oet = new FileOutputStream(isimfile,true);
        FileOutputStream oit = new FileOutputStream(soyisimfile,true);
        FileOutputStream oot = new FileOutputStream(harfnotfile,true);
        FileOutputStream opt = new FileOutputStream(dersfile,true);
        FileOutputStream ost = new FileOutputStream(arasınavfile,true);
        FileOutputStream okt = new FileOutputStream(finalfile,true);
        BufferedReader br = new BufferedReader(new FileReader(idfile));
        BufferedReader br1 = new BufferedReader(new FileReader(şifrefile));
        BufferedReader br2 = new BufferedReader(new FileReader(isimfile));
        BufferedReader br3 = new BufferedReader(new FileReader(soyisimfile));
        BufferedReader br4 = new BufferedReader(new FileReader(dersfile));
        BufferedReader br5 = new BufferedReader(new FileReader(harfnotfile));
        BufferedReader br6 = new BufferedReader(new FileReader(arasınavfile));
        BufferedReader br7 = new BufferedReader(new FileReader(finalfile));
        
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
	    if (yazi1 != null)
		soyisimler.add(yazi1);
            else
                break;           
	}
        dersler_ogrenci.clear();
        while(true){
            String yazi1 = br4.readLine();
            if (yazi1 != null)
                dersler_ogrenci.add(yazi1);
            else
                break;
        }
        harfnotu_ogrenci.clear();
        while(true){
            String yazi1 = br5.readLine();
            if (yazi1 != null)
                harfnotu_ogrenci.add(yazi1);
            else
                break;
        }
        arasinav_ogrenci.clear();
        while(true){
            String yazi1 = br6.readLine();
            if (yazi1 != null)
                arasinav_ogrenci.add(yazi1);
            else
                break;
        }
        final_ogrenci.clear();
        while(true){
            String yazi1 = br7.readLine();
            if (yazi1 != null)
                final_ogrenci.add(yazi1);
            else
                break;
        }
        
        for(i=0;i<idler.size();i++){
            if(idler.get(i).equals(a))
                if(sifreler.get(i).equals(b))
                    return true;
        }
        return false;
    }
    
    public boolean şifreDeğiştir(String şifre, String şifrey) throws IOException{
        if (sifreler.get(i).equals(şifre)) {
            sifreler.set(i, şifrey);
            PrintWriter writer = new PrintWriter(şifrefile);
            writer.print("");
            writer.close();
            FileOutputStream oat = new FileOutputStream(şifrefile, true);
            for (int j = 0; j < sifreler.size(); j++) {
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
        FileOutputStream oot = new FileOutputStream(harfnotfile,true);
        FileOutputStream opt = new FileOutputStream(dersfile,true);
        FileOutputStream ost = new FileOutputStream(arasınavfile,true);
        FileOutputStream okt = new FileOutputStream(finalfile,true);
        FileOutputStream oşt = new FileOutputStream("Tüm IDler.txt",true);
        FileOutputStream oqt = new FileOutputStream("Duyuru Öğrenci.txt",true);
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
        
        new Duyurular();
        
            if(kayıth==true){
                oat.write(b.getBytes());
                oat.write(z.getBytes());
                out.write(a.getBytes());
                out.write(z.getBytes());
                oet.write(c.getBytes());
                oet.write(z.getBytes());
                oit.write(d.getBytes());
                oit.write(z.getBytes());
                oot.write(notlar.getBytes());
                oot.write(z.getBytes());
                opt.write(aldıalmadı.getBytes());
                opt.write(z.getBytes());
                ost.write(notlar.getBytes());
                ost.write(z.getBytes());
                okt.write(notlar.getBytes());
                okt.write(z.getBytes());
                oşt.write(a.getBytes());
                oşt.write(z.getBytes());
            }
        if(Duyurular.duyurular.isEmpty()){ 
            if(kayıth==true){
                oqt.write("f".getBytes());
                oqt.write(z.getBytes());
            }
        }
        else{
            if(kayıth==true){
                for(int j = 0; j<Duyurular.duyurular.size();j++){
                    if(j<Duyurular.duyurular.size()-1){
                        oqt.write("f".getBytes());
                        oqt.write(",".getBytes());
                    }
                    else{
                        oqt.write("f".getBytes());
                    }
                }
                oqt.write(z.getBytes());
            }
        }
            
            
        return kayıth;
    }
}
