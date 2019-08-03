package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import handler.handler;
import model.DanhSachDiem;
import model.Diem;
import model.LopHoc;
import model.SinhVien;
import model.TKB;

public class main {

	public static void main(String[] args) throws IOException {
		menu();
	}

	private static void menu() throws IOException {
		ArrayList<LopHoc> arrLop = new ArrayList<>();
		ArrayList<TKB> arrTKB = new ArrayList<>();
		ArrayList<DanhSachDiem> arrDanhSachDiem = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("1.import danh sách lớp.");
			System.out.println("2.thêm sinh viên vào lớp.");
			System.out.println("3.lưu danh sách lớp.");
			System.out.println("4.import thời khoá biểu.");
			System.out.println("5.lưu thời khoá biểu.");
			System.out.println("6.xem danh sách lớp.");
			System.out.println("7.xem thời khoá biểu.");
			System.out.println("8.import bảng điểm.");
			System.out.println("9.lưu bảng điểm.");
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
	
					if (kt) arrLop.add(l);
	
					break;
				}
			case "2": {
					// yêu cầu 2: thêm sinh viên
					System.out.println("Nhập id lớp cần thêm: ");
					String id = scan.nextLine();
					LopHoc l = null;
	
					for (int i=0; i<arrLop.size(); i++) {
						if(new String(arrLop.get(i).getId()).equalsIgnoreCase(id)) {
							l = arrLop.get(i);
							break;
						}
					}
	
					if (l != null) addSinhVien(l);
	
					break;
				}
			case "3":{
					System.out.println("Nhập folder save file danh sách lớp: ");
					String folder = scan.nextLine();
				
					luuDanhSachLop(arrLop, folder);
					break;
				}
			case "4":{
					// yêu cầu 4: import thời khoá biểu
					TKB tkb = new TKB();
					tkb = import_TKB();
	
					boolean kt = true;
					for (TKB a : arrTKB) {
						if (a.getId() == tkb.getId()) {
							kt = false;
							break;
						}
					}
	
					if (kt) arrTKB.add(tkb);
	
					break;
				}
			case "5":{
					System.out.println("Nhập folder save file thời khoá biểu: ");
					String folder = scan.nextLine();
				
					luuThoiKhoaBieu(arrTKB, folder);
					break;
				}
			case "6":{
					// yêu cầu 5: xem danh sách lớp
					System.out.println("Nhập id lớp: ");
					String id = scan.nextLine();
				
					xemDanhSachLop(arrLop, id);
					break;
				}
			case "7":{
					// yêu cầu 6: xem thời khoá biểu
					System.out.println("Nhập id lớp: ");
					String id = scan.nextLine();
				
					xemThoiKhoaBieu(arrTKB, id);
					break;
				}
			case "8":{
					// yêu cầu 7: import bảng điểm
					DanhSachDiem dsDiem = new DanhSachDiem();
					dsDiem = import_DanhSachDiem();
	
					boolean kt = true;
					for (DanhSachDiem a : arrDanhSachDiem) {
						if (a.getId() == dsDiem.getId()) {
							kt = false;
							break;
						}
					}
	
					if (kt) arrDanhSachDiem.add(dsDiem);
	
					break;
				}
			case "9":{
					System.out.println("Nhập folder save file danh sách điểm: ");
					String folder = scan.nextLine();
				
					luuDanhSachDiem(arrDanhSachDiem, folder);
					break;
				}
			}
		}
	}

	private static void xemThoiKhoaBieu(ArrayList<TKB> arrTKB, String id) {
		for(TKB l:arrTKB) {
			if(l.getId().equalsIgnoreCase(id)) {
				System.out.println("Danh sách lớp: "+l.getId());
				
				for(int i=0; i<l.getMh().size(); i++) {
					System.out.println("STT: "+l.getMh().get(i).getStt());
					System.out.println("Mã môn: "+l.getMh().get(i).getMaMon());
					System.out.println("Tên: "+l.getMh().get(i).getTen());
					System.out.println("Phòng học: "+l.getMh().get(i).getPhong());
				}
						
				break;
			}
		}
	}

	private static void xemDanhSachLop(ArrayList<LopHoc> arrLop, String id) {
		for(LopHoc l:arrLop) {
			if(l.getId().equalsIgnoreCase(id)) {
				System.out.println("Danh sách lớp: "+l.getId());
				
				for(int i=0; i<l.getSv().size(); i++) {
					System.out.println("STT: "+l.getSv().get(i).getStt());
					System.out.println("MSSV: "+l.getSv().get(i).getMssv());
					System.out.println("Tên: "+l.getSv().get(i).getTen());
					System.out.println("Giới Tính: "+l.getSv().get(i).getGioiTinh());
					System.out.println("CMND: "+l.getSv().get(i).getCmnd());
				}
						
				break;
			}
		}
	}

	private static void luuDanhSachLop(ArrayList<LopHoc> arrLop, String folder) throws IOException {
		handler handler = new handler();
		for(int i = 0; i<arrLop.size(); i++) {
			handler.luuFileDanhSachLop(arrLop.get(i), folder+"/"+arrLop.get(i).getId()+".csv");
		}
	}
	
	private static void luuDanhSachDiem(ArrayList<DanhSachDiem> arrDanhSachDiem, String folder) throws IOException {
		handler handler = new handler();
		for(int i = 0; i<arrDanhSachDiem.size(); i++) {
			handler.luuFileDanhSachDiem(arrDanhSachDiem.get(i), folder+"/"+arrDanhSachDiem.get(i).getId()+"-DIEM.csv");
		}
	}
	
	private static void luuThoiKhoaBieu(ArrayList<TKB> arrTKB, String folder) throws IOException {
		handler handler = new handler();
		for(int i = 0; i<arrTKB.size(); i++) {
			handler.luuFileTKB(arrTKB.get(i), folder+"/"+arrTKB.get(i).getId()+"_TKB.csv");
		}
	}

	private static LopHoc import_LopHoc() throws IOException {
		System.out.print("Nhập path file danh sách lớp: ");
		String path = new Scanner(System.in).nextLine();

		handler handler = new handler();
		LopHoc l = handler.docFileDanhSachLop(path);

		return l;
	}
	
	private static DanhSachDiem import_DanhSachDiem() throws IOException {
		System.out.print("Nhập path file danh sách điểm: ");
		String path = new Scanner(System.in).nextLine();

		handler handler = new handler();
		DanhSachDiem dsDiem = handler.docFileDiem(path);

		return dsDiem;
	}
	
	private static TKB import_TKB() throws IOException {
		System.out.print("Nhập path file thời khoá biểu: ");
		String path = new Scanner(System.in).nextLine();

		handler handler = new handler();
		TKB tkb = handler.docFileThoiKhoaBieu(path);

		return tkb;
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
