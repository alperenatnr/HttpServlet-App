package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Personel;

public class PersonelServlet extends HttpServlet {

    private List<Personel> personelList = new ArrayList<>();

    public List<Personel> getPersonelList() {
        return personelList;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonelServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Selam " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init() throws ServletException {
        personelList = new ArrayList<>();
        getServletContext().setAttribute("personelList", personelList);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Personel> personelList = (List<Personel>) getServletContext().getAttribute("personelList");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Personel Listeleme</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
        out.println("</head><body>");
        out.println("<div class=\"container\">");
        out.println("<h1 class=\"mt-5\">Personel Listeleme</h1>");
        out.println("<nav class=\"nav mt-3\">");
        out.println("<a class=\"nav-link\" href=\"index.html\">Anasayfa</a>");
        out.println("<a class=\"nav-link\" href=\"personel-ekle.html\">Personel Ekleme</a>");
        out.println("<a class=\"nav-link\" href=\"personel-listele.jsp\">Personel Listeleme</a>");
        out.println("</nav>");

        if (personelList.isEmpty()) {
            out.println("<p class=\"mt-3\">Henüz personel eklenmemiş.</p>");
        } else {
            out.println("<table class=\"table mt-3\">");
            out.println("<thead><tr><th>Adı</th><th>Soyadı</th><th>Sicil Numarası</th><th>Departman</th><th>Telefon</th><th>İşe Giriş Tarihi</th><th>Maaş</th><th>Aktif</th></tr></thead>");
            out.println("<tbody>");

            double toplamMaas = 0;
            for (Personel personel : personelList) {
                out.println("<tr>");
                out.println("<td>" + personel.getAd() + "</td>");
                out.println("<td>" + personel.getSoyad() + "</td>");
                out.println("<td>" + (personel.getSicilNumarasi() != 0 ? personel.getSicilNumarasi() : "-") + "</td>");
                out.println("<td>" + (personel.getDepartman() != null ? personel.getDepartman() : "-") + "</td>");
                out.println("<td>" + (personel.getTelefon() != null ? personel.getTelefon() : "-") + "</td>");
                out.println("<td>" + personel.getIseGirisTarihi() + "</td>");
                out.println("<td>" + personel.getMaasTutari() + "</td>");
                out.println("<td>" + (personel.isAktiflik() ? "Evet" : "Hayır") + "</td>");
                out.println("</tr>");
                toplamMaas += personel.getMaasTutari();
            }

            out.println("</tbody>");
            out.println("<tfoot><tr><td colspan=\"6\">Toplam Personel</td><td>" + personelList.size() + "</td></tr>");
            out.println("<tr><td colspan=\"6\">Toplam Maaş Tutarı</td><td>" + toplamMaas + "</td></tr></tfoot>");
            out.println("</table>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Personel> personelList = (List<Personel>) getServletContext().getAttribute("personelList");

        String ad = request.getParameter("ad");
        String soyad = request.getParameter("soyad");
        int sicilNumarasi = Integer.parseInt(request.getParameter("sicilNumarasi"));
        String departman = request.getParameter("departman");
        String telefon = request.getParameter("telefon");
        String iseGirisTarihi = request.getParameter("iseGirisTarihi");
        double maasTutari = Double.parseDouble(request.getParameter("maasTutari"));
        boolean aktiflik = Boolean.parseBoolean(request.getParameter("aktiflik"));

        LocalDate parsedGirisTarihi = LocalDate.parse(iseGirisTarihi);
        Personel newPersonel = new Personel(ad, soyad, sicilNumarasi, departman, telefon, parsedGirisTarihi, maasTutari, aktiflik);
        personelList.add(newPersonel);

        response.sendRedirect("http://localhost:5555/Register/index.html");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
