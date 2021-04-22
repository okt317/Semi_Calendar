package Project_First;

public class ChulGyulVO {
	private int year = 0;
	private int month = 0;
	private int day = 0;
//	private String year =    null;
//	private String month =   null;
//	private String day =     null;
	private String chul = null;
	private String toi = null;
	private String mem_id = null; 
	private String yymmdd = null; 
	
	ChulGyulVO(){}
	ChulGyulVO(int year, int month, int day, String chul, String toi,
			String mem_id){}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getChul() {
		return chul;
	}

	public void setChul(String chul) {
		this.chul = chul;
	}

	public String getToi() {
		return toi;
	}

	public void setToi(String toi) {
		this.toi = toi;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getYymmdd() {
		return yymmdd;
	}
	public void setYymmdd(String yymmdd) {
		this.yymmdd = yymmdd;
	}
	
}
