import java.util.Comparator;

class ComparadorLetras implements Comparator<String> {

	@Override
	public int compare(String x, String y) {
		if (getContadorVogal(x) < getContadorVogal(y)) {
			return -1;
		} else if (getContadorVogal(x) > getContadorVogal(y)) {
			return 1;
		}
		return 0;
	}

	public int getContadorVogal(String word) {
		int vogal = 0;
		for (int i = 0; i < word.length(); i++) {
			char chr = word.charAt(i);
			if (chr == 'a' || chr == 'A' || chr == 'e' || chr == 'E'
					|| chr == 'i' || chr == 'I' || chr == 'o' || chr == 'O'
					|| chr == 'u' || chr == 'U')
				vogal++;
		}
		return vogal;
	}
}
