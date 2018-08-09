package UTILS;


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
 */
public class NumToLetra {

    
    
    private ArrayList<Numero> Numeros = new ArrayList<Numero>() {
        {
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

            case 5://<99.999 12345
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
            case 6://<=999.999=> 123456
                /**
                 * de la forma A00.000*
                 */
                if (Num.matches("[1-9][0-9][0-9][0][0][0]")) {//
                    return getNum(Num.substring(0, 3)) + " MIL";
                }
                String SupParte6 = getNum(Num.substring(0, 3)) + " MIL"; //extrayendo ABC.
                NumLengthValue subParte6 = new NumLengthValue(5, Num.substring(3), false);//primera medida de long 6
                while (subParte6.longitud > 0) {
                    subParte6 = getValue(subParte6.value);
                    if (subParte6.enc) {
                        break;
                    }
                }
                if (subParte6 != null) {
                    return SupParte6 + " " + getNum(subParte6.value);
                }

            case 7://<10.000.000

                /**
                 * 1
                 * de la forma A.000.000 CON A=1
                 */
                if (Num.matches("[1-9][0][0][0][0][0][0]")) {//
                    return getNum(Num.substring(0, 1)) + " MILLONES";
                }
                String SupParte7 = getNum(Num.substring(0, 1)) + " MILLONES"; //extrayendo ABC.
                NumLengthValue subParte7 = new NumLengthValue(5, Num.substring(1), false);//primera medida de long 6
                while (subParte7.longitud > 0) {
                    subParte7 = getValue(subParte7.value);
                    if (subParte7.enc) {
                        break;
                    }
                }
                if (subParte7 != null) {
                    return SupParte7 + " " + getNum(subParte7.value);
                }

            case 8://<100.000.000
                /**
                 * 1
                 * de la forma nn.000.000 CON A=1
                 */
                if (Num.matches("[1-9][0-9][0][0][0][0][0][0]")) {//
                    return getNum(Num.substring(0, 2)) + " MILLONES";
                }
                String SupParte8 = getNum(Num.substring(0, 2)) + " MILLONES"; //extrayendo ABC.
                NumLengthValue subParte8 = new NumLengthValue(5, Num.substring(2), false);//primera medida de long 6
                while (subParte8.longitud > 0) {
                    subParte8 = getValue(subParte8.value);
                    if (subParte8.enc) {
                        break;
                    }
                }
                if (subParte8 != null) {
                    return SupParte8 + " " + getNum(subParte8.value);
                }

            case 9://DE LA FORMA ABC.DEF.GHI.XYZ
                if (Num.matches("[1-9][0-9][0-9][0][0][0][0][0][0]")) {//
                    return getNum(Num.substring(0, 3)) + " MILLONES";
                }
                String SupParte = getNum(Num.substring(0, 3)) + " MILLONES"; //extrayendo ABC.
                NumLengthValue subParte = new NumLengthValue(6, Num.substring(3), false);//primera medida de long 6
                while (subParte.longitud > 0) {
                    subParte = getValue(subParte.value);
                    if (subParte.enc) {
                        break;
                    }
                }
                if (subParte != null) {
                    return SupParte + " " + getNum(subParte.value);
                }
            case 10:
                //Según explica el Diccionario panhispánico de dudas, el billion del inglés americano equivale en español a mil millones o un millardo, denominación menos utilizada, y no a un billón, que corresponde a un millón de millones.11 mar. 2011
                //el «billion» inglés no equivale al «billón» español | Fundéu BBVA
                //https://www.fundeu.es/recomendacion/elbillion-inglesno-equivaleal-billon-espanol-858/

                if (Num.matches("[1-9][0][0][0][0][0][0][0][0][0]")) {//
                    return getNum(Num.substring(0, 1)) + " BILLONES";
                }
                String SupParte10 = getNum(Num.substring(0, 1)) + " BILLONES"; //extrayendo ABC.
                NumLengthValue subParte10 = new NumLengthValue(9, Num.substring(1), false);//primera medida de long 6
                while (subParte10.longitud > 0) {
                    subParte10 = getValue(subParte10.value);
                    if (subParte10.enc) {
                        break;
                    }
                }
                if (subParte10 != null) {
                    return SupParte10 + " " + getNum(subParte10.value);
                }
            case 11://este funciona por conjetura pues no se pudo probar con Integer ni con Long
                if (Num.matches("[1-9][0-9][0][0][0][0][0][0][0][0][0]")) {//
                    return getNum(Num.substring(0, 2)) + " BILLONES";
                }
                String SupParte11 = getNum(Num.substring(0, 2)) + " BILLONES"; //extrayendo ABC.
                NumLengthValue subParte11 = new NumLengthValue(10, Num.substring(1), false);//primera medida de long 6
                while (subParte11.longitud > 0) {
                    subParte11 = getValue(subParte11.value);
                    if (subParte11.enc) {
                        break;
                    }
                }
                if (subParte11 != null) {
                    return SupParte11 + " " + getNum(subParte11.value);
                }
        }
        return word;
    }

    public static void main(String[] args) {
        try {
            PrintWriter pf = new PrintWriter("d:\\salida.txt");
            NumToLetra num = new NumToLetra();
//            String aux = "123456";
//            System.out.println(aux + " - " + num.getNumTOLetras(String.valueOf(aux)));
            for (long i = 1000000000; i < 1000000010; i++) {

                String v = num.getNumTOLetras(String.valueOf(i));
                // if (v.length() != 0) {
                //pf.append(i + " - " + v + "\n");
                System.out.println(i + " - " + v);
                // }

            }
            pf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private NumLengthValue getValue(String v) {
        NumLengthValue aux = null;
        if (v.charAt(0) != '0') {//encontro la long q tiene
            return new NumLengthValue(v.length(), v, true);
        } else {
            if (v.length() > 0) {
                aux = getValue(v.substring(1));
            }
        }
        return aux;
    }

    public String getNumTOLetras(String value) {
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
        pos = aux.indexOf("UNO MILLON ");
        if (pos != -1) {
            aux = aux.replace("UNO MILLON ", "UN MILLON ");
        }
        pos = aux.indexOf("UNO MILLON");
        if (pos != -1) {
            aux = aux.replace("UNO MILLON", "UN MILLON");
        }
        pos = aux.indexOf("UNO BILLONES ");
        if (pos != -1) {
            aux = aux.replace("UNO BILLONES ", "UN BILLON ");
        }
        pos = aux.indexOf("UNO BILLONES");
        if (pos != -1) {
            aux = aux.replace("UNO BILLONES", "UN BILLON");
        }

        if (value.length() == 7) {
            if (value.charAt(0) == '1') {
                aux = aux.replace("MILLONES", "MILLON");
            }
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

    class NumLengthValue {

        int longitud;
        String value;
        boolean enc = false;

        public NumLengthValue(int longitud, String value, boolean enc) {
            this.longitud = longitud;
            this.value = value;
            this.enc = enc;
        }

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
