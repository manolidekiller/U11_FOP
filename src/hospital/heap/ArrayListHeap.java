package hospital.heap;
import java.util.ArrayList;

/**
 * FOP Hu 11
 * @author Ozan Agtas
 * @author Emmanouil Vergopoulos
 * @author Berfin Korkmaz
 * @author Jasmin Reis Klapper
 * @param <T> 
 */

public class ArrayListHeap<T extends Comparable<T>> extends AbstractBinaryHeap {

	private ArrayList<T> list = new ArrayList<T>();

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	protected boolean isHeap(int parentIndex, int childIndex) {
		return list.get(parentIndex).compareTo(list.get(childIndex)) <= 0;
	}

	@Override
	protected void swapNodes(int parentIndex, int childIndex) {
		T parent = list.get(parentIndex);
		list.set(parentIndex, list.get(childIndex));
		list.set(childIndex, parent);
	}

	@Override
	public void push(Comparable element) {
		list.add((T) element);
		super.heapifyUp(list.indexOf(element));
	}

	@Override
	public Comparable top() {
		return list.get(0);
	}

	@Override
	public Comparable pop() {
		T root = list.set(0, list.get(getSize() - 1));
		heapifyDown(0);
		return root;
	}

}
