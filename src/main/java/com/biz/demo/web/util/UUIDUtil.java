package com.biz.demo.web.util;

import java.util.UUID;

public class UUIDUtil {

    public static String get32UUID() {
        UUID uuid = UUID.randomUUID();
        String uidString = uuid.toString().replace("-", "");
        return uidString.toLowerCase();
    }

    public static String get36UUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toLowerCase();
    }


    /*public static void main(String[] args) {
        try {
            String fileName = "电子票据111.docx";
            //截取文件前缀
            String caselsh = fileName.substring(0, fileName.lastIndexOf("."));
            //需要转换的word文件
            File inputWord = new File("F:/export/" + fileName);
            //转换后生成的pdf文件
            File outputFile = new File("F:/export/" + caselsh + ".pdf");
            InputStream docxInputStream = new FileInputStream(inputWord);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
            docxInputStream.close();
            converter.shutDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
