/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Autor;
import persistencia.AutorDAO;

/**
 *
 * @author João
 */
@Named
@RequestScoped
public class AutorBean implements Serializable {

    @Inject
    private Autor autor;
    @Inject
    private AutorDAO autorDAO;
    private Integer autorId;

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public void carregarAutorPelaId() {
        this.autor = autorDAO.buscar(autorId);
    }

    public void gravar() {
        if (this.autor.getId() == null) {
            autorDAO.salvar(this.autor);
        } else {
            autorDAO.atualizar(this.autor);
        }

        this.autor = new Autor();
    }

    public void remover(Autor autor) {     
        autorDAO.remove(autor);
    }

    public List<Autor> getAutores() {
        return autorDAO.listar();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
