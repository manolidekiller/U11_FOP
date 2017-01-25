package hospital;

import java.util.ArrayList;
import hospital.heap.ArrayListHeap;
import hospital.patients.*;

public class PatientQueue<T extends AbstractPatient> {
	
	private ArrayListHeap<? extends AbstractPatient> list;
	
	public PatientQueue() {
		list = new ArrayListHeap<>();
	}

	public void addPatient(T patient) {
		
		list.push(patient);
	}
	
	public ArrayList<String> processQueue(){
		ArrayList<String> q = new ArrayList<String>();
		
		while (!list.isEmpty()) {
			q.add(list.pop().toString());	
		}
		
		return q;
	}	
}