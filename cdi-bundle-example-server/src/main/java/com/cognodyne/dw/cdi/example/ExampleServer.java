package com.cognodyne.dw.cdi.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cognodyne.dw.cdi.CdiBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

@ApplicationScoped
public class ExampleServer extends Application<ExampleConfiguration> {
    @Inject
    private CdiBundle cdiBundle;

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.addBundle(this.cdiBundle);
    }

    @Override
    public void run(ExampleConfiguration configuration, Environment environment) throws Exception {
    }

    public static void main(String... args) {
        try {
            CdiBundle.startApp(ExampleServer.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
