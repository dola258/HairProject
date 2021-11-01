package hairline.vo;

public class CustomerVo {
	// Fields
		private  int     idx;        // 고객번호
		private  String  cname;      // 고객명
		private  String  ctel;       // 고객연락처
		private  String  cbirth;     // 고객생년월일
		private  String  dname;      // 담당자
		private  String	 regdate;  	 // 고객등록일 
		private  String  hcode;  	 // 고객마지막헤어스타일
		private  String  specifics;  // 고객특이사항
		
		
		
	// 조회를 위한 생성자 - customer member list
		public CustomerVo(int idx, String cname, String ctel, String cbirth, String dname, String regdate, String hcode,
				String specifics) {
			super();
			this.idx = idx;
			this.cname = cname;
			this.ctel = ctel;
			this.cbirth = cbirth;
			this.dname = dname;
			this.regdate = regdate;
			this.hcode = hcode;
			this.specifics = specifics;
		}
		

	// 신규 등록을 위한 생성자 - customer register
		public CustomerVo(String cname, String ctel, String cbirth, String dname, String specifics) {
			super();
			this.cname = cname;
			this.ctel = ctel;
			this.cbirth = cbirth;
			this.dname = dname;
			this.specifics = specifics;
		}



		// getter /setter
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



		public String getRegdate() {
			return regdate;
		}



		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}



		public String getHcode() {
			return hcode;
		}



		public void setHcode(String hcode) {
			this.hcode = hcode;
		}



		public String getSpecifics() {
			return specifics;
		}



		public void setSpecifics(String specifics) {
			this.specifics = specifics;
		}


	//	toString
		@Override
		public String toString() {
			return "CustomerVo [idx=" + idx + ", cname=" + cname + ", ctel=" + ctel + ", cbirth=" + cbirth + ", dname="
					+ dname + ", regdate=" + regdate + ", hcode=" + hcode + ", specifics=" + specifics + "]";
		}

}
