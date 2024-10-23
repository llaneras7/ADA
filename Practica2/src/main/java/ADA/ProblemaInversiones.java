package ADA;

public class ProblemaInversiones {

	public static int numInversiones(int[] v) {
		return numInv(v, 0, v.length - 1);
	}

	private static int numInv(int[] a, int prim, int ult) {
		if (prim >= ult) {
			return 0;
		}

		//Dividimos el problema
		int medio = (prim + ult) / 2; //La mitad
		int invIzq = numInv(a, prim, medio); //Parte izquierda del primero a la mitad
		int invDer = numInv(a, medio + 1, ult); //Parte derecha de la mitad +1 al ultimo
		int invMezcla = mezclarYContar(a, prim, medio, ult);

		return invIzq + invDer + invMezcla;
	}

	public static int mezclarYContar(int[] a, int inf, int medio, int sup) {
		int i = inf, j = medio + 1;
		int[] b = new int[sup - inf + 1];
		int k = 0;
		int inversiones = 0;

		// Mezclar mientras contamos inversiones
		while (i <= medio && j <= sup) {
			if (a[i] <= a[j]) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
				// Contamos cuántos elementos hay en la mitad izquierda que son mayores que a[j]
				inversiones += (medio - i + 1);
			}
			k++;
		}

		// Copiar los elementos restantes de la mitad izquierda
		while (i <= medio) {
			b[k] = a[i];
			i++;
			k++;
		}

		// Copiar los elementos restantes de la mitad derecha
		while (j <= sup) {
			b[k] = a[j];
			j++;
			k++;
		}

		// Copiar de nuevo al array original
		for (int f = inf; f <= sup; f++) {
			a[f] = b[f - inf];
		}

		return inversiones;
	}
}
