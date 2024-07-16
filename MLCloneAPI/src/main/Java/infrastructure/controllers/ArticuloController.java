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
import java.util.ArrayList;


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
        String nombreArticulo = req.getParameter("nombre");

        if(nombreArticulo != null) {
            Articulo articuloBuscado = articuloService.findByNombre(nombreArticulo.toLowerCase());
            if(articuloBuscado != null) {

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write(mapper.writeValueAsString(articuloBuscado));
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("No se encontro un articulo con ese nombre");
            }

        }else {
            ArrayList<Articulo> articulos = articuloService.getAllArticulos();

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(mapper.writeValueAsString(articulos));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Articulo articulo = mapper.readValue(req.getInputStream(), Articulo.class);
        articuloService.guardarArticulo(articulo);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String targetId = req.getParameter("id");

        if(targetId != null && !targetId.isEmpty()) {
            int id = Integer.parseInt(targetId);

            articuloService.deleteArticulo(id);
            resp.setStatus(HttpServletResponse.SC_OK);
        }else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("ID DE USUARIO INVALIDO");
        }
    }
}
