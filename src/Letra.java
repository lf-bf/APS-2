import java.util.Scanner;

public class Letra {

        private String letrinhaString = "";

        public Letra() {
        }

        public Letra(String s) {
            this.letrinhaString = (s == null) ? "" : s;
        }

        public String getLetrinhaString() {
            return letrinhaString;
        }

        public void setLetrinha(String s) {
            this.letrinhaString = (s == null) ? "" : s;
        }


        public int tratarLetra(Letra letrinha) {
            int codigoSaida;
            if (letrinha.getLetrinhaString().length() == 1) {
                codigoSaida = 1; // sucesso
                letrinha.setLetrinha( switch (letrinha.getLetrinhaString()) {
                    case "a", "A" -> "A";
                    case "b", "B" -> "B";
                    case "c", "C" -> "C";
                    case "d", "D" -> "D";
                    case "e", "E" -> "E";
                    case "f", "F" -> "F";
                    case "g", "G" -> "G";
                    case "h", "H" -> "H";
                    case "i", "I" -> "I";
                    case "j", "J" -> "J";
                    case "k", "K" -> "K";
                    case "l", "L" -> "L";
                    case "m", "M" -> "M";
                    case "n", "N" -> "N";
                    case "o", "O" -> "O";
                    case "p", "P" -> "P";
                    case "q", "Q" -> "Q";
                    case "r", "R" -> "R";
                    case "s", "S" -> "S";
                    case "t", "T" -> "T";
                    case "u", "U" -> "U";
                    case "v", "V" -> "V";
                    case "w", "W" -> "W";
                    case "x", "X" -> "X";
                    case "y", "Y" -> "Y";
                    case "z", "Z" -> "Z";
                    case "ç", "Ç" -> "Ç";
                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> letrinha.getLetrinhaString();
                    case "!" -> {
                        codigoSaida = 2; // parada
                        yield "";
                    }

                    default -> {
                        codigoSaida = 0; // caractere invalido
                        yield "";
                    }
                });
            } else {
                codigoSaida = -1; // quantidade superior a 1
            }
            return codigoSaida;
        }

        public int tratarLetraPalavra(Letra letrinha) {
            return tratarLetra(letrinha);
        }

        // usa o próprio estado; não recebe parâmetro
        public int tratarLetraCodigo() {
            if (letrinhaString.length() != 1) return -1;
            switch (letrinhaString) {
                case ".":
                case "-":
                    return 1;               // válido
                case "!":
                    letrinhaString = "";    // limpar
                    return 2;               // parar
                default:
                    letrinhaString = "";
                    return 0;               // inválido
            }
        }


    }


