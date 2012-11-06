package br.com.mariojp.exemplos.onibus;

import java.io.Serializable;

/**
 * Bean para manipulação de coordenadas geográficas
 * 
 * @author Thiago Galbiatti Vespa
 *
 */
public class GeoCoordinate implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 201009101110L;
	/**
	 * Latitude em graus
	 */
	private double latitude;
	/**
	 * Longitude em graus
	 */
	private double longitude;

	/**
	 * Construtor com latitude e longitude em graus
	 * 
	 * @param latitude Latitude em graus
	 * @param longitude Longitude em graus
	 */
	public GeoCoordinate(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Recupera a latitude
	 * @return Latitude em graus
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Atribui uma latitude
	 * @param latitude Latitude em graus
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Recupera uma longitude
	 * @return Longitude em graus
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Atribui uma longitude
	 * @param longitude Longitude em graus
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Distância em Quilômetros de uma coordenada para a atual
	 * @param coordinate coordenada a ser calcula a distância
	 * @return Distância entre as duas coordenadas
	 */
	public double distanceInKm(GeoCoordinate coordinate) {
		return GeoUtils.geoDistanceInKm(this, coordinate);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new GeoCoordinate(this.getLatitude(), this.getLatitude());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoCoordinate other = (GeoCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

}
