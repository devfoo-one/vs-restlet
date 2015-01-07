import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.util.Calendar;

public class IndexResource extends ServerResource {

    public IndexResource() {
        super();
    }
    public IndexResource(Context context,
                         Request request,
                         Response response) {
        getVariants().add(new Variant(MediaType.TEXT_PLAIN));
    }
  
    @Override
    protected Representation get() throws ResourceException {
        StringBuilder stringBuilder = new StringBuilder();

        // Build the response as a HTML page
        stringBuilder.append("<html>");
        stringBuilder.append("<head><title>Steckdosen - Kontrollo-mat</title></head>");
        stringBuilder.append("<body bgcolor=white>");

        stringBuilder.append("<table border=\"0\">");
        stringBuilder.append("<tr>");
        stringBuilder.append("<td colspan=\"3\">");
        stringBuilder.append("<h3>Ports ein/ausschalten</h3>");
        stringBuilder.append("</td>");
        stringBuilder.append("</tr>");

        for(int port=1; port<=4; port++ ) {
            stringBuilder.append("<tr><td>Output " + port + "</td>");
            stringBuilder.append("<td><a href=\"/on?port="+ port +"\">ON</a></td>");
            stringBuilder.append("<td><a href=\"/off?port="+ port +"\">OFF</a></td>");
            stringBuilder.append("</tr>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return (new StringRepresentation(stringBuilder.toString(),
                MediaType.TEXT_HTML));
    }
     
}