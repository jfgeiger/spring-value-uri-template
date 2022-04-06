package org.example;


import java.text.MessageFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;

@Component
public class URITemplateLogger {

  private static final Logger LOGGER = Logger.getLogger(URITemplateLogger.class.getName());

  private final UriTemplate uriTemplate;

  public URITemplateLogger(@Value("${org.example.uri-template}") final UriTemplate uriTemplate) {
    this.uriTemplate = uriTemplate;
  }

  @PostConstruct
  public void init() {
    final var loggable = LOGGER.isLoggable(Level.INFO);

    if (loggable) {
      final var uriVariables = Map.ofEntries(Map.entry("pathParam", "PATH"),
          Map.entry("queryParam", "QUERY"));
      final var uri = this.uriTemplate.expand(uriVariables);
      final var message = MessageFormat.format("Expanded URI: {0}", uri);
      LOGGER.info(message);
    }
  }
}