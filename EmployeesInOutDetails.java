package RePracticeAlgo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeesInOutDetails {

	private String empId;
	private String inOutDetails;
	private Date date;

	EmployeesInOutDetails(String empId, String inOutDetails, String date) {
		this.empId = empId;
		this.inOutDetails = inOutDetails;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		try {
			this.date = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getInOutDetails() {
		return inOutDetails;
	}

	public void setInOutDetails(String inOutDetails) {
		this.inOutDetails = inOutDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

}
