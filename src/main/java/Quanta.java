import art.ArtGraphics2D;
import art.ArtRand;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Quanta {
    final int SIZE;
    private final int NUM = 1;
    private final List<Particle> particles = new ArrayList<>();
    private final Lorenz l = new Lorenz();

    public Quanta(int size) {
        this.SIZE = size;
        for (int i = 0; i < NUM; i++) {
            double x = 0.01;
            double y = 0.01;
            double z = 0;
            this.particles.add(new Particle(new Vector3D(x, y, z)));
        }
    }

    public void paint(Graphics2D graphics) {
        for (int i = 0; i < NUM; i++) {
            this.particles.get(i).draw(graphics);
        }
    }

    public void update() {
        for (int i = 0; i < NUM; i++) {
            this.particles.get(i).setPos(
                    l.value(this.particles.get(i).pos)
            );
        }
    }

    @Data
    @AllArgsConstructor
    public static class Particle {
        private Vector3D pos;

        public void draw(Graphics2D g) {
            ArtGraphics2D.addVertex(g, new Vector2D(pos.getX() * 20 + 500, pos.getY() * 20 + 500));
        }

        public void setPos(Vector3D pos) {
            this.pos = pos;
        }
    }

    public static class Lorenz {
//        private double dt = 0.008;
        private double dt = 0.002;
        private double sigma = 6;
        private double rho = 30;
        private double beta = 4.2231;

        public Vector3D value(Vector3D pos) {
            var deltaX = sigma * (pos.getY() - pos.getX());
            var deltaY = pos.getX() * (rho - pos.getZ()) - pos.getY();
            var deltaZ = pos.getX() * pos.getY() - beta * pos.getZ();

            return new Vector3D(
                    pos.getX() + deltaX * dt,
                    pos.getY() + deltaY * dt,
                    pos.getZ() + deltaZ * dt
            );
        }
    }
}
