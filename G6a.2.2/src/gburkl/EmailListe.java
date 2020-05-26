package gburkl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Georg Burkl
 * @version 2020-03-13
 */
public class EmailListe {
    private final SortedMap<Schueler, Set<String>> map = new TreeMap<>();

    public void addEmail(Schueler schueler, String email) {
        map.putIfAbsent(schueler, new HashSet<>());
        map.get(schueler).add(email);
    }

    public String[] getEmails(Schueler schueler) {
        return map.getOrDefault(schueler, new HashSet<>()).toArray(String[]::new);
    }

    public void delete(Schueler schueler) {
        map.remove(schueler);
    }

    public void delete(Schueler schueler, String email) {
        map.getOrDefault(schueler, new HashSet<>()).remove(email);
    }

    @Override
    public String toString() {
        return map.entrySet().stream().map(entry ->
                entry.getKey().getVorname() + ' ' +
                entry.getKey().getNachname() + ' ' +
                Arrays.toString(entry.getValue().toArray(String[]::new))
        ).collect(Collectors.joining("\n"));
    }
}
