package art;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.Random;

public class ArtRand {
    public static Random RAND = new Random();

    public static Vector2D inCirc(double R) {
        return inCirc(R, Vector2D.ZERO);
    }

    public static Vector2D inCirc(double R, Vector2D center) {
        var r = R * FastMath.sqrt(RAND.nextDouble());
        var theta = RAND.nextDouble() * 2 * FastMath.PI;

        return new Vector2D(
                center.getX() + r * FastMath.cos(theta),
                center.getY() + r * FastMath.sin(theta)
        );
    }
}
