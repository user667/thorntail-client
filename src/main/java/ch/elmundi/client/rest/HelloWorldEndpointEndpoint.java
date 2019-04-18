package ch.elmundi.client.rest;


import ch.elmundi.sample.HelloWorld;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.URI;

@Path("/hello")
@ApplicationScoped
public class HelloWorldEndpointEndpoint {

    @Inject
    @ConfigProperty(name = "helloworld.server.url")
    private URI helloWorldServerUrl;

    @GET
    @Produces("text/plain")
    public HelloWorld doGet() {
        ch.elmundi.sample.HelloWorldEndpoint helloWorldEndpoint = RestClientBuilder.newBuilder()
                .baseUri(helloWorldServerUrl)
                .build(ch.elmundi.sample.HelloWorldEndpoint.class);
        return helloWorldEndpoint.hello("world");
    }
}
