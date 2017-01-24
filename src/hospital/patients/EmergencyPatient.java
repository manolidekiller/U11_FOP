package hospital.patients;

import java.time.LocalTime;

public class EmergencyPatient extends AbstractPatient {
	
	private TreatmentPriority priority;

	
	public EmergencyPatient(String patientName, LocalTime patientArrivalTime) {
		super(patientName, patientArrivalTime);
		this.priority = TreatmentPriority.HIGH;
	}

	
	@Override
	public int compareTo(AbstractPatient o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreatmentPriority getPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatInfo() {
		return "T1/Red";
	}
}
