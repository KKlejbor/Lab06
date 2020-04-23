import javax.print.attribute.standard.MediaSize;

public class Zad02 {
    public static void main(String[] args) {
        String wyrażenieONP = "47 6 9 * +";
        Stos<String> stosONP = new Stos<>();
        String liczba = "";
        int liczba1, liczba2;
        boolean NAN = false;
        String[] tokeny = wyrażenieONP.split(" ");

        for (int i = 0; i < tokeny.length; i++) {
            String token = tokeny[i];
            switch (token){
               /* case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    liczba += znak;
                    break;*/

                /*case ' ':
                    stosONP.dodajNaStos(liczba);
                    liczba = "";
                    break;*/

                case "+":

                    liczba2 = Integer.parseInt(stosONP.usuńZeStosu());
                    liczba1 = Integer.parseInt(stosONP.usuńZeStosu());
                    stosONP.dodajNaStos(Integer.toString(liczba1+liczba2));
                    break;

                case "-":

                    liczba2 = Integer.parseInt(stosONP.usuńZeStosu());
                    liczba1 = Integer.parseInt(stosONP.usuńZeStosu());
                    stosONP.dodajNaStos(Integer.toString(liczba1-liczba2));
                    break;

                case "*":

                    liczba2 = Integer.parseInt(stosONP.usuńZeStosu());
                    liczba1 = Integer.parseInt(stosONP.usuńZeStosu());
                    stosONP.dodajNaStos(Integer.toString(liczba1*liczba2));
                    break;

                case "/":

                    liczba2 = Integer.parseInt(stosONP.usuńZeStosu());
                    liczba1 = Integer.parseInt(stosONP.usuńZeStosu());

                    if(liczba2 != 0) {
                        stosONP.dodajNaStos(Integer.toString(liczba1 / liczba2));
                    }

                    else {
                        NAN = true;
                    }

                    break;

                default:
                    stosONP.dodajNaStos(token);
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
            stosONP.wydrukujStos();
            System.out.println(i+"\n-----------------------");
        }
    }
}
