import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TratamentoDeDados {
    // Atributos para redirecionamento de E/S
    private Scanner entrada = new Scanner(System.in);  // Atributo para entrada padrao (teclado)
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "carros-sislog.csv";  // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "saida.txt";  // Nome do arquivo de saida de dados

    // Construtor da classe de aplicacao
    public TratamentoDeDados() {
        redirecionaEntrada();    // Redireciona Entrada para arquivos
        redirecionaSaida();    // Redireciona Saida para arquivos

        // Implemente aqui o seu codigo adicional do construtor

    }

    // Redireciona Entrada de dados para arquivos em vez de teclado
    // Chame este metodo para redirecionar a leitura de dados para arquivos
    private void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    // Redireciona Saida de dados para arquivos em vez da tela (terminal)
    // Chame este metodo para redirecionar a escrita de dados para arquivos
    private void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
    }

    // Restaura Entrada padrao para o teclado
    // Chame este metodo para retornar a leitura de dados para o teclado
    private void restauraEntrada() {
        entrada = new Scanner(System.in);
    }

    // Restaura Saida padrao para a tela (terminal)
    // Chame este metodo para retornar a escrita de dados para a tela
    private void restauraSaida() {
        System.setOut(saidaPadrao);
    }

    public void executa() {
        Path path1 = Paths.get("carros-sislog.csv");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-16BE"))) {
            String linha = null;
            String[] palavras = new String[600];
            int numLinha = 0;
            while((linha = reader.readLine()) != null) {
                Scanner scanner = new Scanner(linha).useDelimiter(";");
                numLinha ++;
                palavras = linha.split(";");
            }
            Arrays.stream(palavras).sorted();
            for (int i = 0; i < palavras.length; i++) {
                System.out.println(palavras[i]);
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    }