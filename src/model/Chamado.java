package model;



public class Chamado {

    private String requerente, setor, reclamacao, conclusao, status;

    public Chamado() {
    }

    public Chamado(String requerente, String setor, String reclamacao, String conclusao, String status) {
        this.requerente = requerente;
        this.setor = setor;
        this.reclamacao = reclamacao;
        this.conclusao = conclusao;
        this.status = status;
    }

    public String getRequerente() {
        return requerente;
    }

    public void setRequerente(String requerente) {
        this.requerente = requerente;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public String toString(){
        return "Requerente: " + getRequerente() +
                "\nSetor: " + getSetor() +
                "\nReclamação: " + getReclamacao() + 
                "\nConclusão: " + getConclusao() + 
                "\nStatus do Chamado: " + getStatus();
    }
    
}
