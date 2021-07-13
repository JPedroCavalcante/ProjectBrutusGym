package br.com.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clients {
    private int matricula;
    private String nome;
    private String CttPEmergencia;
    private String DDV;
    private String CPF;
    private String email;
    private String celular;
    private String CEP;
    private String endereco;
    private int N;
    private String comp;
    private String bairro;
    private String cidade;
    private String UF; 
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCttPEmergencia() {
        return CttPEmergencia;
    }

    public void setCttPEmergencia(String CttPEmergencia) {
        this.CttPEmergencia = CttPEmergencia;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

        public String getDDV() {
        return DDV;
        
    }

    public void setDDV(String DDV) {
        this.DDV = DDV;
    }
}