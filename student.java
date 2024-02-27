package MyProjects.studentRegister;

import java.util.List;         
import java.util.ArrayList;

public class student {

    String stdName;               
    long stdNo;                 
    List<String> selectedCrs;  
    List<course> courses;       

    public student(){           

    }

    public student(String stdName, long stdNo, List<course> courses){   
        this.stdName=stdName;                       
        this.stdNo=stdNo;                           
        this.selectedCrs=new ArrayList<String>();   
        this.courses = courses;                     
    }

    public String stdString() {    
        return "\nOgrenci adi: " + stdName + "\nOgrenci Numarasi: " + stdNo + "\nSectigi Dersler: " + selectedCrs + "\n" ;
    }

    private int getDayNumber(String day) {
        switch (day) {
            case "pazartesi":
                return 1;                   
            case "sali":                    
                return 2;                   
            case "carsamba":
                return 3;                   
            case "persembe":
                return 4;
            case "cuma":
                return 5;
            default:
                return 0;
        }
    }

    private boolean checkDayAndTimeConflict(course course1, course course2) {
        int dayNumber1 = getDayNumber(course1.crsDay.toLowerCase());            
        int dayNumber2 = getDayNumber(course2.crsDay.toLowerCase());

        if (dayNumber1 == dayNumber2) {                         
            int endHour1 = course1.crsHour + 3;                 
            int endHour2 = course2.crsHour + 3;                 
            if (course1!=course2 && course1.crsHour < endHour2 && endHour1 > course2.crsHour) {
                return true;
            }
        }
        return false;
    }

    private course findCourse(String courseCode) {
        for (int i = 0; i < courses.size(); i++) {              
            if (courses.get(i).crsCode.equals(courseCode)) {
                return courses.get(i);
            }
        }
        return null;
    }
    
    public void addCrs(course a) {                              
        for (int i = 0; i < selectedCrs.size(); i++) {          
            String selectedCrsCode = selectedCrs.get(i);
            course selectedCrs = findCourse(selectedCrsCode);
            if (selectedCrs != null && checkDayAndTimeConflict(a, selectedCrs)) {
                System.out.println("Ders eklenemedi. " + a.crsName + " dersi ile "+ selectedCrs.crsName + " dersi çakişiyor.");
                return;
            }
        }
        if (selectedCrs.size() < 5 && !selectedCrs.contains(a.crsCode) && a.numberOfStudent < 5) {
            selectedCrs.add(a.crsCode);     
            a.numberOfStudent++;
            System.out.println(stdName + " adli öğrenci, " + a.crsName + " dersini başariyla ekledi.");    
        } 
        else if(selectedCrs.size() >= 5){
            System.out.println("Zaten 5 ders secmissin. ");     
        }
        else if(selectedCrs.contains(a.crsCode)){
            System.out.println("Bu dersi zaten secmissiniz. "); 
        }
        else if(a.numberOfStudent >= 5){
            System.out.println("Bu dersi 5 kisi secmis.");      
        }
    }

    public void dropCrs(course a) {                 
        if (selectedCrs.contains(a.crsCode)) {
            selectedCrs.remove(a.crsCode);                      
            a.numberOfStudent--;
            System.out.println(stdName + " adli öğrenci, " + a.crsName + " dersini başariyla sildi.");
        } 
        else {
            System.out.println("Ders silinemedi. Öğrenci bu dersi daha önce eklememiş.");
        }
    }
}