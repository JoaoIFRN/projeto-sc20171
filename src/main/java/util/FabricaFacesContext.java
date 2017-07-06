/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author João
 */
public class FabricaFacesContext {
    @Produces
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }
}
