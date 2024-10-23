package ADA;

public class KesimoElemento {

	public static int buscarKesimo(int[] a, int k) {
		return buscarKesimo(a, k, 0, a.length - 1);
	}

	private static int buscarKesimo(int[] v, int k, int ini, int fin) {
		if (ini == fin) {
			return v[ini]; // Si solo queda un elemento, ese es el k-ésimo
		}

		// Usamos tu metodo "partir" para particionar el array
		int pivoteIndex = partir(v, ini, fin);

		// Si el pivote está en la posición k, entonces lo hemos encontrado
		if (pivoteIndex == k) {
			return v[pivoteIndex];
		}
		// Si el pivote está en una posición mayor que k, buscamos en la parte izquierda
		else if (pivoteIndex > k) {
			return buscarKesimo(v, k, ini, pivoteIndex - 1);
		}
		// Si el pivote está en una posición menor que k, buscamos en la parte derecha
		else {
			return buscarKesimo(v, k, pivoteIndex + 1, fin);
		}
	}

	// Metodo "partir"
	public static int partir(int[] a, int inf, int sup) {
		int pivote = a[inf];
		int i = inf + 1;
		int j = sup;

		do {
			while ((i <= j) && (a[i] <= pivote)) {
				i++;
			}
			while ((i <= j) && (a[j] > pivote)) {
				j--;
			}
			if (i < j) {
				intercambia(a, i, j);
			}
		} while (i <= j);

		intercambia(a, inf, j);
		return j;
	}

	// Metodo para intercambiar dos elementos en el array
	public static void intercambia(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}

