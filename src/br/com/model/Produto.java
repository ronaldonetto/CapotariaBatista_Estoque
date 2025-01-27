package br.com.model;

import java.time.LocalDate;
/**
 *
 * @author ronaldo neto
 */
public class Produto {
    
    private String os;
    private String produto;
    private int quantidade;
    private double metragem;
    private String categoria;
    private String descricao;
    private LocalDate dataCadastro;
    private String fornecedor;
    private String unidadeMedida;
    
    
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
     *@param fornecedor Fornecedor do produto.
     *@param unidadeMedida Unidade de medida do produto.
     *
    */
    public Produto(String os, String produto, int quantidade, double metragem, String categoria, String descricao,
            LocalDate dataCadastro, String fornecedor, String unidadeMedida) {
       
       this.os = os;
       this.produto = produto;
       this.metragem = metragem;
       this.quantidade = quantidade;
       this.categoria = categoria;
       this.descricao = descricao;
       this.dataCadastro = dataCadastro;
       this.fornecedor = fornecedor;
       this.unidadeMedida = unidadeMedida;
       
    }
    
    //Getters e Setters
    
    public String getOs() {
        return os;
    }
    
    public void setOs(String os) {
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
    
    public LocalDate getDataCadastro(){
        return dataCadastro;
    }
    
    public void setDataCadastro(LocalDate dataCadastro){
        this.dataCadastro = dataCadastro;
    }
    
    public String getFornecedor(){
        return fornecedor;
    }
    
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    
    public String getUnidadeMedida(){
        return unidadeMedida;
    }
    
    public void setUnidadeMedida(String unidadeMedida){
        this.unidadeMedida = unidadeMedida;
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
        return "Produto{" +
                "os='" + os + '\'' +
                ", produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", metragem=" + metragem +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", fornecedor='" + fornecedor + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                '}'; 
    }
}
