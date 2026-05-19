package fr.univartois.butinfo.ihm; /**
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

import javafx.beans.Observable;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

/**
 * La classe Tile représente une tuile composant la carte du jeu Pacman.
 * Une fois créée, une telle tuile devient fixe sur la carte : c'est son
 * contenu qui change au cours du jeu, si cela s'avère nécessaire.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class Tile {

    /**
     * La ligne où cette tuile est positionnée sur la carte.
     */
    private final int row;

    /**
     * La colonne où cette tuile est positionnée sur la carte.
     */
    private final int column;

    /**
     * Le contenu de cette tuile.
     */
    private final ObjectProperty<TileContent> content = new SimpleObjectProperty<>();


    /**
     * Construit une nouvelle instance de Tile.
     * 
     * @param row La ligne où la tuile est positionnée sur la carte.
     * @param column La colonne où la tuile est positionnée sur la carte.
     */
    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Donne la ligne où cette tuile est positionnée sur la carte.
     *
     * @return La ligne où cette tuile est positionnée sur la carte.
     */
    public int getRow() {
        return row;
    }

    /**
     * Donne la colonne où cette tuile est positionnée sur la carte.
     *
     * @return La colonne où cette tuile est positionnée sur la carte.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Donne le contenu de cette tuile.
     *
     * @return Le contenu de cette tuile.
     */
    public ObjectProperty<TileContent> getContent() {
        return content;
    }

    /**
     * Change le contenu de cette tuile.
     *
     * @param content Le nouveau contenu de cette tuile.
     */
    public void setContent(ObjectProperty<TileContent> content) {
        this.content = content;
    }

    /**
     * Vérifie si cette tuile est vide, c'est-à-dire que son contenu est vide.
     *
     * @return Si cette tuile est vide.
     *
     * @see TileContent#isEmpty()
     */
    public Boolean isEmpty() {
        return content.get() == TileContent.PATH;
    }


    public Observable getContentProperty() {
        return content;
    }
}
