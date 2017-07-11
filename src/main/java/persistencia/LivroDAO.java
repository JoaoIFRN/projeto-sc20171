/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Livro;

/**
 *
 * @author João
 */
public class LivroDAO extends DAO<Livro,Integer> {
    
    public LivroDAO() {
        super(Livro.class);
    }
    
}
