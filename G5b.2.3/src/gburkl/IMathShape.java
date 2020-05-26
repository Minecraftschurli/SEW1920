package gburkl;

/*
 *  Konstanten:
 *      je eine Konstante für die Einheit Milimeter, Zentimeter, Meter und Kilometer.
 *  Methoden:
 *      eine Methode initialisieren um sinnvolle Standardwerte eines Objektes zu setzen
 *      eine Methode flaecheBerechnen, die den Flächeninhalt einer Figur berechnet
 *      eine Methode umfangBerechnen, den Umfang einer Figur berechnet
 *      eine Methode setEinheit, die eine Einheit (aus den obigen Konstanten) für die Figur festlegt
 *      eine Methode getEinheit, die die in der Figur gespeicherte Einheit zurückgibt
 *      eine Methode laengenCheck, die eine Länge auf einen gültigen Bereich prüft (zumindest positiv).
 *      eine Methode umrechenFaktor, die den Umrechnungsfaktor von der gespeicherten Einheit zu Meter berechnet
 */


/**
 * @author Georg Burkl
 * @version 2019-12-10
 */
public interface IMathShape {
    String MILLIMETER = "mm";
    String CENTIMETER = "cm";
    String METER = "m";
    String KILOMETER = "km";

    void init();

    double calcArea();

    double calcBorder();

    void setUnit(String unit);

    String getUnit();

    boolean checkValue(String value, double min, double max);

    default double calculationFactor() {
        switch (getUnit()) {
            case MILLIMETER:
                return 0.001;
            case CENTIMETER:
                return 0.01;
            case METER:
                return 1;
            case KILOMETER:
                return 1000;
            default:
                return 0;
        }
    }
}
