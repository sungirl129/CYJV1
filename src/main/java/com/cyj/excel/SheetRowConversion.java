package com.cyj.excel;

import org.apache.poi.ss.usermodel.Row;

public interface SheetRowConversion {

    SheetRowConversion convertToModel(Row row);

    Row convertToRow(Row row);

}
