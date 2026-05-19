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
 * la classe Player représente le personnage du joueur qui utilise
 * l'application, donc Pacman.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class Player extends AbstractCharacter {

	/**
	 * Crée une nouvelle instance de Player.
	 */
	public Player() {
		super(3);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see AbstractCharacter#getName()
	 */
	@Override
	public String getName() {
		return "pacman";
	}

}
