package MyProjects.studentRegister;

public class course {

    String crsCode;         
    String crsName;         
    String crsDay;          
    int crsHour;            
    int numberOfStudent;    

    public course(){        

    }
    
    public course(String crsCode, String crsName, String crsDay, int crsHour){  
        this.crsCode=crsCode;
        this.crsName=crsName;
        this.crsDay=crsDay;
        this.crsHour=crsHour;
        this.numberOfStudent=0;
    }

    public String crsString() {     
        return "\nDers Kodu: " + crsCode + "\nDers Adi: " + crsName +
        "\nDers: " + crsDay + " günü " + crsHour + ".00 - "+ (crsHour+3) + ".00" + 
        "\nKayitli Öğrenci Sayisi: " + numberOfStudent + "\n";
    }
}