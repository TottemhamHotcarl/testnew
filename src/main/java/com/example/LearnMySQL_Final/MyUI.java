package com.example.LearnMySQL_Final;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Label wel = new Label("Welcome to LearnMySQL");
        final VerticalLayout layout = new VerticalLayout();
         
        final TextField username = new TextField();
        username.setCaption("USERNAME");
        final TextField password = new TextField();
        password.setCaption("USERNAME");
        
        Button login = new Button("Log In");
       
        login.setClickShortcut(KeyCode.ENTER);
        login.addClickListener(e -> {
        
        String user = username.getValue();
        String pass = password.getValue();
        
        LoginTool lt = new LoginTool(user,pass);
        
        if(lt.verifyStudentDetails()==true) {
        	   System.out.println("pizza");
        	   
       }
        }); 
        
        
        
        layout.addComponents(wel,username, password,login);
        layout.setComponentAlignment(wel, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(login, Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
