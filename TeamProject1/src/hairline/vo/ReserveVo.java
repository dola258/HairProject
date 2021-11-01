package hairline.vo;

public class ReserveVo {
	private int idx;
	private String did;
	private String cname;
	private String ctel;
	private String cbirth;
	private String dname;
	private String hcode;
	private String hname;
	private String regdate;
	private String specifics;
	private String datetime;
	

	
	public ReserveVo() {}



	public ReserveVo(int idx, String did, String cname, String ctel, String cbirth, String dname, String hcode, String hname, String regdate,
			String specifics, String datetime) {
		super();
		this.idx = idx;
		this.did = did;
		this.cname = cname;
		this.ctel = ctel;
		this.cbirth = cbirth;
		this.dname = dname;
		this.hcode = hcode;
		this.hname = hname;
		this.regdate = regdate;
		this.specifics = specifics;
		this.datetime = datetime;
	}






	public String getHcode() {
		return hcode;
	}



	public void setHcode(String hcode) {
		this.hcode = hcode;
	}



	public String getDid() {
		return did;
	}



	public void setDid(String did) {
		this.did = did;
	}



	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public String getCtel() {
		return ctel;
	}



	public void setCtel(String ctel) {
		this.ctel = ctel;
	}



	public String getCbirth() {
		return cbirth;
	}



	public void setCbirth(String cbirth) {
		this.cbirth = cbirth;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public String getHname() {
		return hname;
	}



	public void setHname(String hname) {
		this.hname = hname;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	public String getSpecifics() {
		return specifics;
	}



	public void setSpecifics(String specifics) {
		this.specifics = specifics;
	}



	public String getDatetime() {
		return datetime;
	}



	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}



	@Override
	public String toString() {
		return "ReserveVo [idx=" + idx + ", did=" + did + ", cname=" + cname + ", ctel=" + ctel + ", cbirth=" + cbirth
				+ ", dname=" + dname + ", hcode=" + hcode + ", hname=" + hname + ", regdate=" + regdate + ", specifics="
				+ specifics + ", datetime=" + datetime + "]";
	}



	


}