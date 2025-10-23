public class Codigo {
    Letra caractere1;
    Letra caractere2;
    Letra caractere3;
    Letra caractere4;
    Letra caractere5;
    String codigoCompleto;
    String letra;


    public Codigo() { //construtor basico
        caractere1 = new Letra();
        caractere2 = new Letra();
        caractere3 = new Letra();
        caractere4 = new Letra();
        caractere5 = new Letra();
        codigoCompleto = "";
        letra = "";
    }
    public Codigo(String caractere1, String caractere2, String caractere3, String caractere4, String caractere5, String codigoCompleto, String letra) { //construtor para montarBase()
        this();
        this.caractere1.setLetrinha(caractere1);
        this.caractere2.setLetrinha(caractere2);
        this.caractere3.setLetrinha(caractere3);
        this.caractere4.setLetrinha(caractere4);
        this.caractere5.setLetrinha(caractere5);
        this.codigoCompleto = codigoCompleto;
        this.letra = letra;
    }





    public void setCaractere(int i, String caractere) {
        switch (i) {
            case 1 -> caractere1.setLetrinha(caractere);
            case 2 -> caractere2.setLetrinha(caractere);
            case 3 -> caractere3.setLetrinha(caractere);
            case 4 -> caractere4.setLetrinha(caractere);
            case 5 -> caractere5.setLetrinha(caractere);
        }

    }

    public Letra getCaractere(int i) {
        return switch (i) {
            case 1 -> caractere1;
            case 2 -> caractere2;
            case 3 -> caractere3;
            case 4 -> caractere4;
            case 5 -> caractere5;
            default -> null;
        };
    }

    public String getLetra() {
        return letra;
    }

    public void setCodigoCompleto(String codigoCompleto) {
        this.codigoCompleto = codigoCompleto;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public String getCodigoCompleto() {
        return codigoCompleto;
    }


    public int tratarCodigo(Letra letrinha) {
        return letrinha.tratarLetraCodigo();
    }
}
