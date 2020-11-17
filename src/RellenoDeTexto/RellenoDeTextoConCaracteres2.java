package RellenoDeTexto;
import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Arrays;
/**
 *
 * @author Ramses
 */
public class RellenoDeTextoConCaracteres2 extends JFrame {

    public RellenoDeTextoConCaracteres2() {
        super("Relleno de texto con Caracteres");
    }

    public void paint(Graphics g) {
        char[] letras = new char[200];
        char caracter = 'a';
        Arrays.fill(letras, caracter);
        Graphics2D g2 = (Graphics2D) g;
        int w = getSize().width;
        int h = getSize().height;
        FontRenderContext frc = g2.getFontRenderContext();
        Font f = new Font("Times", Font.BOLD, 180);
        TextLayout tl = new TextLayout("Texto", f, frc);
        float sw = (float) tl.getBounds().getWidth();
//Se crea un objeto de tipo AffineTransformation
        AffineTransform transform = new AffineTransform();

//Se hace una translacion
        transform.setToTranslation(w / 2 - sw / 2, h * 5 / 8);
        Shape shape = tl.getOutline(transform);
//Se dibujan los caracteres dentro del contorno
        g2.setClip(shape);   
        for (int i = 0; i < this.getHeight(); i = i + 10) {
            g2.drawChars(letras, 0, 100, 0, 0 + i);
     }

// Se dibuja sólo el contorno
        g2.setColor(Color.black);
        g2.draw(shape);

    }

    public static void main(String[] args) {
        RellenoDeTextoConCaracteres2 v = new RellenoDeTextoConCaracteres2();
        v.setSize(500, 335);
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
        v.setResizable(false);
        v.setVisible(true);

    }
}
