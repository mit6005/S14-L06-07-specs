package beforeclass;

public class Find {
    
    public static int find(int x, int[] a) {
        return findLinear(x, a);
    }
    
    public static int findLinear(int x, int[] a) {
        for (int ii = 0; ii < a.length; ii++) {
            if (x == a[ii]) {
                return ii;
            }
        }
        return -1;
    }
    
    public static int findBinaryInRange(int x, int[] a, int start, int end) {
        if (start >= end) { return -1; }
        
        int middle = (start + end) / 2;
        
        if (x < a[middle]) {
            return findBinaryInRange(x, a, start, middle);
        } else if (x > a[middle]) {
            return findBinaryInRange(x, a, middle + 1, end);
        } else {
            return middle;
        }
    }
}
