package br.com.mariojp.exemplos.onibus;

public class RouteStop {
	
	private Integer id;
	private Route route;
	private BusStop busStop;
	private Integer ordem;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public BusStop getBusStop() {
		return busStop;
	}
	public void setBusStop(BusStop busStop) {
		this.busStop = busStop;
	}




}
