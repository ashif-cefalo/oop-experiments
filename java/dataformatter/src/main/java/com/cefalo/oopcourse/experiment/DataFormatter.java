package com.cefalo.oopcourse.experiment;

import java.util.List;

public class DataFormatter {
    private DataService dataService;
    private DataFormatterProcessor processor;

    public DataFormatter(DataService dataService, DataFormatterProcessor processor) {
        this.dataService = dataService;
        this.processor = processor;
    }

    public boolean execute() {
        try {
            dataService.openConnection();

            List<Item> items;
            items = dataService.readData();

            String formattedData = processor.formatData(items);

            boolean isExported = dataService.exportData(formattedData);
            if (processor.shouldNotify()){
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
}
