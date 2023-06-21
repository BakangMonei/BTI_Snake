package com.neizathedev.breakingtheice;

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:32 PM
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/* loaded from: classes5.dex */
public class WordFileReader {
    public static String readWordFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XWPFDocument document = new XWPFDocument(fis);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        String text = extractor.getText();
        fis.close();
        return text;
    }
}