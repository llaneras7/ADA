package uma;

public class CoeficientesBinominales {

    //Precondición: {n >= k >= 0}
    public static int coefBinominalRec(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }else{
            return coefBinominalRec(n-1, k-1) + coefBinominalRec(n-1, k);
        }
    }

    //Precondición: {n >= k >= 0}
    public static int coefBinominalPD(int n, int k){
        //Creamos tabla (matriz)
        int[][] tabla = new int[n+1][];
        for(int i = 0; i<=n; i++){ //por filas, arriba-abajo (i es cada n)
            tabla[i] = new int[i+1]; //??
            for(int j = 0; j<=i; j++){ //hasta diagonal principal (j es cada k)
                if(j<=k){ //Ya que diagonal principal -> j=k
                    if(j == 0 || j == i){
                        tabla[i][j] = 1;
                    }else{
                        tabla[i][j] = tabla[i-1][j-1] + tabla[i-1][j];
                    }
                }
            }
        }
        return tabla[n][k];
    }


}
