
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nelson E
 * nel2044@hotmail.com
 */
public class NumToLetra {

    private ArrayList<Numero> Numeros = new ArrayList<Numero>() {
        {
//            add(new Numero(0, "CERO"));
            add(new Numero(1, "UN"));
            add(new Numero(1, "UNO"));
            add(new Numero(2, "DOS"));
            add(new Numero(3, "TRES"));
            add(new Numero(4, "CUATRO"));
            add(new Numero(5, "CINCO"));
            add(new Numero(6, "SEIS"));
            add(new Numero(7, "SIETE"));
            add(new Numero(8, "OCHO"));
            add(new Numero(9, "NUEVE"));
            add(new Numero(10, "DIEZ"));
            add(new Numero(11, "ONCE"));
            add(new Numero(12, "DOCE"));
            add(new Numero(13, "TRECE"));
            add(new Numero(14, "CATORCE"));
            add(new Numero(15, "QUINCE"));
            add(new Numero(16, "DIECISEIS"));
            add(new Numero(17, "DIECISIETE"));
            add(new Numero(18, "DIECIOCHO"));
            add(new Numero(19, "DIECINUEVE"));
            add(new Numero(20, "VEINTE"));
            add(new Numero(30, "TREINTA"));
            add(new Numero(40, "CUARENTA"));
            add(new Numero(50, "CINCUENTA"));
            add(new Numero(60, "SESENTA"));
            add(new Numero(70, "SETENTA"));
            add(new Numero(80, "OCHENTA"));
            add(new Numero(90, "NOVENTA"));
            add(new Numero(100, "CIEN"));
        }
    };

    private String MilTex[] = new String[]{"MIL", "MILLONES"};

