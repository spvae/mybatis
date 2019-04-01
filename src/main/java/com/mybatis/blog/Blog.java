package com.mybatis.blog;

import com.mybatis.author.Author;
import com.mybatis.post.Post;

import java.util.List;


public class Blog {

    private String id ;
    private String title ;
    private Author author  ;
    private String state  ;
    private int  featured  ;
    private String authorref  ;
    private List<Post>  posts ; // 文章

    public Blog(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAuthorref() {
        return authorref;
    }

    public void setAuthorref(String authorref) {
        this.authorref = authorref;
    }
}


   /* resultMap 元素有很多子元素和一个值得讨论的结构。 下面是 resultMap 元素的概念视图
        resultMap

        constructor - 类在实例化时,用来注入结果到构造方法中
        idArg - ID 参数;标记结果作为 ID 可以帮助提高整体效能
        arg - 注入到构造方法的一个普通结果
        id – 一个 ID 结果;标记结果作为 ID 可以帮助提高整体效能
        result – 注入到字段或 JavaBean 属性的普通结果
        association – 一个复杂的类型关联;许多结果将包成这种类型
        嵌入结果映射 – 结果映射自身的关联,或者参考一个
        collection – 复杂类型的集
        嵌入结果映射 – 结果映射自身的集,或者参考一个
        discriminator – 使用结果值来决定使用哪个结果映射
        case – 基于某些值的结果映射
        嵌入结果映射 – 这种情形结果也映射它本身,因此可以包含很多相 同的元素,或者它可以参照一个外部的结果映射。
*/