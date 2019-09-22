package Teeste.model.dao;

import JDBC.model.bean.Categoria;
import JDBC.model.bean.dao.CategoriaDAO;
import org.junit.Test;

import static org.junit.Assert.*;

import org.hamcrest.SelfDescribing;

import java.util.List;

public class CategoriaDAOTest
{
    @Test
    public void inserir()
    {
        Categoria cat = new Categoria("Calçados");
        CategoriaDAO dao = new CategoriaDAO();

        if (dao.save(cat))
            System.out.println("salvo com sucesso");
        else
            fail("Erro ao salvar");
    }

    @Test
    public void pegarLista()
    {
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> categorias = dao.findAll();
        for (int i = 0; i < categorias.size(); i++)
        {
            System.out.println(categorias.get(i));
        }
    }

    @Test
    public void updateBd()
    {
        CategoriaDAO dao = new CategoriaDAO();
        Categoria cat = new Categoria("Roupa");
        cat.setId(1);

        if (dao.update(cat))
        {
            System.out.println("Att sucesso");
        } else
        {
            fail("ERRO");
        }
    }

    @Test
    public void deleteTest()
    {
        CategoriaDAO dao = new CategoriaDAO();
        Categoria cat = new Categoria();
        cat.setId(2);

        if (dao.delete(cat))
        {
            System.out.println("Deletado com sucesso");
        } else
        {
            fail("ERRO");
        }
    }
}
