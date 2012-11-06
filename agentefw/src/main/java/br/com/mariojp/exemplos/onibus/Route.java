/*
 * Created on 29/03/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.mariojp.exemplos.onibus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Route {

	// "id","code","label"

	private String id;

	private String code;

	private String label;

	private List<RouteStop> routeStops = new ArrayList<RouteStop>();

	@Override
	public boolean equals(Object obj) {
		boolean i = false;
		Route outro = (Route) obj;
		 if(outro != null){
			 i = (this.code.equals(outro.getCode()))?true:false; 
		}
		return i;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<RouteStop> getRouteStops() {
		return routeStops;
	}

	public void setRouteStops(List<RouteStop> routeStops) {
		this.routeStops = routeStops;
	}

	public RouteStop proximoPonto(RouteStop stop) {
		System.out.println(stop);
		RouteStop proximo = null;
		for (int i = 0; i < routeStops.size(); i++) {
			if (routeStops.get(i).equals(stop)) {
				if (i + 1 < routeStops.size()) {
					proximo = routeStops.get(i + 1);
				}
			}
		}
		return proximo;
	}

	public RouteStop proximoPonto(BusStop stop) {
		// System.out.println(stop.getLocation());
		RouteStop proximo = null;
		for (int i = 0; i < routeStops.size(); i++) {
			if (routeStops.get(i).getBusStop().equals(stop)) {
				if (i + 1 < routeStops.size()) {
					proximo = routeStops.get(i + 1);
				}
			}
		}
		return proximo;
	}

	public RouteStop proximoPonto(Integer pontosNaLinha) {
		RouteStop resultado = null;
		Iterator<RouteStop> iterator = routeStops.iterator();
		while(iterator.hasNext()){
			RouteStop rs = iterator.next();
			if (rs.getOrdem() == pontosNaLinha) {
				if(iterator.hasNext()){
					resultado = iterator.next();
				}
			}
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return this.code;
	}

}
