package org.maurange.formation.licpro.rest;

import java.util.List;

public class Arret {
	private String codeLieu;
	private String libelle;
	private String distance;
	private List<NumLigne> ligne;
	/**
	 * @return the codeLieu
	 */
	public String getCodeLieu() {
		return codeLieu;
	}
	/**
	 * @param codeLieu the codeLieu to set
	 */
	public void setCodeLieu(String codeLieu) {
		this.codeLieu = codeLieu;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}
	/**
	 * @return the ligne
	 */
	public List<NumLigne> getLigne() {
		return ligne;
	}
	/**
	 * @param ligne the ligne to set
	 */
	public void setLigne(List<NumLigne> ligne) {
		this.ligne = ligne;
	}
	

}
