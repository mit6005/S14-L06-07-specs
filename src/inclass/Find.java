package inclass;

public class Find {
    
    public static void main(String[] args) {
        int x = 5 + find(7, new int[] { 1, 2, 3 }); // whoops!
        
        // instead, change the spec to throw an exception
        try {
            find(7, new int[] { });
        } catch (NotFoundException nfe) { // exception type declared below
            // ...
        }
    }
    
    /**
     * Find a value x in an array a.
     * @param x value to search for
     * @param a array to search; requires a sorted
     *          (a[0] <= a[1] <= ... a[a.length-1])
     * @return returns lowest i s.t. a[i] == x, or -1 if x is not in a
     */
    public static int find(int x, int[] a) {
        assert isSorted(a); // remember to turn on assertions with -ea
        return findBinaryFirstInRange(x, a, 0, a.length);
    }
    
    public static boolean isSorted(int[] a) {
        for (int ii = 1; ii < a.length; ii++) {
            if (a[ii] < a[ii-1]) { return false; }
        }
        return true;
    }
    
    public static int findLinear(int x, int[] a) {
        for (int ii = 0; ii < a.length; ii++) {
            if (x == a[ii]) {
                return ii;
            }
        }
        return -1;
    }
    
    // returns lowest i s.t. ...
    public static int findBinaryFirstInRange(int x, int[] a, int start, int end) {
        if (start >= end) { return -1; }
        
        int middle = (start + end) / 2;
        
        if (x < a[middle]) {
            return findBinaryFirstInRange(x, a, start, middle);
        } else if (x > a[middle]) {
            return findBinaryFirstInRange(x, a, middle + 1, end);
        } else if (middle > 0 && a[middle-1] == x) {
            return findBinaryFirstInRange(x, a, start, middle);
        } else {
            return middle;
        }
    }
    
    // returns some i s.t. ...
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

class NotFoundException extends Exception {
    // ...
}
