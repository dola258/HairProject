package hairline.vo;

public class DesignerVo {
	private String did;
	private String pw;
	private String dname;
	private String birth;
	private String email;
	private String tel;
	private String wname;

	// 생성자
	public DesignerVo() {}
	public DesignerVo(String did, String pw, String dname, String birth, String email, String tel, String wname) {
		this.did = did;
		this.pw = pw;
		this.dname = dname;
		this.birth = birth;
		this.email = email;
		this.tel = tel;
		this.wname = wname;
	}
	
	public DesignerVo(String did, String pw) {
	}
	// Getter / Setter
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	
	// toString 
	@Override
	public String toString() {
		return "DesignerVo [did=" + did + ", pw=" + pw + ", dname=" + dname + ", birth=" + birth + ", email=" + email
				+ ", tel=" + tel + ", wname=" + wname + "]";
	}

	
	
}
