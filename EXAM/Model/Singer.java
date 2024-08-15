package Model;

import java.util.Scanner;

public class Singer {
    private int singerID;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
    }

    public Singer(int singerID, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerID() {
        return singerID;
    }

    public void setSingerID(int singerID) {
        this.singerID = singerID;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void inputData(Scanner scanner, Singer[] singers,int currentSinger) {

        this.singerID=idAutoIncrement(singers,currentSinger);
        this.singerName=inputSingerName(scanner);
        this.age=inputAge(scanner);
        this.nationality=inputNationality(scanner);
        this.gender=inputGender(scanner);
        this.genre=inputGenre(scanner);
    }
    public void inputUpdate(Scanner scanner, Singer[] singers,int currentSinger) {

        this.singerName=inputSingerName(scanner);
        this.age=inputAge(scanner);
        this.nationality=inputNationality(scanner);
        this.gender=inputGender(scanner);
        this.genre=inputGenre(scanner);
    }


    private String inputGenre(Scanner scanner) {
        System.out.println("Mời bạn nhập tên thể loại");
        do {
            String genre = scanner.nextLine();
            if(genre.trim().isEmpty()){
                System.err.println("Không được để trống thể loại");
            }else {
                return genre;
            }
        }while (true);
    }

    public boolean inputGender(Scanner scanner) {
        System.out.println("Mời bạn nhập giới tính của mình true là Nam và false là nữ");
        do {
            String gender = scanner.nextLine();
            if(gender.equalsIgnoreCase("true")||gender.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(gender);
            }else {
                System.err.println("Vui lòng nhập đúng cú pháp true or false");
            }


        }while (true);
    }

    public String inputNationality(Scanner scanner) {
        System.out.println("Mời bạn nhập quốc tịch của ca sỹ");
        do {
            String nationality = scanner.nextLine();
            if (nationality.trim().isEmpty()){
                System.err.println("Không để trống quốc tịch của ca sỹ");
            }
            else {
                return nationality;
            }
        }while (true);
    }

    public int inputAge(Scanner scanner) {
        System.out.println("Mời bạn nhập tuổi ca sỹ");
        do {
            try{
            String age = scanner.nextLine();
            if(age.trim().isEmpty()){
                System.err.println("Không để trống tên");
            }
            else {
                int ageInt = Integer.parseInt(age);
                if(ageInt>0){
                    return ageInt;

                }else {
                    System.err.println("Số tuổi phải lớn hơn không");
                }
            }}
            catch (NumberFormatException e){
                System.err.println("Nhập age phải là số nguyên ");
            }
        }while (true);
    }

    public String inputSingerName(Scanner scanner) {
        System.out.println("Mời bạn nhập tên ca sỹ ");
        do {
            String singerName = scanner.nextLine();
            if (singerName.trim().isEmpty()){
                System.err.println("Không được để trống tên nhé");
            }
            else {
                return singerName;
            }
        }
        while (true);
    }




    public int idAutoIncrement(Singer[] singers, int currentSinger) {
        int maxID=0;
        for(int i=0;i<currentSinger;i++) {
            if(singers[i].getSingerID()>maxID) {
                maxID=singers[i].getSingerID();
            }
        }return maxID+1;
    }
    public void displayDataSinger() {
        System.out.printf("[ ID: %-5d | Name: %-20s | Age: %-10d | Nationality: %-10s | Gender: %-15s | Genre: %-20s] \n ",this.singerID,this.singerName,this.age,this.nationality,this.gender?"Male":"Female",this.genre  );

    };


}
