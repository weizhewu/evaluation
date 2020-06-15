package com.soft1851.evaluation.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: zw_w
 * @Date: 2020/6/13 17:01
 * @Description:
 */
public class Test {
    /**
     * 生成二维码 直接将二维码图片写到指定文件目录
     *
     * @param content 二维码内容
     */
    public static String generateQRcodePic(String content) {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 1);
        String url = null;
        try {
            // 构造二维字节矩阵
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);

            // 构造文件目录，若目录不存在，则创建目录
            String fileDir = "E:\\test";
            if (!new File(fileDir).exists()) {
                new File(fileDir).mkdirs();
            }
            String name = String.valueOf(UUID.randomUUID());
            Path file = new File(fileDir + File.separator + name+"." + "jpg").toPath();
            url = fileDir + File.separator + name+"." + "jpg";
            // 将二位字节矩阵按照指定图片格式，写入指定文件目录，生成二维码图片
            MatrixToImageWriter.writeToPath(bitMatrix, "jpg", file);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 二维码添加logo
     * @param logoUrl logo图片
     * @return 返回带有logo的二维码图片
     * 参考：https://blog.csdn.net/weixin_39494923/article/details/79058799
     */
    public static BufferedImage LogoMatrix(String content, String logoUrl) throws IOException {
        BufferedImage matrixImage = ImageIO.read(new File(generateQRcodePic(content)));
        /**
         * 读取二维码图片，并构建绘图对象
         */
        Graphics2D g2 = matrixImage.createGraphics();

        int matrixWidth = matrixImage.getWidth();
        int matrixHeigh = matrixImage.getHeight();

        /**
         * 读取Logo图片
         */
        BufferedImage logo = ImageIO.read(new File(download(logoUrl)));

        //开始绘制图片
        g2.drawImage(logo, matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, null);//绘制
        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(stroke);// 设置笔画对象
        //指定弧度的圆角矩形
        RoundRectangle2D.Float round = new RoundRectangle2D.Float(matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, 20, 20);
        g2.setColor(Color.white);
        g2.draw(round);// 绘制圆弧矩形

        //设置logo 有一道灰色边框
        BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(stroke2);// 设置笔画对象
        RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(matrixWidth / 5 * 2 + 2, matrixHeigh / 5 * 2 + 2, matrixWidth / 5 - 4, matrixHeigh / 5 - 4, 20, 20);
        g2.setColor(new Color(128, 128, 128));
        g2.draw(round2);// 绘制圆弧矩形

        g2.dispose();
        matrixImage.flush();
        return matrixImage;
    }
    public static String download(String urlString)  {
        File filename = new File("E:\\test" + File.separator + UUID.randomUUID()+"." + "jpg");

        // 构造URL
        URL url;
        URLConnection con ;
        InputStream is;
        OutputStream os;
        try {
            url = new URL(urlString);
            // 打开连接
            con = url.openConnection();
            // 输入流
            is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            os = new FileOutputStream(filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(filename);
    }

    public static void main(String[] args) throws IOException {
        LogoMatrix("https://img.tukuppt.com/bg_grid/00/04/14/Q3sAbiudRJ.jpg!/fh/350","http://51tfb.com/uploadfile/20190325/201903251640165c9893f0ef3ce.jpg");
    }
}
