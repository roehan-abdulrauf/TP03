import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

/**
 * Classe de tests pour la classe Cercle.
 */
public class CercleTest {

    /**
     * Teste la construction d'un cercle avec un centre, un rayon, et une couleur par défaut.
     */
    @Test
    public void testConstructionCercle() {
        Point centre = new Point(1, 2);
        double rayon = 2.5;
        Cercle cercle = new Cercle(centre, rayon);
        assertEquals(centre, cercle.getCentre());
        assertEquals(rayon, cercle.getRayon(), 0.001);
        assertEquals(Color.BLUE, cercle.getCouleur());
    }

    /**
     * Teste la translation d'un cercle sur les axes X et Y.
     */
    @Test
    public void testTranslater() {
        Cercle cercle = new Cercle(new Point(1, 2), 2.5);
        cercle.translater(3, 4);
        assertEquals(new Point(4, 6), cercle.getCentre());
    }

    // Ajoutez d'autres tests selon les exigences...
}
