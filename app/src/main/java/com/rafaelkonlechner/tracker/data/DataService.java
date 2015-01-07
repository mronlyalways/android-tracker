package com.rafaelkonlechner.tracker.data;

import com.rafaelkonlechner.tracker.model.*;

import java.util.List;

/**
 * Created by Rafael on 07.01.2015.
 */
public interface DataService {

    public List<Category> loadCategories();

    public void persist(Category c);
}
