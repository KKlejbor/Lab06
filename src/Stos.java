public class Stos<Typ> {

    private Węzeł szczyt;
    private int rozmiar;

    private class Węzeł{
        Typ wartość;
        Węzeł następny;

        public Węzeł(Typ wartość) {
            this.wartość = wartość;
            następny = null;
        }
    }

    public Stos() {
        szczyt = null;
        rozmiar = 0;
    }

    public void dodajNaStos(Typ wartość){
        Węzeł nowySzczyt = new Węzeł(wartość);
        nowySzczyt.następny = szczyt;
        szczyt = nowySzczyt;
        rozmiar++;
    }

    public Typ usuńZeStosu(){
        Typ wartość = szczyt.wartość;
        szczyt = szczyt.następny;
        rozmiar--;
        return  wartość;
    }

    public Typ zwróćSzczyt(){
        return szczyt.wartość;
    }

    public int zwróćRozmiar() {
        return rozmiar;
    }

    public boolean czyPusty(){
        return rozmiar == 0;
    }

    public void wydrukujStos(){
        // metoda do testowania kodu
        Węzeł element = szczyt;
        while(element != null){
            System.out.print(element.wartość+" ");
            element = element.następny;
        }
        System.out.println("\nRozmiar stosu: " + rozmiar + "\n");
    }
}
