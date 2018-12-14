package domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.persistence.*;

/**
 * The type Allergen.
 */
@Entity
@NamedQuery(name = "Allergen.findByName", query = "SELECT a FROM Allergen a WHERE a.name = :allergenName")
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Transient
    private ImageView icon;

    /**
     * Instantiates a new Allergen.
     */
    public Allergen() {
    }

    /**
     * Instantiates a new Allergen.
     *
     * @param name the name
     */
    public Allergen(String name) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
        setIcon(name);
    }

    // Sets an icon if one is available
    public void setIcon(String allergenName) {
        String url;
        switch (allergenName) {
            case ("Almond"):
                url = "/images/almond.png";
                break;
            case ("Amandel"):
                url = "/images/almond.png";
                break;
            case ("Celery"):
                url = "/images/celery.png";
                break;
            case ("Selder"):
                url = "/images/celery.png";
                break;
            case ("Crustaceans"):
                url = "/images/crustaceans.png";
                break;
            case ("Schaaldieren"):
                url = "/images/crustaceans.png";
                break;
            case ("Egg"):
                url = "/images/egg.png";
                break;
            case ("Ei"):
                url = "/images/egg.png";
                break;
            case ("Fish"):
                url = "/images/fish.png";
                break;
            case ("Vis"):
                url = "/images/fish.png";
                break;
            case ("Gluten"):
                url = "/images/gluten.png";
                break;
            case ("Lupin"):
                url = "/images/lupin.png";
                break;
            case ("Lupine"):
                url = "/images/lupin.png";
                break;
            case ("Milk"):
                url = "/images/milk.png";
                break;
            case ("Melk"):
                url = "/images/milk.png";
                break;
            case ("Mollusc"):
                url = "/images/mollusc.png";
                break;
            case ("Weekdier"):
                url = "/images/mollusc.png";
                break;
            case ("Mustard"):
                url = "/images/mustard.png";
                break;
            case ("Mosterd"):
                url = "/images/mustard.png";
                break;
            case ("Peanut"):
                url = "/images/peanut.png";
                break;
            case ("Pinda"):
                url = "/images/peanut.png";
                break;
            case ("Sesame"):
                url = "/images/sesame.png";
                break;
            case ("Sesamzaad"):
                url = "/images/sesame.png";
                break;
            case ("Soybean"):
                url = "/images/soybean.png";
                break;
            case ("Soja"):
                url = "/images/soybean.png";
                break;
            case ("Sulfide"):
                url = "/images/sulfide.png";
                break;
            case ("Sulfiet"):
                url = "/images/sulfide.png";
                break;
            default:
                url = "/images/notfound.png";
                break;
        }
        icon = new ImageView(new Image(url, 50, 50, true, true));
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    protected void setName(String name) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
    }

    /**
     * Gets icon.
     *
     * @return the icon
     */
    public ImageView getIcon() {
        return icon;
    }

    /**
     * Name property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
