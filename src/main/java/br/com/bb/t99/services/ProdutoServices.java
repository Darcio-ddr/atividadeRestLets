package br.com.bb.t99.services;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;

import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.t99.dao.ProdutoDao;
import br.com.bb.t99.model.Produto;
import java.util.List;


@ApplicationScoped
@Traced
public class ProdutoServices {

    @Inject
    ProdutoDao dao;

    //@Transactional
    public List<Produto> listarProduto() {
    	return dao.listarProduto();
    }

    public List<Produto> deletarProduto(int id){
        dao.deletarProduto(id);
        return null;
    }
    
}
