import java.util.ArrayList;

public class SystemRezerwacji {
    private ArrayList<Wydarzenie> listaWydarzeń = new ArrayList<>();
    private ArrayList<Klient> listaKlientów = new ArrayList<>();

    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        listaWydarzeń.add(wydarzenie);
    }

    public Wydarzenie znajdzWydarzenie(String nazwa) {
        for (Wydarzenie wydarzenie : listaWydarzeń) {
            if (wydarzenie.getNazwa().equals(nazwa)) {
                return wydarzenie;
            }
        }
        return null;
    }

    public void dodajKlienta(Klient klient) {
        listaKlientów.add(klient);
    }

    public Klient znajdzKlienta(String nazwisko) {
        for (Klient klient : listaKlientów) {
            if (klient.getNazwisko().equals(nazwisko)) {
                return klient;
            }
        }
        return null;
    }

    public void dokonajRezerwacji(Klient klient, Wydarzenie wydarzenie) {
        if (wydarzenie.getDostępneMiejsca() > 0) {
            klient.dodajRezerwację(wydarzenie);
            wydarzenie.zarezerwujMiejsce();
        } else {
            System.out.println("Brak miejsc na wydarzenie!");
        }
    }

    public void zmienCeneWydarzenia(String nazwa, double nowaCena) {
        Wydarzenie wydarzenie = znajdzWydarzenie(nazwa);
        if (wydarzenie != null) {
            wydarzenie.setCena(nowaCena);
        }
    }
}