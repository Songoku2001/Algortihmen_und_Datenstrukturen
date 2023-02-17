package ads.Blatt7.Projekt.Aufgabe2;

import java.util.Arrays;

public class LogicSolverDivideAndConquer {

	static boolean satisfies(short[] assignment, short[] clause) {
		for (int i = 0; i < clause.length; ++i)
			if (assignment[i] * clause[i] == 1) return true;
		return false;
	}

	static short[][] solutionsForClause(short[] clause) {
		short[][] shortarray = new short[(int) Math.pow(2, clause.length)][clause.length];
		short[][] tmparray = new short[(int) Math.pow(2, clause.length)][clause.length];
		int counter = 0;

		for (int i = 0; i < shortarray.length; i++) {
			String bin = toBin(i, clause);								  			    //Aufruf der toBin Methode
			for (int j = 0; j < shortarray[i].length; j++) {         //Iterieren der einzelnen Klausel
				if (bin.charAt(j) == 48) {											      //wenn mein char der 48 entspricht, dann....
					shortarray[i][j] = (short) (bin.charAt(j)-'1');    // soll er minus '1'=49 rechnen 0 wird zu -1 denn -1==false ansonsten...
				}
				else {
					shortarray[i][j] = (short) (bin.charAt(j)-'0');  //minus'0'=48 rechnen, denn 1==true
				}
			}

			if (satisfies(shortarray[i], clause)) {              //satisfies aufrufen ob die einzelnen Klausel....
				tmparray[counter++] = shortarray[i];							//sie dann in ein tmp array speichern mit einem counter, weil
			}																									 // tmp array nur eine klausel bekommt die bei satisfies true ergibt
		}
		short[][] result = new short[counter][clause.length];  					 //durch den counter kennen wir die lände wie viele der satisfies entspricht
		System.arraycopy(tmparray, 0, result, 0, counter); //und die kopieren wir anschließend unserem result array
		return result;
	}

	//https://stackoverflow.com/questions/2406432/converting-an-int-to-a-binary-string-representation-in-java
	//Von Lesya
	private static String toBin(int zahl, short[] clause) {
		String s = "";
		while (zahl>0) {   																	//wandelt den int wert in ein binärzahl solange es größer 0 ist
			s = ((zahl%2) == 0 ? "0" : "1") + s;
			zahl = zahl/2;
		}
		while (s.length() < clause.length) {							//füllt hinten nullen auf solange es kleienr ist als die Klausel
			s = "0" + s;
		}
		return s;                                        // Binärzahl wird zurückgegeben in String
	}

	static short[][] solveDivideAndConquer(short[][] formula) {
		short[][] kopie = formula.clone();
		return teilen(kopie, 0, kopie.length-1);     	//aufruf der teilen methode
	}

	private static short[][] teilen(short[][] kopie, int left, int right) {
		if (left >= right) { 															//abbruchbedingung wenn fürs rekursive teilen
			return solutionsForClause(kopie[right]);
		}
		int mid = left+(right-left)/2; 																	//die mitte bestimmen
		short[][] rechterteil = teilen(kopie, mid+1, right);			 //rechte hälfte des array
		short[][] linkerteil = teilen(kopie, left, mid);							//linke häfte des array

		return mischen(rechterteil, linkerteil);										//mischen aufrufen
	}

	private static short[][] mischen(short[][] rechterteil, short[][] linkerteil) {
		int counter = 0;
		short[][] tmp = new short[rechterteil.length][rechterteil[0].length];;

		for (int i=0; i<rechterteil.length; i++) {									 //iterieren der rechten klausel
			for (int j=0; j<linkerteil.length; j++) {									//iterieren der linken klausel
				if (Arrays.equals(rechterteil[i],linkerteil[j])) {		 //schnittmenge finden
					counter++;																					//mithilfe des counters anzahl der schnittmenge herausfinden
					tmp[i] = rechterteil[i];
					break;
				}
			}
		}

		short[][] result = new short[counter][linkerteil[0].length];
		counter = 0;

		for (int i=0; i<tmp.length; i++) {
			if (tmp[i][0] != 0) {              		//Entfernen der schnittmenge mit der 0
				result[counter++] = tmp[i];				 //sie dann in das result array speichern
			}
		}
		return result;
	}



	public static void main(String[] args) {
		short[][] formula1 = new short[][]{
						{-1, -1, -1, 1},
						{-1, 1, -1, 1},
						{-1, 1, 1, -1},
						{-1, 1, 1, 1},
						{1, -1, -1, 1}
		};
		var test = solveDivideAndConquer(formula1);

		solveDivideAndConquer(formula1);
		/*short[][] noresult = new short[formula1.length][formula1[0].length];
		for (int i = 0; i < noresult.length; i++) {
			for (int j = 0; j < noresult[i].length; j++) {
				System.out.println(Arrays.toString(noresult[i]));
			}
		}*/
		// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 )
		short[][] formula3 = new short[][] {
						{-1, -1},
						{-1,  1},
						{1, -1},
						{1,  1},
		};
		// X6
		short[][] formula5 = new short[][] {
						{0, 0, 0, 1},
		};
		var test3 = solveDivideAndConquer(formula5);
		System.out.println(Arrays.deepToString(test3));

		/*for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.println(test[i][j]);
			}
		}*/
	}
}

