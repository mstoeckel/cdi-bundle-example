package com.cognodyne.dw.cdi.example;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.cognodyne.dw.cdi.CdiConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class ExampleConfiguration extends Configuration implements CdiConfiguration {
    @Valid
    @JsonProperty("cdi")
    private Optional<CdiConfiguration> cdiConfig = Optional.empty();

    @Override
    public Set<String> getIncludes() {
        if (this.cdiConfig.isPresent()) {
            return this.cdiConfig.get().getIncludes();
        }
        return Collections.emptySet();
    }

    @Override
    public Set<String> getExcludes() {
        if (this.cdiConfig.isPresent()) {
            return this.cdiConfig.get().getExcludes();
        }
        return Collections.emptySet();
    }
}
