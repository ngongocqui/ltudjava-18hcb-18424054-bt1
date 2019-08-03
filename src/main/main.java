package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import handler.handler;
import model.LopHoc;
import model.SinhVien;

public class main {

	public static void main(String[] args) throws IOException {
		menu();
	}

	private static void menu() throws IOException {
		ArrayList<LopHoc> arrLop = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("1.import danh sách lớp.");
			System.out.println("2.thêm sinh viên vào lớp.");
			System.out.println("3.lưu danh sách lớp.");
			System.out.println("Bạn chọn: ");
			String select = scan.nextLine();

			switch (select) {
			case "1": {
					// yêu cầu 1: Import danh sách lớp (file CSV) vào hệ thống.
					LopHoc l = new LopHoc();
					l = import_LopHoc();
	
					boolean kt = true;
					for (LopHoc a : arrLop) {
						if (a.getId() == l.getId()) {
							kt = false;
							break;
						}
					}
	
					if (kt)
						arrLop.add(l);
	
					break;
				}
			case "2": {
					System.out.println("Nhập id lớp cần thêm: ");
					String id = scan.nextLine();
					LopHoc l = null;
	
					for (int i=0; i<arrLop.size(); i++) {
						if(new String(arrLop.get(i).getId()).equalsIgnoreCase(id)) {
							l = arrLop.get(i);
							break;
						}
					}
	
					if (l != null) {
						addSinhVien(l);
					}
	
					break;
				}
			case "3":{
					System.out.println("Nhập folder save file danh sách lớp: ");
					String folder = scan.nextLine();
				
					luuDanhSachLop(arrLop, folder);
				}
			}
		}
	}

	private static void luuDanhSachLop(ArrayList<LopHoc> arrLop, String folder) throws IOException {
		handler handler = new handler();
		for(int i = 0; i<arrLop.size(); i++) {
			handler.luuFileDanhSachLop(arrLop.get(i), folder+"/"+arrLop.get(i).getId()+".csv");
		}
	}

	private static LopHoc import_LopHoc() throws IOException {
		System.out.print("Nhập path file danh sách lớp: ");
		String path = new Scanner(System.in).nextLine();

		handler handler = new handler();
		LopHoc l = handler.docFileDanhSachLop(path);

		return l;
	}
	
	

	private static LopHoc addSinhVien(LopHoc l) throws IOException {
		System.out.print("Nhập mssv: ");
		String mssv = new Scanner(System.in).nextLine();
		System.out.print("Nhập ten: ");
		String ten = new Scanner(System.in).nextLine();
		System.out.print("Nhập gioi tinh: ");
		String gioiTinh = new Scanner(System.in).nextLine();
		System.out.print("Nhập cmnd: ");
		String cmnd = new Scanner(System.in).nextLine();

		SinhVien sv = new SinhVien(l.getSv().size() + "", mssv, ten, gioiTinh, cmnd);
		l.getSv().add(sv);

		return l;
	}

}
