package hospital.test;


import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

import hospital.PatientQueue;
import hospital.heap.ArrayListHeap;
import hospital.patients.AbstractPatient;
import hospital.patients.EmergencyPatient;
import hospital.patients.SeverelyInjuredPatient;
import hospital.patients.SlightlyInjuredPatient;

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
		//TODO Implement test!
	}
	
	// Check correct behavior of the getCatInfo() method
	// for each patient class.
	@Test
	public void validateGetCatInfo(){
		//TODO Implement test!
	}
	
	// Check correct behavior of the compareTo(...) method WITHIN each patient
	// class, i.e. check ordering for each category separately. Use at least
	// three object instances per patient class!
	@Test
	public void validateCompareTo(){
		//TODO Implement test!
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
		SlightlyInjuredPatient easy1 = new SlightlyInjuredPatient("Josef", LocalTime.of(17, 15));
		SeverelyInjuredPatient med1 = new SeverelyInjuredPatient("Salz", LocalTime.of(14, 51), 51);
		SeverelyInjuredPatient med2 = new SeverelyInjuredPatient("Max", LocalTime.of(23, 23), 12);
		EmergencyPatient hard1 = new EmergencyPatient("Mustermann", LocalTime.of(10, 30));
		EmergencyPatient hard2 = new EmergencyPatient("Dwayne TheRock Johnson", LocalTime.of(10, 32));
		AbstractPatient[] listOfPatients = { easy1, med1, med2, hard1, hard2 };
		
		PatientQueue<AbstractPatient> list = new PatientQueue<AbstractPatient>();
		
		for (AbstractPatient abstractPatient : getShuffledArray(listOfPatients)) {
			System.out.println(abstractPatient.toString());
			list.addPatient(abstractPatient);
		}
		
		System.out.println("foreach fertig. Process Queue startet");
		ArrayList<String> result = list.processQueue();
		System.out.println("Process Queue fertig");
		
	}
}