import art.ArtFN;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        int size = 1000;

        var im = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        var g = im.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        g.setPaint(Color.BLACK);
        g.fillRect(0, 0, size, size);

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        Color color = new Color(0x30ffffff, true);
        g.setColor(color);

        var quanta = new Quanta(size);
        for (int i = 0; i < 50000000; i++) {
            quanta.paint(g);
            quanta.update();

            if (i % 100000 == 0) {
                System.out.printf("Iteration: %d\n", i);
            }
        }

        var fn = String.format("render/%s", ArtFN.generate("quanta", ".png"));
        ImageIO.write(im, "PNG", new File(fn));
    }
}
