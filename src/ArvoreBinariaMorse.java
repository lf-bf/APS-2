public class ArvoreBinariaMorse {

    private static class Nodo {
        String nodoCaractere;  // Caractere
        Nodo esquerda; // ponto (.)
        Nodo direita; // traço (-)
        Nodo(String c) { this.nodoCaractere = c; }
    }

    private Nodo raiz = new Nodo("");

    // Inicializa a árvore
    public void inicializar() {
        raiz = new Nodo("");
    }

    // Insere uma letra conforme o código morse
    public void inserir(Codigo codigoObjeto, int varInicializar) {


        Nodo atual = raiz;  // atual representa o nodo atual que estamos, inicializa na raiz
        for (int i = 1; i <= codigoObjeto.codigoCompleto.length(); i++) {   // loopa pelo codigoObjeto usando o tamanho da string com o codigo morse como parametro
            Letra s = codigoObjeto.getCaractere(i);                         // s recebe o caractere do codigo morse no index i
            switch (s.getLetrinhaString()) {
                case ".":                                                   //verifica se carectere é um ponto
                    if (atual.esquerda == null) atual.esquerda = new Nodo("");     //Se for um ponto, verifica se existe um nodo a esquerda do "diretorio" atual para ser percorrido, se não existir cria um vazio
                    atual = atual.esquerda;                                      //se existir um a esquerda, "entra" no "diretorio"
                    break;
                case "-":
                    if (atual.direita == null) atual.direita = new Nodo("");     //Se for um traço, verifica se existe um nodo a direita do "diretorio" atual para ser percorrido, se não existir cria um vazio
                    atual = atual.direita;                                      //se existir um a direita, "entra" no "diretorio"
                    break;
                default:
                    return;                                                  // caso s não seja nenhum dos dois, retorna a função sem inserir nada
            }

        }
        atual.nodoCaractere = codigoObjeto.getLetra();                                  //apos "criar o diretorio" ele atribui a letra ao nodo
        if (varInicializar == 0) {
            System.out.println("Letra " + codigoObjeto.getLetra() + " adicionada com código " + codigoObjeto.getCodigoCompleto()); // mensagem de sucesso
        }

    }

    // Busca uma letra pelo código
    public String buscarPorCodigo(Codigo codigoObjeto) {
        //if (codigo == null || codigo.length() == 0) return "?";

        Nodo atual = raiz;         // atual representa o no atual que estamos, inicializa na raiz
        for (int i = 1; i <= codigoObjeto.codigoCompleto.length(); i++) { //loopa pelo codigoObjeto usando o tamanho da string codigo como parametro
            Letra s = codigoObjeto.getCaractere(i);
            switch (s.getLetrinhaString()) {
                case ".":
                    if (atual.esquerda == null) break;
                    atual = atual.esquerda;
                    break;
                case "-":
                    if (atual.direita == null) break;
                    atual = atual.direita;
                    break;
                default:
                    break;
            }
        }

        codigoObjeto.setLetra( switch (atual.nodoCaractere) {
            case "" -> "?";
            case null -> "?";
            default -> atual.nodoCaractere;
        });
        System.out.println("Código " + codigoObjeto.getCodigoCompleto() + " corresponde à letra: " + codigoObjeto.getLetra());
        return codigoObjeto.getLetra();
    }

    // Chama função recursiva para buscar código de uma letra
    public void buscarCodigoPorLetra(Letra letrinha) {
        String letra = letrinha.getLetrinhaString();                      //Insere a letra de codigoObjeto em letra

        String resultado = buscarCodigo(raiz, letra, "");    //Chama a função recursiva e atribui o que foi achado em resultado

        String caminho = switch (resultado) {                        // garante que caminho tenha dados validos para serem impressos
            case "" -> "?";
            case null -> "?";
            default -> resultado;
        };

        System.out.println("Letra " + letra + " corresponde ao código: " + caminho);    //imprime resultado da busca
    }


    private String buscarCodigo(Nodo nodo, String letra, String caminho) {
        if (nodo == null) return null;                                                              // se o nodo atual for nulo, retorna
        if (nodo.nodoCaractere == letra) return caminho;                                                       // se o caractere armazenado no "diretorio" atual for igual ao alvo, retorna caminho percorrido
        String achou = buscarCodigo(nodo.esquerda, letra, caminho + ".");                     // chama a função novamente percorrendo o caminho da esquerda (".") até encontrar a letra ou achar um nodo nulo
        if (achou != null) return achou;                                                            // se achou for diferente de nulo, volta na recursão
        return buscarCodigo(nodo.direita, letra, caminho + "-");                             // e caso tenha chego ao final sem encontrar a letra pedida, volta para o . mais antigo e troca a busca por -
    }

    // Remove uma letra (sem destruir a estrutura)
    public void removerLetraOrigem(Letra letraObjeto) {
        String letra = letraObjeto.getLetrinhaString();                                         //Insere a letra de codigoObjeto em letra
        int sucesso = removerLetra(raiz, letra);                                        //Chama a função recursiva e atribui o resultado da remoção em sucesso
        System.out.println(sucesso == 1 ? "Letra " + letra + " removida com sucesso!"   //Mensagem de sucesso
                                        : "Letra" + letra + " não encontrada.");        //Mensagem de falha
    }

    private int removerLetra(Nodo nodo, String letra) {
        if (nodo == null) return 0;     // se o nodo atual for nulo, retorna 0
        if (nodo.nodoCaractere == letra) {         // se a letra do nodo atual for igual a que esta sendo procurada
            nodo.nodoCaractere = "";               // "apaga" caractere atribuindo uma string vazia
            return 1;                   // retorna sucesso
        }
        int achou = removerLetra(nodo.esquerda, letra); // chama a função novamente percorrendo o caminho da esquerda (".") até encontrar a letra ou achar um nodo nulo
        if (achou == 1) return 1;                  // se achou, retorna 1
        return removerLetra(nodo.direita, letra);      // e caso tenha chego ao final sem encontrar a letra pedida, volta para o . mais antigo e troca a busca por -
    }

    // Codifica um texto em Morse
    public void codificar(Palavra palavraObjeto) {
        if (palavraObjeto.getPalavraCompleta() == null) {
            System.out.println("Resultado em Morse: " + " ");
        }
        String out = "";
        int i = 1;
        while (i <= palavraObjeto.getPalavraCompleta().length()) {
            Letra letrinha = new Letra();
            letrinha.setLetrinha((palavraObjeto.getCaractere(i)).getLetrinhaString());
            String code = buscarCodigo(raiz, letrinha.getLetrinhaString(), "");
            if (code != null) out = out + code + " ";
            i = i + 1;
        }
            System.out.println("Resultado em Morse: " + out);
    }

    // Decodifica código Morse para texto
    public void decodificar(Codigo codigoObjeto) {
        String morse = codigoObjeto.getCodigoCompleto();
        if (morse == null) System.out.println("Resultado traduzido: " + "(erro)");
        String resultado = "";
        String token = "";
        int i = 1;
        while (i <= morse.length()) {
            Letra c = new Letra();
            c.setLetrinha(codigoObjeto.getCaractere(i).getLetrinhaString());
            if (c.getLetrinhaString() == "") {
                if (token.length() > 0) {
                    if (token == ("/")) {
                        resultado = resultado + " ";
                    } else {
                        Letra letrinha = new Letra();
                        letrinha.setLetrinha(buscarPorCodigo(codigoObjeto));
                        resultado = resultado + letrinha;
                    }
                    token = "";
                }
            } else {
                token = token + c.getLetrinhaString();
            }
            i = i + 1;
        }
        if (token.length() > 0) {
            if (token.equals("/")) {
                resultado = resultado + "";
            } else {
                String letra = buscarPorCodigo(codigoObjeto);
                resultado = resultado + letra;
            }
        }
        System.out.println("(correto)Resultado traduzido: " + resultado);
    }

    // Mostra a árvore completa de forma hierárquica
    public void mostrarArvore() {
        System.out.println("(raiz)");
        exibirRec(raiz.esquerda, "", 1, ".");
        exibirRec(raiz.direita, "", 0, "-");
    }

    private void exibirRec(Nodo no, String prefixo, int esquerda, String caminho) {
        if (no == null) return;
        String conector = (esquerda == 1) ? "├─· " : "└─- ";
        String rotulo = (no.nodoCaractere == "") ? "(" + caminho + ")" : "(" + caminho + ") " + no.nodoCaractere;
        System.out.println(prefixo + conector + rotulo);

        String proxPref = (esquerda == 1) ? prefixo + "│   " : prefixo + "    ";
        exibirRec(no.esquerda, proxPref, 1, caminho + ".");
        exibirRec(no.direita, proxPref, 0, caminho + "-");
    }

    // Carrega tabela A–Z e 0–9
    public void montarBase() {
        //Letras da nossa arvore

        inserir(new Codigo(".", "-", "",  "",  "",  ".-",   "A"), 1);
        inserir(new Codigo("-", ".", ".", ".", "",  "-...", "B"), 1);
        inserir(new Codigo("-", ".", "-", ".", "",  "-.-.", "C"), 1);
        inserir(new Codigo("-", ".", ".", "",  "",  "-..",  "D"), 1);
        inserir(new Codigo(".", "",  "",  "",  "",  ".",    "E"), 1);
        inserir(new Codigo(".", ".", "-", ".", "",  "..-.", "F"), 1);
        inserir(new Codigo("-", "-", ".", "",  "",  "--.",  "G"), 1);
        inserir(new Codigo(".", ".", ".", ".", "",  "....", "H"), 1);
        inserir(new Codigo(".", ".", "",  "",  "",  "..",   "I"), 1);
        inserir(new Codigo(".", "-", "-", "-", "",  ".---", "J"), 1);
        inserir(new Codigo("-", ".", "-", "",  "",  "-.-",  "K"), 1);
        inserir(new Codigo(".", "-", ".", ".", "",  ".-..", "L"), 1);
        inserir(new Codigo("-", "-", "",  "",  "",  "--",   "M"), 1);
        inserir(new Codigo("-", ".", "",  "",  "",  "-.",   "N"), 1);
        inserir(new Codigo("-", "-", "-", "",  "",  "---",  "O"), 1);
        inserir(new Codigo(".", "-", "-", ".", "",  ".--.", "P"), 1);
        inserir(new Codigo("-", "-", ".", "-", "",  "--.-", "Q"), 1);
        inserir(new Codigo(".", "-", ".", "",  "",  ".-.",  "R"), 1);
        inserir(new Codigo(".", ".", ".", "",  "",  "...",  "S"), 1);
        inserir(new Codigo("-", "",  "",  "",  "",  "-",    "T"), 1);
        inserir(new Codigo(".", ".", "-", "",  "",  "..-",  "U"), 1);
        inserir(new Codigo(".", ".", ".", "-", "",  "...-", "V"), 1);
        inserir(new Codigo(".", "-", "-", "",  "",  ".--",  "W"), 1);
        inserir(new Codigo("-", ".", ".", "-", "",  "-..-", "X"), 1);
        inserir(new Codigo("-", ".", "-", "-", "",  "-.--", "Y"), 1);
        inserir(new Codigo("-", "-", ".", ".", "",  "--..", "Z"), 1);

        
        //numeros da nossa arvore morse 
        inserir(new Codigo("-", "-", "-", "-", "-",  "-----", "0"), 1);
        inserir(new Codigo(".", "-", "-", "-", "-",  ".----", "1"), 1);
        inserir(new Codigo(".", ".", "-", "-", "-",  "..---", "2"), 1);
        inserir(new Codigo(".", ".", ".", "-", "-",  "...--", "3"), 1);
        inserir(new Codigo(".", ".", ".", ".", "-",  "....-", "4"), 1);
        inserir(new Codigo(".", ".", ".", ".", ".",  ".....", "5"), 1);
        inserir(new Codigo("-", ".", ".", ".", ".",  "-....", "6"), 1);
        inserir(new Codigo("-", "-", ".", ".", ".",  "--...", "7"), 1);
        inserir(new Codigo("-", "-", "-", ".", ".",  "---..", "8"), 1);
        inserir(new Codigo("-", "-", "-", "-", ".",  "----.", "9"), 1);

    }
}
