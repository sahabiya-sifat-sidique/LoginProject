<%@page import="dao.AdminDAO"%>
<jsp:useBean id="admin" class="model.Admin" scope="request"/>
<jsp:setProperty name="admin" property="*"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
   if(AdminDAO.authenticateAdmin(admin) && AdminDAO.updateToken(admin))
   {
         session.setAttribute("current_user", admin.getEmail());
         session.setAttribute("token",admin.getToken());
         response.sendRedirect("admin_dashboard.jsp");
   }
   else
   {
      
   response.sendRedirect("index.jsp");
    
   }
 %>
