package Run;

import Model.Singer;
import Model.Song;
import controller.SingerController;

import java.util.Scanner;

public class MUCSIC_MANAGERMENT {
    

    public static  Song [] song=new Song[100];
    public static  int currentSong=0;


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // show ra menu
        do
        {
            MUCSIC_MANAGERMENT main = new MUCSIC_MANAGERMENT();
            System.out.println("********************* MUSIC-MANAGEMENT *********************");
            System.out.println("1. Quản lý ca sỹ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("************************************************************");
            System.out.println("Lựa chọn đê: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice)
            {
                case 1:
                {
                    new SingerController().menuSinger(scanner);
                    break;
                }
                case 2:
                {
                    main.menuSong(scanner);
                    break;
                }
                case 3:
                {
                    main.menuSearch(scanner);
                    break;
                }
                case 4:
                {
                    System.exit(0);
                    break;
                }
                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 4");
            }
        }
        while (true);
    }

    public void menuSearch(Scanner scanner) {
        boolean isLoop = true;
        do
        {
            System.out.println("--------------------------*SEARCH-MANAGEMENT*---------------------------\n" +
                    "\n" +
                    "1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại\n" +
                    "2. Tìm kiếm ca sĩ theo tên hoặc thể loại \n" +
                    "3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần\n" +
                    "4. Hiển thị 10 bài hát được đăng mới nhất\n" +
                    "5. Thoát" );
            System.out.println("Lựa chọn đê: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice)
            {
                case 1:
                {   searchSongBySingerorCategory(scanner);
                    break;
                }
                case 2:
                {   searchSingerByNameorCategory(scanner);
                    break;
                }
                case 3:
                {   sortSongNameIncrement(scanner);
                    break;
                }
                case 4:
                {   showingTheLastTenSongs(scanner);
                    break;
                }

                case 5:
                {
                    isLoop = false;
                    break;
                }
                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 5");
            }
        }
        while (isLoop);
    }

    private void showingTheLastTenSongs(Scanner scanner) {
      for (int i = 0; i < currentSong-1; i++) {
          for (int j = i+1; j < currentSong; j++) {
              if(song[i].getCreatedDate().after(song[j].getCreatedDate())){
                  Song temp = song[i];
                  song[i] = song[j];
                  song[j] = temp;
              }
          }

      }
        int startIndex = Math.max(0, currentSong - 10);
        for (int i = startIndex ; i < currentSong ; i++) {
            song[i].displayDataSong(singers,currentSinger);
        }

    }



    private void sortSongNameIncrement(Scanner scanner) {
        for(int i =0;i< currentSong;i++ ){
            for (int j=i+1;j<currentSong;j++){
                if(song[i].getSongName()!=null && song[j].getSongName()!=null){
                    if(song[i].getSongName().compareTo(song[j].getSongName())>0){
                        Song temp = song[i];
                        song[i] = song[j];
                        song[j+1] = temp;
                    }
                }
            }
        } showAllSong();


    }

    private void searchSingerByNameorCategory(Scanner scanner) {
        if(currentSinger==0){
            System.err.println("List ca sỹ đang trống");
            return;
        }
        System.out.println("Mời bạn nhập tên bài hát muốn thêm ");
        String keyword = scanner.nextLine();
        boolean check=false;
        for (int i=0;i<currentSinger;i++){
            if(singers[i].getSingerName().contains(keyword)||singers[i].getGenre().contains(keyword)){
                singers[i].displayDataSinger();
                check=true;

            }
        }
        if(!check){
            System.err.println("Không tìm thấy ca sỹ "+keyword);
        }
    }

    private void searchSongBySingerorCategory(Scanner scanner) {
        if(currentSong==0){
            System.err.println("List bài hat đang trống");
            return;
        }
        if(currentSinger==0){
            System.err.println("List ca sỹ đang trống");
            return;
        }
        System.out.println("Mời bạn nhập tên tên bài hát muốn tìm");
        String keyword = scanner.nextLine();
        boolean check=false;
        for (int i = 0; i < currentSong; i++) {
            if(song[i].getSinger().getSingerName().contains(keyword) || song[i].getSinger().getGenre().contains(keyword)
            ){
                song[i].displayDataSong(singers,currentSinger);
                check=true;
            }
        }
        if(!check){
            System.err.println("Không tìm bài hát "+keyword);
        }
    }

    public void menuSinger(Scanner scanner)
    {
        boolean isLoop = true;
        do
        {
            System.out.println("---------------------------SINGER-MANAGEMENT*---------------------------\n" +
                    "\n" +
                    "1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới\n" +
                    "2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ\n" +
                    "3. Thay đổi thông tin ca sĩ theo mã id\n" +
                    "4. Xóa ca sĩ theo mã id \n" +
                    "5. Thoát");
            System.out.println("Lựa chọn đê: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice)
            {
                case 1:
                {   addNewSinger(scanner);
                    break;
                }
                case 2:
                {   showAllSinger();
                    break;
                }
                case 3:
                {   updateSinger(scanner);
                    break;
                }
                case 4:
                {   deleteListSinger(scanner);
                    break;
                }
                case 5:
                {
                    isLoop = false;
                    break;
                }
                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 5");
            }
        }
        while (isLoop);
    }

    private void deleteListSinger(Scanner scanner) {
        System.out.println("Mời bạn nhập id muốn xóa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        int indexDelete = findIndexByIDSinger(idDelete);
        if(indexDelete != -1){
            boolean check = false;
            for (int i=0; i<currentSong; i++) {

                if(idDelete == song[i].getSinger().getSingerID()) {

                    check = true;
                    break;
                }
            }
            if(check){
                System.err.println("Không thể xóa bài hát");
                return;
            }

          for (int i=indexDelete;i<currentSinger;i++){
              singers[i]=singers[i+1];
              currentSinger--;

          }
            System.out.println("Xóa thành công");
        }
        else {
            System.out.println("Khong tim thay vi tri xoa");
        }

    }

    private void updateSinger(Scanner scanner) {
        System.out.println("Nhap ID muon thay doi");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        int indexUpdate = findIndexByIDSinger(idUpdate);
        if(indexUpdate != -1){


                singers[indexUpdate].inputUpdate(scanner,singers,currentSinger);
            }

        else {
            System.out.println("Khong tim thay id can update");
        }

    }

    private void showAllSinger() {
        if(currentSinger==0){
            System.err.println("Danh sach trong");
        }
        else {
            for (int i=0; i<currentSinger; i++){
                singers[i].displayDataSinger();
            }

        }
    }
  public static int findIndexByIDSinger(int id) {
        for (int i=0; i<currentSinger; i++){
            if (singers[i].getSingerID()==id){
                return i;
            }
        }return -1;


  }

    private void addNewSinger(Scanner scanner) {
        System.out.println("Mời bạn nhập số lượng ca sỹ muốn thêm vào");
        do {

            try {
                int n= Integer.parseInt(scanner.nextLine());
                if (n > 0) {
                    for (int i = 0; i < n; i++) {
                        System.out.println("Ca sỹ thêm vào thứ " + (i + 1) + " là :");
                        singers[currentSinger] = new Singer();
                        singers[currentSinger].inputData(scanner, singers, currentSinger);
                        currentSinger++;
                    }
                    break;
                } else {
                    System.err.println("số lượng phải lớn hơn ");
                }
            }
            catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên hợp lê");
            }
            catch (Exception e){
                System.err.println("đã xảy ra lỗi"+ e.getMessage());
            }
        }while (true);
    }

    public void menuSong(Scanner scanner)
    {
        boolean isLoop = true;
        do
        {
            System.out.println("---------------------------SONG-MANAGEMENT---------------------------\n" +
                    "\n" +
                    "1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới\n" +
                    "2. Hiển thị danh sách tất cả bài hát đã lưu trữ\n" +
                    "3. Thay đổi thông tin bài hát theo mã id\n" +
                    "4. Xóa bài hát theo mã id\n" +
                    "5. Thoát\n"
                    );
            System.out.println("Lựa chọn : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice)
            {
                case 1:
                {   addNewSong(scanner);
                    break;
                }
                case 2:
                {   showAllSong();
                    break;
                }
                case 3:
                {
                    updateSong(scanner);
                    break;
                }
                case 4:
                {   deleteSong(scanner);
                    break;
                }
                case 5:
                {
                    isLoop = false;
                    break;
                }

                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 5");
            }
        }
        while (isLoop);
    }

    private void deleteSong(Scanner scanner) {

            System.out.println("Mời bạn nhập iD muốn xóa");
            String ID = scanner.nextLine();
            int indexDelete=findindexSongByID(ID);

            if(indexDelete!=-1){
                for (int i=indexDelete; i<currentSong; i++){
                    song[i]=song[i+1];
                    currentSong--;
                    System.out.println("Xóa thành công");
                }
            }else {
                System.err.println("Không tìm thấy vị trí ID muốn xóa"+indexDelete);
            }

    }

    private void updateSong(Scanner scanner) {
        System.out.println("Nhập id muốn thay đổi");
        String idUpdateP = scanner.nextLine();
        if (  findSongBYID(idUpdateP)!=null) {

                findSongBYID(idUpdateP).inputUpdateSong(scanner,song,currentSong,singers,currentSinger);

        }
        else {
            System.err.println("Không tồn tại id có mã"+idUpdateP);
        }
    }

    private void showAllSong() {
        if(currentSong==0){
            System.err.println("Danh sách trống");
            return;
        }

            for (int i=0; i<currentSong;i++){
                song[i].displayDataSong(singers,currentSinger);

        }
    }

    public static Song findSongBYID(String id2) {
        for (int i = 0; i <currentSong; i++) {
            if(song[i].getSongId().equals(id2) ){
                return song[i];}
        }
        return null;
    }
    public int findindexSongByID(String id) {
        for (int i = 0; i <currentSong; i++) {
            if(song[i].getSongId().equals(id) ){
                return i;
            }
        }
        return -1;
    }

    private void addNewSong(Scanner scanner) {
        System.out.println("Nhập số bài hát muốn thêm vào?");
        do {
            if (currentSinger == 0) {
                System.err.println("Danh sách ca sĩ đang trống, cần nhập thêm");
                break;
            }
            try {
                int n = Integer.parseInt(scanner.nextLine());
                if (n > 0) {
                    for (int i = 0; i < n; i++) {
                        System.out.println("Mã bài hát thứ " + (i + 1));
                        song[currentSong] = new Song();
                        song[currentSong].inputDataSong(scanner, song, currentSong, singers, currentSinger);
                        currentSong++;
                    }
                    break;
                } else {
                    System.err.println("N phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số nguyên hợp lệ.");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        } while (true);
    }
}
