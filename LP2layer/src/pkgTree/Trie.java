/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgTree;

/**
 *
 * @author viniciusrvk
 */
public class Trie {
    private TrieNode raiz;
    private int cout;

    public Trie() {
        raiz = new TrieNode("/");
        cout = 0;
    }
    public TrieNode getRaiz(){
        return raiz;
    }
    public int getCout() {
		return cout;
	}
    public void insert(String chave, Object valor){
        TrieNode corredor = raiz;
        for(int i=0; i<chave.length(); i++){
        	//System.out.println(chave.length()+" "+i+" "+chave.substring(i, i+1));
            if(!corredor.temProximoValor(chave.substring(i, i+1))){
                TrieNode novo = new TrieNode(chave.substring(i, i+1));
                corredor.addPonteiro(novo);
                corredor = corredor.Proximo(chave.substring(i, i+1));
            }else{
            	//System.out.println(chave.length()+" "+i+" "+chave.substring(i, i+1)+" else");
                corredor = corredor.Proximo(chave.substring(i, i+1));
            }
        }
        corredor.stopIt();
        corredor.setValor(valor);
        cout++;
    }

    public boolean search(String str) {
        
        TrieNode corredor = raiz;
        for(int i=0; i<str.length(); i++){
            if(corredor.temProximoValor(str.substring(i, i+1))){
                corredor = corredor.Proximo(str.substring(i, i+1));
            }else{
                return false;
            }
        }
        return corredor.getStop()==true ? true:false;
    }
    public Object getValor(String str) {
    	TrieNode corredor = raiz;
        for(int i=0; i<str.length(); i++){
            if(corredor.temProximoValor(str.substring(i, i+1))){
                corredor = corredor.Proximo(str.substring(i, i+1));
            }else{
                return null;
            }
        }
        return corredor.getValor();
    }
    
    public boolean remove(String str){
        TrieNode corredor = raiz;
        for(int i=0; i<str.length(); i++){
            if(corredor.temProximoValor(str.substring(i, i+1)) && corredor.Proximo(str.substring(i, i+1)).qtdPnteiro() < 2){
                corredor.removePonteiro(corredor.Proximo(str.substring(i, i+1)));
                return true;
            }
        }
        //System.out.println("Já nao existia");
        return true;
    }
    
    public void show(){
        show(raiz, "");
    }
    private void show(TrieNode raiz, String str){
        if(raiz.getPonteiroNodes().isEmpty()){
            // retorna
        }else{
            for (TrieNode node : raiz.getPonteiroNodes()) {
                if(node.getStop()==true){
                    System.out.println(str+node.getChave());
                }else {
                	show(node, str+node.getChave());
                }
            }
        }
    }
}
