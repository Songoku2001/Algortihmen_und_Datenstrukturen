package ads.Blatt7.Projekt.Aufgabe3;

import java.util.Arrays;

public class LogicSolverBacktracking {

  static boolean satisfies(short[] assignment, short[] clause) {
    for (int i=0; i<clause.length; ++i)
      if(assignment[i]*clause[i]==1)
        return true;
    return false;
  }

  static boolean satisfies(short[] assignment, short[][] formula) {
    for (short[] shorts : formula) {
      if (!satisfies(assignment, shorts)) {
        return false;
      }
    }
    return true;
  }

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

  static boolean satisfiable(short[] assignment, short[][] formula) {
    for (int i=0; i<formula.length; i++) {
      if (!satisfiable(assignment, formula[i])) {
        return false;
      }
    }
    return true;
  }

  static short[] solveBacktracking(short[][] formula) {
    return hilfsmethode(formula, new short[formula[0].length], 0);
  }

  private static short[] hilfsmethode(short[][] formula, short[] assign, int height) {
    short[] kopieassign = assign.clone();
    //short[] result = new short[formula.length];
/*    if (height== formula.length-1) {            //Abbruchbedingung
      return assign;
    }*/
    if (satisfies(assign, formula)) {     //wenn sie die klausel erfüllt soll er die lösung zurückgeben
      return assign;
    }
    if (!satisfiable(assign, formula)) {   //wenn es keine Lösung gibt soll er ein array mit nullen zurückgeben
      return new short[formula[0].length];
    }
    if (assign[height]==0) {
      assign[height] = -1;
    }
    else {
      assign[height]=1;
    }
    if (satisfiable(kopieassign, formula)) {
      hilfsmethode(formula, assign, height+1);
    }
    if (assign[height]==-1) {
      hilfsmethode(formula, assign, height);
    }
//    assign = hilfsmethode(formula, assign, height+1);
//    kopieassign = hilfsmethode(formula, kopieassign, height+1);
    for (int i=0; i<formula.length; i++) {
      if (satisfiable(kopieassign, formula[height])) {
        kopieassign[height] = formula[i][height];
        break;
      }
    }
    return hilfsmethode(formula, assign, height+1);
  }

  public static void main(String[] args) {

    // ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 )
    short[][] formula1 = new short[][]{
            {-1, -1, 0, 0},
            {0, 1, -1, 0},
            {0, 0, 1, 1}
    };

    // ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 )
    short[][] formula2 = new short[][]{
            {-1, -1},
            {-1, 1},
            {1, -1},
    };

    // ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 )
    short[][] formula3 = new short[][]{
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1},
    };

    // ( -X1 v -X2 ) ^ X1
    short[][] formula4 = new short[][]{
            {-1, -1},
            {1, 0},
    };

    // X6
    short[][] formula5 = new short[][]{
            {0, 0, 0, 1},
    };

    var x = solveBacktracking(formula1);
    System.out.println(Arrays.toString(x));
    System.out.println(Arrays.toString(solveBacktracking(formula1)));
  }
}
