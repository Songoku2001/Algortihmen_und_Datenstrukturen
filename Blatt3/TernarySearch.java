package ads.Blatt3;

public class TernarySearch {
  public static int ternarySearch(int[] a, int value) {
    return ter(a, value, 0, a.length-1);
  }


  static int ter(int[] a, int value, int links, int rechts) {
    if (links <= rechts) {
      int m1 = links+(rechts-links)/3;
      int m2 = ((rechts-links)/3)+m1;

      if (value==a[m1]) {
        return m1;
      }
      if (value==a[m2]) {
        return m2;
      }

      if (value<a[m1]) {
        return ter(a, value, links, m1-1);
      }
      if (value>a[m2]) {
        return ter(a, value, m2+1, rechts);
      }
      else {
        return ter(a, value, m1+1, m2-1);
      }
    }
    return -1;
  }
}




    /*
    int m1 = (a.length-1)/3;
    int m2 = ((a.length-1)/3)*2;
    int m3 = a.length-1;

    if (a[m1] == value) {
      return m1;
    }
    if (a[m2] == value) {
      return m2;
    }
    if (a[m3]==value) {
      return m3;
    }

    if (value < a[m1]) {
      for (int i=0; i<m1; i++){
        if (a[i]==value)
          return i;
    }
  }
    if (value > a[m1] && value < a[m2]) {
      for (int i=m1; i<m2; i++){
        if (a[i]==value)
          return i;
      }
    }
    if (value > a[m2]) {
      for (int i=m2; i<m3; i++){
        if (a[i]==value)
          return i;
      }
    }
    return -1;
    }*/