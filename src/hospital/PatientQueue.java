package hospital;

import java.util.ArrayList;
import hospital.heap.ArrayListHeap;
import hospital.patients.*;

public class PatientQueue<T extends AbstractPatient> {
	
	private ArrayListHeap<? extends AbstractPatient> list;
	
	/**
	 * 
	 */
	public PatientQueue() {
		list = new ArrayListHeap<>();
	}

	public void addPatient(T patient) {
		
	}
	
	public ArrayList<String> processQueue(){
		ArrayList<String> q = new ArrayList<String>();
		
		return q;
	}	
}