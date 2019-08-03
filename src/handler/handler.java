package handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.LopHoc;
import model.SinhVien;

public class handler {

	public LopHoc docFileDanhSachLop(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String line;
		LopHoc l = new LopHoc();
		
		while((line = br.readLine()) != null) {
			l.setId(line.split(",")[0]);
			ArrayList<SinhVien> arr = new ArrayList<>();

			int n = Integer.parseInt(line.split(",")[1]);
			
			for(int i=0; i<n; i++) {
				line = br.readLine();
				SinhVien sv = new SinhVien();
				
				sv.setStt(i+1+"");
				sv.setMssv(line.split(",")[0]);
				sv.setTen(line.split(",")[1]);
				sv.setGioiTinh(line.split(",")[2]);
				sv.setCmnd(line.split(",")[3]);
				
				arr.add(sv);
			}
			
			l.setSv(arr);
		}
		
		return l;
	}
	
	public void luuFileDanhSachLop(LopHoc l, String path) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.write(l.getId()+","+l.getSv().size());
		for(int i=0; i<l.getSv().size(); i++) {
			bw.newLine();
			bw.write(l.getSv().get(i).getMssv()+",");
			bw.write(l.getSv().get(i).getTen()+",");
			bw.write(l.getSv().get(i).getGioiTinh()+",");
			bw.write(l.getSv().get(i).getCmnd());
		}
	}
}
