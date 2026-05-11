package fr.univ_amu.iut.exercice4;

/**
 * Exercice 4 - Robot sur grille infinie.
 *
 * <p>Un robot a une {@link Position} et une {@link Orientation}. Il peut :
 *
 * <ul>
 *   <li>tourner à droite / à gauche (sens horaire / antihoraire)
 *   <li>avancer d'une case dans sa direction courante
 * </ul>
 *
 * <p>Les rotations ne modifient <b>pas</b> la position, et l'avancée ne modifie <b>pas</b>
 * l'orientation. La grille est infinie dans les deux dimensions.
 */
public class Robot {

  private Position position;
  private Orientation orientation;

  public Robot(Position position, Orientation orientation) {
    this.position = position;
    this.orientation = orientation;
  }

  public Position getPosition() {
    return position;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  /** Fait pivoter le robot d'un quart de tour vers sa droite (sens horaire). */
  public void tournerADroite() {
    // TODO exercice 4 : implémenter la rotation horaire.
    // Astuce : profitez de l'ordre NORD → EST → SUD → OUEST → NORD
    // (les valeurs de l'enum sont déjà dans le sens horaire).
    int prochainIndex = (this.orientation.ordinal() + 1) % 4;
    this.orientation = Orientation.values()[prochainIndex];
  }

  /** Fait pivoter le robot d'un quart de tour vers sa gauche (sens antihoraire). */
  public void tournerAGauche() {
    // TODO exercice 4 : implémenter la rotation antihoraire.
    int prochainIndex = (this.orientation.ordinal() + 3) % 4;
    this.orientation = Orientation.values()[prochainIndex];
  }

  /** Avance le robot d'une case dans la direction de son orientation courante. */
  public void avancer() {
    switch (this.orientation) {
      case NORD -> this.position = new Position(this.position.x(), this.position.y() + 1);
      case EST -> this.position = new Position(this.position.x() + 1, this.position.y());
      case SUD -> this.position = new Position(this.position.x(), this.position.y() - 1);
      case OUEST -> this.position = new Position(this.position.x() - 1, this.position.y());
    }
  }
}
