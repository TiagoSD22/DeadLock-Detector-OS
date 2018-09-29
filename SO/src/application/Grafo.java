package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Grafo<V> {
    public int n_vertices;
    public Map<V,List<V>> vizinhos = new HashMap<V,List<V>>();
    public Map<V,String> cores = new HashMap<V,String>();
    public List<ArrayList<V>> ciclos = new ArrayList<ArrayList<V>>();
    public List<V> impedidos = new ArrayList<V>();
    public List<V> livres = new ArrayList<V>();
    
    public void set_N_Vertices(int n){
    	n_vertices = n;
    }
    
    public String toString () {
        StringBuffer s = new StringBuffer();
        for (V v: vizinhos.keySet()) s.append("\n    " + v + " -> " + vizinhos.get(v));
        return s.toString();                
    }
    
    public void add (V vertice) {
        if (vizinhos.containsKey(vertice)) return;
        vizinhos.put(vertice, new ArrayList<V>());
    }
    
    public void Remover(V v){
    	if(!vizinhos.containsKey(v))return;
    	if(!cores.containsKey(v)) return;
    	cores.remove(v);
    	cores.keySet().remove(v);
    	for (V u : vizinhos.keySet()){
    		if(vizinhos.get(u).contains(v)){
    			vizinhos.get(u).remove(v);
    		}
    		if(vizinhos.get(v).contains(u)){
    			vizinhos.get(v).remove(u);
    		}
    	}
    	vizinhos.keySet().remove(v);
    }
    
    public boolean contains (V vertice) {
        return vizinhos.containsKey(vertice);
    }
    
    public void add (V from, V to) {
        this.add(from); this.add(to);
        vizinhos.get(from).add(to);
    }
    
    public void Remover (V from, V to) {
        if (!(this.contains(from) && this.contains(to))){
        	System.out.println(from + " " + to);
            throw new IllegalArgumentException("Vertice Inexistente");
        }
        vizinhos.get(from).remove(to);
    }
    
    public boolean DFSUtil(V inicio, List<V> vertices){
    	cores.put(inicio, "CINZA");
    	vertices.add(inicio);
    	Iterator<V> i = vizinhos.get(inicio).listIterator();
    	while(i.hasNext()){
    		V n = i.next();
    		if(cores.get(n) == "CINZA"){
    			int j = 0;
    			while(j < vertices.size() && vertices.get(j) != n){
    				cores.put(vertices.get(j),"BRANCO");
    				j++;
    			}
    			return true;
    		}
    		if(cores.get(n) == "BRANCO" && DFSUtil(n,vertices))return true;
    	}
    	cores.put(inicio,"PRETO");
    	vertices.remove(inicio);
    	return false;
    }
    
    public boolean Possui_Ciclos(){
    	boolean saida = false;
    	ciclos.clear();
    	impedidos.clear();
    	livres.clear();
    	List<V> vertices = new ArrayList<V>();
    	for(V v : vizinhos.keySet()){
    		cores.put(v, "BRANCO");
    	}
    	for(V v : vizinhos.keySet()){
    		if(cores.get(v) == "BRANCO")
    			if(DFSUtil(v,vertices)){
    				ArrayList<V> vertices_no_ciclo = new ArrayList<V>();
    				for(V u: cores.keySet()){
    					if(cores.get(u) == "CINZA"){
    						vertices_no_ciclo.add(u);
    					}
    				}
    				if(!ciclos.contains(vertices_no_ciclo))
    					ciclos.add(vertices_no_ciclo);
    				vertices.clear();
    				for(V c : cores.keySet()){
    					cores.put(c, "BRANCO");
    				}
    				saida = true;
    			}
    	}
    	return saida;
    }
    
    public boolean Vertice_Bloqueado(V vertice){
    	Iterator<ArrayList<V>> v = ciclos.listIterator();
    	while(v.hasNext()){
    		if(v.next().contains(vertice))
    			return true;
    	}
    	return false;
    }
    
    public boolean Vertice_Afetado_Por_Ciclo(V vertice){
    	if(Vertice_Bloqueado(vertice))
    		return true;
    	Iterator<V> v = vizinhos.get(vertice).listIterator();
    	while(v.hasNext()){
    		if(Vertice_Afetado_Por_Ciclo(v.next())){
    			return true;
    		}
    	}
		return false;
	}
    
    public void Encontrar_Vertices_Impedidos(){
    	for(V v : vizinhos.keySet()){
    		if(!Vertice_Bloqueado(v)){
    			if(Vertice_Afetado_Por_Ciclo(v)){
    				impedidos.add(v);
    			}
    		}
    	}
    }
    
    public void Encontrar_Vertices_Livres(){
    	for(V v : vizinhos.keySet())
    		if(!Vertice_Bloqueado(v) && !Vertice_Afetado_Por_Ciclo(v))
    			livres.add(v);
    }
}
