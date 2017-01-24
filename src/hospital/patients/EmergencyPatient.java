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
		// HohePrio.compareTo(niedrigePrio) = -1
		// niedrigePrio.compareTo(HohePrio) = +1
		if (o instanceof SlightlyInjuredPatient || o instanceof SeverelyInjuredPatient){
			 return -1;
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
		return "T1/Red";
	}
}
