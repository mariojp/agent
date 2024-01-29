
package br.com.mariojp.exemplos.onibus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import us.monoid.web.Resty;

import br.com.mariojp.exemplos.metroparis.excecoes.DistanciaNaoInformadaException;



/**
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseDados {
	
	
	
	private static final BaseDados instancia = new BaseDados();
	private Map<String,BusStop> busStops = new HashMap<String,BusStop>();
	private Map<String,Route> routes = new HashMap<String,Route>();
	private Map<Integer,RouteStop> routeStops = new HashMap<Integer,RouteStop>();
	private Map<String,Trecho> realdistances = new HashMap<String,Trecho>();

	
    File arquivo  = null;
    FileOutputStream fos = null;
	
	private BaseDados(){
	}
	
	public static BaseDados getInstancia(){
		return instancia;
	}
		
	public double getDistanciaReal(BusStop e1,BusStop e2) throws DistanciaNaoInformadaException{
		/*for (int i =0;i<distReaisEstacoes.size(); i++) {
			Distancia distancia = (Distancia) distReaisEstacoes.get(i);
			if (distancia.getOrigem().equals(e1) &&
					distancia.getDestino().equals(e2))
				return distancia.getDistancia();
			if (distancia.getOrigem().equals(e2) &&
					distancia.getDestino().equals(e1))
				return distancia.getDistancia();
		}

		throw new DistanciaNaoInformadaException("Distancia Real nao informada para "+e1+"-"+e2); */
