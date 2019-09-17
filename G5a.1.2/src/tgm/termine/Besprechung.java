package tgm.termine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Besprechung extends Termin {
	private List<Benutzer> teilnehmer = new ArrayList<>();
	private Ort ort;

	public Besprechung(LocalDateTime beginn, int dauer, String name, Benutzer besitzer, Ort ort) {
		super(beginn, dauer, name, besitzer);
		this.ort = ort;
	}

	public void addTeilnehmer(Benutzer neuerTeilnehmer) {
		this.teilnehmer.add(neuerTeilnehmer);
	}
}
