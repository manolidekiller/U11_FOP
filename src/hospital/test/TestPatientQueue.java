package hospital.test;



import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import static org.junit.Assert.*;

import org.junit.Test;

import hospital.patients.AbstractPatient;
import hospital.patients.EmergencyPatient;
import hospital.patients.SeverelyInjuredPatient;
import hospital.patients.SlightlyInjuredPatient;
import hospital.patients.TreatmentPriority;

public class TestPatientQueue {
	

	//**************************************************************
	//********************** Helper method *************************
	//**************************************************************	
	/**
	 * Takes an array of patients and returns a shuffled copy.
	 * @param patients the patients
	 * @return the patients in shuffled order
	 */
	private static AbstractPatient[] getShuffledArray(AbstractPatient[] patients){
		// Init random number generator with fixed seed
		Random random = new Random(12345);
		
		// Add patients to new list
		ArrayList<AbstractPatient> list = new ArrayList<AbstractPatient>();
		for (AbstractPatient p : patients){
			list.add(p);
		}		
		
		AbstractPatient[] shuffledArray = new AbstractPatient[list.size()];
		Collections.shuffle(list, random);
		list.toArray(shuffledArray);
		return shuffledArray;
	}
	

	//**************************************************************
	//****************** Test patient categories *******************
	//**************************************************************	
	
	// Check correct behavior of the getPriority() method 
	// for each patient class.
	@Test
	public void validateGetPriority(){
		EmergencyPatient testpatient1 = new EmergencyPatient("TestEmergency", LocalTime.of(20, 30));
		SeverelyInjuredPatient testpatient2 = new SeverelyInjuredPatient("TestSeverlyInjured", LocalTime.of(20, 30), 5);
		SlightlyInjuredPatient testpatient3 = new SlightlyInjuredPatient("TestSlightlyInjured", LocalTime.of(20, 30));
		assertSame(TreatmentPriority.HIGH, testpatient1.getPriority());
		assertSame(TreatmentPriority.MEDIUM, testpatient2.getPriority());
		assertSame(TreatmentPriority.LOW, testpatient3.getPriority());
         
	}
	
	// Check correct behavior of the getCatInfo() method
	// for each patient class.
	@Test
	public void validateGetCatInfo(){
		EmergencyPatient testpatient1 = new EmergencyPatient("TestEmergency", LocalTime.of(20, 30));
		SeverelyInjuredPatient testpatient2 = new SeverelyInjuredPatient("TestSeverlyInjured", LocalTime.of(20, 30), 5);
		SlightlyInjuredPatient testpatient3 = new SlightlyInjuredPatient("TestSlightlyInjured", LocalTime.of(20, 30));
	
		assertEquals("T1/Red" ,testpatient1.getCatInfo());
		assertEquals(String.format("T2/Orange-%d", 5), testpatient2.getCatInfo());
		assertEquals("T3/Green",testpatient3.getCatInfo());
	}
	
	// Check correct behavior of the compareTo(...) method WITHIN each patient
	// class, i.e. check ordering for each category separately. Use at least
	// three object instances per patient class!
	@Test
	public void validateCompareTo(){
		// Emergency Patients test objects
		EmergencyPatient  emergencyPatient1 = new EmergencyPatient("TestEmergency1", LocalTime.of(20, 30));
		EmergencyPatient  emergencyPatient2 = new EmergencyPatient("TestEmergency2", LocalTime.of(19, 15));
		EmergencyPatient  emergencyPatient3 = new EmergencyPatient("TestEmergency3", LocalTime.of(21, 10));
		
		//Test Severely Injured test patients
		SeverelyInjuredPatient siPatient1 = new SeverelyInjuredPatient("TestSeverelyInjured1", LocalTime.of(10, 30), 5);
		SeverelyInjuredPatient siPatient2 = new SeverelyInjuredPatient("TestSeverelyInjured2", LocalTime.of(20, 30), 5);
		SeverelyInjuredPatient siPatient3 = new SeverelyInjuredPatient("TestSeverelyInjured3", LocalTime.of(20, 30), 10);
		
		
	     //normal test objects
		SlightlyInjuredPatient patient1 = new SlightlyInjuredPatient("TestSlightlyInjrued1", LocalTime.of(19, 30));
		SlightlyInjuredPatient patient2 = new SlightlyInjuredPatient("TestSlightlyInjured2", LocalTime.of(20, 30));
		SlightlyInjuredPatient patient3 = new SlightlyInjuredPatient("TestSlightlyInjured3", LocalTime.of(21, 30));
		
		assertEquals(1, emergencyPatient1.compareTo(emergencyPatient2));
		assertEquals(-1, emergencyPatient2.compareTo(emergencyPatient3));
		assertEquals(0, emergencyPatient1.compareTo(emergencyPatient1));
		
		
		
		assertEquals(1, siPatient1.compareTo(siPatient3));
		assertEquals(-1, siPatient3.compareTo(siPatient2));
		assertEquals(0, siPatient3.compareTo(siPatient3));
		
		
		assertEquals(-1, patient1.compareTo(patient2));
		assertEquals(1, patient3.compareTo(patient1));
		assertEquals(0, patient2.compareTo(patient2));
		
		
		
	    assertEquals(-1, emergencyPatient1.compareTo(patient3));
	    assertEquals(-1, siPatient2.compareTo(patient3));
	    assertEquals(1, patient1.compareTo(emergencyPatient3));
	    assertEquals(1, patient2.compareTo(emergencyPatient1));
	    assertEquals(1, siPatient3.compareTo(emergencyPatient1));
		
		
		
	
	}

	//**************************************************************
	//********************* Test patient queue *********************
	//**************************************************************
	
	// Check correct behavior of the process method of the patient queue class,
	// i.e. patients are processed in correct order. Initialize test by adding
	// patients in random order. To generate a randomly ordered patient list, 
	// you can use the provided getShuffledArray(AbstractPatient[] patients) method.
	@Test
	public void validateProcessQueue(){
		//TODO Implement test!
	}
	
	
}
