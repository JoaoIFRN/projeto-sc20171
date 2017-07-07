/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import modelo.Autor;

/**
 *
 * @author João
 */
public class AutorDAO extends DAO<Autor, Integer> implements Serializable {

    public AutorDAO() {
        super(Autor.class);
    }

}
