package com.wzt.practise.service;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.wzt.practise.model.WriteModel;
import com.wzt.practise.util.DataUtil;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    private List<WriteModel> createModelList() {
        List<WriteModel> writeModels = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            WriteModel writeModel = WriteModel.builder()
                    .name("小哈学Java"+i).password("123456").age(i+1).build();
            writeModels.add(writeModel);
        }

        return writeModels;
    }

    /**
     * 简单场景
     * @return
     * @throws IOException
     */
    public String writeExcel() throws IOException {
        // 文件输出位置
        OutputStream out = new FileOutputStream("/Users/wzt/Desktop/test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
        Sheet sheet1 = new Sheet(1, 0, WriteModel.class);

        // 写数据到 Writer 上下文中
        // 入参1: 创建要写入的模型数据
        // 入参2: 要写入的目标 sheet
        writer.write(createModelList(), sheet1);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();

        return "success";
    }

    public String writeExcel2() throws IOException {
        // 文件输出位置
        OutputStream out = new FileOutputStream("/Users/wzt/Desktop/test2.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 动态添加表头，适用一些表头动态变化的场景
        Sheet sheet1 = new Sheet(1, 0);

        sheet1.setSheetName("第一个sheet");

        // 创建一个表格，用于 Sheet 中使用
        Table table1 = new Table(1);

        // 自定义表格样式
        table1.setTableStyle(DataUtil.createTableStyle());

        // 无注解的模式，动态添加表头
        table1.setHead(DataUtil.createTestListStringHead());
        // 写数据
        writer.write1(createDynamicModelList(), sheet1, table1);

//        // 合并单元格
//        writer.merge(5, 6, 0, 4);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();
        return "success";
    }

    /**
     * 无注解的实体类
     *
     * @return
     */
    private List<List<Object>> createDynamicModelList() {
        // 所有行数据
        List<List<Object>> rows = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            // 一行数据
            List<Object> row = new ArrayList<>();
            row.add("字符串" + i);
            row.add(Long.valueOf(187837834l + i));
            row.add(Integer.valueOf(2233 + i));
            row.add("犬小哈");
            row.add("微信公众号：小哈学Java");
            rows.add(row);
        }

        return rows;
    }


}
