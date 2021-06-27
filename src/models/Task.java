package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")  //tasksテーブルを作成
public class Task {
    @Id
    @Column(name = "ID")    //IDカラム
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Creater_at", nullable = false)  //作成日時カラム
    private Timestamp created_at;

    @Column(name = "Updated_at", nullable = false)  //更新日時カラム
    private Timestamp updated_at;

    @Column(name = "Content", length = 255, nullable = false)   //content(タスクの内容)カラム
    private String content;

    //以下，setter/getterメソッド
    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId () {
        return id;
    }

    public void setCreated_at (Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getCreated_at () {
        return created_at;
    }

    public void setUpdated_at (Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getUpdated_at () {
        return updated_at;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getContent () {
        return content;
    }
}
