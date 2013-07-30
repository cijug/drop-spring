package org.cijug.dropspring.view;

import com.yammer.dropwizard.views.View;
import org.cijug.dropspring.core.Blog;

public class BlogView extends View {

    private final Blog blog;

    public BlogView(Blog blog) {
        super("blog.mustache");
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

}
