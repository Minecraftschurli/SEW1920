package gburkl;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Schreibe eine Klasse ListTester mit folgenden Methoden. Alle Methoden übernehmen zumindest eine List<Integer> als Parameter.
 *
 * *) eine Methode addEnd: diese Methode soll neben der Liste noch eine Anzahl als Parameter übernehmen. Die Liste soll dann mit soviel Zufallszahlen befüllt werden, wie in der Anzahl gegeben ist. Die neu generierten Zufallszahlen sollen immer am Ende der Liste hinzugefügt werden (Methode add).
 * *) eine Methode addFirst: diese Methode soll neben der Liste noch eine Anzahl als Parameter übernehmen und die Liste dann mit Zufallszahlen befüllen. Die neu generierten Zufallszahlen sollen immer am Anfang der Liste hinzugefügt werden (Methode add mit zusätzlicher Angabe des Index).
 * *) eine Methode deleteHalf: diese Methode soll die Hälfte aller Elemente der Liste herauslöschen. Verwende für den Zugriff auf die Elemente einen Iterator.
 * *) eine Methode sumIterator: diese Methode soll die Summe aller in der Liste gespeicherten Elemente mit Hilfe eines Iterators berechnen und zurückgeben.
 * *) eine Methode sumIndex: diese Methode soll die Summe aller in der Liste gespeicherten Elemente mit Hilfe des Index (for-Schleife mit Index - nicht for-each-Schleife) berechnen und zurückgeben.
 * *) eine Methode listIterator: diese Methode soll alle Elemente der Liste mit Hilfe eines Iterators in einem String zusammenfassen und zurückgeben.
 * *) eine Methode listIndex: diese Methode soll alle Elemente der Liste über den Index in einem String zusammenfassen und zurückgeben.
 * Schreibe dann ein Programm, das jede dieser Methoden aufruft und die Zeit misst, die für den Aufruf gebraucht wird. Verwende eine Anzahl an Elemente, für die ein signifikanter Unterschied bei den meisten der Methoden sichtbar ist (bei meinem etwas älteren Notebook sind Größen ab 20.000 Elementen deutlich merkbar.
 *
 * Alle Methoden sind zu dokumentieren.
 *
 * Abgabe:
 * Dein Programm (alle Klassen, als JAR-Datei mit Source-Code)
 * Ein kurzes Protokoll (PDF) im doc-Ordner, in welchem du die gemessenen Ergebnisse interpretierst, inklusive:
 * Ein Screenshot deines Testlaufes, auf dem dem die Zeiten auf deinem Computer ersichtlich sind. Eine Beispielausgabe findet sich unten (Format png, jpg)
 *
 * @author Georg Burkl
 * @version 2020-02-18
 */
public class ListTester {
    private static final Random rand = new Random();

    public static void addEnd(List<Integer> list, int count) {
        list.addAll(rand.ints(count).boxed().collect(Collectors.toList()));
    }

    public static void addFirst(List<Integer> list, int count) {
        list.addAll(0, rand.ints(count).boxed().collect(Collectors.toList()));
    }

    public static void deleteHalf(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int c = list.size() / 2;
        while (iterator.hasNext()) {
            if (c <= 0)
                break;
            iterator.next();
            iterator.remove();
            c--;
        }
    }

    public static long sumIterator(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        long sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    public static long sumIndex(List<Integer> list) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static String listIterator(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next()).append(", ");
        }
        return builder.toString();
    }

    public static String listIndex(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(", ");
        }
        return builder.toString();
    }
}
