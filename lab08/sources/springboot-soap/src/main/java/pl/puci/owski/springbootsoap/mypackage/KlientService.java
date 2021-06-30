package pl.puci.owski.springbootsoap.mypackage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlientService {
    private List<Klient> klients;

    public Klient getKlientById(int id){
        return klients.stream().filter(klient->klient.getId() == id).findFirst().get();
    }

    public void setKlients(List<Klient> klients){
        this.klients = klients;
    }
}
