/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Usuario;
import persistencia.UsuarioDAO;

/**
 *
 * @author João
 */
@Named
@RequestScoped
public class LoginBean {

    @Inject
    private Usuario usuario;
    @Inject
    private UsuarioDAO usuarioDAO;
    @Inject
    private FacesContext context;

    public String realizarLogin() {
        if (usuarioDAO.existeUsuario(usuario)) {
            context.getExternalContext().getSessionMap().put("usuario_logado", usuario);
            return "/principal.xhtml?faces-redirect=true";
        } else {
            context.getExternalContext().getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage("Falha no login"));
            return "/login.xhtml?faces-redirect=true";
        }
    }

    public String deslogar() {
        context.getExternalContext().getSessionMap().remove("usuario_logado");
        return "login?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