//		Resty r = new Resty();
//		String name = "";
//		try
//		{
//		Thread.sleep (1000);
//		} catch (InterruptedException e) {};
//		try {
//			System.out.println(("http://maps.googleapis.com/maps/api/directions/json?origin="+e1.getLatitudeGraus()+","+e1.getLongitudeGraus()+"&destination="+e2.getLatitudeGraus()+","+e2.getLongitudeGraus()+"&sensor=false"));
//			name = r.json("http://maps.googleapis.com/maps/api/directions/json?origin="+e1.getLatitudeGraus()+","+e1.getLongitudeGraus()+"&destination="+e2.getLatitudeGraus()+","+e2.getLongitudeGraus()+"&sensor=false").get("routes[0].legs[0].distance.text").toString();
//			System.out.println(name);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		double retorno = 0.0;
//		if (name.indexOf("km")!=-1){
//			retorno =  Double.parseDouble(name.replaceAll("km", ""));
//		}else if (name.indexOf("m")!=-1){
//			retorno =  Double.parseDouble(name.replaceAll("m", ""))/1000;
//		}
//		return retorno;
		return 0.0;
	}
	
	public double getDistanciaDireta(BusStop e1,BusStop e2) {
		return GeoUtils.geoDistanceInKm(e1.getLatitudeGraus(), e1.getLongitudeGraus(), e2.getLatitudeGraus(), e2.getLongitudeGraus());
	}
	


	

	

	public void carregaRotas() throws IOException {
		//"id","code","label"
		BufferedReader in = new BufferedReader(new FileReader("src/test/resources/routes.csv"));
		String linha = in.readLine();  
		while ((linha = in.readLine()) != null) {
		    String conteudo[] = linha.split(",");  
		    Route route = new Route();
		    route.setId(conteudo[0]);
		    route.setCode(conteudo[1]);
		    route.setLabel(conteudo[2]);
		    routes.put(route.getId(),route);
		}  

	}
	
	public void carregaTrechos() throws IOException {
		//"route-id","seq","stop-id"
		BufferedReader in = new BufferedReader(new FileReader("src/test/resources/routestops.csv"));
		String linha = in.readLine();  
		int i = 0;
		RouteStop routeStop = null;
		Route route = null;
		while ((linha = in.readLine()) != null) {
		    String conteudo[] = linha.split(",");  
		    routeStop = new RouteStop();
		    routeStop.setId(i++);
		    route = routes.get(conteudo[0]);
		    BusStop busStop = busStops.get(conteudo[2]);
		    routeStop.setOrdem(Integer.parseInt(conteudo[1]));
		    routeStop.setRoute(route);
		    routeStop.setBusStop(busStop);
		    if(busStop!=null){
		    	busStop.getRoutes().add(route);
			    route.getRouteStops().add(routeStop);
		    	routeStops.put(routeStop.getId(), routeStop);
		    }else{
		    	//System.out.println(conteudo[2] +" : "+busStops.get(conteudo[2].trim()));
		    }		  
		}
		
	}
	
	// Caso a localidade esteja no oeste põe-se um sinal negativo (-) na frente da longitude. Ao invés de usar o sinal negativo, pode-se também usar as letras E e W para indicar "Leste" e "Oeste", respectivamente.

	//A latitude mede-se para norte e para sul do equador, entre 90º sul, no Pólo Sul (ou pólo antártico) (negativa), e 90º norte, no Pólo Norte (ou pólo ártico) (positiva). A latitude no equador é igual a 0º. O modo como a latitude é definida depende da superfície de referência utilizada:

	public void carregaPontos() throws IOException {
		//"Location","Description","Bay","Latitude","Longitude","",
		BufferedReader in = new BufferedReader(new FileReader("src/test/resources/bus-stops.csv"));
		String linha = in.readLine();  
		while ((linha = in.readLine()) != null) {
		    String conteudo[] = linha.split(",");  
		    BusStop busStop = new BusStop();
		    busStop.setLocation(conteudo[0].replaceAll("\"", ""));
		    busStop.setDescription(conteudo[1].replaceAll("\"", ""));
		    String latitude = conteudo[3].replaceAll("\"", "");
		    busStop.setLatitude(latitude);
		    String longitude = conteudo[4].replaceAll("\"", "");
		    busStop.setLongitude(longitude);
		    busStops.put(busStop.getLocation(), busStop);
		    
		}  
	}
	
	public BusStop getBusStop(String codigo){
		return busStops.get(codigo);
	}

	public void carga()  {
		try {
			this.openFile();

			this.carregaPontos();
			this.carregaRotas();
			this.carregaTrechos();
			//this.checaDistancias();
			
			//System.out.println(this.busStops.size());
			//System.out.println(this.routes.size());
			//System.out.println(this.realdistances.size());

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<BusStop> getBusStops() {
		return this.busStops.values();
	}
	
	public void openFile(){
	    try {
	    	arquivo  = new File("arquivo.txt");
			fos = new FileOutputStream(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeFile() {
        try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void main(String[] args) {

		BaseDados.getInstancia().carga();
		try {
			BaseDados.getInstancia().checaDistancias();
		} catch (Exception e) {
			BaseDados.getInstancia().closeFile();
			e.printStackTrace();
		}finally{
		}
		
	}
	
	public void checaDistancias() {
		for(Route r :routes.values()){
			List<RouteStop> array = r.getRouteStops();
			RouteStop aux = null;
			double distancia = 0;
			for(int i = 0 ; i < array.size() ; i++ ){
				RouteStop atual = array.get(i);
				if(i == 0){
					aux = atual;
					distancia = 0;
				}else{
					//System.out.print(atual.getBusStop().getLocation()+"  ");
					//System.out.println(aux.getBusStop().getLocation());
					//distancia = getDistanciaReal(aux.getBusStop(),atual.getBusStop());
					Trecho trecho = new Trecho();
					trecho.setOrigem(aux.getBusStop());
					trecho.setDestino(atual.getBusStop());
					if(!realdistances.containsKey(trecho.getKey())){
						try {
							distancia = getDistanciaReal(aux.getBusStop(),atual.getBusStop());
						} catch (DistanciaNaoInformadaException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						trecho.setDistanciaReal(distancia);
						realdistances.put(trecho.getKey(),trecho);
					}else{
						Trecho t = realdistances.get(trecho.getKey());
						distancia = t.getDistanciaReal();
					}
					aux = atual;
				}
				String texto = r.getId()+","+atual.getOrdem()+","+atual.getBusStop().getLocation()+","+distancia+"\n";
		        try {
					fos.write(texto.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
