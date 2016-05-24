package br.com.fiap.listener;

import java.io.FileWriter;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerAplicacao
 *
 */
@WebListener
public class ListenerAplicacao implements ServletContextListener, ServletRequestAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

  
    public ListenerAplicacao() {
        
    }

	
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	  try {
			gerarLog("Sessao Criada");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
    

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	  try {
			gerarLog("Sessao Destruida");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
        try {
			gerarLog("Sessao Finalizada");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
   

	
    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
         
    }

	
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
        String s = (String)arg0.getServletContext().getAttribute("msg");
        		if(s != null){
        			try {
						gerarLog("'Atributo '" + s + "' Adicionado na Requisicao'");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}else{
        			try {
						gerarLog("'Atributo  Adicionado na Requisicao'");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
    }

	
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
    	String s = (String)arg0.getServletContext().getAttribute("msg");
		if(s != null){
			try {
				gerarLog("'Atributo '" + s + "' Removido na Requisicao'");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				gerarLog("'Atributo  Removido na Requisicao'");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
    private void gerarLog(String texto) throws Exception{
    	try {
    		FileWriter arquivo = new FileWriter("D:\\27CSJ\\log.txt", true);
    		arquivo.write("[" + new Date() + "] - " + texto + "\r\n");
    		arquivo.close();
    		
		} catch (Exception e) {
		}
    }


	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
