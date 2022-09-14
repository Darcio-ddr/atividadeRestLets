package br.com.bb.t99.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.NamedNativeQueries;

@Entity
@Table(name="PRODUTOS", schema="exemplo")
@NamedNativeQueries({
    
    @NamedNativeQuery(name="CONSULTAR_PRODUTO", 
    query = "SELECT id, nome, descricao, preco FROM exemplo.PRODUTOS", resultClass = Produto.class),
    @NamedNativeQuery(name="DELETAR_PRODUTO", 
    query = "DELETE FROM exemplo.PRODUTOS where id =:id", resultClass = Produto.class),

})

public class Produto {
    
   
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

   public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    // @NotNull(message = "Nome é obrigatorio")
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private String descricao;
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //@NotNull(message = "Preço é obrigatorio")
    private double preco;
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    /* private BigDecimal desconto;
    public BigDecimal getDesconto() {
        return desconto;
    }
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
    private Integer estoque;
    public Integer getEstoque() {
        return estoque;
    }
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    private String foto;
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    } */
}
