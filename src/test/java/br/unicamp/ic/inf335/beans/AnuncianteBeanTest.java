package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class AnuncianteBeanTest {
    private final URL url = new URL("http://example.com/foto1.jpg");
    private final ArrayList<URL> fotosUrl = new ArrayList<>(Collections.singleton(url));
    private final ProdutoBean produtoBean = new ProdutoBean("codigo", "nome", "descricao", 5.0, "estado");
    private final AnuncioBean anuncioBean = new AnuncioBean(produtoBean,fotosUrl , 0.7);
    private final ArrayList<AnuncioBean> anuncios = new ArrayList<>(Collections.singleton(anuncioBean));
    private final AnuncianteBean anuncianteBean = new AnuncianteBean("nome", "CPF", anuncios );

    public AnuncianteBeanTest() throws MalformedURLException {
    }

    @Test
    void test_get() {
        //testando todos os get
        assertAll("anuncianteBean",  () -> {
            assertEquals(anuncianteBean.getNome(), "nome");
            assertEquals(anuncianteBean.getCPF(), "CPF");
            assertEquals(anuncianteBean.getAnuncios(), anuncios);
        });
    }

    @Test
    void test_set() throws MalformedURLException {
        URL url2 = new URL("http://example.com/foto2.jpg");
        ArrayList<URL> fotosUrl2 = new ArrayList<>(Collections.singleton(url2));
        ProdutoBean produtoBean2 = new ProdutoBean("codigo2", "nome2", "descricao2", 2.0, "estado");
        AnuncioBean anuncioBean2 = new AnuncioBean(produtoBean2,fotosUrl2 , 0.3);
        ArrayList<AnuncioBean>  anuncios2 =  new ArrayList<>(Collections.singleton(anuncioBean2));

        //testando todos os set
        anuncianteBean.setNome("nome2");
        anuncianteBean.setCPF("CPF2");
        anuncianteBean.setAnuncios(anuncios2);

        assertAll("anuncianteBean",  () -> {
            assertEquals(anuncianteBean.getNome(), "nome2");
            assertEquals(anuncianteBean.getCPF(), "CPF2");
            assertEquals(anuncianteBean.getAnuncios(), anuncios2);
        });
    }

    @Test
    void test_addRemoveAnuncio() throws MalformedURLException {
        //teste adicionar e remover anuncio anuncio
        URL url2 = new URL("http://example.com/foto2.jpg");
        ArrayList<URL> fotosUrl2 = new ArrayList<>(Collections.singleton(url2));
        ProdutoBean produtoBean2 = new ProdutoBean("codigo2", "nome2", "descricao2", 2.0, "estado");
        AnuncioBean anuncioBean2 = new AnuncioBean(produtoBean2, fotosUrl2, 0.3);

        ArrayList<AnuncioBean> valorEsperado = new ArrayList<>();
        valorEsperado.add(anuncioBean);
        valorEsperado.add(anuncioBean2);

        anuncianteBean.addAnuncio(anuncioBean2);

        assertEquals(anuncianteBean.getAnuncios(),valorEsperado);

        ArrayList<AnuncioBean> valorEsperado2 =  new ArrayList<>(Collections.singleton(anuncioBean2));

        anuncianteBean.removeAnuncio(0);
        assertEquals(anuncianteBean.getAnuncios(),valorEsperado2);


    }

    @Test
    void test_valorMedio() throws MalformedURLException {
        URL url2 = new URL("http://example.com/foto2.jpg");
        ArrayList<URL> fotosUrl2 = new ArrayList<>(Collections.singleton(url2));
        ProdutoBean produtoBean2 = new ProdutoBean("codigo2", "nome2", "descricao2", 10.0, "estado");
        AnuncioBean anuncioBean2 = new AnuncioBean(produtoBean2, fotosUrl2, 0.3);
        anuncianteBean.addAnuncio(anuncioBean2);



        Double valorMedio = anuncianteBean.valorMedioAnuncios();

        assertEquals(valorMedio,7.5);

    }

}
