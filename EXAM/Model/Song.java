package Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Run.MUCSIC_MANAGERMENT.findIndexByIDSinger;

public class Song {
    private String songId;
    private String songName;
    private String description;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private Boolean songStatus;
    public Song() {}

    public Song(String songId, String songName, String description, Singer singer, String songWriter, Date createdDate, Boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.description = description;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus=songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(Boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputDataSong(Scanner sc, Song[] songs, int currentSong, Singer[] singers, int  currentSinger) {
        this.songId = inputSongID(sc,songs,currentSong);
        this.songName=inputSongName(sc);
        System.out.println("Mô tả bài hát");
        this.description=sc.nextLine();
        this.createdDate=new Date();
        this.singer=inputSinger(sc,singers,currentSinger);
        this.songWriter=inputSongWrite(sc);
        this.songStatus=inputSongStatus(sc);

    }
    public void inputUpdateSong(Scanner sc, Song[] songs, int currentSong, Singer[] singers, int  currentSinger) {
        this.songName=inputSongName(sc);
        System.out.println("Mô tả bài hát");
        this.description=sc.nextLine();
        this.singer=inputSinger(sc,singers,currentSinger);
        this.songWriter=inputSongWrite(sc);
        this.songStatus=inputSongStatus(sc);

    }

    public Boolean inputSongStatus(Scanner sc) {
        System.out.println("Mời bạn nhập trạng thái bài hát nhé bạn iu");
        do {
            String status=sc.nextLine();
            if (status.equalsIgnoreCase("true")||status.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(status);
            }
            else {
                System.err.println("Bạn vui lòng nhập true or false");
            }

        }
        while (true);
    }

    public String inputSongWrite(Scanner sc) {
        System.out.println("Mời bạn viết song write");
        do {
            String songWrite = sc.nextLine();
            if (songWrite.trim().isEmpty()){
                System.err.println("Ko duoc de cach song write");
            }
            else {
                return songWrite;
            }

        }while (true);

    }


    public Singer inputSinger(Scanner sc, Singer[] singers, int currentSinger) {

        for (int i = 0; i < currentSinger; i++) {
            System.out.printf("[ ID: %d | Name: %s ]\n", singers[i].getSingerID(), singers[i].getSingerName());
        }

        Singer selectedSinger = null;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Lựa chọn ID  ");
            int idChoice = sc.nextInt();

            sc.nextLine();


            for (int i = 0; i < currentSinger; i++) {
                if (singers[i].getSingerID() == idChoice) {
                    selectedSinger = singers[i];
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {
                System.err.println("Không tồn tại danh mục đó. Vui lòng chọn lại.");
            }
        }

        return selectedSinger;
    }


    public Date inputCreated(Scanner sc) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập vào ngày tạo dd/MM/yyyy: ");
        do
        {
            String date = sc.nextLine();
            try
            {
                return sdf.parse(date);
            }
            catch (ParseException e)
            {
                System.err.println("Nhập ngày không đúng định dạng");
            }
        }
        while (true);
    }

    public String inputSongName(Scanner sc) {
        System.out.println("Mời bạn nhập tên bài hát");
        do {
            String songName = sc.nextLine();
            if(songName.trim().isEmpty()) {
                System.err.println("Không được để trùng");
            }
            else {
                return songName;
            }
        }while (true);
    }

    public String inputSongID(Scanner sc, Song[] songs, int currentSong) {
        System.out.println("Nhập mã bài hát (Có 4 ký tự và bắt đầu bằng kí tự S VD:SXXX " );
        do {
            String id = sc.nextLine();
            if (id.matches("^S\\w{3}$")){
                boolean isExist = false;
                for (int i = 0; i < currentSong; i++) {
                    if (songs[i].getSongId().equals(id)) {
                        isExist = true;
                    }
                }if(isExist){
                    System.err.println("Mã sản phẩm đã bị trùng");
                }
                else {
                    return id;
                }
            }
            else {
                System.err.println("Bạn vui lòng nhập ký tự theo hương dẫn VD:SXXX");
            }
        }while (true);
    }

    public String getListSingerNamebyID(Singer[] singers, int currentSinger) {
        for (int i = 0; i < currentSinger; i++) {
            if (singers[i].getSingerID() == this.singer.getSingerID()){
                return singers[i].getSingerName();
            }
        }
        return null;
    }


    public void displayDataSong(Singer[] singers, int currentSinger){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf(
                "[ ID: %s | Name: %s | Des: %s | Created: %s | Singer: %s | SongWriter: %s | Status: %s ]\n",
                this.songId,
                this.songName,
                this.description,
                this.createdDate,
                getListSingerNamebyID(singers, currentSinger),
                this.songWriter,
                this.songStatus  ? "Active" : "In Active"
        );

    }
}
