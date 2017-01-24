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
		// HohePrio.compareTo(niedrigePrio) = -1
		// niedrigePrio.compareTo(HohePrio) = +1
		if (o instanceof EmergencyPatient || o instanceof SeverelyInjuredPatient){
			 return 1;
		} else {
			return this.arrivalTime.compareTo(o.arrivalTime);
		}
	}

	@Override
	public TreatmentPriority getPriority() {
		return this.priority;
	}

	@Override
	public String getCatInfo() {
		return "T3/Green";
	}

	

}
