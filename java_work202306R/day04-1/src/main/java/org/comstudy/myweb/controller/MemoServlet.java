package org.comstudy.myweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.model.Memo;
import org.comstudy.myweb.model.MemoDAO;

@WebServlet("/memos/*")
public class MemoServlet extends HttpServlet {
    private MemoDAO memoDAO = new MemoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] parts = requestURI.split("/");
        if (parts.length > 2) {
            int id = Integer.parseInt(parts[parts.length - 1]);
            Memo memo = memoDAO.getMemoById(id);
            request.setAttribute("memo", memo);
            request.getRequestDispatcher("/memo-detail.jsp").forward(request, response);
        } else {
            List<Memo> memos = memoDAO.getAllMemos();
            request.setAttribute("memos", memos);
            request.getRequestDispatcher("/memo-list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Memo newMemo = new Memo(title, content);
        memoDAO.addMemo(newMemo);
        response.sendRedirect(request.getContextPath() + "/memos");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Memo updatedMemo = new Memo(id, title, content);
        memoDAO.updateMemo(updatedMemo);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        memoDAO.deleteMemo(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
