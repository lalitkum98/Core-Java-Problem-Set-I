package RePracticeAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InOutTimingsFindXTime {
	public void findXHoursEmployee(List<EmployeesInOutDetails> logDetails, int Xhours) {
		Map<String, Integer> hoursLogged = new HashMap<String, Integer>();
	 int hours;
		for(EmployeesInOutDetails emp :logDetails){
			String inOut;
			if(emp.getInOutDetails().equals("In")){
				 inOut ="Out";
			}else{
				inOut="In";
			}
			for(EmployeesInOutDetails findEmp :logDetails){
								
				if(emp.getEmpId().equals(findEmp.getEmpId()) && findEmp.getInOutDetails().equals(inOut)){
					hours = (emp.getDate().getHours()+12) - findEmp.getDate().getHours();
					hoursLogged.put(emp.getEmpId(), hours);
				}
			}
		}
		
		for(Map.Entry<String, Integer> entry : hoursLogged.entrySet()){
			if(entry.getValue().equals(Xhours)){
				System.out.println("Employee who has x hours :" + entry.getKey());
			}
		}
	}

	public static void main(String arg[]) {
		
		List<EmployeesInOutDetails> logDetails = new ArrayList<EmployeesInOutDetails>();
		EmployeesInOutDetails ep1 = new EmployeesInOutDetails("E101", "In",
				"2016/04/10 09:00:00");
		EmployeesInOutDetails ep2 = new EmployeesInOutDetails("E102", "In",
				"2016/04/10 07:00:00");
		EmployeesInOutDetails ep3 = new EmployeesInOutDetails("E101", "Out",
				"2016/04/10 06:00:00");
		EmployeesInOutDetails ep4 = new EmployeesInOutDetails("E102", "Out",
				"2016/04/10 06:00:00");

		logDetails.add(ep1);
		logDetails.add(ep2);
		logDetails.add(ep3);
		logDetails.add(ep4);
		
		InOutTimingsFindXTime tfx = new InOutTimingsFindXTime();
		tfx.findXHoursEmployee(logDetails, 11);
		
	}
}
