package com.resteasyjpa.module;

import com.google.inject.AbstractModule;
import com.resteasyjpa.resource.RestMaping;

public class GuiceModule extends AbstractModule {
  @Override
protected void configure() {
   bind(RestMaping.class);
}
}
