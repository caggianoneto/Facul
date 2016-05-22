import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MinhasCollections {
	public static void main(String[] args) {
		System.out.println("------------- ArrayList ------------------");
		List<Integer> minhaLista = new ArrayList<Integer>();
		minhaLista.add(1);
		minhaLista.add(2);
		minhaLista.add(3);
		minhaLista.add(1);
		minhaLista.add(3);
		minhaLista.add(4);

		for (Integer listaElementos : minhaLista) {
			System.out.println(listaElementos);
		}

		System.out.println("------------- HashSet ------------------");
		Set<Integer> meuSet = new HashSet<Integer>();
		meuSet.add(1);
		meuSet.add(2);
		meuSet.add(3);
		meuSet.add(1);
		meuSet.add(3);
		meuSet.add(4);
		Iterator<Integer> iMeuSet = meuSet.iterator();
		while(iMeuSet.hasNext()){
			System.out.println(iMeuSet.next());
		}

	}

}



