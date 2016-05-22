import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExemplo {
	public static void main(String[] args) {
		Comparator<String> queueComparator = new ComparadorLetras();
		PriorityQueue<String> priorityQueue = new PriorityQueue<String>(10, queueComparator);
		priorityQueue.add("laranja");
		priorityQueue.add("uva");
		priorityQueue.add("limao");
		priorityQueue.add("abacaxi");
		while (priorityQueue.size() != 0) {
			System.out.println(priorityQueue.remove());
		}
	}
}
