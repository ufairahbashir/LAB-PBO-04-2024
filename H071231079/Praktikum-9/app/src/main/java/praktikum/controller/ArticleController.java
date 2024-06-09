package praktikum.controller;

import java.util.ArrayList;
import java.util.List;

import praktikum.config.DbConfig;
import praktikum.models.Article;

public class ArticleController extends DbConfig{

    //read untuk homescene
    public static List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        query = "SELECT * FROM articles";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String imagePath = resultSet.getString("image_path");
                String link = resultSet.getString("url");

                Article article = new Article(id, title, imagePath, link);
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
}
