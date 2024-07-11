package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoBeanTest {

    private final ProdutoBean produtoBean = new ProdutoBean("codigo", "nome", "descricao", 2.0, "estado");

    @Test
    void test_get() {
        //testando todos os get
        assertAll("produtoBean",  () -> {
            assertEquals(produtoBean.getCodigo(), "codigo");
            assertEquals(produtoBean.getNome(), "nome");
            assertEquals(produtoBean.getDescricao(), "descricao");
            assertEquals(produtoBean.getValor(), 2.0);
            assertEquals(produtoBean.getEstado(), "estado");
            assertEquals(ProdutoBean.getSerialversionuid(), 1);
        });
    }

    @Test
    void test_set() {
        //testando todos os set
        produtoBean.setCodigo("codigo2");
        produtoBean.setNome("nome2");
        produtoBean.setDescricao("descricao2");
        produtoBean.setValor(4.0);
        produtoBean.setEstado("estado2");

        assertAll("produtoBean",  () -> {
            assertEquals(produtoBean.getCodigo(), "codigo2");
            assertEquals(produtoBean.getNome(), "nome2");
            assertEquals(produtoBean.getDescricao(), "descricao2");
            assertEquals(produtoBean.getValor(), 4.0);
            assertEquals(produtoBean.getEstado(), "estado2");
        });
    }

    @Test
    void test_compareTo() {
        //teste da ordenacao
        var produtos = new ArrayList<ProdutoBean>();
        produtos.add(new ProdutoBean("codigo", "nome", "descricao", 5.0, "estado"));
        produtos.add(new ProdutoBean("codigo", "nome", "descricao", 9.0, "estado"));
        produtos.add(new ProdutoBean("codigo", "nome", "descricao", 12.0, "estado"));
        produtos.add(produtoBean);

        Collections.sort(produtos);

        boolean passou = false;
        var i = 0;
        //testa se o numero atual é menor que o proximo numero
        while(i < produtos.size()){
            if((i+1)==produtos.size()){break;}
            if(produtos.get(i).getValor() <= produtos.get(i+1).getValor()){
                passou = true;
            }
            else{
                passou = false;
                break;
            }
            i++;
        }
        assertTrue(passou);
    }
}
