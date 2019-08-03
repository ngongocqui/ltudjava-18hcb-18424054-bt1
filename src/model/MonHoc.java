package model;

public class MonHoc {

	private String stt;
	private String maMon;
	private String ten;
	private String phong;
	
	public MonHoc() {
		super();
	}
	public MonHoc(String maMon, String ten, String phong) {
		super();
		this.maMon = maMon;
		this.ten = ten;
		this.phong = phong;
	}
	
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}

}
