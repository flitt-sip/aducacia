package by.flitt.pups;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import by.flitt.pups.model.dao.PupDao;
import by.flitt.pups.model.dao.DaoFactory;

@Configuration
public class AppConfig {

  @Autowired
  private ResourceLoader resourceLoader;

  @Bean
  public PupDao providePupDao() throws IOException {

    try (InputStream is = resourceLoader.getResource("classpath:assets/data.xlsx")
                                        .getInputStream()) {
      return DaoFactory.loadXlsx(is);
    }

  }
}
