package hospital.patients;

import java.time.LocalTime;

public class SeverelyInjuredPatient extends AbstractPatient {

	private TreatmentPriority priority;
	private int injuryRate;
	
	public SeverelyInjuredPatient(String patientName, LocalTime patientArrivalTime, int injuryRate) {
		super(patientName, patientArrivalTime);
		this.injuryRate = injuryRate;
		this.priority = TreatmentPriority.MEDIUM;
	}

	@Override
	public int compareTo(AbstractPatient o) {
		// HohePrio.compareTo(niedrigePrio) = -1
		// niedrigePrio.compareTo(HohePrio) = +1
		if (o instanceof EmergencyPatient) {
			 return 1;
		} else if (o instanceof SlightlyInjuredPatient) {
			return -1;
		} else {
			if (this.injuryRate > ((SeverelyInjuredPatient)o).injuryRate)
				return 1;
			else if (this.injuryRate < ((SeverelyInjuredPatient)o).injuryRate)
				return -1;
			else return this.arrivalTime.compareTo(o.arrivalTime);
		}
	}

	@Override
	public TreatmentPriority getPriority() {
		return this.priority;
	}

	@Override
	public String getCatInfo() {
		return String.format("T2/Orange-%d", this.injuryRate);
	}
}
