/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bb;

import ejb.FileUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author WITC_NP02410A
 */
@Named
@ViewScoped
public class FileBb implements Serializable {
    
    
    private String text;
    @EJB
    FileUtil fileUtil;
    
    {
        fileUtil.loadPropsConfiguration("/resorces/data/shiire.properties");
      
    }
    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}

