package com.cefalo.oopcourse.experiment;

import java.util.List;

public interface DataFormatterProcessor {
    public String formatData(List<Item> items);
    public boolean shouldNotify();
}
