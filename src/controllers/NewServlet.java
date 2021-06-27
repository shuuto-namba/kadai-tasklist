package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //Taskのインスタンスを生成
        Task task = new Task();

        //taskの各フィールドにデータを代入
        String content = "コンテンツ";
        task.setContent(content);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());  //現在の日時を取得
        task.setCreated_at(currentTime);
        task.setUpdated_at(currentTime);

        //データベースに保存
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();

        //自動採番されたIDの値を表示
        response.getWriter().append(Integer.valueOf(task.getId()).toString());

        em.close();
    }
}
