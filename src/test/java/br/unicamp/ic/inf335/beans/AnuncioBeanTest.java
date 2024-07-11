package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class AnuncioBeanTest {
    private final URL url = new URL("http://example.com/foto1.jpg");
    private final ArrayList<URL> fotosUrl = new ArrayList<>(Collections.singleton(url));
    private final ProdutoBean produtoBean = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
    private final AnuncioBean anuncioBean = new AnuncioBean(produtoBean,fotosUrl , 0.7);

    public AnuncioBeanTest() throws MalformedURLException {
    }

    @Test
    void test_get() {
        //testando todos os get
        assertAll("anuncioBean",  () -> {
            assertEquals(anuncioBean.getProduto(), produtoBean);
            assertEquals(anuncioBean.getFotosUrl(), fotosUrl);
            assertEquals(anuncioBean.getDesconto(), 0.7);
            assertEquals(AnuncioBean.getSerialversionuid(), 1);
        });
    }

    @Test
    void test_set() throws MalformedURLException {
        URL url2 = new URL("http://example.com/foto2.jpg");
        ArrayList<URL> fotosUrl2 = new ArrayList<>(Collections.singleton(url2));
        ProdutoBean produtoBean2 = new ProdutoBean("codigo2", "nome2", "descricao2", 2.0, "estado");

        //testando todos os set
        anuncioBean.setProduto(produtoBean2);
        anuncioBean.setFotosUrl(fotosUrl2);
        anuncioBean.setDesconto(0.1);

        assertAll("anuncioBean",  () -> {
            assertEquals(anuncioBean.getProduto(), produtoBean2);
            assertEquals(anuncioBean.getFotosUrl(), fotosUrl2);
            assertEquals(anuncioBean.getDesconto(), 0.1);
        });
    }

    @Test
    void test_getValor() {
        //teste do metodo que retorna o desconto
        Double valorDesconto = anuncioBean.getValor();
        assertEquals(valorDesconto, 3.0);
    }
}
