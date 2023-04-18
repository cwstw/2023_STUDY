package ARTSHOP.STORE;

public class ORDERDTO {
	private int ordnum;
	private int memnum;
	private int pronum;
	private int ordpri;
	private String ordask;
	private String ordemail;
	private String ordstat;
	public int getOrdnum() {
		return ordnum;
	}
	public void setOrdnum(int ordnum) {
		this.ordnum = ordnum;
	}
	public int getMemnum() {
		return memnum;
	}
	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}
	public int getPronum() {
		return pronum;
	}
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	public int getOrdpri() {
		return ordpri;
	}
	public void setOrdpri(int ordpri) {
		this.ordpri = ordpri;
	}
	public String getOrdstat() {
		return ordstat;
	}
	public void setOrdstat(String ordstat) {
		this.ordstat = ordstat;
	}
	public String getOrdemail() {
		return ordemail;
	}
	public void setOrdemail(String ordemail) {
		this.ordemail = ordemail;
	}
	public String getOrdask() {
		return ordask;
	}
	public void setOrdask(String ordask) {
		this.ordask = ordask;
	}
	
}
