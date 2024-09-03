import java.util.List;
import java.util.Scanner;

public class quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> perguntasNaruto = List.of(
                "Quantas grandes guerras ninjas ocorreram no universo de Naruto? ",
                "Quais são os nomes dos Hokages da Vila da Folha, em ordem, do primeiro ao último?",
                "Quantos episódios do anime e filmes existem no universo Naruto?"
        );
        List<String> respostasNaruto = List.of(
                "Quatro grandes guerras ninjas.",
                "Hashirama Senju, Tobirama Senju, Hiruzen Sarutobi, Minato Namikaze, Tsunade Senju, Kakashi Hatake, Naruto Uzumaki",
                "720 episódios e 11 filmes"
        );

        List<String> perguntasOnePiece = List.of(
                "Atualmente, quem é considerado o personagem mais forte em One Piece?",
                "Quais são os nomes dos dois navios do bando do Chapéu de Palha, em ordem do primeiro para o segundo?",
                "Em qual episódio ocorre a morte de Ace em One Piece?"
        );
        List<String> respostasOnePiece = List.of(
                "Joy Boy",
                "O primeiro navio é o Going Merry e o segundo é o Thousand Sunny",
                "episódio 483"
        );

        List<String> perguntasPokemon = List.of(
                "Quantos Pokémon existem até o momento no anime?",
                "Em qual região o anime de Pokémon está atualmente ambientado?",
                "Qual é o Pokémon mais forte da região atual no anime Pokémon?"
        );
        List<String> respostasPokemon = List.of(
                "existem 1010 Pokémon",
                "região de Paldea",
                "Miraidon e Koraidon"
        );

        boolean mainMenu = true;

        while (mainMenu) {
            System.out.println("Escolha um tema:");
            System.out.println("1 Naruto");
            System.out.println("2 One Piece");
            System.out.println("3 Pokémon");
            System.out.println("4 Sair");

            int escolha;
            try {
                escolha = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("ERRO AO LER A OPÇÃO. APENAS NÚMEROS PERMITIDOS DE 1 A 4");
                scanner.nextLine();
                continue;
            }

            switch (escolha) {
                case 1:
                    System.out.println("Você escolheu Naruto!");
                    iniciarquiz(scanner, perguntasNaruto, respostasNaruto);
                    break;
                case 2:
                    System.out.println("Você escolheu One Piece!");
                    iniciarquiz(scanner, perguntasOnePiece, respostasOnePiece);
                    break;
                case 3:
                    System.out.println("Você escolheu Pokémon!");
                    iniciarquiz(scanner, perguntasPokemon, respostasPokemon);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha entre 1 e 4.");
                    break;
            }
        }
        scanner.close();
    }

    private static void iniciarquiz(Scanner scanner, List<String> perguntas, List<String> respostasCorretas) {
        int score = 0;

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(perguntas.get(i));
            System.out.println("Digite sua resposta: ");
            scanner.nextLine(); // Limpar o buffer
            String respostaUsuario = scanner.nextLine().trim();

            if (respostaUsuario.equalsIgnoreCase(respostasCorretas.get(i))) {
                System.out.println("Parabéns, resposta correta!");
                score++;
            } else {
                System.out.println("Resposta errada. A resposta certa é: " + respostasCorretas.get(i));
            }
        }
        System.out.println("Sua pontuação é " + score + "/" + perguntas.size());
    }
}

