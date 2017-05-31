## Excel 导入导出说明

*https://poi.apache.org/*

###  SimpleImportStatus

SimpleImportStatus是一个模板类，用于保存数据导入的结果：

- boolean success 导入是否成功
- int totalCount 导入数据的总数
- int successCount 导入数据成功数
- int failCount 导入数据失败数
- List<T> batchAddList  导入的数据
- List<String> msg  导入时信息
- String errorMsg 错误信息，success为true时为空

### SheetRowConversion
SheetRowConversion是一个接口，导入导出的model需要实现这个接口

``` java
public interface SheetRowConversion {

    SheetRowConversion convertToModel(Row row);

    Row convertToRow(Row row);

}
```
例子：

``` java
public class Stock implements SheetRowConversion {

    public static final String[] HEADER = new String[]{"名称","单位",
    "规格","备注","现有库存","最大库存","最小库存"};

    private StockModel stockModel;
    private GoodsModel goodsModel;

    public StockModel getStockModel() {
        return stockModel;
    }

    public void setStockModel(StockModel stockModel) {
        this.stockModel = stockModel;
    }

    public GoodsModel getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(GoodsModel goodsModel) {
        this.goodsModel = goodsModel;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockModel=" + stockModel +
                ", goodsModel=" + goodsModel +
                '}';
    }

    @Override
    public SheetRowConversion convertToModel(Row row) {
        return null;
    }

    @Override
    public Row convertToRow(Row row) {
        Cell gnameCell = row.createCell(0);
        gnameCell.setCellValue(this.goodsModel.getGname());
        Cell unitCell = row.createCell(1);
        unitCell.setCellValue(this.goodsModel.getUnit());
        Cell specCell = row.createCell(2);
        specCell.setCellValue(this.goodsModel.getSpec());
        Cell noteCell = row.createCell(3);
        noteCell.setCellValue(this.goodsModel.getNote());
        this.stockModel.getNowNumber();
        Cell nowCell = row.createCell(4);
        nowCell.setCellValue(this.stockModel.getNowNumber());
        Cell minCell = row.createCell(5);
        minCell.setCellValue(this.stockModel.getMinStore());
        Cell maxCell = row.createCell(6);
        maxCell.setCellValue(this.stockModel.getMaxStore());
        return row;
    }
}
```




### SheetHandler

SheetHandler是最主要的一个类，负责实际的导入导出，有以下两个函数：

- public static <T extends SheetRowConversion> SimpleImportStatus<T> importSheet(File file,Class clazz,boolean isHeader)
导入函数，参数为（导出的文件名、转化的类的Class，是否有头部），其中文件兼容.xls(2003excel版本) 、.xls(2007excel版本)； clazz为T的类类型，需要实现SheetRowConversion接口；
函数遍历表格的所有行，利用反射实例化具体的类T：

``` java
T t = (T) clazz.newInstance();
t.convertToModel(row);
```
将结果存放在SimpleImportStatus实例中。

- public static <T extends SheetRowConversion> void exportSheet(File file,List<String>header,List<T>data)
导出函数，参数为导出后的文件名，表格头部，以及数据。T需要实现SheetRowConversion接口；

