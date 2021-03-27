package art;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.awt.*;

public class ArtGraphics2D {
    public static void addVertex(Graphics2D g, Vector2D vertex) {
        g.drawLine((int) vertex.getX(), (int) vertex.getY(), (int) vertex.getX(), (int) vertex.getY());
    }

    public static void addLine(Graphics2D g, Vector2D v1, Vector2D v2) {
        g.drawLine((int) v1.getX(), (int) v1.getY(), (int) v2.getX(), (int) v2.getY());
    }
}
