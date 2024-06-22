package com.geekaca.news.service;

import com.geekaca.news.domain.NewsTag;
import java.util.List;


public interface TagService {
    List<NewsTag> selectAllTagNewsCnt();

    int deleteTagById(Integer tagId);
}
