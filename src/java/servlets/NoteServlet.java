package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = "This is the title";
        String contents = "Contents go here";
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        String e = request.getParameter("editnote");
        
        if(e != null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
     
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
     
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        
        try{
            pw.println(title);
            pw.println(contents);
            pw.close();
        }catch(Exception e){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
            .forward(request, response);
            return;
        }
        
        String newT = br.readLine();
        String newC = br.readLine();
        
        Note note = new Note(newT, newC);
        request.setAttribute("note", note);
            
        if(request.getParameter("savenote") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
            .forward(request, response);
        }
    }
}
