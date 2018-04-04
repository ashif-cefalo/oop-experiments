package com.cefalo.oopcourse.experiment;

import java.util.List;

public abstract class DataFormatter {
    private DataService dataService;

    public DataFormatter(DataService dataService) {
        this.dataService = dataService;
    }

    public boolean execute() {
        try {
            dataService.openConnection();

            List<Item> items;
            items = dataService.readData();

            String formattedData = formatData(items);

            boolean isExported = dataService.exportData(formattedData);
            if (shouldNotify()){
                dataService.notifyJobComplete();
            }
            return isExported;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dataService.closeConnection();
        }

        return false;
    }

    protected abstract String formatData(List<Item> items);
    protected abstract boolean shouldNotify();
}
