import java.util.ArrayList;


/**
 * Basic
 */ 
public class Basic {
    // swap string for negative array values
    public ArrayList swapValues(int[] arr) {
        ArrayList<Object> rArr = new ArrayList<Object>();
        for(int x = 0; x < arr.length; x++) {
            if(arr[x] < 0) {
                rArr.add("coding dojo");
            } else {
                rArr.add(arr[x]);
            }
        }
        return rArr;
    }

    public ArrayList swapValues(int[] arr, String str) {
        ArrayList<Object> rArr = new ArrayList<Object>();
        for(int x = 0; x < arr.length; x++) {
            if(arr[x] < 0) {
                rArr.add(str);
            } else {
                rArr.add(arr[x]);
            }
        }
        return rArr;
    }


}