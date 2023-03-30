import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    public void cria(InputStream inputstream, String nomeArquivo) throws Exception {

        BufferedImage imagemOriginal = ImageIO.read(inputstream);

        // leitura da imagem (arquivo)
        //InputStream inputstream = new FileInputStream(new File("imagens/filme.jpg"));
        //BufferedImage imagemOriginal = ImageIO.read(inputstream);

        // leitura de imagem (url)
        //InputStream inputstream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_3.jpg").openStream();
        //BufferedImage imagemOriginal = ImageIO.read(inputstream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal , 0, 0 , null);

        //Configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 90);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        
        // escrever uma frase na nova imagem
        graphics.drawString("TRANSCENDEU", largura/2 - 350 , novaAltura - 80);
        
        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saída/", nomeArquivo));
    }

}

