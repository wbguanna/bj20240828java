package org.ljw.apps.memo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ljw.apps.memo.model.Memo;
import org.ljw.apps.memo.model.MemoDAO;

@WebServlet(urlPatterns="/memos/*", initParams=@WebInitParam(name="encoding", value="UTF-8"))
public class MemoServlet extends HttpServlet {
    private MemoDAO memoDAO = new MemoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println("requestURI >>> " + requestURI);
        String[] parts = requestURI.split("/");
        System.out.println("parts.length >>>> " + parts.length);
        if (parts.length > 2) {
           System.out.println(">>>> 상세 검색 기능 부분 ...");
            int id = Integer.parseInt(parts[parts.length - 1]);
            Memo memo = memoDAO.getMemoById(id);
            request.setAttribute("memo", memo);
            //request.getRequestDispatcher("/memo-detail.jsp").forward(request, response);
            response.getWriter().append(memo.toString());
        } else {
           System.out.println(">>>> 목록 기능 부분 ...");
            List<Memo> memos = memoDAO.getAllMemos();
            request.setAttribute("memos", memos);
            System.out.println(memos);
            //request.getRequestDispatcher("/memo-list.jsp").forward(request, response);
            response.getWriter().append(memos.toString());
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

