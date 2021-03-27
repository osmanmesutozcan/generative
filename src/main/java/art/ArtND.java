package art;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtND {
    public static Double[] flatten(Object[] nd) {
        if (nd == null) {
            return null;
        };

        List<Double> flatList = new ArrayList<Double>();

        for (Object element : nd) {
            if (element instanceof Double) {
                flatList.add((Double) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flatten((Object[]) element)));
            } else {
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }

        return flatList.toArray(new Double[0]);
    }
}
