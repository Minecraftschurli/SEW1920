package tgm.termine;

import java.time.LocalDateTime;

public class Test {
	public static void main(String[] args) {
		Benutzer b1 = new Benutzer("Jakob", 16);
		Benutzer b2 = new Benutzer("Dominik", 30);
		Benutzer b3 = new Benutzer("Sieglinde", 15);
		Benutzer b4 = new Benutzer("Gustav", 19);
		Termin t1 = new Termin(LocalDateTime.of(2019, 2, 10, 15, 30), 60, "Hausuebung machen", b1);
		Ort o1 = new Ort("Wien", "Wexstrasse", 19, 1200);
		Besprechung bspr = new Besprechung(LocalDateTime.of(2019, 3, 15, 8, 0), 100, "SEW Abgabegegespraech", b2, o1);
		bspr.addTeilnehmer(b3);
		bspr.addTeilnehmer(b4);
		System.out.println("snap");
		// SNAPSHOT HIER
	}
}
