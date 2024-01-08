import java.awt.Color;

/**
 * Classe représentant un cercle.
 * Un cercle est défini par son centre, son rayon, et éventuellement sa couleur.
 */
public class Cercle implements Mesurable2D {
    private static final double PI = Math.PI;
    private Point centre;
    private double rayon;
    private Color couleur;

    // Constructeurs
    /**
     * Constructeur d'un cercle avec un centre, un rayon, et une couleur par défaut (bleu).
     *
     * @param centre Le point représentant le centre du cercle.
     * @param rayon  Le rayon du cercle.
     */
    public Cercle(Point centre, double rayon) {
        if (centre == null) {
            // Gérer le cas du centre null (par exemple, créer un centre par défaut)
            this.centre = new Point(0, 0);
        } else {
            this.centre = centre;
        }
        this.rayon = rayon;
        this.couleur = Color.BLUE; // Couleur par défaut
    }

    /**
     * Constructeur d'un cercle avec un centre, un rayon et une couleur spécifiée.
     *
     * @param centre  Le point représentant le centre du cercle.
     * @param rayon   Le rayon du cercle.
     * @param couleur La couleur du cercle.
     */
    public Cercle(Point centre, double rayon, Color couleur) {
        this.centre = centre;
        this.rayon = rayon;
        this.couleur = couleur;
    }

    // Méthodes d'accès
    /**
     * Obtient le centre du cercle.
     *
     * @return Le point représentant le centre du cercle.
     */
    public Point getCentre() {
        return centre;
    }

    /**
     * Obtient le rayon du cercle.
     *
     * @return Le rayon du cercle.
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Obtient le diamètre du cercle.
     *
     * @return Le diamètre du cercle.
     */
    public double getDiametre() {
        return 2 * rayon;
    }

    /**
     * Obtient la couleur du cercle.
     *
     * @return La couleur du cercle.
     */
    public Color getCouleur() {
        return couleur;
    }

    // Méthodes de modification
    /**
     * Transle le cercle selon les déplacements spécifiés sur les axes X et Y.
     *
     * @param deplacementX Le déplacement sur l'axe des X.
     * @param deplacementY Le déplacement sur l'axe des Y.
     */
    public void translater(double deplacementX, double deplacementY) {
        centre.translater(deplacementX, deplacementY);
    }

    /**
     * Modifie le rayon du cercle.
     *
     * @param nouveauRayon Le nouveau rayon du cercle.
     */
    public void setRayon(double nouveauRayon) {
        assert nouveauRayon > 0 : "Le rayon doit être positif";
        rayon = nouveauRayon;
    }

    /**
     * Modifie le diamètre du cercle.
     *
     * @param nouveauDiametre Le nouveau diamètre du cercle.
     */
    public void setDiametre(double nouveauDiametre) {
        assert nouveauDiametre > 0 : "Le diamètre doit être positif";
        rayon = nouveauDiametre / 2;
    }

    /**
     * Modifie la couleur du cercle.
     *
     * @param nouvelleCouleur La nouvelle couleur du cercle.
     */
    public void setCouleur(Color nouvelleCouleur) {
        couleur = nouvelleCouleur;
    }

    // Méthodes spécifiques au cercle
    /**
     * Vérifie si un point donné est à l'intérieur du cercle.
     *
     * @param point Le point à vérifier.
     * @return true si le point est à l'intérieur, false sinon.
     */
    public boolean contient(Point point) {
        double distance = centre.distance(point);
        return distance <= rayon;
    }

    /**
     * Calcule le périmètre du cercle.
     *
     * @return Le périmètre du cercle.
     */
    public double calculerPerimetre() {
        return 2 * PI * rayon;
    }

    /**
     * Calcule l'aire du cercle.
     *
     * @return L'aire du cercle.
     */
    public double calculerAire() {
        return PI * rayon * rayon;
    }

    /**
     * Crée un cercle à partir de deux points, le premier correspond au centre et le deuxième est un point du cercle.
     * Ces deux points forment un rayon du cercle.
     *
     * @param centre                 Le point représentant le centre du cercle.
     * @param pointSurCirconference Le point sur la circonférence du cercle.
     * @return Le cercle créé à partir des deux points.
     */
    public static Cercle creerCercle(Point centre, Point pointSurCirconference) {
        double rayon = centre.distance(pointSurCirconference);
        return new Cercle(centre, rayon, Color.BLUE);
    }

    // Méthode d'affichage
    /**
     * Retourne une représentation textuelle du cercle.
     *
     * @return Une chaîne de caractères représentant le cercle.
     */
    @Override
    public String toString() {
        return "Cr@" + centre + " " + rayon;
    }

    // Implémentation de l'interface Mesurable2D
    @Override
    public double perimetre() {
        return calculerPerimetre();
    }

    @Override
    public double aire() {
        return calculerAire();
    }
}
