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
		return String.format("T2/Orange-%d", this.injuryRate);
	}
}
