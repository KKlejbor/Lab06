import javax.print.attribute.standard.MediaSize;

public class Zad02 {
    public static void main(String[] args) {
        Stos<Integer> stosONP = new Stos<>();
        int liczba1, liczba2;
        boolean NAN = false;

//        String wyrażenieONP = "47 6 9 * +";
        String wyrażenieONP = "3 11 4 2 - * + 15 3 8 + * + 1 -";
        String[] tokeny = wyrażenieONP.split(" ");

        for (int i = 0; i < tokeny.length; i++) {
            String token = tokeny[i];
            switch (token){
                case "+":

                    liczba2 = stosONP.usuńZeStosu();
                    liczba1 = stosONP.usuńZeStosu();
                    stosONP.dodajNaStos(liczba1+liczba2);
                    break;

                case "-":

                    liczba2 = stosONP.usuńZeStosu();
                    liczba1 = stosONP.usuńZeStosu();
                    stosONP.dodajNaStos(liczba1-liczba2);
                    break;

                case "*":

                    liczba2 = stosONP.usuńZeStosu();
                    liczba1 = stosONP.usuńZeStosu();
                    stosONP.dodajNaStos(liczba1*liczba2);
                    break;

                case "/":

                    liczba2 = stosONP.usuńZeStosu();
                    liczba1 = stosONP.usuńZeStosu();

                    if(liczba2 != 0) {
                        stosONP.dodajNaStos(liczba1 / liczba2);
                    }

                    else {
                        NAN = true;
                    }

                    break;

                default:
                    stosONP.dodajNaStos(Integer.parseInt(token));
            }

            if(NAN){
                System.out.println("BŁĄD! Nie można dzielić przez zero!");
                System.out.println(wyrażenieONP);
                for (int j = 0; j < i; j++) {
                    System.out.print(' ');
                }
                System.out.println("^");
                System.out.println("Stos: ");
                stosONP.wydrukujStos();
                break;
            }

            /*stosONP.wydrukujStos();
            System.out.println(i+". krok"+"\n-----------------------");*/
        }
        System.out.println("Wyrażenie: " + wyrażenieONP);
        System.out.println("Wynik działania: ");
        stosONP.wydrukujStos();
    }
}
