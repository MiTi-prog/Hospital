package sample;

public class Pacient {

        String id, ime, priimek, starost, spol, email, naslov, stKartice;

        public Pacient(String id, String ime, String priimek, String starost, String spol, String email, String naslov, String stKartice) {
            this.id = id;
            this.ime = ime;
            this.priimek = priimek;
            this.starost = starost;
            this.spol = spol;
            this.email = email;
            this.naslov = naslov;
            this.stKartice = stKartice;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getStarost() {
        return starost;
    }

    public void setStarost(String starost) {
        this.starost = starost;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getStKartice() {
        return stKartice;
    }

    public void setStKartice(String stKartice) {
        this.stKartice = stKartice;
    }
}
