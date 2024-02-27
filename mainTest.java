package MyProjects.studentRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class mainTest {
    public static void main(String[] args) {

        
        List<course> courses = new ArrayList<>();
		courses.add(new course("ACM112", "Grafik Tasarim'a Giriş", "Pazartesi",12));
		courses.add(new course("ACM212", "İleri Veri Tabani Uygulamalari", "Sali", 9));
		courses.add(new course("ACM262", "Web Tasarim'a Giriş", "Persembe", 13));
		courses.add(new course("ACM321", "Nesne Yönelimli Programlama", "Pazartesi",10));
		courses.add(new course("STAT410", "İstatistik", "Persembe",15));
		courses.add(new course("TKL210", "Türk Dili 1", "Çarsamba", 9));
		courses.add(new course("ACM114", "Bilgisayar Bilimleri ve Programlamaya Giriş", "Cuma", 10));
		courses.add(new course("ACM222", "Yapisal Programlama", "Çarsamba", 11));
		courses.add(new course("AFE122", "İleri İngilizce", "Cuma", 9));
		courses.add(new course("ECON111", "Mikroekonominin Temelleri", "Sali", 16));

        List<student> students = new ArrayList<>();
        students.add(new student("Alperen Kurt", 20212905004L,courses));
        students.add(new student("Eren Guner", 20212905005L,courses));
        students.add(new student("Yasar Tasdelen", 20212905006L,courses));
        students.add(new student("Kerem Damnali", 20212905007L,courses));
        students.add(new student("Sercan Kurt", 20212905008L,courses));
        students.add(new student("Kubra Zenginoglu", 20212905009L,courses));
        students.add(new student("Batuhan Kaya", 20212905010L,courses));
        students.add(new student("Pinar Oztekin", 20212905011L,courses));
        students.add(new student("Can Kayim", 20212905012L,courses));
        students.add(new student("Arda Gurbuz", 20212905013L,courses));

        Scanner scan = new Scanner(System.in); 

        while (true) {
            System.out.println("Menü:");
            System.out.println("1: Ders Listesi");
            System.out.println("2: Öğrenci Bilgileri");
            System.out.println("3: Ders Ekle");
            System.out.println("4: Ders Sil");
            System.out.println("5: Çikiş");
            System.out.print("Lütfen bir seçim yapin: ");

            int secim = scan.nextInt();

            if (secim == 1) {       
                System.out.println("Dersler:");
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println(courses.get(i).crsString());
                }
            } 
            else if (secim == 2) {
                System.out.println("\nÖğrenciler ve Aldiklari Dersler:");
                for (int i = 0; i<students.size();i++) {
                    System.out.println((i+1)+". ogrenci =>");
                    System.out.println(students.get(i).stdString());
                }
            } 
            else if (secim == 3) {
                System.out.println("\nDers Ekleme Menüsü:");       
                System.out.print("Öğrenci numarasini girin: ");
                long ogrenciNo = scan.nextLong();                             
                student ogrenci = findStudent(students, ogrenciNo);
                if (ogrenci != null) {
                    System.out.print("Eklemek istediğiniz dersin kodunu girin: ");
                    String dersKodu = scan.next();
                    course ders = findCourse(courses, dersKodu.toUpperCase());
                    if (ders != null) {
                        ogrenci.addCrs(ders);
                    } 
                    else {
                        System.out.println("Ders bulunamadi.");
                    }
                } 
                else {
                    System.out.println("Öğrenci bulunamadi.");
                }
            }    
            else if (secim == 4) {
                System.out.println("\nDers Silme Menüsü:");
                System.out.print("Öğrenci numarasini girin: ");
                long ogrenciNo = scan.nextLong();                           
                student ogrenci = findStudent(students, ogrenciNo);
                if (ogrenci != null) {
                    System.out.print("Silmek istediğiniz dersin kodunu girin: ");
                    String dersKodu = scan.next();
                    course ders = findCourse(courses, dersKodu.toUpperCase());
                    if (ders != null) {
                        ogrenci.dropCrs(ders);
                    }
                    else {
                        System.out.println("Ders bulunamadi.");
                    }
                } 
            } 
            else if (secim == 5) {
                System.out.println("\nProgramdan cikiliyor...");
                break;
            } 
            else {
                System.out.println("\nGeçersiz seçim. Tekrar deneyin.");
            }
        }
        
        scan.close();

    }

    private static student findStudent(List<student> students, long studentNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).stdNo == studentNo) {
                return students.get(i);                  
            }                                           
        }
        return null;
    }

    private static course findCourse(List<course> courses, String courseCode) {
        for (int i = 0; i<courses.size();i++) {
            if (courses.get(i).crsCode.equals(courseCode)) {
                return courses.get(i);
            }
        }
        return null;
    }
}
    
