public class ONP {
    private static int spr(String token)
    {
        switch (token)
        {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    public static String przekształć(String infix){
        Stos<String> stosOperatów = new Stos<>();
        String postfix = "";
        String[] infixTab = infix.split(" ");

        for (int i = 0; i < infixTab.length; i++) {
            String token = infixTab[i];

            if(token.matches("^[1-9]+[0-9]*$")){
                postfix += token+" ";
            }

           else if(!token.matches("^[+*/\\-()]$")){
                return "#";
            }

            else if(token.equals("(")){
                stosOperatów.dodajNaStos(token);
            }

            else if (token.equals(")"))
            {
                while (!stosOperatów.czyPusty() && !stosOperatów.zwróćSzczyt().equals("("))
                    postfix += stosOperatów.usuńZeStosu()+" ";

                if (!stosOperatów.czyPusty() && !stosOperatów.zwróćSzczyt().equals("("))
                    return "#";
                else
                    stosOperatów.usuńZeStosu();
            }
            else
            {
                while (!stosOperatów.czyPusty() && spr(token) <= spr(stosOperatów.zwróćSzczyt())){
                    if(stosOperatów.zwróćSzczyt().equals("("))
                        return "Invalid Expression";
                    postfix += stosOperatów.usuńZeStosu()+" ";
                }
                stosOperatów.dodajNaStos(token);
            }

        }

        while (!stosOperatów.czyPusty()){
            if(stosOperatów.zwróćSzczyt().equals("("))
                return "#";
            postfix += stosOperatów.usuńZeStosu()+" ";
        }

        return postfix;
    }


}
