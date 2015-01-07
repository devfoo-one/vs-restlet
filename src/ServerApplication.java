import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;


public class ServerApplication extends Application {
	
	
	public static void main(String[] args) throws Exception {

		// URI of the root directory.
		final String ROOT_URI = "file:///Users/tom/Documents/Dev/Studium/vs/Restlet/Restlet/htdocs/";
		
		// Create a component
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8112);
		component.getClients().add(Protocol.FILE);
		component.getClients().add(Protocol.HTTP);

		// Create an application
		Application application = new Application() {
		    @Override
		    public Restlet createInboundRoot() {
		    	
		    	// Create a router
				Router router = new Router(getContext());

				// Provide other functions depending on URL
				router.attach("/", IndexResource.class);
				router.attach("/on", Socket_on.class);
				router.attach("/off", Socket_off.class);
				return router;
		    }
		};

		// Attach the application to the component and start it
		component.getDefaultHost().attach(application);
		component.start();
	}
}