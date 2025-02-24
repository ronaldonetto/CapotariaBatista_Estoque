package br.com.model;

import java.time.LocalDateTime;

/**
 *
 * @author ronaldo neto
 */
public class Produto {
    
    private int os;
    private String produto;
    private int quantidade;
    private double metragem;
    private String categoria;
    private String descricao;
    private LocalDateTime dataCadastro;
    private String fornecedor;
    
    
    
    public Produto(){
        //Construor vázio
    }
    
    /*
     *Construtor com todos os campos
     *
     *@param os Código da OS (Ordem de serviço).
     *@param produto nome do produto.
     *@param quantidade Quantidade disponível.
     *@param metragem Metragem do produto.
     *@param categoria Categoria do produto.
     *@param descricao Descrição do produto.
     *@param dataCadastro Data de cadastro do produto.
     *@param horaCadastro Hora do cadastro do produto.
     *@param fornecedor Fornecedor do produto.
     *
    */
    public Produto(int os, String produto, int quantidade, double metragem, String categoria, String descricao,
            LocalDateTime dataCadastro, String fornecedor) {
       
       this.os = os;
       this.produto = produto;
       this.metragem = metragem;
       this.quantidade = quantidade;
       this.categoria = categoria;
       this.descricao = descricao;
       this.dataCadastro = dataCadastro;
       this.fornecedor = fornecedor;
       
    }
    
    //Getters e Setters
    
    public int getOs() {
        return os;
    }
    
    public void setOs(int os) {
        this.os = os;
    }
    
    public String getProduto() {
        return produto;
    }
    
    public void setProduto(String produto) {
        this.produto = produto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        if(quantidade <0){
            throw new IllegalArgumentException("A quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }
    
    public double getMetragem(){
        return this.metragem;
    }
    
    public void setMetragem(double metragem){
        this.metragem = metragem;
    }
    
    public String getCategoria(){
        return this.categoria;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public LocalDateTime getDataCadastro(){
        return dataCadastro;
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro){
        this.dataCadastro = dataCadastro;
    }
    
    public String getFornecedor(){
        return fornecedor;
    }
    
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    
    
    /**
     * 
     * Representação textual da classe Produto.
     * 
     * 
     * @return String com os detalhes do produto.
     */
    @Override
    public String toString() {
        return String.format("OS: %d | Produto: %s | Categoria: %s | Quantidade: %d | Metragem: %.2f m²", 
            os, produto, categoria, quantidade, metragem);
    }
}
