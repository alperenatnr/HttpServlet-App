<%@ page import="model.Personel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Personel> personelList = (List<Personel>) getServletContext().getAttribute("personelList");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>List Personals</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
        body {
            background-color: #f8f9fa;
        }
        .navbar {
            background-color: #17a2b8; /* Mavi tonu */
        }
        .navbar-brand, .navbar-nav .nav-link {
            color: #ffffff; /* Beyaz renk */
        }
        .container {
            background-color: #ffffff; /* Beyaz arka plan */
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); /* Hafif gölge */
            padding: 20px;
        }
    </style>
    </head>
    <body>
        <div class="container">
            <h1 class="mt-5">Personal List</h1>
            <nav class="nav mt-3">
                <a class="nav-link" href="index.html">Main Page</a>
                <a class="nav-link" href="personel-ekle.html">Add Personal</a>
                <a class="nav-link" href="personel-listele.jsp">List Personals</a>
            </nav>

            <table class="table mt-3">
                <thead>
                    <tr>
                        <th>Adı</th>
                        <th>Soyadı</th>
                        <th>Sicil Numarası</th>
                        <th>Departman</th>
                        <th>Telefon</th>
                        <th>İşe Giriş Tarihi</th>
                        <th>Maaş</th>
                        <th>Aktiflik</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        if (personelList != null) {
                            for (Personel personel : personelList) {
                    %>
                    <tr>
                        <td><%= personel.getAd() %></td>
                        <td><%= personel.getSoyad() %></td>
                        <td><%= (personel.getSicilNumarasi() != 0 ? personel.getSicilNumarasi() : "-") %></td>
                        <td><%= (personel.getDepartman() != null ? personel.getDepartman() : "-") %></td>
                        <td><%= (personel.getTelefon() != null ? personel.getTelefon() : "-") %></td>
                        <td><%= personel.getIseGirisTarihi() %></td>
                        <td><%= personel.getMaasTutari() %></td>
                        <td><%= (personel.isAktiflik() ? "Evet" : "Hayır") %></td>
                    </tr>
                    <% 
                            }
                        }
                    %>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="6">Toplam Personel</td>
                        <td><%= (personelList != null ? personelList.size() : 0) %></td>
                    </tr>
                    <tr>
                        <td colspan="6">Toplam Maaş Tutarı</td>
                        <td>
                            <% 
                                double toplamMaas = 0;
                                if (personelList != null) {
                                    for (Personel personel : personelList) {
                                        toplamMaas += personel.getMaasTutari();
                                    }
                                }
                                out.print(toplamMaas);
                            %>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </body>
</html>
