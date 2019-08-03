package model;

public class SinhVien {

	private String stt;
	private String mssv;
	private String ten;
	private String gioiTinh;
	private String cmnd;
		
	public SinhVien() {
		super();
	}

	public SinhVien(String stt, String mssv, String ten, String gioiTinh, String cmnd) {
		super();
		this.stt = stt;
		this.mssv = mssv;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
	}
	
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
}
