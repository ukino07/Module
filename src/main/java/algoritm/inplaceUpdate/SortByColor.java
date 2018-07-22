package algoritm.inplaceUpdate;

import java.util.ArrayList;

/**
 * Created by u_kino07 on 2018. 6. 26..
 */
public class SortByColor {
    public void sortColors(ArrayList<Integer> a) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for (Integer value : a) {
            if (value.equals(0)) {
                redCount++;
            } else if (value.equals(1)) {
                whiteCount++;
            } else if (value.equals(2)) {
                blueCount++;
            }
        }

        int newIndex = 0;
        for (int i = 0; i < redCount; i++) {
            a.set(newIndex++, 0);
        }

        for (int j = 0; j < whiteCount; j++) {
            a.set(newIndex++, 1);
        }

        for (int k = 0; k < blueCount; k++) {
            a.set(newIndex++, 2);
        }






        int redPointer = 0;
        int whitePointer = 0;
        int bluePointer = 0;
        int currentPointer = 0;

        while (currentPointer < a.size()) {
            if (redPointer == 0 && a.get(currentPointer).equals(0)) {
                redPointer = currentPointer++;
            } else if (whitePointer == 0 && a.get(currentPointer).equals(1)) {
                whitePointer = currentPointer++;
            } else if (bluePointer == 0 && a.get(currentPointer).equals(2)) {
                bluePointer = currentPointer++;
            }

            if (currentPointer >= a.size()) {
                return;
            }

            if (a.get(currentPointer) == 0) {
                a.add(redPointer, a.get(currentPointer++));
                whitePointer++;
                bluePointer++;
            } else if (a.get(currentPointer) == 1) {
                a.add(whitePointer, a.get(currentPointer++));
                bluePointer++;
            } else {
                a.add(bluePointer, a.get(currentPointer++));
            }
        }
    }
}
