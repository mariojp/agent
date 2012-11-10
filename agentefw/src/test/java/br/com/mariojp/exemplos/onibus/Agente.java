//package br.com.mariojp.exemplos.onibus;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.swing.JFrame;
//import javax.swing.event.MouseInputListener;
//
//import br.com.mariojp.ai.agent.AgentFactory;
//import br.com.mariojp.ai.agent.AgentModel;
//import br.com.mariojp.ai.agent.IAgent;
//import br.com.mariojp.ai.agent.INode;
//import br.com.mariojp.ai.agent.exception.EmptyBorderException;
//
//import org.jdesktop.swingx.JXMapViewer;
//import org.jdesktop.swingx.OSMTileFactoryInfo;
//import org.jdesktop.swingx.input.CenterMapListener;
//import org.jdesktop.swingx.input.PanKeyListener;
//import org.jdesktop.swingx.input.PanMouseInputListener;
//import org.jdesktop.swingx.input.ZoomMouseWheelListenerCursor;
//import org.jdesktop.swingx.mapviewer.DefaultTileFactory;
//import org.jdesktop.swingx.mapviewer.DefaultWaypoint;
//import org.jdesktop.swingx.mapviewer.GeoPosition;
//import org.jdesktop.swingx.mapviewer.LocalResponseCache;
//import org.jdesktop.swingx.mapviewer.TileFactoryInfo;
//import org.jdesktop.swingx.mapviewer.Waypoint;
//import org.jdesktop.swingx.mapviewer.WaypointPainter;
//import org.jdesktop.swingx.painter.CompoundPainter;
//import org.jdesktop.swingx.painter.Painter;
//
//public class Agente {
//
//	public static void createGui(INode no) {
//
//		/*
//		 * JFrame frame = new JFrame(); frame.setVisible(true);
//		 * frame.setSize(400, 400); JXMapKit mapViewer = new JXMapKit();
//		 * mapViewer
//		 * .setDefaultProvider(org.jdesktop.swingx.JXMapKit.DefaultProviders
//		 * .OpenStreetMaps); mapViewer.setDataProviderCreditShown(true);
//		 * mapViewer.setZoom(3);
//		 */
//		JXMapViewer mapViewer = new JXMapViewer();
//		   
//		// Setup local file cache
//		File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
//		LocalResponseCache.installResponseCache(cacheDir, false);
//
//		// Create a TileFactoryInfo for OpenStreetMap
//		TileFactoryInfo info = new OSMTileFactoryInfo();
//		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
//		tileFactory.setThreadPoolSize(8);
//		mapViewer.setTileFactory(tileFactory);
//		
//		
//		// Add interactions
//		MouseInputListener mia = new PanMouseInputListener(mapViewer);
//		mapViewer.addMouseListener(mia);
//		mapViewer.addMouseMotionListener(mia);
//
//		mapViewer.addMouseListener(new CenterMapListener(mapViewer));
//		
//		mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
//		
//		mapViewer.addKeyListener(new PanKeyListener(mapViewer));
//
//
//		List<GeoPosition> track = new ArrayList<GeoPosition>();
//		// mapKit.setVisible(false);
//		while (no != null) {
//			Estado e = (Estado) no.getState();
//			track.add(new GeoPosition(e.getPonto().getLatitudeGraus(), e
//					.getPonto().getLongitudeGraus()));
//			// System.out.println(e.getPonto().getLocation()+" "+e.getPonto().getLatitudeGraus()+" "+e.getPonto().getLongitudeGraus());
//			// System.out.println(e.getPonto().getLocation()+" "+e.getPonto().getLatitude()+" "+e.getPonto().getLongitude());
//			no = no.getParent();
//		}
//
//		// Set the focus
//		mapViewer.setZoom(4);
//		mapViewer.setAddressLocation(track.get(0));
//
//		// Create a track from the geo-positions
//		RoutePainter routePainter = new RoutePainter(track);
//
//		// Create waypoints from the geo-positions
//		Set<Waypoint> waypoints = new HashSet<Waypoint>();
//		for (GeoPosition g : track) {
//			waypoints.add(new DefaultWaypoint(g));
//		}
//		
//		
//		for (BusStop bs: BaseDados.getInstancia().getBusStops()) {
//			waypoints.add(new DefaultWaypoint(bs.getLatitudeGraus(),bs.getLongitudeGraus()){
//				
//			});
//		}
//		
//		
//
//		// Create a waypoint painter that takes all the waypoints
//		WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
//		waypointPainter.setWaypoints(waypoints);
//
//		// Create a compound painter that uses both the route-painter and the
//		// waypoint-painter
//		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
//		painters.add(routePainter);
//		
//		painters.add(waypointPainter);
//
//		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(
//				painters);
//		mapViewer.setOverlayPainter(painter);
//
//		// Display the viewer in a JFrame
//		JFrame frame = new JFrame("JXMapviewer2 Example 2");
//		frame.getContentPane().add(mapViewer);
//		frame.setSize(800, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//
//		/*
//		 * WaypointPainter painter = new WaypointPainter();
//		 * painter.setWaypoints(waypoints);
//		 * mapViewer.getMainMap().setOverlayPainter(painter);
//		 * 
//		 * mapViewer.setVisible(true); mapViewer.repaint();
//		 * 
//		 * 
//		 * 
//		 * frame.add(mapViewer);
//		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*
//		 */
//	}
//
//	public static void main(String args[]) {
//
//		BaseDados.getInstancia().carga();
//		AgentModel agent = new AgentModel();
//		agent.addAction("Baldear", new Baldear());
//		agent.addAction("Proximo Ponto", new ProximoPonto());
//
//		/**
//		 * Cria estado inicial 427,1,HAA13649 427,2,SNA13768 427,91,HAA40520
//		 * 
//		 * SN120899
//		 */
//		BusStop pontoInicial = (BusStop) BaseDados.getInstancia().getBusStop(
//				"HAA13649");
//		Estado estadoInicial = new Estado();
//		estadoInicial.setPonto(pontoInicial);
//		estadoInicial.setLinha(null);
//
//		agent.setInitState(estadoInicial);
//
//		/**
//		 * Cria e adiciona os estados que atendem ao objetivo.
//		 */
//		BusStop pontoFinal = (BusStop) BaseDados.getInstancia().getBusStop(
//				"HAA40520");
//
//		// System.out.println(BaseDados.getInstancia().getDistanciaDireta(pontoInicial,pontoFinal));
//
//		Set<Route> linhas = pontoFinal.getRoutes();
//		for (Route l : linhas) {
//			Estado estado = new Estado();
//			estado.setLinha(l);
//			estado.setPonto(pontoFinal);
//			agent.addObjective(estado);
//		}
//		/*
//		 * Hora inicio: 10:18:29 Hora Fim : 10:18:29 Tempo : 97milisegundos
//		 * Total de N��s Expandidos : 63 Total de N��s Visitados : 44
//		 * 
//		 * Proximo Ponto 1.675783872623694 5 Linha: N3 Ponto: HAA40520 SS
//		 * 
//		 * BFS Total de N��s Expandidos : 170 Total de N��s Visitados : 46
//		 * 
//		 * Dik Total de N��s Expandidos : 68 Total de N��s Visitados : 49
//		 * 
//		 * A* Total de N��s Expandidos : 56 Total de N��s Visitados : 36
//		 */
//
//		agent.setFunctions(new Funcoes());
//		agent.setType(IAgent.START_SEARCH);
//
//		IAgent agente = AgentFactory.createAgent(agent);
//
//		INode nofinal = null;
//		try {
//			System.out.println("INICIAR");
//			nofinal = agente.function();
//		} catch (EmptyBorderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<INode> cam = agente.obterCaminho(nofinal);
//		// agente.exibirGrafico(null);
//		System.out.println(cam);
//		System.out.println(agente);
//		System.out.println(nofinal);
//		createGui(nofinal);
//
//	}
//
//}
