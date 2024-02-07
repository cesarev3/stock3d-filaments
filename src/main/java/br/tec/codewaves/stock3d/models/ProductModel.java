package br.tec.codewaves.stock3d.models;

public class ProductModel {

    private String codigo;
    private String material;
    private String tipo;
    private String cor;
    private String fabricante;
    private String fab_produto;
    private double diametro;
    private double retracao_distancia;
    private double retracao_velocidade;
    private String bico_temperaturas;
    private int temperatura_bico;
    private String mesa_temperaturas;
    private int temperatura_mesa;
    private int ventoinha;
    private boolean ativo;

    public ProductModel(){
    }

    public ProductModel(String codigo, String material, String tipo, String cor,
                        String fabricante, String fab_produto, double diametro,
                        double retracao_distancia, double retracao_velocidade,
                        String bico_temperaturas, int temperatura_bico,
                        String mesa_temperaturas, int temperatura_mesa,
                        int ventoinha, boolean ativo) {
        this.codigo = codigo;
        this.material = material;
        this.tipo = tipo;
        this.cor = cor;
        this.fabricante = fabricante;
        this.fab_produto = fab_produto;
        this.diametro = diametro;
        this.retracao_distancia = retracao_distancia;
        this.retracao_velocidade = retracao_velocidade;
        this.bico_temperaturas = bico_temperaturas;
        this.temperatura_bico = temperatura_bico;
        this.mesa_temperaturas = mesa_temperaturas;
        this.temperatura_mesa = temperatura_mesa;
        this.ventoinha = ventoinha;
        this.ativo = ativo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFab_produto() {
        return fab_produto;
    }

    public void setFab_produto(String fab_produto) {
        this.fab_produto = fab_produto;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getRetracao_distancia() {
        return retracao_distancia;
    }

    public void setRetracao_distancia(double retracao_distancia) {
        this.retracao_distancia = retracao_distancia;
    }

    public double getRetracao_velocidade() {
        return retracao_velocidade;
    }

    public void setRetracao_velocidade(double retracao_velocidade) {
        this.retracao_velocidade = retracao_velocidade;
    }

    public String getBico_temperaturas() {
        return bico_temperaturas;
    }

    public void setBico_temperaturas(String bico_temperaturas) {
        this.bico_temperaturas = bico_temperaturas;
    }

    public int getTemperatura_bico() {
        return temperatura_bico;
    }

    public void setTemperatura_bico(int temperatura_bico) {
        this.temperatura_bico = temperatura_bico;
    }

    public String getMesa_temperaturas() {
        return mesa_temperaturas;
    }

    public void setMesa_temperaturas(String mesa_temperaturas) {
        this.mesa_temperaturas = mesa_temperaturas;
    }

    public int getTemperatura_mesa() {
        return temperatura_mesa;
    }

    public void setTemperatura_mesa(int temperatura_mesa) {
        this.temperatura_mesa = temperatura_mesa;
    }

    public int getVentoinha() {
        return ventoinha;
    }

    public void setVentoinha(int ventoinha) {
        this.ventoinha = ventoinha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "codigo='" + codigo + '\'' +
                ", material='" + material + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cor='" + cor + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", fab_produto='" + fab_produto + '\'' +
                ", diametro=" + diametro +
                ", retracao_distancia=" + retracao_distancia +
                ", retracao_velocidade=" + retracao_velocidade +
                ", bico_temperaturas='" + bico_temperaturas + '\'' +
                ", temperatura_bico=" + temperatura_bico +
                ", mesa_temperaturas='" + mesa_temperaturas + '\'' +
                ", temperatura_mesa=" + temperatura_mesa +
                ", ventoinha=" + ventoinha +
                ", ativo=" + ativo +
                '}';
    }
}
