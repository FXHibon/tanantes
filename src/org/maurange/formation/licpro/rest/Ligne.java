package org.maurange.formation.licpro.rest;

public class Ligne {
	private String _ID;
	private String shortName;
	private String longName;
	private String description;
	private int type;
	/**
	 * @return the _ID
	 */
	public String get_ID() {
		return _ID;
	}
	/**
	 * @param _ID the _ID to set
	 */
	public void set_ID(String _ID) {
		this._ID = _ID;
	}
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * @return the longName
	 */
	public String getLongName() {
		return longName;
	}
	/**
	 * @param longName the longName to set
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	

}
