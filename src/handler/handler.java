package handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.DanhSachDiem;
import model.Diem;
import model.LopHoc;
import model.MonHoc;
import model.SinhVien;
import model.TKB;
import model.TaiKhoan;

public class handler {

	public LopHoc docFileDanhSachLop(String path) {
		LopHoc l = new LopHoc();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			
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
				
				System.out.println("Thêm thành công!");
			}
			
			br.close();
		}catch(Exception ex) {
			System.out.println("Thêm thất bại!");
		}
		return l;
	}
	
	public TKB docFileThoiKhoaBieu(String path) {
		TKB tkb = new TKB();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			
			while((line = br.readLine()) != null) {
				tkb.setId(line.split(",")[0]);
				ArrayList<MonHoc> arr = new ArrayList<>();

				int n = Integer.parseInt(line.split(",")[1]);
				
				for(int i=0; i<n; i++) {
					line = br.readLine();
					MonHoc mh = new MonHoc();
					
					mh.setStt(i+1+"");
					mh.setMaMon(line.split(",")[0]);
					mh.setTen(line.split(",")[1]);
					mh.setPhong(line.split(",")[2]);
					
					arr.add(mh);
				}
				
				tkb.setMh(arr);
				
				System.out.println("Thêm thành công!");
			}
			
			br.close();
		}catch(Exception ex) {
			System.out.println("Thêm thất bại!");
		}
		return tkb;
	}
	
	public DanhSachDiem docFileDiem(String path) {
		DanhSachDiem dsDiem = new DanhSachDiem();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			
			while((line = br.readLine()) != null) {
				dsDiem.setId(line.split(",")[0]);
				ArrayList<Diem> arr = new ArrayList<>();

				int n = Integer.parseInt(line.split(",")[1]);
				
				for(int i=0; i<n; i++) {
					line = br.readLine();
					Diem d = new Diem();
					
					d.setStt(i+1+"");
					d.setMssv(line.split(",")[0]);
					d.setTen(line.split(",")[1]);
					d.setDiemGK(Double.parseDouble(line.split(",")[2]));
					d.setDiemCK(Double.parseDouble(line.split(",")[3]));
					d.setDiemKhac(Double.parseDouble(line.split(",")[4]));
					d.setDiemTong(Double.parseDouble(line.split(",")[5]));
					
					arr.add(d);
				}
				
				dsDiem.setDiem(arr);
				
				System.out.println("Thêm thành công!");
			}
			
			br.close();
		}catch(Exception ex) {
			System.out.println("Thêm thất bại!");
		}
		return dsDiem;
	}
	
	public ArrayList<TaiKhoan> docFileTaiKhoan(String path) {
		ArrayList<TaiKhoan> ds = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			
			while((line = br.readLine()) != null) {
				int n = Integer.parseInt(line);
				
				for(int i=0; i<n; i++) {
					line = br.readLine();
					TaiKhoan d = new TaiKhoan();
					
					d.setUsername(line.split(",")[0]);
					d.setPassword(line.split(",")[1]);
					
					ds.add(d);
				}
								
				System.out.println("Thêm thành công!");
			}
			
			br.close();
		}catch(Exception ex) {
			System.out.println("Thêm thất bại!");
		}
		return ds;
	}
	
	public void luuFileTaiKhoan(ArrayList<TaiKhoan> tk, String path) throws IOException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.newLine();
			bw.write(tk.size());
			for(int i=0; i<tk.size(); i++) {
				bw.newLine();
				bw.write(tk.get(i).getUsername()+",");
				bw.write(tk.get(i).getPassword());
			}
			bw.close();
		}catch(Exception ex) {
			System.out.println("Save thất bại!!");
		}
	}
	
	public void luuFileDanhSachLop(LopHoc l, String path) throws IOException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.newLine();
			bw.write(l.getId()+","+l.getSv().size());
			for(int i=0; i<l.getSv().size(); i++) {
				bw.newLine();
				bw.write(l.getSv().get(i).getMssv()+",");
				bw.write(l.getSv().get(i).getTen()+",");
				bw.write(l.getSv().get(i).getGioiTinh()+",");
				bw.write(l.getSv().get(i).getCmnd());
			}
			bw.close();
		}catch(Exception ex) {
			System.out.println("Save thất bại!!");
		}
	}
	
	public void luuFileTKB(TKB tkb, String path) throws IOException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.newLine();
			bw.write(tkb.getId()+","+tkb.getMh().size());
			for(int i=0; i<tkb.getMh().size(); i++) {
				bw.newLine();
				bw.write(tkb.getMh().get(i).getMaMon()+",");
				bw.write(tkb.getMh().get(i).getTen()+",");
				bw.write(tkb.getMh().get(i).getPhong());
			}
			bw.close();
		}catch(Exception ex) {
			System.out.println("Save thất bại!!");
		}
	}
	
	public void luuFileDanhSachDiem(DanhSachDiem dsDiem, String path) throws IOException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.newLine();
			bw.write(dsDiem.getId()+","+dsDiem.getDiem().size());
			for(int i=0; i<dsDiem.getDiem().size(); i++) {
				bw.newLine();
				bw.write(dsDiem.getDiem().get(i).getMssv()+",");
				bw.write(dsDiem.getDiem().get(i).getTen()+",");
				bw.write(dsDiem.getDiem().get(i).getDiemGK()+",");
				bw.write(dsDiem.getDiem().get(i).getDiemCK()+",");
				bw.write(dsDiem.getDiem().get(i).getDiemKhac()+",");
				bw.write(dsDiem.getDiem().get(i).getDiemTong()+"");
			}
			bw.close();
		}catch(Exception ex) {
			System.out.println("Save thất bại!!");
		}
	}
}
