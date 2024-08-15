package controller;

import Model.Singer;
import service.SingerService;

import java.util.Scanner;

public class SingerController
{
	
	
	public void menuSinger(Scanner scanner)
	{
		SingerService singerService = new SingerService();
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
				{   singerService.addNewSinger(scanner);
					break;
				}
				case 2:
				{   singerService.showAllSinger();
					break;
				}
				case 3:
				{   singerService.updateSinger(scanner);
					break;
				}
				case 4:
				{   singerService.deleteListSinger(scanner);
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
	
	
}
