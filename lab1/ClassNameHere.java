public class ClassNameHere {
    /** Returns the maximum value from m using a for loop. */
    public static int forMax(int[] m) {
       int maxNum = 0;
       for (int i = 0; i < m.length; i++) {
          if (maxNum < m[i]) {
             maxNum = m[i];
          }
       }
        return maxNum;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(forMax(numbers));
    }
}