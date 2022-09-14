package br.com.bb.t99.dao;
import org.eclipse.microprofile.opentracing.Traced;
import br.com.bb.t99.model.Produto;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Traced
@RequestScoped
public class ProdutoDao {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public List<Produto> listarProduto()  {
        String nameQuery = "CONSULTAR_PRODUTO";

        TypedQuery<Produto> query = em
                .createNamedQuery(nameQuery, Produto.class);

        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<>();
        }
    }

    @Transactional
    public void deletarProduto(int id){

        String nameQuery = "DELETAR_PRODUTO";

         em
           .createNamedQuery(nameQuery, Produto.class)
           .setParameter("id", id)
           .executeUpdate();

    }
    
}
