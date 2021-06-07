package by.flitt.pups.model.dao;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import by.flitt.pups.model.Pup;
import by.flitt.pups.model.PupCity;

class ListPupDao implements PupDao {

  private final List<Pup> pups;

  ListPupDao(List<Pup> pups) {
    this.pups = pups;
  }

  @Override
  public Set<PupCity> getCities() {
    return pups.stream()
               .map(Pup::getCity)
               .collect(toTreeSet(PupCity::getName));
  }

  @Override
  public Set<Pup> getPups(String cityId) {
    return pups.stream()
               .filter(pup -> Objects.equals(cityId, pup.getCity().getId()))
               .collect(toTreeSet(Pup::getTimestamp));
  }

  private <T, K extends Comparable<K>> Collector<T, ?, TreeSet<T>> toTreeSet(
      Function<T, K> keyExtractor) {
    return Collectors.toCollection(
        () -> new TreeSet<T>(Comparator.comparing(keyExtractor)));
  }
}
