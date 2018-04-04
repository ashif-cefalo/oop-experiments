package com.cefalo.oopcourse.experiment;

import java.util.List;

/**
 * Basic csv formatter
 */
public class CSVFormatter extends DataFormatter{

    public CSVFormatter(DataService dataService) {
        super(dataService);
    }

    public boolean execute() {
        return super.execute();
    }

    /**
     * Returns a csv format from the list of items.
     * First the id, then the title and then the value.
     * All the properties separated by comma. And after every item a new line.
     *
     * @param items The list of items
     * @return A string with proper csv format
     */

    protected String formatData(List<Item> items) {
        String formattedString = "";
        for (Item item : items) {
            formattedString += String.format("%s, %s, %s\n", item.getId(), item.getTitle(), Double.toString(item.getValue()));
        }
        return  formattedString;
    }

    @Override
    protected boolean shouldNotify() {
        return false;
    }
}
