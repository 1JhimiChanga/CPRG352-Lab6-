package servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jimmy
 */
public class ShoppingListServlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Grab existing User
        HttpSession session = request.getSession();
        String existUser = (String) session.getAttribute("username");
        
        
       
        
        
        //Check if user actually exist
        if(existUser != null){
            request.setAttribute("name", existUser);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else{
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
       
          //Logout
        String action = request.getParameter("action");
        if(action.equals("logout")){
            System.out.println("LOG OUT HAPPENED");
            session.invalidate();
            response.sendRedirect("ShoppingList");
            return;
            
            
        }
      
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //Item Input Array
        String itemInput = request.getParameter("c_item");
        ArrayList<String> existList = (ArrayList<String>) session.getAttribute("existList");
        ArrayList<String>itemList;
        
        //Delete Variable
        String deleteItem = request.getParameter("v_item");
        
        
        //Check if itemList already exist.
        if(existList != null){
             itemList = existList;
        } else {
            itemList = new ArrayList();
        }
        
       
        
          //Action Decisions
        String action = request.getParameter("action");
        
       if (action.equals("register")){
             //Store the userrname
            String username = request.getParameter("c_username");
            session.setAttribute("username", username);
            request.setAttribute("name", username);
            System.out.println("Register HAPPENDED");
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if (action.equals("add")){
           //add the item and save it to session
            itemList.add(itemInput);
            session.setAttribute("existList", itemList);
            session.setAttribute("itemList", itemList);
            System.out.println(itemList);
            response.sendRedirect("ShoppingList");
        } else if(action.equals("delete")){
            
            
            itemList.remove(deleteItem);
            
            
            session.setAttribute("existList", itemList);
            session.setAttribute("itemList", itemList);
            System.out.println(itemList);
            response.sendRedirect("ShoppingList");
        }
        
        
        
      
    }



}
