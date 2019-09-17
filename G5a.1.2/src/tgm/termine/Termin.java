package tgm.termine;

import java.time.LocalDateTime;

public class Termin {
	private LocalDateTime beginn;
	private int dauer;
	private String name;
	private Benutzer besitzer;

	public Termin(LocalDateTime beginn, int dauer, String name, Benutzer besitzer) {
		super();
		this.beginn = beginn;
		this.dauer = dauer;
		this.name = name;
		this.besitzer = besitzer;
	}

}
