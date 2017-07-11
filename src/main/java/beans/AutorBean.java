/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Autor;
import persistencia.AutorDAO;

/**
 *
 * @author João
 */
@Named
@SessionScoped
public class AutorBean implements Serializable {

    @Inject
    private Autor autor;
    @Inject
    private AutorDAO autorDAO;
    private Integer autorId;
    private DataModel<Autor> autores;

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

    public void atualizar() {
        this.autor = autores.getRowData();        
    }

    public void remover(Autor autor) {
        autorDAO.remove(autor);
        this.autor = new Autor();
    }

    public DataModel<Autor> getAutores() {
        List<Autor> list = autorDAO.listar();
        autores = new ListDataModel<Autor>(list);
        return autores;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
