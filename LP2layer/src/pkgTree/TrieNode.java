/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgTree;

import java.util.ArrayList;

/**
 *
 * @author viniciusrvk
 */
public class TrieNode {

    private String chave; //chave
    private ArrayList<TrieNode> ponteiros;
    private boolean stop;
    private Object valor; //guarda qualquer valor
    
    /**
     * <h3>Construtor</h3>
     * @param chave
     */
    public TrieNode(String chave) {
        this.chave = chave;
        ponteiros = new ArrayList<TrieNode>();
        stop = false;
    }

    /**
     *
     * @return
     */
    public String getChave() {
        return chave;
    }
    /**
     * <h3>Função para retornar valor</h3>
     * @return
     */
    public Object getValor() {return valor;}
    
    /**
     * <h3>Função para indicar parada</3>
     */
    public void stopIt(){stop = true;}
    
    /**
     * <h3>Função para retornar o valor da parada.</3>
     * @return
     */
    public boolean getStop(){return stop;}
    
    /**
     * Função para retornar os próximos nodes.
     * @return
     */
    public ArrayList<TrieNode> getPonteiroNodes(){
        return ponteiros;
    }
    
    /**
     * Função para adicionar um novo caminho.
     * @param novo
     */
    public void addPonteiro(TrieNode novo){
        ponteiros.add(novo);
    }
    
    /**
     * Função verifica se existe próximo node.
     * @param chave
     * @return
     */
    public boolean temProximoValor(String chave){
        for (TrieNode ponteiro : ponteiros) {
            if(chave.equals(ponteiro.getChave())){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param chave
     */
    public void setValor(Object valor) {
        this.valor = valor;
    }    
    
    /**
     * Função retorna o próximo node.
     * @param chave
     * @return ponteiros
     */
    public TrieNode Proximo(String chave) {
        for (TrieNode ponteiro : ponteiros) {
            if(chave.equals(ponteiro.getChave())){
                return ponteiro;
            }
        }System.out.println("retornou null");
        return null;
    }
    
    /**
     * Função retorna quantidade de filhos.
     * @return
     */
    public int qtdPnteiro() {
        return ponteiros.size();
    }
    
    /**
     * Função para remover um filho.
     * @param node
     */
    public void removePonteiro(TrieNode node){
        ponteiros.remove(node);
    }
    
    /**
     * Função para retornar o filho mais a esquerda.
     * @return
     */
    TrieNode primeiro() {
        return ponteiros.get(0);
    }
    
}
