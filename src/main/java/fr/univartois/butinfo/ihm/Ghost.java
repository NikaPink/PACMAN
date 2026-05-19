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
 * la classe Ghost représente les fantômes, adversaire du joueur dans le jeu Pacman.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class Ghost extends AbstractCharacter {
	
	/**
	 * La couleur de ce fantôme.
	 */
	private String color;

	/**
	 * Crée une nouvelle instance de Ghost.
	 *
	 * @param color La couleur du fantôme.
	 */
	public Ghost(String color) {
		super(Integer.MAX_VALUE);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see AbstractCharacter#getName()
	 */
	@Override
	public String getName() {
		return color;
	}

}
