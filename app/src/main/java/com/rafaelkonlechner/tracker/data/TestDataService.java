package com.rafaelkonlechner.tracker.data;

import com.rafaelkonlechner.tracker.model.Category;
import com.rafaelkonlechner.tracker.model.Element;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rafael on 07.01.2015.
 */
public class TestDataService implements DataService {

    @Override
    public List<Category> loadCategories() {
        Category c1, c2;
        c1 = new Category("Weight", "kg");
        c2 = new Category("Pushups", "reps");
        Element e1, e2, e3, e4;
        e1 = new Element(78, new Date());
        e2 = new Element(79, new Date());
        e3 = new Element(9, new Date());
        e4 = new Element(10, new Date());
        c1.addElement(e1);
        c1.addElement(e2);
        c2.addElement(e3);
        c2.addElement(e4);
        List<Category> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        return list;
    }

    @Override
    public void persist(Category c) {

    }
}
