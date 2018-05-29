package com.javacore.poi;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author qianqian.sun
 * @Date 2018/2/9
 * 描述：
 */
public class JxlsApi {

    public static void writeFile(String templatePath, String filePath, Map beans) throws IOException, InvalidFormatException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(templatePath));
        File tempFile = new File(filePath);
        if (!tempFile.exists()) tempFile.createNewFile();
        OutputStream outputStream = new FileOutputStream(tempFile);

        XLSTransformer xlsTransformer = new XLSTransformer();
        org.apache.poi.ss.usermodel.Workbook workbook = xlsTransformer.transformXLS(inputStream, beans);
        workbook.write(outputStream);
        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }

    @Test
    public void testJxls() throws IOException, InvalidFormatException {
        String templatePath = getClass().getResource("/template/temp.xls").getPath();

        Map<String, Object> map = new HashMap<String, Object>() {{
            put("list", new ArrayList<BeanVo>() {{
                add(new BeanVo("1", "qq"));
                add(new BeanVo("2", "ss"));
            }});
        }};

        writeFile(templatePath, "D:/demo/jxls-test.xls", map);
    }

    public class BeanVo {
        private String id;
        private String name;

        public BeanVo(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