    private String getNum(String Num) {
        String word = "";
        switch (Num.length()) {
            case 1://<10
                return Numeros.get(toInt(Num)).getLetra();
            case 2://<100
                if (Num.matches("[1][0-9]")) {
                    return Numeros.get(toInt(Num)).getLetra();
                }
                if (Num.matches("[2-9][0]")) {
                    for (int i = 20; i < Numeros.size(); i++) {
                        if (Numeros.get(i).isEquals(toInt(Num))) {
                            return Numeros.get(i).getLetra();
                        }
                    }
                }
                //tomando el mas significativo
                int Ms = toInt(String.valueOf(Num.charAt(0)));
                Ms *= 10;
                return getNum(String.valueOf(Ms)) + " Y " + getNum(String.valueOf(Num.charAt(1)));
            case 3://cientos centenas <1000
                if (Num.matches("[1][0][0]")) {//primero 100
                    return "CIEN";
                }
                if (Num.matches("[1][0][1-9]")) {//101-109
                    return "CIENTO " + getNum(Num.substring(2, Num.length()));
                }
                if (Num.matches("[1][1-9][0]")) {//110,120,130,190
                    return "CIENTO " + getNum(Num.substring(1, Num.length()));
                }
                if (Num.matches("[1][1][1-9]")) {//111-119
                    return "CIENTO " + getNum(Num.substring(1, Num.length()));
                }
                if (Num.matches("[1][2-9][1-9]")) {//121-199
                    return "CIENTO " + getNum(Num.substring(1, Num.length()));
                }
                if (Num.matches("[2-9][0][0]")) {//enteros 200,300,400,etc...900
                    return getNum(String.valueOf(Num.charAt(0))) + "CIENTOS";
                }
                if (Num.matches("[2-9][0][1-9]")) {//201-209
                    return getNum(String.valueOf(Num.charAt(0))) + "CIENTOS " + getNum(Num.substring(2, Num.length()));
                }
                if (Num.matches("[2-9][1][0-9]")) {//210-219
                    return getNum(String.valueOf(Num.charAt(0))) + "CIENTOS " + getNum(Num.substring(1, Num.length()));
                }
                if (Num.matches("[2-9][2-9][0-9]")) {//221-999
                    return getNum(String.valueOf(Num.charAt(0))) + "CIENTOS " + getNum(Num.substring(1, Num.length()));
                }
            case 4://miles <10.000
                if (Num.matches("[1][0][0][0]")) {//primero 1000
                    return "MIL";
                }
                if (Num.matches("[1][0][0][1-9]")) {//1001-1009
                    return "MIL " + getNum(String.valueOf(Num.charAt(3)));
                }
                if (Num.matches("[1][0][0-9][0-9]")) {//1010-1019
                    return "MIL " + getNum(Num.substring(2));
                }
                if (Num.matches("[1][0-9][0-9][0-9]")) {//1001-1999
                    return "MIL " + getNum(Num.substring(1));
                }
                if (Num.matches("[2-9][0][0][0]")) {//2000,3000,4000...9000
                    return getNum(String.valueOf(Num.charAt(0))) + " MIL ";
                }
                if (Num.matches("[2-9][1-9][0-9][0-9]")) {//2100,3900,4000...9900
                    return getNum(String.valueOf(Num.charAt(0))) + " MIL " + getNum(Num.substring(1));
                }
                if (Num.matches("[2-9][0][1-9][0-9]")) {//2010-2099
                    return getNum(String.valueOf(Num.charAt(0))) + " MIL " + getNum(Num.substring(2));
                }
                if (Num.matches("[2-9][0][0][1-9]")) {//2001 -2009
                    return getNum(String.valueOf(Num.charAt(0))) + " MIL " + getNum(String.valueOf(Num.charAt(3)));
                }

            case 5://<100000
                if (Num.matches("[1-9][0-9][0][0][0]")) {//10mil,20mil,...90mil
                    return getNum(Num.substring(0, 2)) + " MIL";
                }
                if (Num.matches("[1-9][0-9][0][0][1-9]")) {//10mil,20mil,...90mil
                    return getNum(Num.substring(0, 2)) + " MIL " + getNum(Num.substring(4, 5));
                }
                if (Num.matches("[1-9][0-9][0][0-9][0-9]")) {//
                    return getNum(Num.substring(0, 2)) + " MIL " + getNum(Num.substring(3, 5));
                }
                if (Num.matches("[1-9][0-9][0-9][0-9][0-9]")) {//
                    return getNum(Num.substring(0, 2)) + " MIL " + getNum(Num.substring(2, 5));
                }
            case 6://<100000
                if (Num.matches("[1-9][0][0][0][0][0]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL";
                }
                if (Num.matches("[1-9][0-9][0-9][0][0][0]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL";
                }
                if (Num.matches("[1-9][0-9][0-9][0][0][1-9]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL "+getNum(Num.substring(5, 6));
                }
                if (Num.matches("[1-9][0-9][0-9][0][1-9][0]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL "+getNum(Num.substring(4, 6));
                }
                if (Num.matches("[1-9][0-9][0-9][0-9][1-9][0]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL "+getNum(Num.substring(3, 6));
                }
                if (Num.matches("[1-9][0-9][0-9][0-9][0][0]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL "+getNum(Num.substring(3, 6));
                }
              
                if (Num.matches("[1-9][0][0][0][0-9][0-9]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL " + getNum(Num.substring(4, 6));
                }
                if (Num.matches("[1-9][0][0][0-9][0-9][0-9]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL " + getNum(Num.substring(3, 6));
                }
                if (Num.matches("[1-9][0][0-9][0][1-9][1-9]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL " + getNum(Num.substring(4, 6));
                }
               
        }
        return word;
    }

    public static void main(String[] args) {
        try {
            PrintWriter pf = new PrintWriter("d:\\salida.txt");
            NumToLetra num = new NumToLetra();
            for (int i = 101100; i < 200000; i++) {
                //System.out.println(i + " - " + num.Letras(String.valueOf(i)));
                pf.append(i + " - " + num.Letras(String.valueOf(i)) + "\n");

            }
            pf.close();
        } catch (Exception e) {

        }
    }

    public String Letras(String value) {
        String aux = getNum(value);
        int pos = aux.indexOf("VEINTE Y ");
        if (pos != -1) {
            aux = aux.replace("VEINTE Y ", "VEINTI");
        }
        pos = aux.indexOf("CINCOCIENTOS ");
        if (pos != -1) {
            aux = aux.replace("CINCOCIENTOS ", "QUINIENTOS ");
        }
        pos = aux.indexOf("CINCOCIENTOS");
        if (pos != -1) {
            aux = aux.replace("CINCOCIENTOS", "QUINIENTOS");
        }
        pos = aux.indexOf("SIETECIENTOS ");
        if (pos != -1) {
            aux = aux.replace("SIETECIENTOS ", "SETECIENTOS ");
        }
        pos = aux.indexOf("SIETECIENTOS");
        if (pos != -1) {
            aux = aux.replace("SIETECIENTOS", "SETECIENTOS");
        }
        pos = aux.indexOf("NUEVECIENTOS ");
        if (pos != -1) {
            aux = aux.replace("NUEVECIENTOS ", "NOVECIENTOS ");
        }
        pos = aux.indexOf("NUEVECIENTOS");
        if (pos != -1) {
            aux = aux.replace("NUEVECIENTOS", "NOVECIENTOS");
        }
        return aux;
    }

    private int toInt(String v) {
        if (v != null) {//q no sea null
            if (v.length() != 0) {//que no este vacia
                if (v.matches("\\d+")) {
                    return Integer.parseInt(v);
                }
            }
        }
        return -1;
    }
}

class Numero {

    private int numero;
    private String Letras;

    public Numero(int numero, String Letra) {
        this.numero = numero;
        this.Letras = Letra;
    }

    public int getNumero() {
        return numero;
    }

    public String getLetra() {
        return Letras;
    }

    public boolean isEquals(int value) {
        return value == numero;
    }
}
