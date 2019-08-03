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

	
}
