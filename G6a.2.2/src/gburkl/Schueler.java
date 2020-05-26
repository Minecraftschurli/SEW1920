package gburkl;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Georg Burkl
 * @version 2020-02-25
 */
public class Schueler implements Comparable<Schueler>, Serializable {
    private static final long serialVersionUID = 5362826545062689650L;

    private int katalognummer;
    private String vorname;
    private String nachname;
    private Character gruppe;
    private final EnumMap<Gegenstand, Integer> notenliste = new EnumMap<>(Gegenstand.class);

    public Schueler() {
        this.katalognummer = -1;
        this.vorname = null;
        this.nachname = null;
        this.gruppe = null;
    }

    public Schueler(int katalognummer, String vorname, String nachname, char gruppe) {
        this.katalognummer = katalognummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.gruppe = gruppe;
    }

    public int getKatalognummer() {
        return katalognummer;
    }

    public void setKatalognummer(int katalognummer) {
        this.katalognummer = katalognummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public char getGruppe() {
        return gruppe;
    }

    public void setGruppe(char gruppe) {
        this.gruppe = gruppe;
    }

    /**
     * Returns a textual form of the {@link Schueler Schuelers} noten liste
     * @return the string representation of this {@link Schueler Schuelers} noten liste
     */
    public String notenListe() {
        return notenliste
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().name() + '(' + entry.getKey().getFullName() + "): " + entry.getValue())
                .collect(Collectors.joining(", "));
    }

    public int note(Gegenstand gegenstand) {
        return notenliste.get(gegenstand);
    }

    public void noteHinz(Gegenstand gegenstand, int note) {
        notenliste.put(gegenstand, note);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schueler schueler = (Schueler) o;
        return getKatalognummer() == schueler.getKatalognummer() &&
                Objects.equals(getVorname(), schueler.getVorname()) &&
                Objects.equals(getNachname(), schueler.getNachname()) &&
                Objects.equals(getGruppe(), schueler.getGruppe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKatalognummer(), getVorname(), getNachname(), getGruppe());
    }

    @Override
    public String toString() {
        return "Schueler{" +
                "katalognummer=" + getKatalognummer() +
                ", vorname='" + getVorname() + '\'' +
                ", nachname='" + getNachname() + '\'' +
                ", gruppe=" + getGruppe() +
                '}';
    }

    @Override
    public int compareTo(Schueler o) {
        if (Objects.equals(this, o))
            return 0;
        int ret;
        if ((ret = this.vorname.compareTo(o.vorname)) != 0)
            return ret;
        if ((ret = this.nachname.compareTo(o.nachname)) != 0)
            return ret;
        if ((ret = this.katalognummer - o.katalognummer) != 0)
            return ret;
        if ((ret = Character.compare(this.gruppe, o.gruppe)) != 0)
            return ret;
        return 0;
    }
}
