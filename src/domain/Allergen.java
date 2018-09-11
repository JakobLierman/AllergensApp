package domain;

import javafx.beans.property.SimpleStringProperty;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The type Allergen.
 */
@Entity
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Transient
    private BufferedImage icon;

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
    private void setIcon(String allergenName) {
        String url;
        switch (allergenName) {
            case ("Almond"):
                url = "/resources/images/almond.png";
                break;
            case ("Amandel"):
                url = "/resources/images/almond.png";
                break;
            case ("Celery"):
                url = "/resources/images/celery.png";
                break;
            case ("Selder"):
                url = "/resources/images/celery.png";
                break;
            case ("Crustaceans"):
                url = "/resources/images/crustaceans.png";
                break;
            case ("Schaaldieren"):
                url = "/resources/images/crustaceans.png";
                break;
            case ("Egg"):
                url = "/resources/images/egg.png";
                break;
            case ("Ei"):
                url = "/resources/images/egg.png";
                break;
            case ("Fish"):
                url = "/resources/images/fish.png";
                break;
            case ("Vis"):
                url = "/resources/images/fish.png";
                break;
            case ("Gluten"):
                url = "/resources/images/gluten.png";
                break;
            case ("Lupin"):
                url = "/resources/images/lupin.png";
                break;
            case ("Lupine"):
                url = "/resources/images/lupin.png";
                break;
            case ("Milk"):
                url = "/resources/images/milk.png";
                break;
            case ("Melk"):
                url = "/resources/images/milk.png";
                break;
            case ("Mollusc"):
                url = "/resources/images/mollusc.png";
                break;
            case ("Weekdier"):
                url = "/resources/images/mollusc.png";
                break;
            case ("Mustard"):
                url = "/resources/images/mustard.png";
                break;
            case ("Mosterd"):
                url = "/resources/images/mustard.png";
                break;
            case ("Peanut"):
                url = "/resources/images/peanut.png";
                break;
            case ("Pinda"):
                url = "/resources/images/peanut.png";
                break;
            case ("Sesame"):
                url = "/resources/images/sesame.png";
                break;
            case ("Sesamzaad"):
                url = "/resources/images/sesame.png";
                break;
            case ("Soybean"):
                url = "/resources/images/soybean.png";
                break;
            case ("Soja"):
                url = "/resources/images/soybean.png";
                break;
            case ("Sulfide"):
                url = "/resources/images/sulfide.png";
                break;
            case ("Sulfiet"):
                url = "/resources/images/sulfide.png";
                break;
            default:
                url = "/resources/images/notfound.png";
                break;
        }
        try {
            icon = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void setName(String name) {
        if (name.isEmpty())
            throw new NullPointerException("Name can't be empty.");
        this.name = name;
    }

    /**
     * Gets icon.
     *
     * @return the icon
     */
    public BufferedImage getIcon() {
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
}
