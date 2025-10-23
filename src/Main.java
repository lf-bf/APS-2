import java.util.Scanner;

public class Main {
    public static void verificarCodigo(Scanner sc, Codigo codigoObjeto, int comando) {
        int encerrarLoop = 0;
        int limiteCaracteresloop = 5;
        int limiteCaracteres = 5;
        for (int i = 1; encerrarLoop == 0 && i <= limiteCaracteresloop; ) {

            System.out.println("Codigo inserido até o momento: " + codigoObjeto.getCodigoCompleto());
                System.out.println("Limite de caracteres no codigo: 5 \n" +
                                   "Digitos Restantes: " + limiteCaracteres);
                System.out.println("Digite . ou - para incrementar o codigo ou ! para parar: ");

            // codigoObjeto.tratarCodigo(codigoObjeto.setCaractere(i, sc.nextLine()));
                Letra letrinha = new Letra();
                System.out.print("> " + codigoObjeto.getCodigoCompleto());
                letrinha.setLetrinha(sc.next());
                codigoObjeto.setCaractere(i, letrinha.getLetrinhaString());// ou nextLine()

                int codigo = letrinha.tratarLetraCodigo();
                switch (codigo) {
                    case 1:
                        codigoObjeto.setCodigoCompleto(codigoObjeto.getCodigoCompleto() + letrinha.getLetrinhaString());
                        i++;
                        limiteCaracteres--;
                        break;
                    case 2:
                        System.out.println("Parada solicitada, codigo definido: " + codigoObjeto.getCodigoCompleto());
                        encerrarLoop = 1;
                        break;
                    case 0:
                        System.out.println("Caractere inserido invalido! Apenas \".\", \"-\" ou \"!\" para finalizar! Tente novamente.");
                        break;
                    case -1:
                        System.out.println("Apenas um digito como entrada! Tente novamente.");
                        break;




                }
            }
    }
    public static void verificarLetra(Scanner sc, Letra letraObjeto, int comando) {
        String mensagemInicio = "Você não deveria ver isso, vai rever o codigo";
        mensagemInicio = switch(comando){
            case 1 -> "Digite a Letra que deseja atribuir ao codigo: ";
            case 3 -> "Insira a letra para ver seu codigo morse";
            case 4 -> "Insira a letra que deseja remover";
            default -> mensagemInicio;
        };

        int inputValido = 0;
        while (inputValido == 0) {
            System.out.println(mensagemInicio);
            System.out.print("> ");
            letraObjeto.setLetrinha(sc.nextLine());
            int codigo = letraObjeto.tratarLetra(letraObjeto);
            switch (codigo) {
                case -1:
                    System.out.println("Apenas um digito como entrada! Tente novamente.");
                    break;
                case 0:
                    System.out.println("Apenas alfabeto (a..z) e numeros (0..9). Tente novamente.");
                    break;
                case 1:
                    inputValido = 1;
                    break;
                case 2:
                    System.out.println("Parada não pode ser atendida! Tente novamente.");
                    break;
            }
        }
    }
    public static void verificarPalavra(Scanner sc, Palavra palavraObjeto, int comando) {
        int encerrarLoop = 0;
        int limiteCaracteresloop = 10;
        int limiteCaracteres = 10;
        for (int i = 1; encerrarLoop == 0 && i <= limiteCaracteresloop; ) {



            System.out.println("Palavra digitada até o momento: " + palavraObjeto.getPalavraCompleta());
            System.out.println("Limite de caracteres na palavra: 10 \n Espaços Restantes: " + limiteCaracteres);
            System.out.println("Digite uma letra (a..z) ou um numero (0..9) e aperte enter para continuar ou ! para parar: ");
            System.out.print("> ");
            palavraObjeto.setCaractere(i, sc.nextLine());
            int codigo = palavraObjeto.tratarPalavra(palavraObjeto.getCaractere(i));
            switch (codigo) {
                case 1:
                    palavraObjeto.setPalavraCompleta(palavraObjeto.getPalavraCompleta() + palavraObjeto.getCaractere(i).getLetrinhaString());
                    i++;
                    limiteCaracteres--;
                    break;
                case 2:
                    System.out.println("Parada solicitada, palavra definida: " + palavraObjeto.getPalavraCompleta());
                    encerrarLoop = 1;
                    break;
                case 0:
                    System.out.println("Caractere inserido invalido! Apenas letras (a..z), numeros (0..9), ou ! para finalizar. Tente novamente.");
                    break;
                case -1:
                    System.out.println("Apenas um digito como entrada! Tente novamente.");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        Codigo codigoObjeto = new Codigo();
        Palavra palavraObjeto = new Palavra();
        Letra letraObjeto = new Letra();
        ArvoreBinariaMorse arv = new ArvoreBinariaMorse();
        arv.inicializar();
        arv.montarBase();

        Scanner sc = new Scanner(System.in);
        int rodando = 1;
        while (rodando == 1) {

            System.out.println("\n--MENU--\n");
            System.out.println("Comandos disponíveis:");
            System.out.println("1.  ADICIONAR_CODIGO ➕");
            System.out.println("2.  BUSCAR_POR_CODIGO 🔎🔢");
            System.out.println("3.  BUSCAR_POR_LETRA 🔍🔠");
            System.out.println("4.  REMOVER_LETRA ️🗑️");
            System.out.println("5.  CODIFICAR_TEXTO 💻");
            System.out.println("6.  DECODIFICAR_MORSE 🖥️");
            System.out.println("7.  MOSTRAR_ARVORE 🌲");
            System.out.println("0.  SAIR 🏃‍♂️");

            System.out.print("> ");
            String cmd = "";
            int opcaoValida = 0;

            while (opcaoValida == 0 ) { //verificação de entrada de opção
                cmd = sc.nextLine();
                if (cmd.length() == 1) {
                    opcaoValida = switch(cmd){
                        case "1", "2", "3", "4", "5", "6", "7", "0" -> 1;
                        default -> {
                            System.out.println("Escolha das opções disponiveis! (0..7). Tente novamente.");
                            yield 0;
                        }
                    };

                }
                else {
                    System.out.println("Apenas um digito como entrada! Tente novamente.");
                }
            }


            switch (cmd) {
                case "1": //ADICIONAR_CODIGO
                    System.out.println("\n--ADICIONAR CODIGO--");
                    codigoObjeto = new Codigo();
                    letraObjeto = new Letra();
                    verificarCodigo(sc,codigoObjeto, 1);
                    verificarLetra(sc, letraObjeto, 1);
                    codigoObjeto.setLetra(letraObjeto.getLetrinhaString());
                    arv.inserir(codigoObjeto, 0);
                    break;

                case "2": //BUSCAR_POR_CODIGO
                    codigoObjeto = new Codigo();
                    verificarCodigo(sc,codigoObjeto, 2);
                    arv.buscarPorCodigo(codigoObjeto);
                    break;

                case "3": //BUSCAR_POR_LETRA
                    letraObjeto = new Letra();
                    verificarLetra(sc, letraObjeto, 3);
                    arv.buscarCodigoPorLetra(letraObjeto);
                    break;

                case "4"://REMOVER_LETRA
                    letraObjeto = new Letra();
                    verificarLetra(sc, letraObjeto, 4);
                    arv.removerLetraOrigem(letraObjeto);
                    break;

                case "5"://CODIFICAR_TEXTO
                    palavraObjeto = new Palavra();
                    verificarPalavra(sc, palavraObjeto, 5);
                    arv.codificar(palavraObjeto);
                    break;

                case "6"://DECODIFICAR_MORSE
                    codigoObjeto = new Codigo();
                    //palavraObjeto = new Palavra();
                    //letraObjeto = new Letra();
                    System.out.println("Aqui você podera criar uma frase de até 10 caracteres, iniciando recebimento de codigo Morse.");
                    verificarCodigo(sc,codigoObjeto, 6);
                    arv.decodificar(codigoObjeto);
                    break;

                case "7":
                    arv.mostrarArvore();
                    break;
                case "0":
                    rodando = 0;
                    break;
                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }

        sc.close();
        System.out.println("Sistema encerrado.");
    }
}
