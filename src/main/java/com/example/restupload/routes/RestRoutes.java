package com.example.restupload.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {

            restConfiguration()
                    .bindingMode(RestBindingMode.auto);

        rest("/upload").consumes("multipart/form-data")
                .produces("application/json")
                .post().to("direct:upload");

        from("direct:upload").to("log:upload-log")
                .transform().constant("hello");

    }
}
