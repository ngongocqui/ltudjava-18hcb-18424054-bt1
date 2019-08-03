package model;

import java.util.ArrayList;

public class DanhSachDiem {

	private String id;
	private ArrayList<Diem> diem;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Diem> getDiem() {
		return diem;
	}
	public void setDiem(ArrayList<Diem> diem) {
		this.diem = diem;
	}

	public int getSinhVienDau() {
		int tong = 0;
		for(Diem d: this.diem) {
			if(d.getDiemTong() >= 5) tong++;
		}
		
		return tong;
	}
	
	public int getSinhVienRot() {
		int tong = 0;
		for(Diem d: this.diem) {
			if(d.getDiemTong() < 5) tong++;
		}
		
		return tong;
	}
	
	public double getPhanTramSinhVienDau() {
		float tong = getSinhVienDau();
		
		return (tong/diem.size())*100;
	}
	
	public double getPhanTramSinhVienRot() {
		float tong = getSinhVienRot();
		
		return (tong/diem.size())*100;
	}
	
}
