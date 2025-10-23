public class Palavra {
    Letra caractere1;
    Letra caractere2;
    Letra caractere3;
    Letra caractere4;
    Letra caractere5;
    Letra caractere6;
    Letra caractere7;
    Letra caractere8;
    Letra caractere9;
    Letra caractere10;
    String palavraCompleta = "";
    Letra vazio;


    public Palavra() {
        caractere1 = new Letra();
        caractere2 = new Letra();
        caractere3 = new Letra();
        caractere4 = new Letra();
        caractere5 = new Letra();
        caractere6 = new Letra();
        caractere7 = new Letra();
        caractere8 = new Letra();
        caractere9 = new Letra();
        caractere10 = new Letra();
        vazio = new Letra();
        palavraCompleta = "";
    }



    public void setPalavraCompleta(String palavraCompleta) {
        this.palavraCompleta = palavraCompleta;
    }

    public String getPalavraCompleta() {
        return palavraCompleta;
    }

    public void setCaractere(int i, String letrinha) {
        switch (i) {
            case 1 -> caractere1.setLetrinha(letrinha);
            case 2 -> caractere2.setLetrinha(letrinha);
            case 3 -> caractere3.setLetrinha(letrinha);
            case 4 -> caractere4.setLetrinha(letrinha);
            case 5 -> caractere5.setLetrinha(letrinha);
            case 6 -> caractere6.setLetrinha(letrinha);
            case 7 -> caractere7.setLetrinha(letrinha);
            case 8 -> caractere8.setLetrinha(letrinha);
            case 9 -> caractere9.setLetrinha(letrinha);
            case 10 -> caractere10.setLetrinha(letrinha);
        }

    }

    public Letra getCaractere(int i) {
        return switch (i) {
            case 1 -> caractere1;
            case 2 -> caractere2;
            case 3 -> caractere3;
            case 4 -> caractere4;
            case 5 -> caractere5;
            case 6 -> caractere6;
            case 7 -> caractere7;
            case 8 -> caractere8;
            case 9 -> caractere9;
            case 10 -> caractere10;
            default -> null;
        };
    }
    public int tratarPalavra(Letra letrinha) {
        return letrinha.tratarLetra(letrinha);
    }
}
