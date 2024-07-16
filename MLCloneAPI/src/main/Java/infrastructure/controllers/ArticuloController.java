package infrastructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.models.Articulo;
import service.ArticuloService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/articulos")
public class ArticuloController extends HttpServlet {

    private ObjectMapper mapper;
    private ArticuloService articuloService;

    public ArticuloController() {
        this.mapper = new ObjectMapper();
        this.articuloService = new ArticuloService();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Articulo articulo = mapper.readValue(req.getInputStream(), Articulo.class);
        articuloService.guardarArticulo(articulo);

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
