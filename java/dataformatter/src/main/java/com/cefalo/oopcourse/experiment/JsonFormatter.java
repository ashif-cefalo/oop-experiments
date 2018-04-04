package com.cefalo.oopcourse.experiment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * Basic json formatter
 */
public class JsonFormatter extends DataFormatter{

    public JsonFormatter(DataService dataService) {
        super(dataService);
    }

    public boolean execute() {
        return super.execute();
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

    protected String formatData(List<Item> items){
        try {
            return JsonUtil.fromItemList(items);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected boolean shouldNotify() {
        return true;
    }
}
