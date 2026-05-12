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

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
    private void onHelloButtonClick() {
        // Ici, on va simplement afficher un message dans le label de l'application.
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}
