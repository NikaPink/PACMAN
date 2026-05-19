/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d'aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d'adéquation
 * à un usage particulier et d'absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d'auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d'un contrat, d'un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d'autres éléments du logiciel.
 *
 * (c) 2022-2026 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * La classe HelloController illustre le fonctionnement du contrôleur associé à une vue.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class HelloController {

    /**
     * Le label de l'application, où l'on va pouvoir afficher des messages.
     * Cet attribut sera initialisé automatiquement par JavaFX grâce à l'annotation {@link FXML}.
     */
    @FXML
    private Label welcomeText;

    /**
     * Cette méthode exécute une action lorsque l'utilisateur clique sur le bouton de la fenêtre.
     * Le lien avec le bouton de l'application sera réalisé automatiquement par JavaFX grâce à
     * l'annotation {@link FXML}.
     */
    @FXML
    private GridPane gridPane;






    /* private Image loadPathImage() {
        try {
            URL url = getClass().getResource("/fr/univartois/butinfo/ihm/Images/path.png");
            return new Image(url.toExternalForm(), 32, 32, true, true);

        } catch (NullPointerException | IllegalArgumentException e) {
            throw new NoSuchElementException("Could not load image", e);
        }
    }

    private Image loadWallImage() {
        try {
            URL url = getClass().getResource("/fr/univartois/butinfo/ihm/Images/wall.png");
            return new Image(url.toExternalForm(), 32, 32, true, true);

        } catch (NullPointerException | IllegalArgumentException e) {
            throw new NoSuchElementException("Could not load image", e);
        }
    } */

    private Image loadImage(String path) {
        try {
            URL url = getClass().getResource(path);
            return new Image(url.toExternalForm(), 16, 16, true, true);

        } catch (NullPointerException | IllegalArgumentException e) {
            throw new NoSuchElementException("Could not load image", e);
        }
    }




    /* private int[][] mapGame = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
        {1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
        {1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
        {1,0,0,0,0,1,1,0,1,1,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    }; */

    GameMap generatedMap =  GameMapFactory.createMapWithRandomWalls(16,16);


    /*public void initialize() {


    } */

    public void drawMap() {
        for (int i = 0; i < generatedMap.getHeight()  ; i++) {
            for (int j = 0; j < generatedMap.getWidth(); j++) {
                ImageView view = new ImageView();
                Tile tile = generatedMap.get(i,j);
                if (generatedMap.get(i,j).getContent().getName().equals(TileContent.WALL.getName())) {
                    Bindings.createObjectBinding(() -> loadImage(tile.getContent().getName()),
                            tile.getContentProperty());

                } else {
                    Bindings.createObjectBinding(() -> loadImage(tile.getContent().getName()),
                            tile.getContentProperty());

                }
                gridPane.add(view, j, i);
            }
        }
    }

    private void onHelloButtonClick() {
        // Ici, on va simplement afficher un message dans le label de l'application.
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}
