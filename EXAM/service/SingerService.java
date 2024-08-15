package service;

import Model.Singer;

import java.util.Scanner;

public class SingerService
{
	public static  Singer[] singers=new Singer[100];
	public static int  currentSinger=0;
	
	public void deleteListSinger(Scanner scanner) {
		System.out.println("Mời bạn nhập id muốn xóa");
		int idDelete = Integer.parseInt(scanner.nextLine());
		int indexDelete = findIndexByIDSinger(idDelete);
		if(indexDelete != -1){
			boolean check = false;
			for (int i=0; i<SongService.currentSong; i++) {
				
				if(idDelete == SongService.song[i].getSinger().getSingerID()) {
					
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
	
	public void updateSinger(Scanner scanner) {
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
	
	public void showAllSinger() {
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
	
	public void addNewSinger(Scanner scanner) {
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
}
