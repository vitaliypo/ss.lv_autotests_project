package testtask.lv.ss;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Vitaliy on 7/16/2017.
 */
public class Utilities {

    public static int[] getRandomInts(int qtyOfInts, int min, int max) {
        return new Random().ints(min, max).distinct().limit(qtyOfInts).toArray();
    }

//    Method needed because ads names can have different length, so we should trim them
    public static void trimListsForComparison(List<String> list1, List<String> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        for(int i = 0; i < list2.size(); i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                if(list1.get(i).length()> list2.get(i).length()) {
                    list1.set(i, list1.get(i).substring(0, list2.get(i).length()));
                }
                if(list1.get(i).length()< list2.get(i).length()) {
                    list2.set(i, list2.get(i).substring(0, list1.get(i).length()));
                }
            }
        }
    }
}