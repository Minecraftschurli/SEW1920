package gburkl;

/**
 * @author Georg Burkl
 * @version 2020-03-13
 */
public enum Gegenstand {
    AM("Angenadte Mathematik"),
    E1("Englisch"),
    D("Deutsch"),
    NWTK("Netzwerktechnik"),
    SYT("Systemtechnik"),
    MEDT("Medientechnik"),
    ITP("Informationstechnische Projekte"),
    GGP("Geschichte Geografie Politischebildung");

    private final String fullName;

    Gegenstand(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
