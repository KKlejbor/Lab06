public class Zad02 {
    public static void main(String[] args) {
        String wyrażenieONP = "47 6 9 * +";
        Stos<String> stosONP = new Stos<>();
        String liczba = "";

        for (int i = 0; i < wyrażenieONP.length(); i++) {
            char znak = wyrażenieONP.charAt(i);
            switch (znak){
                case '0':
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
                    break;
                case ' ':
                    stosONP.dodajNaStos(liczba);
                    liczba = "";
                    break;
                case '+':
                    stosONP.dodajNaStos("+");
                    break;
                case '-':
                    stosONP.dodajNaStos("-");
                    break;
                case '*':
                    stosONP.dodajNaStos("*");
                    break;
                case '/':
                    stosONP.dodajNaStos("/");
                    break;
                default:
                    break;
            }
            stosONP.wydrukujStos();
        }
    }
}
