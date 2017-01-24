package hospital.patients;

import java.time.LocalTime;

public class SlightlyInjuredPatient extends AbstractPatient {
	
	private TreatmentPriority priority;
	
	
	public SlightlyInjuredPatient(String patientName, LocalTime patientArrivalTime) {
		super(patientName, patientArrivalTime);
		this.priority =  TreatmentPriority.LOW;
	}
	

	@Override
	public int compareTo(AbstractPatient o) {
		if (o instanceof EmergencyPatient || o instanceof SeverelyInjuredPatient){
			// this = SlightylyInjuredPatient | o = Emergencypatient
			
		} else {
			// 
			
		}
	}

	@Override
	public TreatmentPriority getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}

	@Override
	public String getCatInfo() {
		return "T3/Green";
	}

	

}
