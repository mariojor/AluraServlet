package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Resultado da busca:<br/>");
		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(req.getParameter("filtro"));
		writer.println("<ul>");
		for (Empresa empresa : empresas) {
			writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
		}
		writer.println("</ul>");

		writer.println("</body>");
		writer.println("</html>");
	}

}
