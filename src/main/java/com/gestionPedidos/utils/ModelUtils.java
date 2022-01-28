package com.gestionPedidos.utils;

public class ModelUtils {

    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            cedulaCorrecta = false;
        }

        return cedulaCorrecta;
    }

    public static boolean esSoloLetras(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.toUpperCase().charAt(i);

            int valorASCII = (int) caracter;

            if (valorASCII != 32 && valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))

                return false;

        }

        return true;
    }

    public static boolean validatePassword(String password) {
        int length = password.length();
        if (length >= 4 && length <= 15 && searchNumeroInPassword(password) && searchMayusInPassword(password))
            return true;
        return false;
    }

    private static boolean searchNumeroInPassword(String password) {
        for (Character c : password.toCharArray()) {
            if (c.equals('0') || c.equals('1') || c.equals('2') || c.equals('3') || c.equals('4')
                    || c.equals('5') || c.equals('6') || c.equals('7') || c.equals('8') || c.equals('9') )
                return true;
        }
        return false;
    }

    private static boolean searchMayusInPassword(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                return true;
        }
        return false;
    }


}
