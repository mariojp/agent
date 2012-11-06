package br.com.mariojp.exemplos.onibus;

import java.util.HashSet;
import java.util.Set;

public class BusStop {
	// "Location","Description","Bay","Latitude","Longitude","",

	private String location;

	private String description;

	private String longitude;

	private String latitude;

	private Set<Route> routes = new HashSet<Route>();

	@Override
	public boolean equals(Object obj) {
		BusStop outro = (BusStop) obj;
		return this.location.equals(outro.getLocation());
	}

	
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Set<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}
	
    
	
	public double getLatitudeGraus() {
		double valor = 0d;
		String lat = "";
		if (latitude.contains("S")) {
			lat = latitude.replace("S", "");
		    String conteudo[] = lat.split(" ");  
			valor = Double.parseDouble(conteudo[0]);
			valor = (valor + (Double.parseDouble(conteudo[1])/60))*-1;
		} else {
			lat = latitude.replace("N", "");
		    String conteudo[] = lat.split(" ");  
			valor = Double.parseDouble(conteudo[0]);
			valor = (valor + (Double.parseDouble(conteudo[1])/60));
		}
		return valor;
	}

	public double getLongitudeGraus() {
		double valor = 0d;
		String lng = "";
		if (longitude.contains("W")) {
			lng = longitude.replace("W", "");
			String conteudo[] = lng.split(" "); 
			valor = Double.parseDouble(conteudo[0]);
			valor = ((valor + ((Double.parseDouble(conteudo[1])/60)))*(-1));
		} else {
			lng = longitude.replace("E", "");
		    String conteudo[] = lng.split(" ");  
			valor = Double.parseDouble(conteudo[0]);
			valor = (valor + (Double.parseDouble(conteudo[1])/60));		
		}

		return valor;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.location;
	}
}
