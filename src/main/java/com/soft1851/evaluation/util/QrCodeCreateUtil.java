package com.soft1851.evaluation.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**

 * @author wzw
 * @Description: 二维码的生成
 */
public class QrCodeCreateUtil {
    /**
     *  默认是黑色
     */
    private static final int QR_COLOR = 0xFF000000;
    /**
     * 背景颜色
     */
    private static final int BG_WHITE = 0xFFFFFFFF;
    /**
     * 二维码宽
     */
    private static final int WIDTH = 300;
    /**
     * 二维码高
     */
    private static final int HEIGHT = 300;

    // 用于设置QR二维码参数
    private static Map<EncodeHintType, Object> hints = new HashMap<>() {
        private static final long serialVersionUID = 1L;

        {
            // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            // 设置编码方式
            put(EncodeHintType.CHARACTER_SET, "utf-8");

            put(EncodeHintType.MARGIN, 0);
        }
    };


    /**
     * 生成带logo的二维码图片
     * @param logUrl 前端传过来的二维码图片地址
     * @param content 二维码内容
     * @param title 二维码下面文字
     * @return 本地图片上传到阿里云后返回的地址
     */
    public static void drawLogoQRCode(String logUrl, String content, String title) {
        String name = String.valueOf(UUID.randomUUID());
        String fileDir = "E:\\test";
        File logoFile = new File(download(logUrl));
        File codeFile = new File(fileDir + File.separator + name);
        String result = "";
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
            BitMatrix bm = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    image.setRGB(x, y, bm.get(x, y) ? QR_COLOR : BG_WHITE);
                }
            }

            int width = image.getWidth();
            int height = image.getHeight();
            if (logoFile.exists()) {
                // 构建绘图对象
                Graphics2D g = image.createGraphics();
                // 读取Logo图片
                BufferedImage logo = ImageIO.read(logoFile);
                // 开始绘制logo图片
                g.drawImage(logo, width * 2 / 5, height * 2 / 5, width * 2 / 10, height * 2 / 10, null);
                g.dispose();
                logo.flush();
            }

            // 自定义文本描述
            if (StringUtils.isNotEmpty(title)) {
                // 新的图片，把带logo的二维码下面加上文字
                BufferedImage outImage = new BufferedImage(400, 445, BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D outg = outImage.createGraphics();
                // 画二维码到新的面板
                outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
                // 画文字到新的面板
                outg.setColor(Color.BLACK);
                // 字体、字型、字号
                outg.setFont(new Font("楷体", Font.BOLD, 30));
                int strWidth = outg.getFontMetrics().stringWidth(title);
                if (strWidth > 399) {
                    // //长度过长就截取前面部分
                    // 长度过长就换行
                    String note1 = title.substring(0, title.length() / 2);
                    String note2 = title.substring(title.length() / 2);
                    int strWidth1 = outg.getFontMetrics().stringWidth(note1);
                    int strWidth2 = outg.getFontMetrics().stringWidth(note2);
                    outg.drawString(note1, 200 - strWidth1 / 2, height + (outImage.getHeight() - height) / 2 + 12);
                    BufferedImage outImage2 = new BufferedImage(400, 485, BufferedImage.TYPE_4BYTE_ABGR);
                    Graphics2D outg2 = outImage2.createGraphics();
                    outg2.drawImage(outImage, 0, 0, outImage.getWidth(), outImage.getHeight(), null);
                    outg2.setColor(Color.BLACK);
                    // 字体、字型、字号
                    outg2.setFont(new Font("宋体", Font.BOLD, 30));
                    outg2.drawString(note2, 200 - strWidth2 / 2, outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight()) / 2 + 5);
                    outg2.dispose();
                    outImage2.flush();
                    outImage = outImage2;
                } else {
                    // 画文字
                    outg.drawString(title, 200 - strWidth / 2, height + (outImage.getHeight() - height) / 2 + 12);
                }
                outg.dispose();
                outImage.flush();
                image = outImage;
            }

            image.flush();

            ImageIO.write(image, "jpg", codeFile);
//            result = AliOssUtil.upload(codeFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return result;
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

    public static void main(String[] args) {
        String logUrl = "https://img.tukuppt.com/bg_grid/00/04/14/Q3sAbiudRJ.jpg!/fh/350";
        String content = "https://img.tukuppt.com/bg_grid/00/04/14/Q3sAbiudRJ.jpg!/fh/350";
        String title = "测试一下";
        drawLogoQRCode(logUrl,content,title);
    }


}