package br.com.fiap.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;




/**
 * Servlet implementation class LoginFilter
 */
@WebFilter(urlPatterns="/admin/*")
public class LoginFilter implements Filter {

	
	public LoginFilter(){
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Usuario usuario = (Usuario)session.getAttribute("usuario_sessao");
		
		if(usuario == null){
					
			
			((HttpServletResponse)response).sendRedirect("/AplicacaoServletJsp2/login.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

    /**
     * Default constructor. 
     */
  

}
