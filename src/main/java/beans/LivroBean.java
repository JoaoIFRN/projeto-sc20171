/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Autor;
import modelo.Livro;
import persistencia.AutorDAO;
import persistencia.LivroDAO;

/**
 *
 * @author João
 */
@Named
@SessionScoped
public class LivroBean implements Serializable {

    @Inject
    private Livro livro;
    @Inject
    private LivroDAO livroDAO;
    @Inject
    private AutorDAO autorDAO;
    private Integer livroId;
    private Integer autorId;
    private DataModel<Livro> livros;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getLivroId() {
        return livroId;
    }

    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }

    public DataModel<Livro> getLivros() {
        List<Livro> list = livroDAO.listar();
        livros = new ListDataModel<Livro>(list);
        return livros;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public void gravarAutor() {
        Autor autor = autorDAO.buscar(this.autorId);
        this.livro.adicionaAutor(autor);
    }

    public String formAutor() {
        return "autor?faces-redirect=true";
    }

    public void removerAutorDoLivro(Autor autor) {
        this.livro.removeAutor(autor);
    }

    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (livro.getAutores().isEmpty()) {
            context.addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
            return;
        }
        if (this.livro.getId() == null) {
            livroDAO.salvar(this.livro);
            //this.livros = dao.listaTodos();
        } else {
            livroDAO.atualizar(this.livro);
        }

        this.livro = new Livro();
    }

    public void carregar(Livro livro) {
        this.livro = livro;
    }

    public void remover(Livro livro) {
        livroDAO.remove(livro);
        this.livro = new Livro();
    }

    public List<Autor> getAutores() {
        return autorDAO.listar();
    }

    public List<Autor> getAutoresDoLivro() {
        return this.livro.getAutores();
    }
}
