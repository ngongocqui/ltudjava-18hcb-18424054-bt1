package main;

import java.io.IOException;
import java.util.Scanner;

import handler.handler;
import model.LopHoc;
import model.SinhVien;

public class main {

	public static void main(String[] args) throws IOException {
		// yêu cầu 1: Import danh sách lớp (file CSV) vào hệ thống.
		LopHoc l = hanndler_1();
	}

	private static LopHoc hanndler_1() throws IOException {
		System.out.print("Nhập path file danh sách lớp: ");
		String path = new Scanner(System.in).nextLine();
		
		handler handler = new handler();
		LopHoc l = handler.docFileDanhSachLop(path);
		
		return l;
	}

}
