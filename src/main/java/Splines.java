import art.ArtGraphics2D;
import art.ArtMath;
import art.ArtRand;
import art.ArtVec;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Splines {
    final double SIZE;
    private final double PADDING;
    private final int ROWS = 15;
    private final int ITT = 10000;
    private final int REPEAT = 500;

    public Splines(int size) {
        this.SIZE = size;
        this.PADDING = size * 0.30;
    }

    public void paint(Graphics2D graphics) {
        graphics.setColor(new Color(0x68ffffff, true));

        double row = 0;
        for (double i : ArtMath.linspace(PADDING, SIZE - PADDING, ROWS)) {
            var p1 = new Vector2D(PADDING + ArtRand.RAND.nextInt((int) (PADDING * 0.05)), i);
            var p2 = new Vector2D(SIZE - PADDING - ArtRand.RAND.nextInt((int) (PADDING * 0.2)), i);
            System.out.printf("p1: %s - p2: %s\n", p1, p2);

            for (double j : ArtMath.linspace(0, REPEAT, REPEAT)) {
                var va = Vector2D.ZERO;
                for (double s : ArtMath.linspace(0, 1, ITT)) {
                    var v1 = va.add(ArtVec.onLine(s, p1, p2));
                    ArtGraphics2D.addVertex(graphics, v1);

                    var randAmount = FastMath.max(row, 0.2) * s * (j % 5) * 0.5;
                    va = va.add(ArtRand.inCirc(randAmount));
                }
            }

            row++;
        }
    }

    public void run(Graphics2D g) {
    }
}
