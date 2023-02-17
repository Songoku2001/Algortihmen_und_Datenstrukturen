package ads.Blatt7.Projekt.Aufgabe1;

public class LogicSolverGreedy {
//O(k)
  static boolean satisfies(short[] assignment, short[] clause) {
	  for (int i=0; i<clause.length; ++i)
		  if(assignment[i]*clause[i]==1)
			  return true;
	  return false;
  }
//O(n*k)
  static boolean satisfies(short[] assignment, short[][] formula) {
    for (short[] shorts : formula) {
      if (!satisfies(assignment, shorts)) {
        return false;
      }
    }
    return true;
  }
//O(k^2)
  static boolean satisfiable(short[] assignment, short[] clause) {
    for (int i=0; i<clause.length; i++) {
      if (assignment[i] * clause[i]==1) {
        return true;
      }
      if (assignment[i] == 0 && clause[i] == 1 ||  //1*clause[i] == 1
              assignment[i] == 0 && -1*clause[i] == 1 && clause[i] != 0) {
        return true;
      }
      if (satisfies(assignment, clause)) {
        return true;
      }
    }
    return false;
  }
  //O(n*k^2)
  static boolean satisfiable(short[] assignment, short[][] formula) {
    for (int i=0; i<formula.length; i++) {
      if (!satisfiable(assignment, formula[i])) {
        return false;
      }
    }
    return true;
  }

  static short[] solveGreedy(short[][] formula) {
    short[] res = new short[formula[0].length];
    short[] noresult = new short[formula[0].length];

    for (int i=0; i<formula.length; i++) { //Iterieren der Klausel
      if (satisfies(res, formula[i])) { //  wenn die bedingung für eine Klausel erfüllt ist dann...
        continue;                      //braucht er nicht die innere schleife zu gehen
      }
      for (int j=0; j<formula[i].length; j++) {    //Iterieren der einzelnen Klausel
        if (formula[i][j]!=0 && res[j]==0) {      //wenn die formel keine 0 enthält aber unser res schon.....
          res[j] = formula[i][j];                //belege sie dann dementsprechend......
          break;                                //und verlasse die innere for
        }
        if (formula[i][j]==-1 && res[j]==0) {  //falls mein res eine 0 enthält und die formel -1
          res[j]=-1;                          //belege sie mit -1
        }
        if (formula[i][j]==1 && res[j]==0) {  //falls mein res eine 0 enthält und die formel 1
          res[j]=1;                           //belege sie mit 1
        }
      }
      if (!(satisfiable(res, formula[i]))) { //wenn die bedingung nicht erfüllt ist
        return noresult;                    //gib ein leeren array zurück die nur 0 enthalten
      }
    }
    return res;                           //ergebnis zurückgeben
  }

  public static void main(String[] args) {
    short[] shorts = new short[] {0,-1,-1,0};
    short[] shorttest4 = new short[] {1,1,1,1};
    short[] clause1 = new short[] {0, 1, 1, 0,-1}; // X2 v X3 v -X5
    short[] clause2 = new short[] {0,-1}; // -X2

    short[][] formula1 = new short[][] { // ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 )
            {-1, -1, 0, 0},
            {0, 1, -1, 0},
            {0, 0, 1, 1}
    };

    // ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 )
    short[][] formula2 = new short[][] {
            {-1, -1},
            {-1, 1},
            {1, -1},
    };

    // ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 )
    short[][] formula3 = new short[][] {
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1},
    };

    // ( -X1 v -X2 ) ^ X1
    short[][] formula4 = new short[][] {
            {-1, -1},
            {1, 0},
    };

    // X4
    short[][] formula5 = new short[][] {
            {0, 0, 0, 1},
    };
    short[] rs = new short[formula1[0].length];
    //short[] rst = formula1[0];
    short[] rst = new short[formula1.length];
    //System.out.println(Arrays.toString(rst));
    //System.out.println(Arrays.toString(solveGreedy(formula1)));
    /*System.out.println(Arrays.toString(solveGreedy(formula5)));
    System.out.println(Arrays.toString(solveGreedy(formula2)));
    System.out.println(Arrays.toString(solveGreedy(formula3)));
    System.out.println(Arrays.toString(solveGreedy(formula4)));*/

  }
}
