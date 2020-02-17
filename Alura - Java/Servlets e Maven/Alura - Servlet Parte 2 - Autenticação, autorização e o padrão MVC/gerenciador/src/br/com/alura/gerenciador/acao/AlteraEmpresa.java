package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando Empresa");
    	
    	String data = request.getParameter("data");
    	String nomeEmpresa = request.getParameter("nome");
    	String idParam = request.getParameter("id");
    	Integer id = Integer.valueOf(idParam);
    	
    	Date abertura = null;
    	
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			abertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
    	
    	Banco banco = new Banco();
    	Empresa empresa = banco.buscaEmpresaPeloId(id);
    	empresa.setNome(nomeEmpresa);
    	empresa.setDataAbertura(abertura);
    	
    	response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
