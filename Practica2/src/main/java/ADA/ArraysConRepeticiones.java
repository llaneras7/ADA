public class ArraysConRepeticiones {

	//Precondición: hay un elemento repetido => v.length >= 2
	public static int encuentraElem(int [] v) {
		return encuentraElem(v, 0, v.length - 1);
	}

	private static int encuentraElem(int [] v, int izq, int der) {
		if (izq >= der) {
			// Caso base: hemos encontrado el valor repetido
			return v[izq];
		}

		int medio = (izq + der) / 2;

		// Comparar el valor en 'medio' con su posición esperada
		if (v[medio] == v[medio + 1]) {
			// Si el valor en 'medio' es igual al siguiente, el repetido está aquí
			return v[medio];
		} else if (medio > 0 && v[medio] == v[medio - 1]) {
			// Si el valor en 'medio' es igual al anterior, el repetido está aquí
			return v[medio];
		} else if (v[medio] == (v[0] + medio)) {
			// Si el valor en la posición media es igual al esperado (sin repetición),
			// entonces el problema está en la mitad derecha
			return encuentraElem(v, medio + 1, der);
		} else {
			// Si hay una discrepancia con el valor esperado, el repetido está en la mitad izquierda
			return encuentraElem(v, izq, medio - 1);
		}
	}
}
