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

/**
 * L'énumération TileContent énumère les différents éléments qui constituent
 * la carte du jeu Pacman.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public enum TileContent {

    /**
     * Le contenu d'une tuile de chemin.
     * Les personnages peuvent se déplacer sur une tuile de ce type.
     */
    PATH,

    /**
     * Le contenu d'une tuile de mur.
     * Les personnages ne peuvent pas se déplacer sur une tuile de ce type.
     */
    WALL;

    /**
     * Donne le nom de cet élément de la carte.
     *
     * @return Le nom de cet élément.
     */
    public String getName() {
        return name().toLowerCase();
    }

    /**
     * Vérifie si cet élement est considéré comme vide.
     * Un élément vide est un élément sur lequel un personnage peut se déplacer.
     *
     * @return Si cet élement est vide.
     */
    public boolean isEmpty() {
        return this == PATH;
    }

}
