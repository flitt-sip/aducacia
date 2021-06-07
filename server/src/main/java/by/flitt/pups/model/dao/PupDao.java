package by.flitt.pups.model.dao;

import java.util.Set;
import by.flitt.pups.model.Pup;
import by.flitt.pups.model.PupCity;

public interface PupDao {

  Set<PupCity> getCities();

  Set<Pup> getPups(String cityId);
}
