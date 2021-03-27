package art;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class ArtVec {

    public static Vector2D onLine(double p, Vector2D a, Vector2D b) {
        return new Vector2D(
                (a.getX() + (p * (b.getX() - a.getX()))),
                (a.getY() + (p * (b.getY() - a.getY())))
        );
    }
}
