package com.cefalo.oopcourse.experiment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * Basic json formatter
 */
public class JsonFormatter implements DataFormatterProcessor{

    private DataFormatter formatter;

    public JsonFormatter(DataService dataService) {
        this.formatter = new DataFormatter(dataService, this);
    }


    public boolean execute() {
        return formatter.execute();
    }

    /**
     * Returns a String json format from the list of items.
     * It should be something like following -
     * {
     * "result": [
     * {
     * "id": "1",
     * "title": "item 1",
     * "value": 100.0
     * }, {
     * "id": "2",
     * "title": "item 2",
     * "value": 120.0
     * }
     * ]
     * }
     *
     * @param items The list of items
     * @return A string with proper csv format
     */

    public String formatData(List<Item> items){
        try {
            return JsonUtil.fromItemList(items);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return "";
    }

    public boolean shouldNotify() {
        return true;
    }
}
