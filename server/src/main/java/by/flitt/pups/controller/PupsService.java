package by.flitt.pups.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import by.flitt.pups.model.Pup;
import by.flitt.pups.model.PupCity;
import by.flitt.pups.model.dao.PupDao;

@RestController()
@RequestMapping(value = "/v1")
public class PupsService {

  @Autowired
  private PupDao pups;

  @RequestMapping(value = "/city")
  public Set<PupCity> cities() {
    return pups.getCities();
  }

  @RequestMapping(value = "/pups/{cityId}")
  public Set<Pup> pups(@PathVariable("cityId") String cityId) {
    return pups.getPups(cityId);
  }
}
