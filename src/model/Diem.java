package model;

public class Diem {

	private String stt;
	private String mssv;
	private String ten;
	private double diemGK;
	private double diemCK;
	private double diemKhac;
	private double diemTong;
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
	public double getDiemGK() {
		return diemGK;
	}
	public void setDiemGK(double diemGK) {
		this.diemGK = diemGK;
	}
	public double getDiemCK() {
		return diemCK;
	}
	public void setDiemCK(double diemCK) {
		this.diemCK = diemCK;
	}
	public double getDiemKhac() {
		return diemKhac;
	}
	public void setDiemKhac(double diemKhac) {
		this.diemKhac = diemKhac;
	}
	public double getDiemTong() {
		return diemTong;
	}
	public void setDiemTong(double diemTong) {
		this.diemTong = diemTong;
	}
	public Diem(String stt, String mssv, String ten, double diemGK, double diemCK, double diemKhac, double diemTong) {
		super();
		this.stt = stt;
		this.mssv = mssv;
		this.ten = ten;
		this.diemGK = diemGK;
		this.diemCK = diemCK;
		this.diemKhac = diemKhac;
		this.diemTong = diemTong;
	}
	public Diem() {
		super();
	}

}
